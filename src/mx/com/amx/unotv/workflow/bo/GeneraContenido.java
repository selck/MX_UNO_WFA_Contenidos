package mx.com.amx.unotv.workflow.bo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import mx.com.amx.unotv.workflow.dto.ContentDTO;
import mx.com.amx.unotv.workflow.dto.IdResponseFacebook;
import mx.com.amx.unotv.workflow.dto.NoticiaDTO;
import mx.com.amx.unotv.workflow.dto.ParametrosDTO;
import mx.com.amx.unotv.workflow.dto.PushAMP;
import mx.com.amx.unotv.workflow.dto.RespuestaWSAMP;
import mx.com.amx.unotv.workflow.dto.VideoOoyalaDTO;
import mx.com.amx.unotv.workflow.dto.WrapperJsonDetail;
import mx.com.amx.unotv.workflow.util.ElementosContenido;
import mx.com.amx.unotv.workflow.util.OperacionesPreRender;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.ibm.workplace.wcm.api.Content;
import com.ibm.workplace.wcm.api.ContentComponent;
import com.ibm.workplace.wcm.api.ContentComponentIterator;
import com.ibm.workplace.wcm.api.ShortTextComponent;
import com.ibm.workplace.wcm.api.Workspace;
public class GeneraContenido{
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public boolean validaInsertContenido(Content myContent) {
		boolean success = true;
		
		try {
			OperacionesPreRender prerender = new OperacionesPreRender();
			ParametrosDTO parametrosDTO = prerender.obtenerPropiedades("ambiente.resources.properties");
			ElementosContenido con = new ElementosContenido();
			if (myContent.getWorkflowStageId().getName().trim().equals(parametrosDTO.getNameStageExpireWF())) {
				try {
					Workspace ws = null;					
					String authoringTemplate = myContent.getAuthoringTemplateID().getName();
					if(authoringTemplate != null && authoringTemplate.trim().equals(parametrosDTO.getNameAuthoringTemplate())) {					
						ws = myContent.getSourceWorkspace();																
						ws.login();						
						ProcesoBO procesoBO = new ProcesoBO(parametrosDTO.getURL_WS_BASE());
						//ProcesoBO procesoBOColombia = new ProcesoBO(parametrosDTO.getURL_WS());
						try {												
							ContentDTO contentDTO=new ContentDTO();
							contentDTO = con.getContenido(myContent, ws, parametrosDTO);
							
							if(contentDTO.getFcTagsApp() != null && contentDTO.getFcTagsApp().length>0){
								success = procesoBO.deleteTagsApp(contentDTO);
								logger.info("Delete Tags App " + myContent.getTitle() + ": " + success);
							}
							success = procesoBO.deleteNotaBD(contentDTO);
							success = procesoBO.deleteNotaHistoricoBD(contentDTO);
							
							try {
								procesoBO = new ProcesoBO(parametrosDTO.getURL_WS_BASE_FB());
								String articleFBId="";
								ContentComponentIterator ci = myContent.componentIterator();						
							 	while (ci.hasNext()) {					 	
							 		ContentComponent curr = (ContentComponent) ci.next();
							 		 if(curr.getName().trim().equals("txtArticleId")) {
							 			ShortTextComponent shortText = (ShortTextComponent) curr;
							 			articleFBId=shortText.getText();
							 		 }
							 	}
							 	if(!articleFBId.equals(""))
							 		logger.info(procesoBO.deleteArticleFB(articleFBId));
							 	else
							 		logger.info("No se contaba con el articleFBId");
							} catch (Exception e) {
								logger.error("Error en delete FB: ",e);
							}
							
							logger.info("Delete Nota " + myContent.getTitle() + ": " + success);
						} catch(Exception e) {
							success = false;
							logger.error("Ocurrio error al acceder a BO: " + e.getMessage());
						}			
						ws.logout();												
					}      
				} catch (Exception e) {
					logger.debug("Exception: ", e);
				}
			}else if(myContent.getWorkflowStageId().getName().trim().equals(parametrosDTO.getNameStageReviewWF()) &&
					myContent.getAuthoringTemplateID().getName().trim().equals(parametrosDTO.getNameAuthoringTemplate())){
					ContentDTO contentDTO = new ContentDTO();
					logger.info("------------Solo se creara el HTML------------");
					Workspace ws = myContent.getSourceWorkspace();						
					ws.login();																							
					contentDTO = con.getContenido(myContent, ws, parametrosDTO);
						try {
							String tipoSeccion="";
							if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticia") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticias"))
								tipoSeccion="noticias";
							else if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblog") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblogs"))
								tipoSeccion="videoblogs";
							else
								tipoSeccion=contentDTO.getFcTipoSeccion();						
							
