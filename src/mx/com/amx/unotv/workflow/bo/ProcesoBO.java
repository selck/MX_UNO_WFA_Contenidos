package mx.com.amx.unotv.workflow.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import mx.com.amx.unotv.workflow.dto.ParametrosDTO;
import mx.com.amx.unotv.workflow.dto.PushAMP;
import mx.com.amx.unotv.workflow.dto.RespuestaWSAMP;
import mx.com.amx.unotv.workflow.dto.ContentDTO;
import mx.com.amx.unotv.workflow.dto.VideoOoyalaDTO;


@Component
@Qualifier("procesoBO")
public class ProcesoBO{

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private RestTemplate restTemplate;
	private String URL_WS_BASE="";
	private HttpHeaders headers = new HttpHeaders();
	
	
	
	public ProcesoBO(String urlWS) {
		super();
		restTemplate = new RestTemplate();
		ClientHttpRequestFactory factory = restTemplate.getRequestFactory();

	        if ( factory instanceof SimpleClientHttpRequestFactory)
	        {
	            ((SimpleClientHttpRequestFactory) factory).setConnectTimeout( 50 * 1000 );
	            ((SimpleClientHttpRequestFactory) factory).setReadTimeout( 50 * 1000 );
	        }
	        else if ( factory instanceof HttpComponentsClientHttpRequestFactory)
	        {
	            ((HttpComponentsClientHttpRequestFactory) factory).setReadTimeout( 50 * 1000);
	            ((HttpComponentsClientHttpRequestFactory) factory).setConnectTimeout( 50 * 1000);
	            
	        }
	        restTemplate.setRequestFactory( factory );
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
			URL_WS_BASE = urlWS;
	}
	
