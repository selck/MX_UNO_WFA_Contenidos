package mx.com.amx.unotv.workflow.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ibm.workplace.wcm.api.Content;
import com.ibm.workplace.wcm.api.ContentComponent;
import com.ibm.workplace.wcm.api.ContentComponentIterator;
import com.ibm.workplace.wcm.api.DocumentId;
import com.ibm.workplace.wcm.api.HTMLComponent;
import com.ibm.workplace.wcm.api.OptionSelectionComponent;
import com.ibm.workplace.wcm.api.RichTextComponent;
import com.ibm.workplace.wcm.api.ShortTextComponent;
import com.ibm.workplace.wcm.api.SiteArea;
import com.ibm.workplace.wcm.api.TextComponent;
import com.ibm.workplace.wcm.api.Workspace;

import mx.com.amx.unotv.workflow.dto.ContentDTO;
import mx.com.amx.unotv.workflow.dto.ParametrosDTO;

public class ElementosContenido {
	
private final Logger logger = Logger.getLogger(this.getClass().getName());
	
public ContentDTO getContenido(Content myContent, Workspace ws, ParametrosDTO parametrosDTO) {
		ContentDTO contentDTO = new ContentDTO();
		boolean success = true;
		try {			
			try {									
				DocumentId sitA = myContent.getDirectParent();
				SiteArea siteAreaParent = (SiteArea) ws.getById(sitA);		
				ContentComponentIterator ci = siteAreaParent.componentIterator();
				while (ci.hasNext()) {
			 		ContentComponent curr = (ContentComponent) ci.next();		
			 		if(curr.getName().trim().equals("txtSeccion")) {	
			 			TextComponent shortText = (TextComponent) curr;
			 			contentDTO.setFcSeccion(shortText.getText());
			 		}else if(curr.getName().trim().equals("txtTipoSeccion")) {
			 			TextComponent shortText = (TextComponent) curr;
			 			contentDTO.setFcTipoSeccion(shortText.getText());
			 		}else if(curr.getName().trim().equals("txtCategoria")) {
			 			TextComponent shortText = (TextComponent) curr;
			 			contentDTO.setFcIdCategoria(shortText.getText());
			 		}else if(curr.getName().trim().equals("txtNombreCategoria")) {
			 			TextComponent shortText = (TextComponent) curr;
			 			contentDTO.setFcNombreCategoria(shortText.getText());
			 		}else if(curr.getName().trim().equals("txtFriendlyURLSeccion")) {
			 			TextComponent shortText = (TextComponent) curr;
			 			contentDTO.setFcFriendlyURLSeccion(shortText.getText());
			 		}else if(curr.getName().trim().equals("txtFriendlyURLCategoria")) {
			 			TextComponent shortText = (TextComponent) curr;
			 			contentDTO.setFcFriendlyURLCategoria(shortText.getText());
			 		}
			 		
			 	}					 																	
			} catch (Exception e) {
				success = false;
				logger.error("Error al recorrer el area de sitio padre: ", e);
			}
			
			if(success) {
				try {		
					try { 
						String keyWords [] = myContent.getKeywords();
						String keywords = "";
						for(int i = 0; i < keyWords.length; i++) {
							if(i==0)
								keywords = keyWords[i];
							else 
								keywords += "," + keyWords[i];
						}
						contentDTO.setFcKeywords(keywords);
					} catch (Exception e) {
						contentDTO.setFcKeywords("");
					}
					contentDTO.setFcTitulo(myContent.getTitle().trim().replaceAll("\n", "").replaceAll("\r", ""));
					contentDTO.setFcNombre(myContent.getName().trim().replaceAll("\n", "").replaceAll("\r", ""));
					contentDTO.setFcIdContenido(myContent.getId().getId());
					contentDTO.setFcPaisRegistro("MEX");
					/*String descripcion=myContent.getDescription();
					logger.info("IndexOf Salto Linea Descripcion 1: "+descripcion.indexOf("\n"));
					descripcion=descripcion.replaceAll("/\r?\n/g", "");
					descripcion=descripcion.trim().replaceAll("\n", "").replaceAll("\r", "");
					logger.info("IndexOf Salto Linea Descripcion 2: "+descripcion.indexOf("\n"));*/
					contentDTO.setFcDescripcion(myContent.getDescription().trim().replaceAll("/\r?\n/g", "").replaceAll("\n", "").replaceAll("\r", ""));
					contentDTO.setFdFechaPublicacion(new Timestamp(myContent.getEffectiveDate().getTime()));
					//Fecha de ModificacioncontentDTO.setFdFechaPublicacion(new Timestamp(myContent.getModifiedDate().getTime()));
					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					contentDTO.setFcFecha(format.format(myContent.getEffectiveDate()));
					format = new SimpleDateFormat("HH:mm");
					contentDTO.setFcHora(format.format(myContent.getEffectiveDate()));
					ContentComponentIterator ci = myContent.componentIterator();						
				 	while (ci.hasNext()) {					 	
				 		ContentComponent curr = (ContentComponent) ci.next();
				 		 if(curr.getName().trim().equals("txtTags")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcTags(shortText.getText().toLowerCase()); 
				 		 }else if(curr.getName().trim().equals("txtEscribio")) {
			 				ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcEscribio(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtImagenPrincipal")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcImgPrincipal(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtPieImagenPrincipal")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcPieFoto(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtImagenInfografia")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcImgInfografia(shortText.getText());
				 		}else if(curr.getName().trim().equals("htmlData")) {	
				 			HTMLComponent html = (HTMLComponent) curr;
	    					contentDTO.setClGaleriaImagenes(html.getHTML());	    									 		
				 		}else if(curr.getName().trim().equals("selectGalery")) {
				 			OptionSelectionComponent op = (OptionSelectionComponent) curr;
				 			try {
				 				contentDTO.setPlaceGallery((op.getSelections()[0]));
				 			} catch (Exception e){
				 				logger.error("Error en selectGalery");
				 			}
	    					 									 		
				 		}else if(curr.getName().trim().equals("selectPcodes")) {
				 			OptionSelectionComponent op = (OptionSelectionComponent) curr;
				 			try {
				 				Properties propsTmp = new Properties();
				 				propsTmp.load(this.getClass().getResourceAsStream( "/general.properties" ));
				 				String seleccion = op.getSelections()[0];
				 				contentDTO.setFcPCode(propsTmp.getProperty("pcode."+seleccion));
				 			} catch (Exception e){
				 				logger.error("Error en selectPcode");
				 			}
	    					 									 		
				 		} else if(curr.getName().trim().equals("rtfContenido")) {
				 			RichTextComponent rtf = (RichTextComponent) curr;
				 			contentDTO.setClRtfContenido(rtf.getRichText());
				 		} else if(curr.getName().trim().equals("txtIDVideoYouTube")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcIdVideoYouTube(shortText.getText());
				 		} else if(curr.getName().trim().equals("txtIDVideoOoyala")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcIdVideoOoyala(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtIDPlayerOoyala")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcIdPlayerOoyala(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtTituloComentario")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcTituloComentario(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtEscribio")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcEscribio(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtLugar")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcLugar(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtFuente")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcFuente(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtPatrocinioBackGround")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcPatrocinioBackGround(shortText.getText());
				 		}else if(curr.getName().trim().equals("txtPatrocinioColor")) {
				 			ShortTextComponent shortText = (ShortTextComponent) curr;
	    					contentDTO.setFcPatrocinioColorTexto(shortText.getText());
				 		}else if(curr.getName().trim().equals("selectCategorias")) {
				 			OptionSelectionComponent op = (OptionSelectionComponent) curr;
				 			try {
				 				for (String seleccion : op.getSelections()) {
									if(seleccion.toLowerCase().trim().equals("infinito home")){
										contentDTO.setFiBanInfinito(1);
									}else if(seleccion.toLowerCase().trim().equals("videos virales")){
										contentDTO.setFiBanVideoViral(1);
									}else if(seleccion.toLowerCase().trim().equals("no te lo pierdas")){
										contentDTO.setFiBanNoTeLoPierdas(1);
									}else if(seleccion.toLowerCase().trim().equals("patrocinio")){
										contentDTO.setFiBanPatrocinio(1);
									}
								}
				 			} catch (Exception e){
				 				logger.error("Error en selectCategorias");
				 			}
				 		}else if(curr.getName().trim().equals("selectTagApp")) {
				 			OptionSelectionComponent op = (OptionSelectionComponent) curr;
				 			try {
				 				contentDTO.setFcTagsApp(op.getSelections());
				 			} catch (Exception e){
				 				logger.error("Error en selectTagApp");
				 			}
				 		}
				 	}
				 	contentDTO.setFcIdTipoNota(validateNota(contentDTO));
				} catch (Exception e) {
					contentDTO = new ContentDTO();
					success = false;
					logger.error("Error al recorrer el contenido: ", e);
				}
			}		
		} catch(Exception e) {
			contentDTO = new ContentDTO();
		}
		return contentDTO;
	}		
	
	String validateNota(ContentDTO contentDTO){
		String respuesta = "";
		try {

			if(//contentDTO.getFcIdVideoYouTube() !=null && !contentDTO.getFcIdVideoYouTube().equals("") && contentDTO.getClGaleriaImagenes() != null && !contentDTO.getClGaleriaImagenes().equals("") || 
			   contentDTO.getFcIdVideoOoyala() !=null && !contentDTO.getFcIdVideoOoyala().equals("") && contentDTO.getClGaleriaImagenes() != null && !contentDTO.getClGaleriaImagenes().equals("") 
			   ){
			   respuesta="multimedia";
			}else if(contentDTO.getFcIdVideoYouTube() !=null && !contentDTO.getFcIdVideoYouTube().equals("") || contentDTO.getFcIdVideoOoyala() !=null && !contentDTO.getFcIdVideoOoyala().equals("")){
				respuesta="video";
			}else if( contentDTO.getClGaleriaImagenes() != null && !contentDTO.getClGaleriaImagenes().equals("")){
				respuesta="galeria";
			}else if(contentDTO.getFcImgInfografia() != null && !contentDTO.getFcImgInfografia().equals("")){
				respuesta="infografia";
			}else
				respuesta="imagen";
		} catch (Exception e) {
			logger.error("Error validateNota: ",e);
		}
		return respuesta;
	}
}
