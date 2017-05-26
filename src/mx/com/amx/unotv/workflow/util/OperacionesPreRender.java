package mx.com.amx.unotv.workflow.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import mx.com.amx.unotv.workflow.bo.ProcesoBO;
import mx.com.amx.unotv.workflow.dto.ParametrosDTO;
import mx.com.amx.unotv.workflow.dto.ContentDTO;
import mx.com.amx.unotv.workflow.dto.RedSocialEmbedPost;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class OperacionesPreRender {

private final static Logger logger = Logger.getLogger(OperacionesPreRender.class);	

public static void main(String[] args){
	try {
		//String rtfContenido="<p dir=\"ltr\">Ella es <strong>Simone Anderson</strong>. La mujer de 25 años, residente de Auckland, <strong>Nueva Zelanda</strong>, dbajó 88 kilos en ¡tan sólo 20 meses!</p>/n/n<p dir=\"ltr\">Su transformación fue documentada en sus redes sociales desde 2014, donde, además de fotografías, que dan cuenta de la evolución de su cuerpo, publica arduas sesiones de ejercicio y presume cómo es su vida ahora que cuenta con un cuerpo realmente esbelto.</p>/n/n<p dir=\"ltr\">[instagram=https://www.instagram.com/p/BFPle90NKsh/=instagram]</p>/n/n<p dir=\"ltr\">Dijo que compartió su historia en Instagram para motivarse. Hizo un compromiso, lo respetó y ahora cuenta su historia a la <strong>BBC</strong>, donde explica el porqué decidió hacer un cambio drástico en su vida.</p>/n/n<p dir=\"ltr\"><em><strong>\"Era el momento de hacer algo al respecto y sentí que utilizando Instagram sería la forma de comprometerme verdaderamente\".</strong></em></p>/n/n<p dir=\"ltr\">Publicar en 2014, a los 23 años, su primera foto en <strong>Instagram </strong>no fue nada sencillo, comenta. Pasó horas llorando hasta que por fin se decidió a hacerlo.</p>/n/n<p dir=\"ltr\"><em><strong>\"En el momento en el que le di a \"publicar' sentí que me liberaba de un gran peso, sabía que no había vuelta atrás\".</strong></em></p>/n/n<p dir=\"ltr\">Recibió críticas, muchas críticas, e incluso cuestionamientos sobre la veracidad de su transformación. Se sintió herida. Al mismo tiempo fue ganando adeptos, quienes siguieron puntualmente sus pasos.</p>/n/n<p dir=\"ltr\"><em><strong>\"Me di cuenta que estaba siendo una inspiración para otra gente con el mismo problema y eso me encantaba\".</strong></em></p>/n/n<p dir=\"ltr\">Aquí el antes y el después:</p>/n/n<p dir=\"ltr\">[instagram=https://www.instagram.com/p/BFBSQLCNKs-/=instagram]</p>/n/n<p dir=\"ltr\"><em><strong>¿Y cómo logró tan buenos resultados?</strong></em></p>/n/n<p dir=\"ltr\">Simone explica que se sometió a la operación de la manga gástrica, mediante la cual redujo alrededor del 15% del tamaño original del estómago. Aunado a ello, hizo dieta y se fijó un estilo de vida más saludable, acompañado de un régimen de ejercicio.</p>/n/n<p dir=\"ltr\">Ahora la mujer, rubia y guapísima, se ve así:</p>/n/n<p dir=\"ltr\">[instagram=https://www.instagram.com/p/BFqIZkVtKu_/=instagram]</p>/n/n<p dir=\"ltr\">[instagram=https://www.instagram.com/p/BFF1GcbNKpQ/=instagram]</p>/n/n<p dir=\"ltr\">¿Guapa, verdad?</p>/n/n<p dir=\"ltr\"><em><strong>Su evolución en imágenes:</strong></em></p>/n/n<p dir=\"ltr\">Aquí puedes ver un Timelapse de su pérdida de peso:</p>/n/n<p dir=\"ltr\">kaka</p>/n";
		String rtfContenido="Los boxeadores profesionales, sin excluir a superestrellas como Floyd Mayweather o Manny Pacquiao, podrían realizar su debut olímpico en Río 2016 según los planes del presidente de la AIBA, Asociación Internacional de Boxeo adscrita al Comité Olímpico Internacional, Wu Ching-kuo. Este, en el transcurso de una reunión de su Asociacion en Gran Bretaña, señaló que los criterios de elegibilidad olímpica pueden ser modificados en breve. Este cambio será tratado en la misma, si bien luego debe ser ratificado por la Comisión Ejecutiva en caso de ser aprobados.Pocas dudas hay de que lo serán, sin embargo. Wu ha señalado que el boxeo es \"el único deporte sin sus profesionales en los Juegos. El COI y las Federaciones queremos que estén los mejores. De acuerdo con nuestros estatutos es posible realizar el cambio de forma inmediata. Es, además, el 70 aniversario de la AIBA y queremos hacer algo especial\".La AIBA lleva tiempo, en un proceso acelerado por la llegada de Wu a la presidencia, tratando de entrar en el mundo del boxeo profesional. Según algunas opiniones, tratando también de dar la batalla a las organizaciones puramente profesionales (WBA, WBO, WBC, IBF...) aprovechando para ello también su vinculación al COI, dado que sólo podrían participar en los Juegos aquellos púgiles con licencia AIBA. Así, se ha eliminado la palabra 'amateur' de su nombre, se han eliminado el casco y la camiseta de muchos de sus eventos masculinos, y se ha establecido que no se considerará profesional a quien haya disputado menos de 15 combates remunerados."+
"Barça"+
"<p dir=\"ltr\" style=\"text-align: justify;\"> aki va un parrafo veda</p>"+
"Barça"+
"FACEBOOK"+
"[facebook=https://www.facebook.com/martavsilva10/photos/pb.100433703438266.-2207520000.1457207815./101605036654466/?type=3&theater=facebook]"+
"INSTAGRAM"+
"[instagram=https://www.instagram.com/p/BCP4DShq_0F/?taken-by=musaliya135=instagram]"+
"Además, la AIBA ha organizado las Series Mundiales, una competición por equipos con pagos a los púgiles.Esta medida significaría, al menos en teoria, que se podrían ver en acción ya en Río 2016 a algunas de las grandes estrellas del boxeo. Floyd Mayweather podría volver a los Juegos a unir a los títulos mundiales en cinco categorías y sus cientos de millones de dólares ganados el oro en peso pluma que se escapó en Atlanta 1996, derrotado por el búlgaro Serafim Todorov.Su rival en la pelea por el mundial welter que batió récords de expectación y económicos, el ahora controvertido Manny Pacquiao, también podría entonces volver a los Juegos con todas las de ley, tras haber sido abanderado de Filipinas en Pekín 2008. En aquella ocasión fue elegido el nadador Miguel Molina, pero la presidenta Gloria Macapagal pidió que se le confiriera el honor al boxeador, que se había proclamado pocos meses antes campeón mundial del peso ligero WBC.Otros boxeadores, como Mohamed Alí, George Foreman o Lennox Lewis, entre otros, pasaron por los Juegos antes de iniciar exitosas trayectorias profesionales."+
"FACEBOOK 2"+
"[facebook=https://web.facebook.com/barackobama/videos/10154182550046749/=facebook]"+
"Sin embargo, no se ha hablado de un cambio de reglamentos para el boxeo olímpico, que consta de tres asaltos, mientras un combate profesional se compone de 12. Otras voces señalan que sería injusto enfrentar en los combates olímpicos a profesionales expertos con jóvenes que realizan sus primeras armas en el boxeo. Y finalmente, está por ver que grandes y supermillonarias estrellas, que no acostumbran a dar un paso gratuitamente, se sientan lo bastante atraídas por el oro olímpico como para disputar unos combates sin remuneración, al menos directa."+
"TWITTER"+
"[twitter=https://twitter.com/missyfranklin/status/703369208382431232=twitter]"+
"Y ya por ultimo un lindo gif..."+
"[giphy=http://giphy.com/gifs/sassy-batman-ZuM7gif8TCvqU,http://i.giphy.com/rgg2PJ6VJTyPC.gif=giphy]"+
"TWITTER 2"+
"[twitter=https://twitter.com/yelenaisinbaeva/status/636795867622731776=twitter]"+
"Más de Instagram"+
"La judoca mexicana, Vanessa Zambotti, tendrá el control total del Instagram de Claro Sports.Así como lo lees, tendremos #UnDíaConVanessaZambotti, donde la atleta mexicana compartirá con los seguidores de Claro Sports su vida diaria, desde los entrenamientos y muchas cosas más que no puedes perderte."+ 
"[instagram=https://www.instagram.com/p/BCqE0Ixhfy1/?taken-by=clarosports=instagram]"+
"Así que no lo dudes, síguenos en Instagram @ClaroSports, porque tendremos un lunes muy especial."+
"[instagram=https://www.instagram.com/p/BCqXA_ABf3x/?taken-by=clarosports=instagram]"+
"WIDGET"+
"[widget-elecciones-eeuu]"+
"<p dir=\"ltr\" style=\"text-align: justify;\"> aki va otro parrafo veda</p>"+
"¿Quieres ver las fotos que está compartiendo Vanessa desde nuestra cuenta? Da clic AQUÍ."+
"Y ya por ultimo un lindo gif 2..."+
"[giphy=http://giphy.com/gifs/superman-funny-wdh1SvEn0E06I,http://i.giphy.com/wdh1SvEn0E06I.gif=giphy]";
		
		
		/*String [] listInstagram=StringUtils.substringsBetween(rtfContenido, "https://www.instagram.com/p/", "/");
		for (String string : listInstagram) {
			System.out.println(string);
		}
		
		String [] listFace=StringUtils.substringsBetween(rtfContenido, "[facebook=", "=facebook]");
		for (String string : listFace) {
			System.out.println(string);
		}	
		
		String [] listTwitter=StringUtils.substringsBetween(rtfContenido, "[twitter=", "=twitter]");
		for (String string : listTwitter) {
			System.out.println(string);
		}
		
		String [] listGIF=StringUtils.substringsBetween(rtfContenido, "[twitter=", "=twitter]");
		for (String string : listGIF) {
			System.out.println(string);
		}*/
		
	
	} catch (Exception e) {
		System.out.println(e.getLocalizedMessage());
	}
}
private static String devuelveCadenasPost(String id_red_social, String rtfContenido){
	String url="", cadenaAReemplazar="", salida="";
	try {
		cadenaAReemplazar=rtfContenido.substring(rtfContenido.indexOf("["+id_red_social+"="), rtfContenido.indexOf("="+id_red_social+"]"))+"="+id_red_social+"]";
		url=cadenaAReemplazar.replace("["+id_red_social+"=", "").replace("="+id_red_social+"]", "");
		salida=cadenaAReemplazar+"|"+url;
	} catch (Exception e) {
		logger.error("Error devuelveCadenasPost: ",e);
		return "|";
	}
	return salida;
}

private static String getEmbedPost(String RTFContenido){
	try {
		String rtfContenido=RTFContenido;
		
		String url, cadenaAReemplazar;
		StringBuffer embedCode;
		HashMap<String,ArrayList<RedSocialEmbedPost>> MapAReemplazar = new HashMap<String,ArrayList<RedSocialEmbedPost>>();
		int num_post_embebidos;
		int contador;
		if(rtfContenido.contains("[instagram")){
			//logger.info("Embed Code instagram");
			ArrayList<RedSocialEmbedPost> listRedSocialEmbedInstagram=new ArrayList<RedSocialEmbedPost>();
			num_post_embebidos=rtfContenido.split("\\[instagram=").length-1;
			contador=1;
			do{
				RedSocialEmbedPost embebedPost=new RedSocialEmbedPost();
				String cadenas=devuelveCadenasPost("instagram", rtfContenido);
				cadenaAReemplazar=cadenas.split("\\|")[0];
				url=cadenas.split("\\|")[1];
				rtfContenido=rtfContenido.replace(cadenaAReemplazar, "");
				embedCode=new StringBuffer();
				embedCode.append(" <div class=\"instagram-post\"> \n");
				embedCode.append(" <blockquote data-instgrm-captioned data-instgrm-version=\"6\" class=\"instagram-media\"> \n");
				embedCode.append(" <div> \n");
				embedCode.append(" 	<p><a href=\""+url+"\"></a></p> \n");
				embedCode.append(" </div> \n");
				embedCode.append(" </blockquote> \n");
				embedCode.append(" <script async defer src=\"//platform.instagram.com/en_US/embeds.js\"></script> \n");
				embedCode.append(" </div> \n");
				
				embebedPost.setCadena_que_sera_reemplazada(cadenaAReemplazar);
				embebedPost.setRed_social("instagram");
				embebedPost.setCodigo_embebido(embedCode.toString());
				
				listRedSocialEmbedInstagram.add(embebedPost);
				contador ++;
			}while(contador <= num_post_embebidos);
			
			MapAReemplazar.put("instagram", listRedSocialEmbedInstagram);
		}
		if(rtfContenido.contains("[twitter")){
			//logger.info("Embed Code twitter");
			ArrayList<RedSocialEmbedPost> listRedSocialEmbedTwitter=new ArrayList<RedSocialEmbedPost>();
			num_post_embebidos=rtfContenido.split("\\[twitter=").length-1;
			contador=1;
			do{
				RedSocialEmbedPost embebedPost=new RedSocialEmbedPost();
				String cadenas=devuelveCadenasPost("twitter", rtfContenido);
				cadenaAReemplazar=cadenas.split("\\|")[0];
				url=cadenas.split("\\|")[1];
				rtfContenido=rtfContenido.replace(cadenaAReemplazar, "");
				embedCode=new StringBuffer();
				embedCode.append(" <div class=\"tweeet-post\"> \n");
				embedCode.append(" 		<blockquote data-width=\"500\" lang=\"es\" class=\"twitter-tweet\"><a href=\""+url+"\"></a></blockquote> \n");
				embedCode.append(" 		<script type=\"text/javascript\" async defer src=\"//platform.twitter.com/widgets.js\" id=\"twitter-wjs\"></script> \n");
				embedCode.append(" </div> \n");
				
				embebedPost.setCadena_que_sera_reemplazada(cadenaAReemplazar);
				embebedPost.setRed_social("twitter");
				embebedPost.setCodigo_embebido(embedCode.toString());
				
				listRedSocialEmbedTwitter.add(embebedPost);
				contador ++;
			}while(contador <= num_post_embebidos);
			
			MapAReemplazar.put("twitter", listRedSocialEmbedTwitter);
		
		}
		if(rtfContenido.contains("[facebook")){
			//logger.info("Embed Code facebook");
			ArrayList<RedSocialEmbedPost> listRedSocialEmbedFacebook=new ArrayList<RedSocialEmbedPost>();
			num_post_embebidos=rtfContenido.split("\\[facebook=").length-1;
			contador=1;
			do{
				RedSocialEmbedPost embebedPost=new RedSocialEmbedPost();
				String cadenas=devuelveCadenasPost("facebook", rtfContenido);
				cadenaAReemplazar=cadenas.split("\\|")[0];
				url=cadenas.split("\\|")[1];
				rtfContenido=rtfContenido.replace(cadenaAReemplazar, "");
				embedCode=new StringBuffer();
				embedCode=new StringBuffer();
				embedCode.append(" <div class=\"facebook-post\"> \n");
				embedCode.append(" 		<div data-href=\""+url+"\" data-width=\"500\" class=\"fb-post\"></div> \n");
				embedCode.append(" </div> \n");
				
				embebedPost.setCadena_que_sera_reemplazada(cadenaAReemplazar);
				embebedPost.setRed_social("facebook");
				embebedPost.setCodigo_embebido(embedCode.toString());
				
				listRedSocialEmbedFacebook.add(embebedPost);
				contador++;;
			}while(contador <= num_post_embebidos);
			
			MapAReemplazar.put("facebook", listRedSocialEmbedFacebook);
		}
		if(rtfContenido.contains("[giphy")){
			//logger.info("Embed Code giphy");
			ArrayList<RedSocialEmbedPost> listRedSocialEmbedGiphy=new ArrayList<RedSocialEmbedPost>();
			num_post_embebidos=rtfContenido.split("\\[giphy=").length-1;
			contador=1;
			do{
				RedSocialEmbedPost embebedPost=new RedSocialEmbedPost();
				String cadenas=devuelveCadenasPost("giphy", rtfContenido);
				cadenaAReemplazar=cadenas.split("\\|")[0];
				url=cadenas.split("\\|")[1];
				rtfContenido=rtfContenido.replace(cadenaAReemplazar, "");
				embedCode=new StringBuffer();
				embedCode=new StringBuffer();
				embedCode.append(" <img src=\""+url.split("\\,")[1]+"\" class=\"giphy\"> \n");
				embedCode.append(" <span>Vía  \n");
				embedCode.append(" 	<a href=\""+url.split("\\,")[0]+"\" target=\"_blank\">Giphy</a> \n");
				embedCode.append("  </span> \n");
				
				embebedPost.setCadena_que_sera_reemplazada(cadenaAReemplazar);
				embebedPost.setRed_social("giphy");
				embebedPost.setCodigo_embebido(embedCode.toString());
				
				listRedSocialEmbedGiphy.add(embebedPost);
				contador ++;
			}while(contador <= num_post_embebidos);
			
			MapAReemplazar.put("giphy", listRedSocialEmbedGiphy);
		}
		
		
		if(!MapAReemplazar.isEmpty()){
			Iterator<String> iterator_red_social = MapAReemplazar.keySet().iterator();
			String red_social="", codigo_embebido="", cadena_que_sera_reemplazada="";
			while(iterator_red_social.hasNext()){
				red_social = iterator_red_social.next();
		        if(red_social.equalsIgnoreCase("twitter") || red_social.equalsIgnoreCase("facebook") || red_social.equalsIgnoreCase("instagram") 
		        		|| red_social.equalsIgnoreCase("giphy")){
		        	ArrayList<RedSocialEmbedPost> listEmbebidos=MapAReemplazar.get(red_social);
		        	for (RedSocialEmbedPost redSocialEmbedPost : listEmbebidos) {
			        	cadena_que_sera_reemplazada=redSocialEmbedPost.getCadena_que_sera_reemplazada();
			        	codigo_embebido=redSocialEmbedPost.getCodigo_embebido();
			        	RTFContenido=RTFContenido.replace(cadena_que_sera_reemplazada, codigo_embebido);
					}
		        	
		        }
		    } 
		}
		try {
			StringBuffer widget=new StringBuffer();
			widget.append(" <div class=\"widget-eua\">\n");
			widget.append(" <script type=\"text/javascript\" src=\"https://dujy1obvgbkk2.cloudfront.net/widgets/index.js\" data-showtbox-include data-widget-type=\"us_election\" data-height=\"300px\" data-width=\"300px\" data-widget-country=\"MX\" data-widget-lang=\"ES\" data-partner-id=\"b982ecc6-af9d-4b94-a073-fc40d15ce9e0\" data-fullscreen-link=\"https://www.showt.com/us-election/ES\"></script>\n");
			widget.append(" </div>\n");
			RTFContenido = RTFContenido.replace("[widget-elecciones-eeuu]", widget.toString());
		} catch (Exception e) {
			RTFContenido = RTFContenido.replace("[widget-elecciones-eeuu]", "");
			logger.error("Error al sustituir [widget-elecciones-eeuu]");
		}
		
		try {
			StringBuffer widget=new StringBuffer();
			widget.append(" <div class=\"mapa-elecciones\">\n");
			widget.append(" 	<div class=\"counter-elecciones\">\n");
			widget.append(" 	  <p>Clinton</p>\n");
			widget.append(" 	  <p>Tendencia Clinton</p>\n");
			widget.append(" 	  <p>No decidido</p>\n");
			widget.append(" 	  <p>Tendencia Trump</p>\n");
			widget.append(" 	  <p>Trump</p>\n");
			widget.append(" 	</div>\n");
			widget.append(" 	<div id=\"mapa-elecciones\"></div>\n");
			widget.append(" 	<script type=\"text/javascript\" src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDomk2vz2UiyFZNxaW80hOueCie6qgIed8&amp;language=es\"></script>\n");
			widget.append(" </div>\n");
			/*widget.append(" <div class=\"mapa-elecciones\">\n");
			widget.append(" <div class=\"counter-elecciones\">\n");
			widget.append(" <p>Democratas</p>\n");
			widget.append(" <p></p>\n");
			widget.append(" <p>No decidido</p>\n");
			widget.append(" <p></p>\n");
			widget.append(" <p>Republicanos</p>\n");
			widget.append(" </div>\n");
			widget.append(" <div id=\"mapa-elecciones\"></div>\n");
			widget.append(" <script type=\"text/javascript\" src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDomk2vz2UiyFZNxaW80hOueCie6qgIed8&amp;language=es\"></script>\n");
			widget.append(" </div>\n"); */
			RTFContenido = RTFContenido.replace("[mapa-elecciones-eeuu]", widget.toString());
		} catch (Exception e) {
			RTFContenido = RTFContenido.replace("[mapa-elecciones-eeuu]", "");
			logger.error("Error al sustituir [mapa-elecciones-eeuu]");
		}
		return RTFContenido;
	} catch (Exception e) {
		logger.error("Error getEmbedPost: ",e);
		return RTFContenido;
	}
}

	public ParametrosDTO obtenerPropiedades(String properties) {
		ParametrosDTO parametrosDTO = new ParametrosDTO();		 
		try {	    		
			Properties propsTmp = new Properties();
			propsTmp.load(this.getClass().getResourceAsStream( "/general.properties" ));
			String ambiente = propsTmp.getProperty("ambiente");
			//logger.info("ambiente: "+ambiente);
			String rutaProperties = propsTmp.getProperty(properties.replace("ambiente", ambiente));
			//logger.info("rutaProperties: "+rutaProperties);
			Properties props = new Properties();
			
			props.load(new FileInputStream(new File(rutaProperties)));
			parametrosDTO.setURL_WS(propsTmp.getProperty(ambiente+".URL_WS"));
			parametrosDTO.setURL_WS_VIDEO(propsTmp.getProperty(ambiente+".URL_WS_VIDEO"));
			parametrosDTO.setURL_WS_PARAMETROS(propsTmp.getProperty(ambiente+".URL_WS_PARAM"));
			parametrosDTO.setCarpetaResources(props.getProperty("carpetaResources"));
			parametrosDTO.setPathFiles(props.getProperty("pathFiles"));
			parametrosDTO.setBasePaginaPlantilla(props.getProperty("basePaginaPlantilla"));
			parametrosDTO.setPathShell(props.getProperty("pathShell"));
			parametrosDTO.setPathRemote(props.getProperty("pathRemote"));
			parametrosDTO.setNameAuthoringTemplate(props.getProperty("nameAuthoringTemplate"));
			parametrosDTO.setNameHTML(props.getProperty("nameHTML"));
			parametrosDTO.setBaseTheme(props.getProperty("baseTheme"));		
			parametrosDTO.setBaseURL(props.getProperty("baseURL"));
			parametrosDTO.setURL_WS_BASE(props.getProperty("URL_WS_BASE"));
			parametrosDTO.setBasePagesPortal(props.getProperty("basePagesPortal"));	
			parametrosDTO.setBaseNoticiasComscore(props.getProperty("baseNoticiasComscore"));		
			parametrosDTO.setPathShellElimina(props.getProperty("pathShellElimina"));
			parametrosDTO.setPathDetalle(props.getProperty("pathDetalle"));
			parametrosDTO.setDominio(props.getProperty("dominio"));
			parametrosDTO.setNameStageExpireWF(props.getProperty("nameStageExpireWF"));
			parametrosDTO.setAmbiente(props.getProperty("ambiente"));
			parametrosDTO.setUrlBuscador(props.getProperty("urlBuscador"));
			parametrosDTO.setURL_WS_BASE_BUSCADOR(props.getProperty("URL_WS_BASE_BUSCADOR"));
			parametrosDTO.setMetaVideo(props.getProperty("metaVideo"));
			parametrosDTO.setMetaVideoSecureUrl(props.getProperty("metaVideoSecureUrl"));
			parametrosDTO.setURL_WEBSERVER(props.getProperty("URL_WEBSERVER"));
			
			parametrosDTO.setNameStagePublishWF(props.getProperty("nameStagePublishWF"));
			parametrosDTO.setNameStageReviewWF(props.getProperty("nameStageReviewWF"));
			parametrosDTO.setPathFilesTest(props.getProperty("pathFilesTest"));
			parametrosDTO.setBaseURLTest(props.getProperty("baseURLTest"));
			
			parametrosDTO.setURL_WS_BASE_AMP(props.getProperty("URL_WS_BASE_AMP"));
			parametrosDTO.setURL_WEBSERVER_AMP(props.getProperty("URL_WEBSERVER_AMP"));
			parametrosDTO.setURL_WEBSERVER_CSS_AMP(props.getProperty("URL_WEBSERVER_CSS_AMP"));
			parametrosDTO.setURL_WS_BASE_FB(props.getProperty("URL_WS_BASE_FB"));
			
			parametrosDTO.setCatalogoParametros(propsTmp.getProperty("catalogoParametros"));
			
			
		} catch (Exception ex) {
			parametrosDTO = new ParametrosDTO();
			logger.error("No se encontro el Archivo de propiedades: ", ex);			
		}
		return parametrosDTO;
    }
	
	public boolean createFolders(String carpetaContenido) {
		boolean success = false;
		try {						
			File carpetas = new File(carpetaContenido) ;
			if(!carpetas.exists()) {   
				success = carpetas.mkdirs();					
			} else 
				success = true;							
		} catch (Exception e) {
			success = false;
			logger.error("Ocurrio error al crear las carpetas: ", e);
		} 
		return success;
	}
	
	public boolean createPlantilla(ParametrosDTO parametrosDTO, ContentDTO contentDTO, String etapaTrabajo) {
		boolean success = false;
		Document doc = null;
		String tipoSeccion="";
		String id_categoria="";
		String id_seccion="";
		try {
						
			try {
				if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticia") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticias"))
					tipoSeccion="noticias";
				else if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblog") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblogs"))
					tipoSeccion="videoblogs";
				else
					tipoSeccion=contentDTO.getFcTipoSeccion();
				
				id_categoria=contentDTO.getFcFriendlyURLCategoria() !=null && !contentDTO.getFcFriendlyURLCategoria().equals("")?contentDTO.getFcFriendlyURLCategoria():contentDTO.getFcIdCategoria();
				
				//String seccion=contentDTO.getFcSeccion().equalsIgnoreCase("estados")?"portal/estados":contentDTO.getFcSeccion();
				id_seccion=contentDTO.getFcFriendlyURLSeccion() !=null && !contentDTO.getFcFriendlyURLSeccion().equals("")?contentDTO.getFcFriendlyURLSeccion():contentDTO.getFcSeccion();
				
				String urlAConectar=parametrosDTO.getBasePaginaPlantilla().replace("$TIPO_SECCION$", tipoSeccion).replace("$SECCION$", id_seccion).replace("$CATEGORIA$", id_categoria);
				if(contentDTO.getFcSeccion().equalsIgnoreCase("estados")){
					//id_seccion=id_seccion.equalsIgnoreCase("estados")?"portal/estados":id_seccion;
					//http://UTVSVPPOS01-1.tmx-internacional.net:10039/wps/portal/unotv/unotv/$TIPO_SECCION$/$SECCION$/$CATEGORIA$//detalle-prerender
					urlAConectar=parametrosDTO.getBasePaginaPlantilla().replace("$TIPO_SECCION$", tipoSeccion).replace("$SECCION$", id_seccion.equalsIgnoreCase("estados")?"portal/estados":id_seccion).replace("$CATEGORIA$", "").replaceAll("//detalle-prerender", "/detalle-prerender");;
					//urlAConectar=urlAConectar.replaceAll("//", "/");
				}
				
				logger.info("Conectandose a : "+urlAConectar);
				doc = Jsoup.connect(urlAConectar).timeout(120000).get();
				success = true;								
			} catch(Exception e) {
				logger.error("Ocurrio error al Obtener el HTML de : ", e);					
				success = false;
			}
			if(success) {
				String HTML = doc.html();
				
				HTML = reemplazaPlantilla(HTML, contentDTO, parametrosDTO);
				
				String carpetaResources=etapaTrabajo.equalsIgnoreCase("unotv-wfs-revision")?
						"http://pruebas-unotv.tmx-internacional.net/"+ parametrosDTO.getCarpetaResources() + "/":
							"/" + parametrosDTO.getCarpetaResources() + "/";
						
				HTML = HTML.replace(parametrosDTO.getBaseTheme(),carpetaResources);
				//HTML = HTML.replace(parametrosDTO.getBaseTheme(), "/" + parametrosDTO.getCarpetaResources() + "/");
				
				//String tipoSeccion=(contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticia") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticias")) ?"noticias":"videoblogs";
				
				//String rutaHTML = parametrosDTO.getPathFiles() + tipoSeccion + "/" + id_seccion+"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre() + "/" + parametrosDTO.getNameHTML();
				String rutaHTML = etapaTrabajo.equalsIgnoreCase("unotv-wfs-revision")?
						parametrosDTO.getPathFilesTest() + tipoSeccion + "/" + id_seccion+"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre() + "/" + parametrosDTO.getNameHTML()
						:parametrosDTO.getPathFiles() + tipoSeccion + "/" + id_seccion+"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre() + "/" + parametrosDTO.getNameHTML();

				logger.info("Ruta HTML: "+rutaHTML);
				success = writeHTML(rutaHTML, HTML);
								
				logger.info("Genero HTML Local: "+success);
				if(success && parametrosDTO.getAmbiente().equalsIgnoreCase("desarrollo")) {					
					transfiereWebServer(parametrosDTO);
				}
			}
		} catch(Exception e) {
			logger.error("Error al obtener HTML de Plantilla: ", e);
		}
		return success;
	}
	
	public String createPlantillaAMP(ParametrosDTO parametrosDTO, ContentDTO contentDTO,String etapaTrabajo) {
		boolean success = false;
		String tipoSeccion="";
		String id_categoria="";
		String id_seccion="";
		String HTML="";
		try {
						
			if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticia") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticias"))
				tipoSeccion="noticias";
				else if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblog") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblogs"))
				tipoSeccion="videoblogs";
				else
				tipoSeccion=contentDTO.getFcTipoSeccion();

				id_categoria=contentDTO.getFcFriendlyURLCategoria() !=null && !contentDTO.getFcFriendlyURLCategoria().equals("")?contentDTO.getFcFriendlyURLCategoria():contentDTO.getFcIdCategoria();

				id_seccion=contentDTO.getFcFriendlyURLSeccion() !=null && !contentDTO.getFcFriendlyURLSeccion().equals("")?contentDTO.getFcFriendlyURLSeccion():contentDTO.getFcSeccion();

				ReadHTMLWebServer readHTMLWebServer=new ReadHTMLWebServer();
				
				HTML = readHTMLWebServer.getHTML_DetailAMP(parametrosDTO);

				HTML = reemplazaPlantillaAMP(HTML, contentDTO, parametrosDTO);

				String rutaHTML = etapaTrabajo.equalsIgnoreCase("unotv-wfs-revision")?
				parametrosDTO.getPathFilesTest() + tipoSeccion + "/" + id_seccion+"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre() + "/amp.html"
				:parametrosDTO.getPathFiles() + tipoSeccion + "/" + id_seccion+"/"+ id_categoria+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre() + "/amp.html";

				logger.info("Ruta HTML AMP: "+rutaHTML);
				success = writeHTML(rutaHTML, HTML);
						
				logger.info("Genero HTML Local AMP: "+success);
				if(success && parametrosDTO.getAmbiente().equalsIgnoreCase("desarrollo")) {					
					transfiereWebServer(parametrosDTO);
				}
			
		} catch(Exception e) {
			logger.error("Error al obtener HTML de Plantilla: ", e);
			return "";
		}
		return HTML;
	}
	private String htmlEncode(final String string) {
		  final StringBuffer stringBuffer = new StringBuffer();
		  for (int i = 0; i < string.length(); i++) {
		    final Character character = string.charAt(i);
		    if (CharUtils.isAscii(character)) {
		      // Encode common HTML equivalent characters
		      stringBuffer.append(
		    		  org.apache.commons.lang3.StringEscapeUtils.escapeHtml4(character.toString()));
		    } else {
		      // Why isn't this done in escapeHtml4()?
		      stringBuffer.append(
		          String.format("&#x%x;",
		              Character.codePointAt(string, i)));
		    }
		  }
		  return stringBuffer.toString();
		}
	private String reemplazaPlantilla(String HTML, ContentDTO contentDTO, ParametrosDTO parametrosDTO) 
	{
		
		try {
			String[] pala=  contentDTO.getFcNombre().split("-");
			String id="";
			if(pala.length > 1){
				id=pala[pala.length - 1];
			}
			HTML = HTML.replace("numberUnoCross", id.trim());
		} catch (Exception e) {
			HTML = HTML.replace("numberUnoCross", "");
			logger.error("Error al remplazar numberUnoCross");
			
		}
		try {
			String titulo_comentario=contentDTO.getFcTituloComentario() == null || contentDTO.getFcTituloComentario().equals("")?"¿Qué opinas?":contentDTO.getFcTituloComentario();
			HTML = HTML.replace("$WCM_TITULO_COMENTARIO$", StringEscapeUtils.escapeHtml(titulo_comentario));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_TITULO_COMENTARIO$", "");
			logger.error("Error al sustituir $WCM_TITULO_COMENTARIO$");
		}
		// Remplaza comscore
		try {		
			HTML = HTML.replace("$WCM_NAVEGACION_COMSCORE$", contentDTO.getFcTipoSeccion() + "." + contentDTO.getFcSeccion()+"."+ contentDTO.getFcIdCategoria()+ "." + parametrosDTO.getPathDetalle() + "." + contentDTO.getFcNombre());
		} catch (Exception e) {
			logger.error("Error al sustituir navegacion  comscore");
		}
		

		try {
			HTML = HTML.replace("$WCM_DESCRIPCION_CONTENIDO$", htmlEncode(contentDTO.getFcDescripcion().trim()));
		} catch(Exception e) {
			HTML = HTML.replace("$WCM_DESCRIPCION_CONTENIDO$", "");
			logger.error("Error al remplazar $WCM_DESCRIPCION_CONTENIDO$");
		}
		
		try {
			HTML = HTML.replace("$WCM_ID_CATEGORIA$", contentDTO.getFcIdCategoria().trim());
		} catch(Exception e) {
			HTML = HTML.replace("$WCM_ID_CATEGORIA$", "");
			logger.error("Error al remplazar $WCM_ID_CATEGORIA$");
		}
		try {
			//HTML = HTML.replace("$WCM_TITLE_CONTENIDO$", StringEscapeUtils.escapeHtml((contentDTO.getFcTitulo().trim()));
			HTML = HTML.replace("$WCM_TITLE_CONTENIDO$",StringEscapeUtils.escapeHtml(contentDTO.getFcTitulo().trim()));
		} catch(Exception e) {
			HTML = HTML.replace("$WCM_TITLE_CONTENIDO$", "");
			logger.error("Error al remplazar $WCM_TITLE_CONTENIDO$");
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			HTML = HTML.replace("$WCM_FECHA$", format.format(contentDTO.getFdFechaPublicacion()));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_FECHA$", "");
			logger.error("Error al remplazar $WCM_FECHA$");
		}
		try {
			HTML = HTML.replace("$WCM_HORA$", contentDTO.getFcHora());
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_HORA$", "");
			logger.error("Error al remplazar $WCM_HORA$");
		}
		try {
			String autor = contentDTO.getFcEscribio() == null? "": contentDTO.getFcEscribio();
			HTML = HTML.replace("$WCM_AUTOR$", StringEscapeUtils.escapeHtml(autor).trim());
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_AUTOR$", "");
			logger.error("Error al remplazar $WCM_AUTOR$");
		}
		try {
			String lugar = contentDTO.getFcLugar() == null? "": contentDTO.getFcLugar();
			HTML = HTML.replace("$WCM_LUGAR$", StringEscapeUtils.escapeHtml(lugar));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_LUGAR$", "");
			logger.error("Error al remplazar $WCM_LUGAR$");
		}
		try {
			String nombreCategoria = contentDTO.getFcNombreCategoria() == null? "": contentDTO.getFcNombreCategoria();
			HTML = HTML.replace("$WCM_CATEGORIA$", StringEscapeUtils.escapeHtml(nombreCategoria));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_CATEGORIA$", "");
			logger.error("Error al remplazar $WCM_CATEGORIA$");
		}
		try {
			String fuente = contentDTO.getFcFuente() == null? "": contentDTO.getFcFuente();
			HTML = HTML.replace("$WCM_FUENTE$", StringEscapeUtils.escapeHtml(fuente));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_FUENTE$", "");
			logger.error("Error al remplazar $WCM_FUENTE$");
		}
				
		
		try {
			boolean tieneGaleria=contentDTO.getClGaleriaImagenes() != null && !contentDTO.getClGaleriaImagenes().equals("")?true:false;
			boolean tieneVideo=contentDTO.getFcIdVideoOoyala() != null && !contentDTO.getFcIdVideoOoyala().equals("")?true:false;
			boolean tieneInfografia=contentDTO.getFcImgInfografia() != null && !contentDTO.getFcImgInfografia().equals("")?true:false;
				
			if(tieneGaleria && tieneVideo){
				logger.info("Tipo de Nota multimedia, se reemplaza tanto la galeria, como el video");
				//logger.info("Galeria: "+contentDTO.getClGaleriaImagenes());
				//logger.info("getPlaceGallery"+contentDTO.getPlaceGallery());
				HTML = HTML.replace("$WCM_MEDIA_CONTENT$", getMediaContent(contentDTO, parametrosDTO));
				if(contentDTO.getPlaceGallery().equalsIgnoreCase("arriba")){
					HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", cambiaCaracteres(contentDTO.getClGaleriaImagenes()));
					HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$","");
				}else{
					HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$","");
					HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", cambiaCaracteres(contentDTO.getClGaleriaImagenes()));
				}
			}else if (tieneGaleria) {
				logger.info("Tipo de Nota Galeria, se reemplaza solo la galeria");
				//logger.info("contentDTO.getPlaceGallery(): "+contentDTO.getPlaceGallery());
				HTML = HTML.replace("$WCM_MEDIA_CONTENT$", "");
				if(contentDTO.getPlaceGallery().equalsIgnoreCase("arriba")){
					HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", cambiaCaracteres(contentDTO.getClGaleriaImagenes()));
					HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$","");
				}else{
					HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$","");
					HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", cambiaCaracteres(contentDTO.getClGaleriaImagenes()));
				}
			}else if(tieneInfografia){
				logger.info("Tipo de Nota Infografia");
				HTML = HTML.replace("$WCM_MEDIA_CONTENT$", "");
				HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", "");
				HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", getMediaContent(contentDTO, parametrosDTO));
			}else{
				logger.info("Tipo de Nota video o default, se reemplaza solo el media Content");
				HTML = HTML.replace("$WCM_MEDIA_CONTENT$", getMediaContent(contentDTO, parametrosDTO));
				HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", "");
				HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", "");
			}
		} catch(Exception e) {
			HTML = HTML.replace("$WCM_MEDIA_CONTENT$", "");
			HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", "");
			HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", "");
			logger.error("Error al remplazar $WCM_MEDIA_CONTENT$ y $WCM_TIENE_GALERIA$");
		}
		
		
		try {
			HTML = HTML.replace("$WCM_RTF_CONTENIDO$", cambiaCaracteres(getEmbedPost(contentDTO.getClRtfContenido())));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_RTF_CONTENIDO$", "");
			logger.error("Error al remplazar $WCM_RTF_CONTENIDO$");
		}	
		try {
			StringBuffer widget=new StringBuffer();
			widget.append(" <div class=\"widget-eua\">\n");
			widget.append(" <script type=\"text/javascript\" src=\"https://dujy1obvgbkk2.cloudfront.net/widgets/index.js\" data-showtbox-include data-widget-type=\"us_election\" data-height=\"300px\" data-width=\"300px\" data-widget-country=\"MX\" data-widget-lang=\"ES\" data-partner-id=\"b982ecc6-af9d-4b94-a073-fc40d15ce9e0\" data-fullscreen-link=\"https://www.showt.com/us-election/ES\"></script>\n");
			widget.append(" </div>\n");
			HTML = HTML.replace("[widget-elecciones-eeuu]", widget.toString());
		} catch (Exception e) {
			HTML = HTML.replace("[widget-elecciones-eeuu]", "");
			logger.error("Error al sustituir [widget-elecciones-eeuu]");
		}
		//				
		try {
			String tipoSeccion="";
			if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticia") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("noticias"))
				tipoSeccion="noticias";
			else if(contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblog") || contentDTO.getFcTipoSeccion().equalsIgnoreCase("videoblogs"))
				tipoSeccion="videoblogs";
			else
				tipoSeccion=contentDTO.getFcTipoSeccion();
			
			String url = tipoSeccion + "/" + contentDTO.getFcSeccion() +"/"+ contentDTO.getFcIdCategoria()+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre();
			
			//HTML = HTML.replace("$WCM_URL_PAGE$", contentDTO.getFcTipoSeccion() + "/" + contentDTO.getFcSeccion()+"/"+ contentDTO.getFcIdCategoria()+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre());
			//HTML = HTML.replace("$URL_PAGE$", "http://www.unotv.com/"+contentDTO.getFcTipoSeccion() + "/" + contentDTO.getFcSeccion()+"/"+ contentDTO.getFcIdCategoria()+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre()+"/");
			
			HTML = HTML.replace("$WCM_URL_PAGE$", url);
			HTML = HTML.replace("$URL_PAGE$", "http://www.unotv.com/"+url+"/");
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_URL_PAGE$", "");
			logger.error("Error al remplazar $WCM_URL_PAGE$");
		}
		
		/*
		 * COMENTADO POR PROBLEMAS CON EL GSA
		try {
			ParseaXMLWS parseaXMLWS=new ParseaXMLWS(parametrosDTO.getURL_WS_BASE_BUSCADOR());
			WrapperContentDTO wrapperContentDTO= parseaXMLWS.getListRelacionadasWrapper(contentDTO.getFcTags());
			List<ContentDTO> listRelacionadas=wrapperContentDTO.getListNotas();
			
			if(listRelacionadas!=null && listRelacionadas.size()>0){
			
								
				StringBuffer items=new StringBuffer();				
				String urlNota="";
				String idCategoria="", auxiliarURL=""; 
				
				for (int i = 0; i < listRelacionadas.size(); i++) {
					
					ContentDTO contentDTORelacionada = listRelacionadas.get(i);
					urlNota=contentDTORelacionada.getFcUrl();
					auxiliarURL=urlNota;
					auxiliarURL=auxiliarURL.substring(0,auxiliarURL.indexOf("/detalle"));
					String [] list=auxiliarURL.split("\\/");
					idCategoria=list[list.length - 1];
					
					items.append("<a href=\""+urlNota+"\" class=\"item-note\"> \n");
					items.append("  <div class=\"thumb\"> \n");
					items.append("	<img src=\"utils/img/blank.gif\" data-echo=\""+contentDTORelacionada.getFcImgPrincipal()+"\"> \n");
					items.append("  </div> \n");
					items.append("  <h3><span class=\"title\"> \n");										
					if(contentDTORelacionada.getFcIdTipoNota()!=null && contentDTORelacionada.getFcIdTipoNota().equals("video"))
					{
						items.append("<i class=\"fa fa fa-play\"></i>\n");
					}
					else if(contentDTORelacionada.getFcIdTipoNota()!=null && contentDTORelacionada.getFcIdTipoNota().equals("galeria"))
					{
						items.append("<i class=\"fa fa fa-camera-retro\"></i>\n");
					}										
					//items.append("	  "+cambiaCaracteres(contentDTORelacionada.getFcTitulo()).replaceAll("\\“", "&#8220;").replaceAll("\\”", "&#8221;")+" \n");
					items.append(" "+StringEscapeUtils.escapeHtml(contentDTORelacionada.getFcTitulo())+" \n");
					items.append("	  </span> \n");
					//provisional
					//items.append("	  <span class=\""+contentDTORelacionada.getFcIdCategoria()+" tag\">"+contentDTORelacionada.getFcIdCategoria()+"</span> \n");
					items.append("	  <span class=\""+idCategoria+" tag\">"+idCategoria+"</span> \n");
					items.append("  </h3> \n");
					items.append("</a> \n");
				}
				
				HTML = HTML.replace("$WCM_ELEMENTOS_INFINITO$", items);      
			}
			else
			{
				logger.debug("No hay notas relacionadas: ");
				HTML = HTML.replace("$WCM_ELEMENTOS_INFINITO$", "");			
			}
			
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_ELEMENTOS_INFINITO$", "");
			logger.error("Error al remplazar $WCM_ELEMENTOS_INFINITO$",e);
		}*/	
		
		/*
		Comentado por errores de repetidos
		try{
			ReadHTMLWebServer readHTMLWebServer=new ReadHTMLWebServer();
			String html_infinite=readHTMLWebServer.getHTMLInfinite(contentDTO.getFcIdCategoria(), parametrosDTO);
			logger.debug("Reemplazando relacionadas desde el webServer");
			HTML = HTML.replace("$WCM_ELEMENTOS_INFINITO$", html_infinite);
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_ELEMENTOS_INFINITO$", "");
			logger.error("Error al remplazar $WCM_ELEMENTOS_INFINITO$",e);
		}*/
		
		try{
			ProcesoBO procesoBO = new ProcesoBO(parametrosDTO.getURL_WS_BASE());
			List<ContentDTO> listRelacionadas=procesoBO.getRelacionadasbyIdCategoria(contentDTO);
			if(listRelacionadas!=null && listRelacionadas.size()>0){
				StringBuffer items=new StringBuffer();				
				for (int i = 0; i < listRelacionadas.size(); i++) {
					
					ContentDTO contentDTORelacionada = listRelacionadas.get(i);
					
					items.append("<a href=\""+contentDTORelacionada.getFcUrl()+"\" class=\"item-note\"> \n");
					items.append("  <div class=\"thumb\"> \n");
					items.append("	<img src=\"utils/img/blank.gif\" data-echo=\""+contentDTORelacionada.getFcImgPrincipal().replace("Principal", "Miniatura")+"\"  alt=\""+StringEscapeUtils.escapeHtml(contentDTORelacionada.getFcPieFoto())+"\">");
					items.append("  </div> \n");
					items.append("  <h3><span class=\"title\"> \n");										
					if(contentDTORelacionada.getFcIdTipoNota().equals("video"))
					{
						items.append("<i class=\"fa fa fa-play\"></i>\n");
					}else if(contentDTORelacionada.getFcIdTipoNota().equals("galeria"))
					{
						items.append("<i class=\"fa fa fa-camera-retro\"></i>\n");
					}else if(contentDTORelacionada.getFcIdTipoNota().equals("infografia"))
						items.append("<i class=\"fa fa-file-picture-o\"></i>");
					else if(contentDTORelacionada.getFcIdTipoNota().equals("multimedia")){
						items.append("<i class=\"fa fa fa-play\"></i> \n");
						items.append("<i class=\"fa fa fa-camera-retro\"></i> \n");
					}										
					items.append(" "+StringEscapeUtils.escapeHtml(contentDTORelacionada.getFcTitulo())+" \n");
					items.append("	  </span> \n");
					items.append("	  <span class=\""+contentDTORelacionada.getFcIdCategoria()+" tag\">"+StringEscapeUtils.escapeHtml(contentDTORelacionada.getFcNombreCategoria())+"</span> \n");
					items.append("  </h3> \n");
					items.append("</a> \n");
				}
				
				HTML = HTML.replace("$WCM_ELEMENTOS_INFINITO$", items);      
			}else{
				
				logger.debug("No hay notas relacionadas: ");
				HTML = HTML.replace("$WCM_ELEMENTOS_INFINITO$", "");			
			}
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_ELEMENTOS_INFINITO$", "");
			logger.error("Error al remplazar $WCM_ELEMENTOS_INFINITO$",e);
		}
		//Remplaza metas
		HTML = remplazaMetas(HTML, contentDTO, parametrosDTO);
		
		try {
			//logger.debug("Cambiando base URL...");
			//<base href="/wps/portal/unotv/unotv/noticias/portal/nacional/detalle-prerender/" target="_self" />
			String valorBase [] = HTML.split("<base");
			valorBase[0] = valorBase[1].substring(0, valorBase[1].indexOf("/>"));
			String tmp [] = valorBase[0].split("href=\"");
			String base = tmp[1].substring(0, tmp[1].indexOf("\""));
			//logger.debug("Base URL: "+base);
			HTML = HTML.replace(base, parametrosDTO.getBaseURL());
			//HTML = HTML.replace(base, "/");
		} catch (Exception e) {
			logger.debug("No tiene base URL");
		}	
		
		HTML = reemplazaURLPages(HTML, parametrosDTO.getBasePagesPortal());
		//HTML = reemplazaURLPages(HTML, "/wps/portal/unotv/unotv/");
		return HTML;
	}
	private String reemplazaPlantillaAMP(String HTML, ContentDTO contentDTO, ParametrosDTO parametrosDTO){
		
		try {
			ProcesoBO procesoBO = new ProcesoBO(parametrosDTO.getURL_WS_BASE());
			List<ContentDTO> listRelacionadas=procesoBO.getNotasMagazine("magazine-home-2",contentDTO.getFcIdContenido());
			StringBuffer relacionadas=new StringBuffer();
			if(listRelacionadas!=null && listRelacionadas.size()>0){
				for (ContentDTO relacionada : listRelacionadas) {
					relacionadas.append("<a class=\"card\" href=\""+relacionada.getFcUrl()+"\">\n");
					relacionadas.append("	<amp-img width=\"100\" height=\"70\" src=\""+relacionada.getFcImgPrincipal()+"\"></amp-img>\n");
					relacionadas.append("	<div>\n");
					relacionadas.append("	<span>"+StringEscapeUtils.escapeHtml(relacionada.getFcTitulo())+"</span>\n");
					relacionadas.append("	<small>"+relacionada.getFcIdCategoria()+"</small>\n");
					relacionadas.append("	</div>\n");
					relacionadas.append("</a>\n");
				}
				HTML = HTML.replace("$WCM_LIST_RELACIONADAS$",relacionadas.toString().trim());
			}
		} catch (Exception e) {
			logger.error("Error al sustituir relacionadas");
			HTML = HTML.replace("$WCM_LIST_RELACIONADAS$","");
		}
		
		try {		
			HTML = HTML.replace("$WCM_NAVEGACION_COMSCORE$", contentDTO.getFcTipoSeccion() + "." + contentDTO.getFcSeccion()+"."+ contentDTO.getFcIdCategoria()+ "." + parametrosDTO.getPathDetalle() + "." + contentDTO.getFcNombre());
		} catch (Exception e) {
			logger.error("Error al sustituir navegacion  comscore");
		}
		
		try {
			ReadHTMLWebServer readHTMLWebServer=new ReadHTMLWebServer();
			HTML = HTML.replace("$WCM_STYLES$",readHTMLWebServer.getCSS_DetailAMP(parametrosDTO).trim());
		} catch(Exception e) {
			HTML = HTML.replace("$WCM_STYLES$", "");
			logger.error("Error al remplazar $WCM_STYLES$");
		}
		
		try {
			HTML = HTML.replace("$WCM_TITLE_CONTENIDO$",StringEscapeUtils.escapeHtml(contentDTO.getFcTitulo().trim()));
		} catch(Exception e) {
			HTML = HTML.replace("$WCM_TITLE_CONTENIDO$", "");
			logger.error("Error al remplazar $WCM_TITLE_CONTENIDO$");
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			HTML = HTML.replace("$WCM_FECHA$", format.format(contentDTO.getFdFechaPublicacion()));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_FECHA$", "");
			logger.error("Error al remplazar $WCM_FECHA$");
		}
		try {
			HTML = HTML.replace("$WCM_HORA$", contentDTO.getFcHora());
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_HORA$", "");
			logger.error("Error al remplazar $WCM_HORA$");
		}
		try {
			String autor = contentDTO.getFcEscribio() == null? "": contentDTO.getFcEscribio();
			HTML = HTML.replace("$WCM_AUTOR$", StringEscapeUtils.escapeHtml(autor).trim());
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_AUTOR$", "");
			logger.error("Error al remplazar $WCM_AUTOR$");
		}
		try {
			String lugar = contentDTO.getFcLugar() == null? "": contentDTO.getFcLugar();
			HTML = HTML.replace("$WCM_LUGAR$", StringEscapeUtils.escapeHtml(lugar));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_LUGAR$", "");
			logger.error("Error al remplazar $WCM_LUGAR$");
		}
		try {
			String nombreCategoria = contentDTO.getFcNombreCategoria() == null? "": contentDTO.getFcNombreCategoria();
			HTML = HTML.replace("$WCM_CATEGORIA$", StringEscapeUtils.escapeHtml(nombreCategoria));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_CATEGORIA$", "");
			logger.error("Error al remplazar $WCM_CATEGORIA$");
		}
		try {
			String fuente = contentDTO.getFcFuente() == null? "": contentDTO.getFcFuente();
			HTML = HTML.replace("$WCM_FUENTE$", StringEscapeUtils.escapeHtml(fuente));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_FUENTE$", "");
			logger.error("Error al remplazar $WCM_FUENTE$");
		}
				
		
		try {
			boolean tieneGaleria=contentDTO.getClGaleriaImagenes() != null && !contentDTO.getClGaleriaImagenes().equals("")?true:false;
			boolean tieneVideo=contentDTO.getFcIdVideoOoyala() != null && !contentDTO.getFcIdVideoOoyala().equals("")?true:false;
			boolean tieneInfografia=contentDTO.getFcImgInfografia() != null && !contentDTO.getFcImgInfografia().equals("")?true:false;
				
			if(tieneGaleria && tieneVideo){
				logger.info("Tipo de Nota multimedia, se reemplaza tanto la galeria, como el video");
				HTML = HTML.replace("$WCM_MEDIA_CONTENT$", getMediaContentAMP(contentDTO));
				if(contentDTO.getPlaceGallery().equalsIgnoreCase("arriba")){
					HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", getGaleriaAMP(contentDTO));
					HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$","");
				}else{
					HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$","");
					HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", getGaleriaAMP(contentDTO));
				}
			}else if (tieneGaleria) {
				logger.info("Tipo de Nota Galeria, se reemplaza solo la galeria");
				HTML = HTML.replace("$WCM_MEDIA_CONTENT$", "");
				if(contentDTO.getPlaceGallery().equalsIgnoreCase("arriba")){
					HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", getGaleriaAMP(contentDTO));
					HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$","");
				}else{
					HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$","");
					HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", getGaleriaAMP(contentDTO));
				}
			}else if(tieneInfografia){
				logger.info("Tipo de Nota Infografia");
				HTML = HTML.replace("$WCM_MEDIA_CONTENT$", "");
				HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", getMediaContentAMP(contentDTO));
				HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", "");
			}else{
				logger.info("Tipo de Nota video o default, se reemplaza solo el media Content");
				HTML = HTML.replace("$WCM_MEDIA_CONTENT$", getMediaContentAMP(contentDTO));
				HTML = HTML.replace("$WCM_TIENE_GALERIA_DOWN$", "");
				HTML = HTML.replace("$WCM_TIENE_GALERIA_UP$", "");
			}
		} catch(Exception e) {
			HTML = HTML.replace("$WCM_MEDIA_CONTENT$", "");
			HTML = HTML.replace("$WCM_TIENE_GALERIA$", "");
			logger.error("Error al remplazar $WCM_MEDIA_CONTENT$ y $WCM_TIENE_GALERIA$");
		}
		
		
		try {
			HTML = HTML.replace("$WCM_RTF_CONTENIDO$", cambiaCaracteres(getEmbedPostAMP(contentDTO.getClRtfContenido())));
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_RTF_CONTENIDO$", "");
			logger.error("Error al remplazar $WCM_RTF_CONTENIDO$");
		}	
		
		try {			
			HTML = HTML.replace("$URL_WHATSAPP$", "http://www.unotv.com/"+contentDTO.getFcTipoSeccion() + "/" + contentDTO.getFcSeccion()+"/"+ contentDTO.getFcIdCategoria()+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre()+"/");
		} catch (Exception e) {
			HTML = HTML.replace("$URL_WHATSAPP$", "");
			logger.error("Error al remplazar $URL_WHATSAPP$");
		}
		
		try {			
			HTML = HTML.replace("$URL_PAGE$", "http://www.unotv.com/"+contentDTO.getFcTipoSeccion() + "/" + contentDTO.getFcSeccion()+"/"+ contentDTO.getFcIdCategoria()+"/"+ parametrosDTO.getPathDetalle() + "/" +contentDTO.getFcNombre()+"/");
		} catch (Exception e) {
			HTML = HTML.replace("$WCM_URL_PAGE$", "");
			logger.error("Error al remplazar $WCM_URL_PAGE$");
		}
		
		return HTML;
	}
	private static String getEmbedPostAMP(String RTFContenido){
		try {
			String rtfContenido=RTFContenido;
			String url, cadenaAReemplazar;
			StringBuffer embedCode;
			HashMap<String,ArrayList<RedSocialEmbedPost>> MapAReemplazar = new HashMap<String,ArrayList<RedSocialEmbedPost>>();
			int num_post_embebidos;
			int contador;
			if(rtfContenido.contains("[instagram")){
				//logger.info("Embed Code instagram");
				ArrayList<RedSocialEmbedPost> listRedSocialEmbedInstagram=new ArrayList<RedSocialEmbedPost>();
				num_post_embebidos=rtfContenido.split("\\[instagram=").length-1;
				contador=1;
				do{
					RedSocialEmbedPost embebedPost=new RedSocialEmbedPost();
					String cadenas=devuelveCadenasPost("instagram", rtfContenido);
					cadenaAReemplazar=cadenas.split("\\|")[0];
					url=cadenas.split("\\|")[1];
					rtfContenido=rtfContenido.replace(cadenaAReemplazar, "");
					embedCode=new StringBuffer();
					embedCode.append("<amp-instagram data-shortcode=\""+StringUtils.substringBetween(url, "https://www.instagram.com/p/", "/")+"\" width=\"300\" height=\"300\" layout=\"responsive\"></amp-instagram>\n");
					
					embebedPost.setCadena_que_sera_reemplazada(cadenaAReemplazar);
					embebedPost.setRed_social("instagram");
					embebedPost.setCodigo_embebido(embedCode.toString());
					
					listRedSocialEmbedInstagram.add(embebedPost);
					contador ++;
				}while(contador <= num_post_embebidos);
				
				MapAReemplazar.put("instagram", listRedSocialEmbedInstagram);
			}
			if(rtfContenido.contains("[twitter")){
				//logger.info("Embed Code twitter");
				ArrayList<RedSocialEmbedPost> listRedSocialEmbedTwitter=new ArrayList<RedSocialEmbedPost>();
				num_post_embebidos=rtfContenido.split("\\[twitter=").length-1;
				contador=1;
				do{
					RedSocialEmbedPost embebedPost=new RedSocialEmbedPost();
					String cadenas=devuelveCadenasPost("twitter", rtfContenido);
					cadenaAReemplazar=cadenas.split("\\|")[0];
					url=cadenas.split("\\|")[1];
					rtfContenido=rtfContenido.replace(cadenaAReemplazar, "");
					embedCode=new StringBuffer();
							
					embedCode.append(" <amp-twitter class=\"twitter\" width=\"400\" height=\"300\" layout=\"responsive\" data-tweetid=\""+url.split("/status/")[1]+"\" data-cards=\"hidden\"></amp-twitter> \n");
					
					embebedPost.setCadena_que_sera_reemplazada(cadenaAReemplazar);
					embebedPost.setRed_social("twitter");
					embebedPost.setCodigo_embebido(embedCode.toString());
					
					listRedSocialEmbedTwitter.add(embebedPost);
					contador ++;
				}while(contador <= num_post_embebidos);
				
				MapAReemplazar.put("twitter", listRedSocialEmbedTwitter);
			
			}
			if(rtfContenido.contains("[facebook")){
				//logger.info("Embed Code facebook");
				ArrayList<RedSocialEmbedPost> listRedSocialEmbedFacebook=new ArrayList<RedSocialEmbedPost>();
				num_post_embebidos=rtfContenido.split("\\[facebook=").length-1;
				contador=1;
				do{
					RedSocialEmbedPost embebedPost=new RedSocialEmbedPost();
					String cadenas=devuelveCadenasPost("facebook", rtfContenido);
					cadenaAReemplazar=cadenas.split("\\|")[0];
					url=cadenas.split("\\|")[1];
					rtfContenido=rtfContenido.replace(cadenaAReemplazar, "");
					embedCode=new StringBuffer();
					embedCode=new StringBuffer();
					if(url.contains("/videos/")){
						embedCode.append(" <amp-facebook width=\"300\" height=\"175\" layout=\"responsive\" data-embed-as=\"video\" data-href=\""+url+"\"></amp-facebook> \n");
					}else{
						embedCode.append(" <amp-facebook width=\"600\" height=\"300\" layout=\"responsive\" data-href=\""+url+"\"></amp-facebook>  \n");
					}
					
					embebedPost.setCadena_que_sera_reemplazada(cadenaAReemplazar);
					embebedPost.setRed_social("facebook");
					embebedPost.setCodigo_embebido(embedCode.toString());
					
					listRedSocialEmbedFacebook.add(embebedPost);
					contador++;;
				}while(contador <= num_post_embebidos);
				
				MapAReemplazar.put("facebook", listRedSocialEmbedFacebook);
			}
			if(rtfContenido.contains("[giphy")){
				//logger.info("Embed Code giphy");
				ArrayList<RedSocialEmbedPost> listRedSocialEmbedGiphy=new ArrayList<RedSocialEmbedPost>();
				num_post_embebidos=rtfContenido.split("\\[giphy=").length-1;
				contador=1;
				do{
					RedSocialEmbedPost embebedPost=new RedSocialEmbedPost();
					String cadenas=devuelveCadenasPost("giphy", rtfContenido);
					//cadenas giphy: [giphy=http://giphy.com/gifs/sassy-batman-ZuM7gif8TCvqU,http://i.giphy.com/rgg2PJ6VJTyPC.gif=giphy]|http://giphy.com/gifs/sassy-batman-ZuM7gif8TCvqU,http://i.giphy.com/rgg2PJ6VJTyPC.gif
					//cadenas giphy: [giphy=http://giphy.com/gifs/superman-funny-wdh1SvEn0E06I,http://i.giphy.com/wdh1SvEn0E06I.gif=giphy]|http://giphy.com/gifs/superman-funny-wdh1SvEn0E06I,http://i.giphy.com/wdh1SvEn0E06I.gif

					cadenaAReemplazar=cadenas.split("\\|")[0];
					url=cadenas.split("\\|")[1];
					rtfContenido=rtfContenido.replace(cadenaAReemplazar, "");
					embedCode=new StringBuffer();
					embedCode=new StringBuffer();
					embedCode.append(" <amp-img class=\"giphy\" src=\""+url.split("\\,")[1]+"\" width=\"300\" height=\"125\" layout=\"responsive\"></amp-img> \n");
					embedCode.append(" <span> Vía  \n");
					embedCode.append(" 	<a href=\""+url.split("\\,")[0]+"\" target=\"_blank\">Giphy</a> \n");
					embedCode.append("  </span> \n");
					
					embebedPost.setCadena_que_sera_reemplazada(cadenaAReemplazar);
					embebedPost.setRed_social("giphy");
					embebedPost.setCodigo_embebido(embedCode.toString());
					
					listRedSocialEmbedGiphy.add(embebedPost);
					contador ++;
				}while(contador <= num_post_embebidos);
				
				MapAReemplazar.put("giphy", listRedSocialEmbedGiphy);
			}
			
			
			if(!MapAReemplazar.isEmpty()){
				Iterator<String> iterator_red_social = MapAReemplazar.keySet().iterator();
				String red_social="", codigo_embebido="", cadena_que_sera_reemplazada="";
				while(iterator_red_social.hasNext()){
					red_social = iterator_red_social.next();
			        if(red_social.equalsIgnoreCase("twitter") || red_social.equalsIgnoreCase("facebook") || red_social.equalsIgnoreCase("instagram") 
			        		|| red_social.equalsIgnoreCase("giphy")){
			        	ArrayList<RedSocialEmbedPost> listEmbebidos=MapAReemplazar.get(red_social);
			        	for (RedSocialEmbedPost redSocialEmbedPost : listEmbebidos) {
				        	cadena_que_sera_reemplazada=redSocialEmbedPost.getCadena_que_sera_reemplazada();
				        	codigo_embebido=redSocialEmbedPost.getCodigo_embebido();
				        	RTFContenido=RTFContenido.replace(cadena_que_sera_reemplazada, codigo_embebido);
						}
			        	
			        }
			    } 
			}
			try {
				String listStyles[]=StringUtils.substringsBetween(RTFContenido,"style=\"","\"");
				for (String style : listStyles) {
					RTFContenido = RTFContenido.replace(style,"");
				}
				RTFContenido = RTFContenido.replace("style=\"\"","");
				
			} catch (Exception e) {
				//RTFContenido = RTFContenido.replace("[widget-elecciones-eeuu]", "");
				logger.error("Error al sustituir styles");
			}
			
			try {
				StringBuffer widget=new StringBuffer();
				widget.append("<amp-iframe class=\"video\" width=\"300px\" height=\"150px\" layout=\"responsive\" sandbox=\"allow-scripts allow-same-origin allow-popups allow-forms\" src=\"https://www.showt.com/widgets/US-Election?showtee_id=&amp;language_filter=ES&amp;theme=light&amp;event_id=&amp;partner_id=b982ecc6-af9d-4b94-a073-fc40d15ce9e0&amp;fullscreen_link=https%3A%2F%2Fwww.showt.com%2Fus-election%2FES&amp;widget_country=MX&amp;widget_lang=ES&amp;stream_id=&amp;window_type=showtbox&amp;intent=show-showtees\">\n");
				widget.append("        <amp-img layout=\"fill\" src=\"/recursos_mobile_first/css/img/usa_flag.jpg\" placeholder></amp-img>\n");
				widget.append("</amp-iframe>\n");
				RTFContenido = RTFContenido.replace("[widget-elecciones-eeuu]", widget.toString());
			} catch (Exception e) {
				RTFContenido = RTFContenido.replace("[widget-elecciones-eeuu]", "");
				logger.error("Error al sustituir [widget-elecciones-eeuu]");
			}
			
			try {
				StringBuffer widget=new StringBuffer();
				widget.append(" <amp-iframe class=\"video\" width=\"300px\" height=\"175px\" frameborder=\"0\" layout=\"responsive\" sandbox=\"allow-scripts allow-same-origin allow-popups allow-forms\" src=\"https://widgets.unotv.com/mapa-eleciones/\">\n");
				widget.append(" <amp-img layout=\"fill\" src=\"/recursos_mobile_first/css/img/usa_flag.jpg\" placeholder></amp-img>\n");
				widget.append(" </amp-iframe>\n");
				
				RTFContenido = RTFContenido.replace("[mapa-elecciones-eeuu]", widget.toString());
			} catch (Exception e) {
				RTFContenido = RTFContenido.replace("[mapa-elecciones-eeuu]", "");
				logger.error("Error al sustituir [mapa-elecciones-eeuu]");
			}
			return RTFContenido;
		} catch (Exception e) {
			logger.error("Error getEmbedPost: ",e);
			return RTFContenido;
		}
	}

	private String getMediaContentAMP(ContentDTO dto){
		String media="";
		if(!dto.getFcIdVideoOoyala().trim().equals("") || !dto.getFcIdVideoYouTube().trim().equals("") || !dto.getFcIdPlayerOoyala().trim().equals("")){
			media=getVideoAMP(dto);
		}else{
			media=getImagenAMP(dto);
		}
		return media;
	}
	private String getVideoAMP(ContentDTO dto) {
		
		StringBuffer mediaContent = new StringBuffer();
		String IdVideoYouTube = dto.getFcIdVideoYouTube() == null? "":dto.getFcIdVideoYouTube().trim();  
		String IdVideoOoyala = dto.getFcIdVideoOoyala() == null? "" : dto.getFcIdVideoOoyala().trim();
		String IdPlayerVideoOoyala = dto.getFcIdPlayerOoyala() == null? "" : dto.getFcIdPlayerOoyala().trim();
		
		if(!IdVideoYouTube.trim().equals("")){
			mediaContent.append("<amp-iframe class=\"video\" width=\"16\" height=\"9\" layout=\"responsive\" sandbox=\"allow-scripts allow-same-origin\" src=\"https://www.youtube.com/embed/"+IdVideoYouTube+"\"></amp-iframe>");
		}else if(!IdVideoOoyala.trim().equals("") && !IdPlayerVideoOoyala.trim().equals("")){
			mediaContent.append("<amp-iframe class=\"video\" width=\"16\" height=\"9\" layout=\"responsive\" sandbox=\"allow-scripts allow-same-origin\" src=\"https://player.ooyala.com/iframe.html?ec="+IdVideoOoyala+"&amp;pbid="+IdPlayerVideoOoyala+"&amp;platform=html5\">\n");
			mediaContent.append("<amp-img layout=\"fill\" src=\""+dto.getFcImgPrincipal()+"\" placeholder></amp-img>\n");
			mediaContent.append("</amp-iframe>\n");
			
		}
		return mediaContent.toString();
	}
	private String getGaleriaAMP(ContentDTO dto) {
		StringBuffer mediaImage = new StringBuffer("");
		String galeria = dto.getClGaleriaImagenes() == null?"":dto.getClGaleriaImagenes();
		if(!galeria.trim().equals("")){
		String listSRC[]=StringUtils.substringsBetween(galeria,"src=\"", "\">");
		String listDesc[]=StringUtils.substringsBetween(galeria,"<p>","<u>");
		String listPie[]=StringUtils.substringsBetween(galeria,"<u>","</u>");
			if(listSRC.length == listDesc.length && listSRC.length == listPie.length){
				mediaImage.append("<div class=\"gallery\">");
				for (int i = 0; i < listSRC.length; i++) {
					mediaImage.append("<div class=\"item-gallery\">");
					mediaImage.append("<amp-img width=\"545\" height=\"360\" layout=\"responsive\" src=\""+listSRC[i]+"\"></amp-img>");
					mediaImage.append("<p>"+cambiaCaracteres(listDesc[i])+" ");
					mediaImage.append("<u>"+cambiaCaracteres(listPie[i])+"</u>");
					mediaImage.append("</p>");
					mediaImage.append("</div>");
				}
				mediaImage.append("</div>");
				
			}
		}
		return mediaImage.toString();
	}
	private String getImagenAMP(ContentDTO dto) {
		StringBuffer mediaImage = new StringBuffer("");
		String imgPrincipal = dto.getFcImgPrincipal() == null?"":dto.getFcImgPrincipal();
		String imgInfografia = dto.getFcImgInfografia() == null?"":dto.getFcImgInfografia();
		String galeria = dto.getClGaleriaImagenes() == null?"":dto.getClGaleriaImagenes();
		String pieFoto = dto.getFcPieFoto() == null?"":dto.getFcPieFoto().trim();
		
		/*if(!galeria.trim().equals("")){
			String listSRC[]=StringUtils.substringsBetween(galeria,"src=\"", "\">");
			String listDesc[]=StringUtils.substringsBetween(galeria,"<p>","<u>");
			String listPie[]=StringUtils.substringsBetween(galeria,"<u>","</u>");
			if(listSRC.length == listDesc.length && listSRC.length == listPie.length){
				mediaImage.append("<div class=\"gallery\">");
				for (int i = 0; i < listSRC.length; i++) {
					mediaImage.append("<div class=\"item-gallery\">");
					mediaImage.append("<amp-img width=\"545\" height=\"360\" layout=\"responsive\" src=\""+listSRC[i]+"\"\"></amp-img>");
					mediaImage.append("<p>"+StringEscapeUtils.escapeHtml(listDesc[i])+" ");
					mediaImage.append("<u>"+StringEscapeUtils.escapeHtml(listPie[i])+"</u>");
					mediaImage.append("</p>");
					mediaImage.append("</div>");
				}
				mediaImage.append("</div>");
				
			}
		}else*/ 
		if(!imgInfografia.trim().equals("")){
			mediaImage.append("<amp-img width=\"287\" height=\"775\" layout=\"responsive\" src=\""+imgPrincipal+"\"></amp-img>");
		}else{
			mediaImage.append("<amp-img width=\"545\" height=\"360\" layout=\"responsive\" src=\""+imgPrincipal+"\"></amp-img>");
		}
		  return mediaImage.toString();
	}
	/*public String cambiaBaseURL(String HTML, String baseURL){
		try {
			logger.debug("Cambiando base URL...");
			String valorBase [] = HTML.split("<base");
			valorBase[0] = valorBase[1].substring(0, valorBase[1].indexOf("/>"));
			String tmp [] = valorBase[0].split("href=\"");
			String base = tmp[1].substring(0, tmp[1].indexOf("\""));
			logger.debug("Base URL: "+base);
			HTML = HTML.replace(base, baseURL);			
		} catch (Exception e) {
			logger.debug("No tiene base URL");
		}	
		return HTML;
	}*/
	/**
	 * */
	private String reemplazaURLPages(String HTML,  String basePortal) {
		try {
			HTML = HTML.replace(basePortal, "");
		} catch (Exception e) {
			logger.error("Ocurrio error al modificar URL de las paginas");
		}
		return HTML;		
	}
	
	/**
	 * 
	 * */
	private String getMediaContent(ContentDTO dto, ParametrosDTO parametrosDTO){
		String media="";
		if(!dto.getFcIdVideoOoyala().trim().equals("") || !dto.getFcIdVideoYouTube().trim().equals("") || !dto.getFcIdPlayerOoyala().trim().equals("")){
			media=getVideo(dto);
		}else{
			media=getImagen(dto);
		}
		return media;
	}
	
	/**
	 * 
	 * */
	private String getImagen(ContentDTO dto) {
		StringBuffer mediaImage = new StringBuffer("");
		String imgPrincipal = dto.getFcImgPrincipal() == null?"":dto.getFcImgPrincipal();
		String imgInfografia = dto.getFcImgInfografia() == null?"":dto.getFcImgInfografia();
		String galeria = dto.getClGaleriaImagenes() == null?"":dto.getClGaleriaImagenes();
		String pieFoto = dto.getFcPieFoto() == null?"":dto.getFcPieFoto().trim();
		
		if(!galeria.trim().equals("")){
			mediaImage.append(cambiaCaracteres(galeria));
		}else if(!imgInfografia.trim().equals("")){
			mediaImage.append("<div class=\"photo\">\n");
			mediaImage.append("<img src=\""+imgInfografia+"\" alt=\""+StringEscapeUtils.escapeHtml(pieFoto)+"\">");
			mediaImage.append("</div>");
		}else{
			mediaImage.append("<div class=\"photo\">\n");
			mediaImage.append("<img src=\""+imgPrincipal+"\" alt=\""+StringEscapeUtils.escapeHtml(pieFoto)+"\">");
			mediaImage.append("<p>"+StringEscapeUtils.escapeHtml(pieFoto)+"</p>");
			mediaImage.append("</div>");
		}
		  return mediaImage.toString();
	}
	
		
	private String getVideo(ContentDTO dto) {
		
		StringBuffer mediaContent = new StringBuffer();
		String IdVideoYouTube = dto.getFcIdVideoYouTube() == null? "":dto.getFcIdVideoYouTube().trim();  
		String IdVideoOoyala = dto.getFcIdVideoOoyala() == null? "" : dto.getFcIdVideoOoyala().trim();
		String IdPlayerVideoOoyala = dto.getFcIdPlayerOoyala() == null? "" : dto.getFcIdPlayerOoyala().trim();
		
		if(!IdVideoYouTube.trim().equals("")){
			mediaContent.append(" <div class=\"video\"> \n");
			mediaContent.append("<iframe id=\"ytplayer\" type=\"text/html\" width=\"640\" height=\"360\" src=\"https://www.youtube.com/embed/"+IdVideoYouTube+"\" frameborder=\"0\" allowfullscreen></iframe>\n");
			mediaContent.append(" </div> \n");
		}else if(!IdVideoOoyala.trim().equals("") && !IdPlayerVideoOoyala.trim().equals("")){
			mediaContent.append(" <div class=\"video\"> \n");
			mediaContent.append(" <div id=\"ooyalaplayer\"></div> \n");
			mediaContent.append(" </div> \n");
			//version 3 mediaContent.append("<script src=\"//player.ooyala.com/v3/"+IdPlayerVideoOoyala+"?platform=html5-priority\"></script>\n");
			//VERSION DE SIEMPRE 
			mediaContent.append("<script src=\"//player.ooyala.com/v3/"+IdPlayerVideoOoyala+"\"></script>\n");
			mediaContent.append("<script>OO.ready(function() { OO.Player.create('ooyalaplayer', '"+IdVideoOoyala+"', {\"autoplay\":true}); });</script>\n");
			mediaContent.append("<noscript><div>Please enable Javascript to watch this video</div></noscript>\n");
			
			//VERSION 4
			/*mediaContent.append(" <link rel=\"stylesheet\" href=\"//player.ooyala.com/static/v4/stable/4.10.6/skin-plugin/html5-skin.min.css\"> \n");
			mediaContent.append(" <script src=\"//player.ooyala.com/static/v4/stable/4.10.6/core.min.js\"></script> \n");
			mediaContent.append(" <script src=\"//player.ooyala.com/static/v4/stable/4.10.6/video-plugin/main_html5.min.js\"></script> \n");
			mediaContent.append(" <script src=\"//player.ooyala.com/static/v4/stable/4.10.6/video-plugin/osmf_flash.min.js\"></script> \n");
			mediaContent.append(" <script src=\"//player.ooyala.com/static/v4/stable/4.10.6/video-plugin/bit_wrapper.min.js\"></script> \n");
			mediaContent.append(" <script src=\"//player.ooyala.com/static/v4/stable/4.10.6/skin-plugin/html5-skin.min.js\"></script> \n");
			mediaContent.append(" <script type=\"text/javascript\" src=\"//player.ooyala.com/static/v4/stable/4.10.6/ad-plugin/google_ima.min.js\"></script> \n");
			
			mediaContent.append(" <script> \n");
			mediaContent.append(" var playerParam = { \n");
			mediaContent.append(" 	\"pcode\": \""+dto.getFcPCode()+"\", // Pcode Uno TV \n");
			mediaContent.append(" 	\"playerBrandingId\": \""+IdPlayerVideoOoyala+"\", // Player ID \n");
			mediaContent.append(" \"platform\": \"html5\", \n ");
			mediaContent.append(" 	\"autoplay\": true, \n");
			mediaContent.append(" 	\"skin\": { \n");
			mediaContent.append(" 		\"config\": \"/portal/unotv/ooyala/v4.10.6/skin.json\" \n");
			//mediaContent.append(" 		\"config\": \"/ooyala/v4.10.6/skin.json\" \n");
			mediaContent.append(" 	} \n");
			mediaContent.append(" }; \n");
			mediaContent.append(" OO.ready(function() { \n");
			mediaContent.append(" 	window.pp = OO.Player.create('ooyalaplayer', '"+IdVideoOoyala+"', playerParam); \n"); // Content ID
			mediaContent.append(" }); \n");
			mediaContent.append(" </script> \n"); */
		}
		return mediaContent.toString();
	}		

	public boolean writeHTML(String rutaHMTL, String HTML) {
		boolean success = false;
		try {
			FileWriter fichero = null;
	        PrintWriter pw = null;
	        try {
				fichero = new FileWriter(rutaHMTL);				
				pw = new PrintWriter(fichero);							
				pw.println(HTML);
				pw.close();
				success = true;
			} catch(Exception e){			
				logger.error("Error al obtener la plantilla " + rutaHMTL + ": ", e);
				success = false;
			}finally{
				try{                    			              
					if(null!= fichero)
						fichero.close();
				}catch (Exception e2){
					success = false;
					logger.error("Error al cerrar el file: ", e2);
				}
			}	
		} catch(Exception e) {
			success = false;
			logger.error("Fallo al crear la plantilla: ", e);
		}		
		return success;
	}
	
	private boolean transfiereWebServer(ParametrosDTO parametros) {
		logger.debug("transfiereWebServer");
		boolean success = false;
		String local = parametros.getPathFiles() + "*";
		String remote = parametros.getPathRemote();
		String comando= parametros.getPathShell() + " " + local + " " + remote;
		//String comandoElimina = parametros.getPathShellElimina() + " " + parametros.getPathFiles() + "*";
		
		try {								
			Runtime r = Runtime.getRuntime();
			logger.debug("comando: "+comando);
			//logger.debug("comandoElimina: "+comandoElimina);
			r.exec(comando).waitFor();
			//r.exec(comandoElimina).waitFor();			
			success = true;
		} catch(Exception e) {
			success = false;
			logger.error("Ocurrio un error al ejecutar el Shell " + comando + ": ", e);
		}		
		return success;
	}
	
	/**
	 * Metodo que remplaza los metas de una nota
	 * */
	private String remplazaMetas(String HTML, ContentDTO contentDTO, ParametrosDTO parametrosDTO)
	{
		
		/*logger.debug("==== Inicia remplazaMetas ==== ");
		logger.debug("contentDTO.getFcImgPrincipal():"+contentDTO.getFcImgPrincipal());
		logger.debug("contentDTO.getFcKeywords():"+contentDTO.getFcKeywords());
		logger.debug("contentDTO.getFdFechaPublicacion():"+contentDTO.getFcTitulo());
		logger.debug("contentDTO.getFcIdTipoNota():"+contentDTO.getFcIdTipoNota());
		logger.debug("contentDTO.getFcTipoSeccion():"+contentDTO.getFcTipoSeccion());
		logger.debug("contentDTO.getFcSeccion():"+contentDTO.getFcSeccion());
		logger.debug("contentDTO.getFcIdCategoria():"+contentDTO.getFcIdCategoria());
		logger.debug("contentDTO.getFcTags():"+contentDTO.getFcIdCategoria());*/
		

		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		TimeZone tz = TimeZone.getTimeZone("America/Mexico_City");
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		df.setTimeZone(tz);
		Date date = new Date();
				
		// Remplaza og:image
		try {
			String imageFija="/utils/img/default-noticias.png";
			HTML = HTML.replace(imageFija, contentDTO.getFcImgPrincipal().trim());			
		} catch (Exception e) {
			logger.error("Error al reemplazar meta og:image");
		}
		
		// Remplaza twitter:image
		try {
			HTML = HTML.replace("twitter:image", "twitter:image:src");			
		} catch (Exception e) {
			logger.error("Error al reemplazar meta twitter:image");
		}
		
		try {
			HTML = HTML.replace("$WCM_KEYWORDS$", cambiaCaracteres(contentDTO.getFcKeywords().trim()));
		} catch(Exception e) {
			HTML = HTML.replace("$WCM_KEYWORDS$", "");
			logger.error("Error al remplazar $WCM_KEYWORDS$");
		}
		
		//Remplaza nota:published_time [$META_PUBLISHED_TIME$]
		try {
			String fechaS=df.format(contentDTO.getFdFechaPublicacion());
			fechaS=fechaS.substring(0, fechaS.length()-2)+":00";
			HTML = HTML.replace("$META_PUBLISHED_TIME$" ,fechaS);
		} catch(Exception e) {
			HTML = HTML.replace("$META_PUBLISHED_TIME$", "");
			logger.error("Error al remplazar $META_PUBLISHED_TIME$");
		}

		//Remplaza nota:modified_time [$META_MODIFIED_TIME$]
		try {
			String fechaS=df.format(date);
			fechaS=fechaS.substring(0, fechaS.length()-2)+":00";
			HTML = HTML.replace("$META_MODIFIED_TIME$" ,fechaS);
		} catch(Exception e) {
			HTML = HTML.replace("$META_MODIFIED_TIME$", "");
			logger.error("Error al remplazar $META_MODIFIED_TIME$");
		}
		//Remplaza nota:tipo [$META_CONTENT_ID$]
		try {
			HTML = HTML.replace("$META_CONTENT_ID$" ,contentDTO.getFcIdContenido());
		} catch(Exception e) {
			HTML = HTML.replace("$META_CONTENT_ID$", "");
			logger.error("Error al remplazar $META_CONTENT_ID$");
		}
		//Remplaza nota:tipo [$META_FRIENDLY_URL$]
		try {
			HTML = HTML.replace("$META_FRIENDLY_URL$" ,contentDTO.getFcNombre());
		} catch(Exception e) {
			HTML = HTML.replace("$META_FRIENDLY_URL$", "");
			logger.error("Error al remplazar $META_FRIENDLY_URL$");
		}
		//Remplaza nota:tipo [$META_TIPO$]
		try {
			HTML = HTML.replace("$META_TIPO$" ,contentDTO.getFcIdTipoNota());
		} catch(Exception e) {
			HTML = HTML.replace("$META_TIPO$", "");
			logger.error("Error al remplazar $META_TIPO$");
		}
		
		//Remplaza nota:tipo_seccion [$META_TIPO_SECCION$]
		try {
			HTML = HTML.replace("$META_TIPO_SECCION$" ,contentDTO.getFcTipoSeccion());
		} catch(Exception e) {
			HTML = HTML.replace("$META_TIPO_SECCION$", "");
			logger.error("Error al remplazar $META_TIPO_SECCION$");
		}
		
		//Remplaza nota:seccion [$META_SECCION$]
		try {
			HTML = HTML.replace("$META_SECCION$" ,contentDTO.getFcSeccion());
		} catch(Exception e) {
			HTML = HTML.replace("$META_SECCION$", "");
			logger.error("Error al remplazar $META_SECCION$");
		}
		
		//Remplaza nota:categoria [$META_CATEGORIA$]
		try {
			HTML = HTML.replace("$META_CATEGORIA$" ,contentDTO.getFcIdCategoria());
		} catch(Exception e) {
			HTML = HTML.replace("$META_CATEGORIA$", "");
			logger.error("Error al remplazar $META_CATEGORIA$");
		}
		
		//Remplaza nota:tags [$META_TAGS$]
		try {
			HTML = HTML.replace("$META_TAGS$" ,cambiaCaracteres(contentDTO.getFcTags()));
		} catch(Exception e) {
			HTML = HTML.replace("$META_TAGS$", "");
			logger.error("Error al remplazar $META_TAGS$");
		}
		
		//Remplaza nota:tags [$META_IMG$]
		try {
			HTML = HTML.replace("$META_IMG$" ,contentDTO.getFcImgPrincipal());
		} catch(Exception e) {
			HTML = HTML.replace("$META_IMG$", "");
			logger.error("Error al remplazar $META_IMG$");
		}
		
		//Remplaza nota:tags [$META_TITULO$]
		try {
			HTML = HTML.replace("$META_TITULO$" ,htmlEncode(contentDTO.getFcTitulo().trim()));
		} catch(Exception e) {
			HTML = HTML.replace("$META_TITULO$", "");
			logger.error("Error al remplazar $META_TITULO$");
		}
		
		// Remplaza los metas de video ooyala
		if(!contentDTO.getFcIdVideoOoyala().equals("") && !contentDTO.getFcIdPlayerOoyala().equals("")){
			try {							
				HTML = HTML.replace("$OG_VIDEO$",parametrosDTO.getMetaVideo().replace("$ID_VIDEO$", contentDTO.getFcIdVideoOoyala()).replace("$ID_VIDEO_PLAYER$", contentDTO.getFcIdPlayerOoyala()));
				HTML = HTML.replace("$OG_VIDEO_SECURE$",parametrosDTO.getMetaVideoSecureUrl().replace("$ID_VIDEO$", contentDTO.getFcIdVideoOoyala()).replace("$ID_VIDEO_PLAYER$", contentDTO.getFcIdPlayerOoyala()));
			} catch (Exception e) {
				HTML = HTML.replace("$OG_VIDEO_SECURE$", "");
				HTML = HTML.replace("$OG_VIDEO$", "");
				logger.error("Error al sustituir metas de Video $OG_VIDEO$ y $OG_VIDEO_SECURE$");
			}
		}else{
			HTML = HTML.replace("<meta property=\"og:video\" content=\"$OG_VIDEO$\" />", "");
			HTML = HTML.replace("<meta property=\"og:video:secure_url\" content=\"$OG_VIDEO_SECURE$\" />", "");
			HTML = HTML.replace("<meta property=\"og:video:type\" content=\"application/x-shockwave-flash\" />", "");
			HTML = HTML.replace("<meta property=\"og:type\" content=\"video.other\" />", "");
			HTML = HTML.replace("<meta property=\"og:video:height\" content=\"480\" />", "");
			HTML = HTML.replace("<meta property=\"og:video:width\" content=\"640\" />", "");
		}
		
		//Remplaza nota:tags [$META_IMG$]
		try {
			ProcesoBO procesoBO = new ProcesoBO(parametrosDTO.getURL_WS_PARAMETROS());
			//String cad="version_styles,$VERSION_STYLES$|version_scripts,$VERSION_SCRIPT$|version_libs,$VERSION_LIBS$|version_gas_json,$VERSION_GAS_JSON$|version_banner_json,$VERSION_BANNER_JSON$";
			String [] params=parametrosDTO.getCatalogoParametros().split("\\|");
			String valor="";
			String cad_a_reemplazar="";
			for (int i = 0; i < params.length; i++) {
				valor=procesoBO.getParameter(params[i].split("\\,")[0]);
				cad_a_reemplazar=params[i].split("\\,")[1];
				if(valor!=null && !valor.equals("")){
					HTML = HTML.replace(cad_a_reemplazar ,valor);
				}else{
					HTML = HTML.replace(cad_a_reemplazar ,"");
				}
			}
		} catch(Exception e) {
			logger.error("Error al remplazar version de estilos"+e.getLocalizedMessage());
		}
		
		return HTML;
	}
	
	private static String cambiaCaracteres(String texto) {
		
		texto = texto.replaceAll("á", "&#225;");
        texto = texto.replaceAll("é", "&#233;");
        texto = texto.replaceAll("í", "&#237;");
        texto = texto.replaceAll("ó", "&#243;");
        texto = texto.replaceAll("ú", "&#250;");  
        texto = texto.replaceAll("Á", "&#193;");
        texto = texto.replaceAll("É", "&#201;");
        texto = texto.replaceAll("Í", "&#205;");
        texto = texto.replaceAll("Ó", "&#211;");
        texto = texto.replaceAll("Ú", "&#218;");
        texto = texto.replaceAll("Ñ", "&#209;");
        texto = texto.replaceAll("ñ", "&#241;");        
        texto = texto.replaceAll("ª", "&#170;");          
        texto = texto.replaceAll("ä", "&#228;");
        texto = texto.replaceAll("ë", "&#235;");
        texto = texto.replaceAll("ï", "&#239;");
        texto = texto.replaceAll("ö", "&#246;");
        texto = texto.replaceAll("ü", "&#252;");    
        texto = texto.replaceAll("Ä", "&#196;");
        texto = texto.replaceAll("Ë", "&#203;");
        texto = texto.replaceAll("Ï", "&#207;");
        texto = texto.replaceAll("Ö", "&#214;");
        texto = texto.replaceAll("Ü", "&#220;");
        texto = texto.replaceAll("¿", "&#191;");
        texto = texto.replaceAll("“", "&#8220;");        
        texto = texto.replaceAll("”", "&#8221;");
        texto = texto.replaceAll("‘", "&#8216;");
        texto = texto.replaceAll("’", "&#8217;");
        texto = texto.replaceAll("…", "...");
        texto = texto.replaceAll("¡", "&#161;");
        texto = texto.replaceAll("¿", "&#191;");
        texto = texto.replaceAll("°", "&#176;");
        
        texto = texto.replaceAll("“", "&#147;");
        texto = texto.replaceAll("”", "&#148;");
        
        texto = texto.replaceAll("–", "&#8211;");
        texto = texto.replaceAll("—", "&#8212;"); 
        
        //texto = texto.replaceAll("\"", "&#34;");
		return texto;
	}
	
}