	public String insertUpdateArticleFB (ContentDTO contentDTO){
		
		String respuesta="";
		String metodo="insertUpdateArticle2";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<ContentDTO> entity = new HttpEntity<ContentDTO>( contentDTO );
			respuesta=restTemplate.postForObject(URL_WS, entity, String.class);
		} catch(Exception e) {
			logger.error("Error insertUpdateArticle - FB [BO]: "+e.getLocalizedMessage());
		}
		return respuesta;
	}
	public String deleteArticleFB (String articleId){
		
		String respuesta="";
		String metodo="deleteArticle";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<String> entity = new HttpEntity<String>( articleId );
			respuesta=restTemplate.postForObject(URL_WS, entity, String.class);
		} catch(Exception e) {
			logger.error("Error deleteArticle - FB [BO]: "+e.getLocalizedMessage());
		}
		return respuesta;
	}
	public List<ContentDTO> getRelacionadasbyIdCategoria(ContentDTO contentDTO) {
		ContentDTO[] arrayContentsRecibidos=null;
		ArrayList<ContentDTO> listRelacionadas=null;
		String metodo="getRelacionadasbyIdCategoria";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<ContentDTO> entity = new HttpEntity<ContentDTO>( contentDTO );
			arrayContentsRecibidos=restTemplate.postForObject(URL_WS, entity, ContentDTO[].class);
			listRelacionadas=new ArrayList<ContentDTO>(Arrays.asList(arrayContentsRecibidos));
			
		} catch(Exception e) {
			logger.error("Error getRelacionadasbyIdCategoria [BO]: "+e.getLocalizedMessage());
		}		
		return listRelacionadas;	
	}
	public List<ContentDTO> getNotasMagazine(String idMagazine, String idContenido) {
		ContentDTO[] arrayContentsRecibidos=null;
		ArrayList<ContentDTO> listRelacionadas=null;
		String metodo="getNotasMagazine";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			//HttpEntity<String> entity = new HttpEntity<String>( idMagazine );
			MultiValueMap<String, Object> parts;
			parts = new LinkedMultiValueMap<String, Object>();
			parts.add("idMagazine", idMagazine);
			parts.add("idContenido", idContenido);
			arrayContentsRecibidos=restTemplate.postForObject(URL_WS, parts, ContentDTO[].class);
			listRelacionadas=new ArrayList<ContentDTO>(Arrays.asList(arrayContentsRecibidos));
			
		} catch(Exception e) {
			logger.error("Error getNotasMagazine [BO]: "+e.getLocalizedMessage());
		}		
		return listRelacionadas;	
	}
	public List<ContentDTO> getNotasMagazine(String idMagazine) {
		ContentDTO[] arrayContentsRecibidos=null;
		ArrayList<ContentDTO> listRelacionadas=null;
		String metodo="getNotasMagazine";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<String> entity = new HttpEntity<String>( idMagazine );
			arrayContentsRecibidos=restTemplate.postForObject(URL_WS, entity, ContentDTO[].class);
			listRelacionadas=new ArrayList<ContentDTO>(Arrays.asList(arrayContentsRecibidos));
			
		} catch(Exception e) {
			logger.error("Error getNotasMagazine [BO]: "+e.getLocalizedMessage());
		}		
		return listRelacionadas;	
	}
	
	public boolean deleteNotaBD(ContentDTO contentDTO) {
		boolean success = false;
		String metodo="deleteNotaBD";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<ContentDTO> entity = new HttpEntity<ContentDTO>( contentDTO );
			success=restTemplate.postForObject(URL_WS, entity, Boolean.class);
		} catch(Exception e) {
			logger.error("Error deleteNotaBD [BO]: "+e.getLocalizedMessage());
		}		
		return success;		
	}

	
	public boolean deleteNotaHistoricoBD(ContentDTO contentDTO) {
		boolean success = false;
		String metodo="deleteNotaHistoricoBD";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<ContentDTO> entity = new HttpEntity<ContentDTO>( contentDTO );
			success=restTemplate.postForObject(URL_WS, entity, Boolean.class);
		} catch(Exception e) {
			logger.error("Error deleteNotaHistoricoBD [BO]: "+e.getLocalizedMessage());
		}		
		return success;	
	}
	public String getIdNotaByName(String nombreContenido) {
		String idContenido="";
		String metodo="getIdNotaByName";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<String> entity = new HttpEntity<String>( nombreContenido );
			idContenido=restTemplate.postForObject(URL_WS, entity, String.class);
		} catch(Exception e) {
			logger.error("Error getIdNotaByName [BO]: "+e.getLocalizedMessage());
		}		
		return idContenido;	
	}
	public boolean insertTagsApp(String idContenido, String[] TagsApp) {
		boolean success = false;
		try {	
			ContentDTO contentDTO=new ContentDTO();
			contentDTO.setFcIdContenido(idContenido);
			deleteTagsApp(contentDTO);
				for (String idTag:TagsApp) {
					success=insertNotaTag(idContenido, idTag);
					//logger.info("Inserto Tag "+idTag+": "+success);
				}
		} catch(Exception e) {
			logger.error("Error insertTagsApp [BO]: "+e.getLocalizedMessage());
		}		
		return success;
	}
	public boolean insertTagsAppContent(ContentDTO contentDTO) {
		boolean success = false;
		try {	
			deleteTagsApp(contentDTO);
			success=insertNotaTagContent(contentDTO);			
		} catch(Exception e) {
			logger.error("Error insertTagsAppContent [BO]: "+e.getLocalizedMessage());
		}		
		return success;
	}	
	public boolean deleteTagsApp(ContentDTO contentDTO) {
		boolean success = false;
		String metodo="deleteNotaTag";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<ContentDTO> entity = new HttpEntity<ContentDTO>( contentDTO );
			success=restTemplate.postForObject(URL_WS, entity, Boolean.class);
		} catch(Exception e) {
			logger.error("Error deleteTagsApp [BO]: "+e.getLocalizedMessage());
		}		
		return success;	
	}
	public boolean insertNotaTag(String idContenido, String idTag) {
		boolean success = false;
		try {	
			String URL_WS=URL_WS_BASE+"insertNotaTag";
			restTemplate=new RestTemplate();
			MultiValueMap<String, Object> parts;
			parts = new LinkedMultiValueMap<String, Object>();
			parts.add("idContenido", idContenido);
			parts.add("idTag", idTag);
			success=restTemplate.postForObject(URL_WS, parts, Boolean.class);
				
		} catch(Exception e) {
			logger.error("Error insertNotaTag [BO]: "+e.getLocalizedMessage());
		}		
		return success;
	}
	public boolean insertNotaTagContent(ContentDTO contentDTO) {
		boolean success = false;
		try {	
			String URL_WS=URL_WS_BASE+"insertNotaTagContent";
			HttpEntity<ContentDTO> entity = new HttpEntity<ContentDTO>( contentDTO );
			success=restTemplate.postForObject(URL_WS, entity, Boolean.class);
				
		} catch(Exception e) {
			logger.error("Error insertNotaTagContent [BO]: "+e.getLocalizedMessage());
		}		
		return success;
	}
	
	public boolean setNotaBD(ContentDTO contentDTO) {
		boolean success = false;
		try {	
			String URL_WS=URL_WS_BASE+"existeNotaRegistrada";
			restTemplate=new RestTemplate();
			HttpEntity<ContentDTO> entity = new HttpEntity<ContentDTO>( contentDTO );
			success=restTemplate.postForObject(URL_WS, entity, Boolean.class);
			if(success){
				logger.info("Se actualiza la nota");
				success=restTemplate.postForObject(URL_WS_BASE+"updateNotaBD", entity, Boolean.class);
				success=restTemplate.postForObject(URL_WS_BASE+"updateNotaHistoricoBD", entity, Boolean.class);
			}else{
				logger.info("Se inserta nueva nota");
				success=restTemplate.postForObject(URL_WS_BASE+"insertNotaBD", entity, Boolean.class);
				success=restTemplate.postForObject(URL_WS_BASE+"insertNotaHistoricoBD", entity, Boolean.class);
			}
				
		} catch(Exception e) {
			logger.error("Error setNotaBD :( [BO]: "+e.getLocalizedMessage());
		}		
		return success;
	}
	
	public RespuestaWSAMP sendPushAMP(PushAMP pushAMP ) {
		RespuestaWSAMP respuestaWSAMP=new RespuestaWSAMP();
		String URL_WS=URL_WS_BASE+"sendPushAMP";
		try {
			HttpEntity<PushAMP> entity = new HttpEntity<PushAMP>( pushAMP );
			respuestaWSAMP=restTemplate.postForObject(URL_WS, entity, RespuestaWSAMP.class);
		} catch(Exception e) {
			logger.error("Error sendPushAMP [BO]: "+e.getLocalizedMessage());
		}		
		return respuestaWSAMP;	
	}
	
	public VideoOoyalaDTO getInfoVideo(String content_id, ParametrosDTO parametrosDTO) {
		VideoOoyalaDTO respuesta = new VideoOoyalaDTO();
		String metodo="getInfoVideo";
		String URL_WS=parametrosDTO.getURL_WS_VIDEO()+metodo;
		try {
			HttpEntity<String> entity = new HttpEntity<String>( content_id );
			respuesta=restTemplate.postForObject(URL_WS, entity, VideoOoyalaDTO.class);
		} catch(Exception e) {
			logger.error("Error getInfoVideo [BO]: "+e.getLocalizedMessage());
		}		
		return respuesta;	
	}
	public String getParameter(String idParameter) {
		String resultado = "";
		String metodo="getParameter";
		String URL_WS=URL_WS_BASE+metodo;
		try {
			HttpEntity<String> entity = new HttpEntity<String>( idParameter );
			resultado=restTemplate.postForObject(URL_WS, entity, String.class);
		} catch(Exception e) {
			logger.error("Error getParameter [BO]: "+e.getLocalizedMessage());
		}		
		return resultado;		
	}
}