							String id_categoria=contentDTO.getFcFriendlyURLCategoria() !=null && !contentDTO.getFcFriendlyURLCategoria().equals("")?contentDTO.getFcFriendlyURLCategoria():contentDTO.getFcIdCategoria();
							
							String id_seccion=contentDTO.getFcFriendlyURLSeccion() !=null && !contentDTO.getFcFriendlyURLSeccion().equals("")?contentDTO.getFcFriendlyURLSeccion():contentDTO.getFcSeccion();
							
							String carpetaContenido = parametrosDTO.getPathFilesTest() + tipoSeccion + "/" + id_seccion +"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre();
	
							logger.info("carpetaContenido: "+carpetaContenido);
							success = prerender.createFolders(carpetaContenido);
							
							//Se utilizara la base url absoluta para poder ver las imagenes y estilos productivos.
							
							parametrosDTO.setBaseURL(parametrosDTO.getBaseURLTest());
							
							if(success) 
								prerender.createPlantilla(parametrosDTO, contentDTO,myContent.getWorkflowStageId().getName().trim());
							
							ContentComponentIterator ci = myContent.componentIterator();						
						 	while (ci.hasNext()) {					 	
						 		ContentComponent curr = (ContentComponent) ci.next();
						 		 if(curr.getName().trim().equals("txtURLContenido")) {
						 			ShortTextComponent shortText = (ShortTextComponent) curr;
						 			String urlContenido=parametrosDTO.getAmbiente().equalsIgnoreCase("desarrollo")?parametrosDTO.getDominio()+"/portal/test-unotv/"+tipoSeccion + "/" + id_seccion +"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre():
						 				"http://pruebas-unotv.tmx-internacional.net"+"/"+tipoSeccion + "/" + id_seccion +"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre();
						 			shortText.setText(urlContenido);
						 			logger.info("Seteamos la url del contenido veda: "+urlContenido);
						 			myContent.setComponent("txtURLContenido", shortText);
						 		 }
						 	}
						 	//ws.save(myContent);
						} catch (Exception e) {
							logger.error("Error al generar prerender : ", e);
						}					
					ws.logout();												
					//ws.save(myContent);
				
			}else  if(myContent.getWorkflowStageId().getName().trim().equals(parametrosDTO.getNameStagePublishWF()) &&
					myContent.getAuthoringTemplateID().getName().trim().equals(parametrosDTO.getNameAuthoringTemplate())){
				ContentDTO contentDTO = new ContentDTO();
				String authoringTemplate = myContent.getAuthoringTemplateID().getName();
				
				if(authoringTemplate != null && authoringTemplate.trim().equals(parametrosDTO.getNameAuthoringTemplate())) {
					logger.info("------------Inicio del proceso de detalle------------");
					Workspace ws = myContent.getSourceWorkspace();						
					ws.login();																							
					ProcesoBO procesoBO = new ProcesoBO(parametrosDTO.getURL_WS_BASE());
					
					try {															
						contentDTO = con.getContenido(myContent, ws, parametrosDTO);
						if(contentDTO.getFcIdTipoNota().equals("video") || contentDTO.getFcIdTipoNota().equals("multimedia")
								&& !contentDTO.getFcIdVideoOoyala().equals("")){
							
							VideoOoyalaDTO ooyalaDTO=procesoBO.getInfoVideo(contentDTO.getFcIdVideoOoyala(), parametrosDTO);
							contentDTO.setFcSourceVideo(ooyalaDTO.getSource() ==  null?"":ooyalaDTO.getSource());
							contentDTO.setFcAlternateTextVideo(ooyalaDTO.getAlternate_text()==null?"":ooyalaDTO.getAlternate_text());
							contentDTO.setFcDurationVideo(ooyalaDTO.getDuration()==null?"":ooyalaDTO.getDuration());
							contentDTO.setFcFileSizeVideo(ooyalaDTO.getFileSize()==null?"":ooyalaDTO.getFileSize());
						}
						
						success = procesoBO.setNotaBD(contentDTO);
						
						if(contentDTO.getFcTagsApp() != null && contentDTO.getFcTagsApp().length>0 && success){
							String id_contenido=procesoBO.getIdNotaByName(contentDTO.getFcNombre());
							if(!id_contenido.equals("")){
								success = procesoBO.insertTagsApp(id_contenido, contentDTO.getFcTagsApp());
								logger.info("insertoTagsApp " + contentDTO.getFcNombre() + ": " + success);
							}
						}
					} catch(Exception e) {
						success = false;
						logger.error("Ocurrio error al acceder a BO: " + e.getMessage());
					}
					if(success) {
						try {
							String tipoSeccion="";
							if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticia") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticias"))
								tipoSeccion="noticias";
							else if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblog") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblogs"))
								tipoSeccion="videoblogs";
							else
								tipoSeccion=contentDTO.getFcTipoSeccion();
							
							String id_categoria=contentDTO.getFcFriendlyURLCategoria() !=null && !contentDTO.getFcFriendlyURLCategoria().equals("")?contentDTO.getFcFriendlyURLCategoria():contentDTO.getFcIdCategoria();
							
							String id_seccion=contentDTO.getFcFriendlyURLSeccion() !=null && !contentDTO.getFcFriendlyURLSeccion().equals("")?contentDTO.getFcFriendlyURLSeccion():contentDTO.getFcSeccion();
							
							String carpetaContenido = parametrosDTO.getPathFiles() + tipoSeccion + "/" + id_seccion +"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre();

							//logger.info("carpetaContenido: "+carpetaContenido);
							success = prerender.createFolders(carpetaContenido);
							
							if(success){
								prerender.createPlantilla(parametrosDTO, contentDTO,myContent.getWorkflowStageId().getName().trim());
								String html_amp=prerender.createPlantillaAMP(parametrosDTO, contentDTO,myContent.getWorkflowStageId().getName().trim());
								if(!html_amp.equals("")){
									try {
										logger.info("Enviamos PUSH al AMP");
										//WrapperAMP wrapperAMP=new WrapperAMP();
										//wrapperAMP.setContentDTO(contentDTO);
										//wrapperAMP.setHtmlAMP(html_amp);
										PushAMP pushAMP=new PushAMP();
										pushAMP.setFcIdCategoria(contentDTO.getFcIdCategoria());
										pushAMP.setFcIdContenido(contentDTO.getFcIdContenido());
										pushAMP.setFcNombre(contentDTO.getFcNombre());
										pushAMP.setFcSeccion(contentDTO.getFcSeccion());
										pushAMP.setFcTipoSeccion(contentDTO.getFcTipoSeccion());
										pushAMP.setFcTitulo(contentDTO.getFcTitulo());
										pushAMP.setFdFechaPublicacion(contentDTO.getFdFechaPublicacion());
										pushAMP.setHtmlAMP(html_amp);
										procesoBO = new ProcesoBO(parametrosDTO.getURL_WS_BASE_AMP());
										//RespuestaWSAMP  respuestaWSAMP=procesoBO.sendPushAMP(wrapperAMP);
										RespuestaWSAMP  respuestaWSAMP=procesoBO.sendPushAMP(pushAMP);
										
										logger.info("Respuesta AMP: "+respuestaWSAMP.getRespuesta());
									} catch (Exception e) {
										logger.info("Ocurrio un error al hacer la PUSH al AMP");
									}
								}
								try {
									procesoBO = new ProcesoBO(parametrosDTO.getURL_WS_BASE_FB());
									//IdResponse article_id_fb=procesoBO.insertUpdateArticleFB(contentDTO);
									String res=procesoBO.insertUpdateArticleFB(contentDTO);
									Gson respuestaJson = new Gson();
									IdResponseFacebook article_id_fb=respuestaJson.fromJson(res.toString(), IdResponseFacebook.class);
									
									ContentComponentIterator ci = myContent.componentIterator();						
								 	while (ci.hasNext()) {					 	
								 		ContentComponent curr = (ContentComponent) ci.next();
								 		 if(curr.getName().trim().equals("txtArticleId")) {
								 			ShortTextComponent shortText = (ShortTextComponent) curr;
								 			shortText.setText(article_id_fb.getId());
								 			logger.info("Seteamos el article id generado por face: "+article_id_fb.getId());
								 			myContent.setComponent("txtArticleId", shortText);
								 		 }
								 	}
								} catch (Exception e) {
									logger.error("Error en FB: "+e.getMessage()+" -- "+e.getLocalizedMessage());
								}
								
								try {
									//Creando el json
									
									
									NoticiaDTO noticia=con.getNoticiaJson(myContent, ws, parametrosDTO);
									
									JSONObject jsonDetalle = new JSONObject();
									JSONObject jsonNota = new JSONObject();
									
									jsonNota.put("url_nota", noticia.getUrl_nota());
									jsonNota.put("id_contenido", noticia.getId_contenido());
									jsonNota.put("id_categoria", noticia.getId_categoria());
									jsonNota.put("nombre", noticia.getNombre());
									jsonNota.put("titulo", noticia.getTitulo());
									jsonNota.put("descripcion", noticia.getDescripcion());
									jsonNota.put("escribio", noticia.getEscribio());
									jsonNota.put("lugar", noticia.getLugar());
									jsonNota.put("fuente", noticia.getFuente());
									jsonNota.put("id_tipo_nota", noticia.getId_tipo_nota());
									jsonNota.put("imagen_principal", noticia.getImagen_principal());
									jsonNota.put("pie_imagen", noticia.getPie_imagen());
									jsonNota.put("video_youtube", noticia.getVideo_youtube());
									jsonNota.put("id_video_content", noticia.getId_video_content());
									jsonNota.put("id_video_player", noticia.getId_video_player());
									jsonNota.put("id_video_pcode", noticia.getId_video_pcode());
									jsonNota.put("galeria", noticia.getGaleria());
									jsonNota.put("imagen_infografia", noticia.getImagen_infografia());
									jsonNota.put("contenido_nota", noticia.getContenido_nota());
									jsonNota.put("fecha_publicacion", noticia.getFecha_publicacion());
									jsonNota.put("fecha_modificacion", noticia.getFecha_modificacion());
									jsonNota.put("adSetCode", noticia.getAdSetCode());
									jsonNota.put("ruta_dfp", noticia.getRuta_dfp());
									jsonNota.put("desc_categoria", noticia.getDesc_categoria());
									jsonNota.put("desc_seccion", noticia.getDesc_seccion());
									jsonNota.put("posicion_galeria", noticia.getPosicion_galeria());
									
									jsonDetalle.put("noticia", jsonNota);
									jsonDetalle.put("mensaje", "OK");
									jsonDetalle.put("codigo", "0");
									jsonDetalle.put("causa_error", "");	
									
									writeJson(carpetaContenido+"/detalle.json", jsonDetalle.toString());
								    
								} catch (Exception e) {
									logger.error("Error convirtiendo el objeto NoticiaDTO: ",e);
								}
								
							}
								
						} catch (Exception e) {
							logger.error("Error al generar prerender : ", e);
						}					
					}			
				
					ws.logout();												
				}
			  }
			} catch (Exception e) {
			logger.debug("Exception GeneraNoticia: ", e);
		}
		return success;		
	}
	
	
	private void writeJson(String parRuta, String json)
	{		
		
		try {							
			Writer wt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(parRuta),"UTF-8"));
			try {
				wt.write(json);
			} finally {
				wt.close();
			}						
		} catch (Exception e) {
			logger.error("Exception en writeJson: ",e);
		}
	}
}
