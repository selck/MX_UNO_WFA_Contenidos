package mx.com.amx.unotv.workflow.bo;

import mx.com.amx.unotv.workflow.dto.ContentDTO;
import mx.com.amx.unotv.workflow.dto.IdResponseFacebook;
import mx.com.amx.unotv.workflow.dto.ParametrosDTO;
import mx.com.amx.unotv.workflow.dto.PushAMP;
import mx.com.amx.unotv.workflow.dto.RespuestaWSAMP;
import mx.com.amx.unotv.workflow.dto.VideoOoyalaDTO;
import mx.com.amx.unotv.workflow.util.ElementosContenido;
import mx.com.amx.unotv.workflow.util.OperacionesPreRender;

import org.apache.log4j.Logger;

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
							/*try {
								if(contentDTO.getFcTagsApp() != null && contentDTO.getFcTagsApp().length>0){
									procesoBOColombia.deleteTagsApp(contentDTO);
								}
							} catch (Exception e) {
								logger.error("Error deleteTagsApp[Colombia]: "+e.getLocalizedMessage());
							}
							try {
								procesoBOColombia.deleteNotaBD(contentDTO);
							} catch (Exception e) {
								logger.error("Error deleteNotaBD[Colombia]: "+e.getLocalizedMessage());
							}
							try {
								procesoBOColombia.deleteNotaHistoricoBD(contentDTO);
							} catch (Exception e) {
								logger.error("Error deleteNotaHistoricoBD[Colombia]: "+e.getLocalizedMessage());
							}*/
							
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
							
							//Se utilizará la base url absoluta para poder ver las imagenes y estilos productivos.
							
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
								
								//bo
							}
								
						} catch (Exception e) {
							logger.error("Error al generar prerender : ", e);
						}					
					}			
					/*logger.info("=========================Empezando con Colombia===================================================================");
					try {
						ProcesoBO procesoBOColombia = new ProcesoBO(parametrosDTO.getURL_WS());
						try {
							procesoBOColombia.setNotaBD(contentDTO);
							logger.info("Termino setNota OK");
						} catch (Exception e) {
							logger.error("Error setNotaBD[Colombia]: "+e.getLocalizedMessage());
						}
												
						try {
								procesoBOColombia.insertTagsAppContent(contentDTO);
						} catch (Exception e) {
								logger.error("Error insertTagsAppContent[Colombia]: "+e.getLocalizedMessage());
						}
						logger.info("insertoTagsApp_colombia " + contentDTO.getFcNombre() + ": " + success);
						
						
					} catch (Exception e) {
						logger.error("Error con el proceso de Colombia ",e);
					}*/
					ws.logout();												
				}
			  }
			} catch (Exception e) {
			logger.debug("Exception GeneraNoticia: ", e);
		}
		return success;		
	}
}
