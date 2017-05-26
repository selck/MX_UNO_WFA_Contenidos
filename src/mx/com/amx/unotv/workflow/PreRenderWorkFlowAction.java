package mx.com.amx.unotv.workflow;

import java.util.Date;

import javax.naming.InitialContext;

import mx.com.amx.unotv.workflow.bo.GeneraContenido;

import org.apache.log4j.Logger;

import com.ibm.workplace.wcm.api.Content;
import com.ibm.workplace.wcm.api.Document;
import com.ibm.workplace.wcm.api.DocumentId;
import com.ibm.workplace.wcm.api.WebContentCustomWorkflowService;
import com.ibm.workplace.wcm.api.WebContentLibraryService;
import com.ibm.workplace.wcm.api.WebContentService;
import com.ibm.workplace.wcm.api.Workspace;
import com.ibm.workplace.wcm.api.custom.CustomWorkflowAction;
import com.ibm.workplace.wcm.api.custom.CustomWorkflowActionResult;
import com.ibm.workplace.wcm.api.custom.Directive;
import com.ibm.workplace.wcm.api.custom.Directives;

public class PreRenderWorkFlowAction implements CustomWorkflowAction{
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());	
	
	InitialContext initContext=null ;		
		
	@SuppressWarnings("unchecked")
	DocumentId docId =null;
	WebContentService wContentService=null;
	WebContentLibraryService webContentLibraryService =null;
	Workspace ws =null;
	
	Content myContent =null;
	String message=null;
	WebContentCustomWorkflowService webContentCustomWorkflowService = null ;
	
	String listOfApprovers =null;
	CustomWorkflowActionResult result = null;
	
	public PreRenderWorkFlowAction()
	{
		//logger.debug("UnoTVPreRenderWorkFlowAction has been invoked () ");
	}

	public CustomWorkflowActionResult execute(Document arg0)
	{		
		
		Directive directive = Directives.CONTINUE;	
		if (arg0 instanceof Content) {							
				try {					
					myContent = (Content) arg0;					
					initContext = new InitialContext();
					wContentService = (WebContentService) initContext.lookup("portal:service/wcm/WebContentService");
					webContentLibraryService = (WebContentLibraryService)initContext.lookup("portal:service/wcm/WebContentLibraryService");
					
					//Se valida el tipo de plantilla de contenido para insertalo en la BD y generar su pagina Estatica.
					GeneraContenido genera = new GeneraContenido();
					//logger.debug("Titulo Isra: "+myContent.getTitle());
					genera.validaInsertContenido(myContent);	
					
					
				} catch(Exception e1) {
					logger.error("An exception has occured in e1: " + e1);
					message = "An exception has occured in e1 " + e1.getMessage();
					directive = Directives.ROLLBACK_DOCUMENT ;
				}
				
				try {	
					webContentCustomWorkflowService = (WebContentCustomWorkflowService)initContext.lookup( "portal:service/wcm/WebContentCustomWorkflowService");
				} catch(Exception e2) {
					logger.error("An exception has occured in e2: " + e2);
					message = "An exception has occured in e2 " + e2.getMessage();	
					directive = Directives.ROLLBACK_DOCUMENT ;
				}
		} 
		
		result = webContentCustomWorkflowService.createResult(directive,message);			
		return result;
	}
	
	public Date getExecuteDate(Document arg0) {
		return DATE_EXECUTE_NOW;
	}
		
}
