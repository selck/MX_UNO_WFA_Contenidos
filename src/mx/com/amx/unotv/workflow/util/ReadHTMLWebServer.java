package mx.com.amx.unotv.workflow.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


import mx.com.amx.unotv.workflow.dto.ParametrosDTO;

import org.apache.log4j.Logger;

public class ReadHTMLWebServer {
	
	static Logger logger=Logger.getLogger(ReadHTMLWebServer.class);
	
		
	public String getHTMLInfinite(String categoria, ParametrosDTO parametrosDTO){
		URL url;
		StringBuffer HTML=new StringBuffer();
		try {
			// get URL content
			String conectar=parametrosDTO.getURL_WEBSERVER().replace("$ID_CATEGORIA$", categoria);
			logger.debug("Conectandose a: "+conectar);
			url = new URL(conectar);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));
			String inputLine;
			/*String fileName = "C:/pruebas/test.html";
			/File file = new File(fileName);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);*/

			while ((inputLine = br.readLine()) != null) {
				HTML.append(inputLine);
				//bw.write(inputLine);
			}
			//bw.close();
			br.close();
		} catch (MalformedURLException e) {
			logger.error("Error getHTMLInfinite MalformedURLException: ",e);
		} catch (IOException e) {
			logger.error("Error getHTMLInfinite IOException: ",e);
		}
		return HTML.toString();
	}
	public String getHTML_DetailAMP(ParametrosDTO parametrosDTO){
		URL url;
		StringBuffer HTML=new StringBuffer();
		try {
			// get URL content
			String conectar=parametrosDTO.getURL_WEBSERVER_AMP();
			//String conectar="http://QROPC2WEB07.tmx-internacional.net/portal/unotv/utils/plantilla_amp.html";
			logger.debug("Conectandose a: "+conectar);
			url = new URL(conectar);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));
			String inputLine;
			/*String fileName = "C:/pruebas/test.html";
			/File file = new File(fileName);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);*/

			while ((inputLine = br.readLine()) != null) {
				HTML.append(inputLine+"\n");
				//bw.write(inputLine);
			}
			//bw.close();
			br.close();
		} catch (MalformedURLException e) {
			logger.error("Error getHTML_DetailAMP MalformedURLException: ",e);
		} catch (IOException e) {
			logger.error("Error getHTML_DetailAMP IOException: ",e);
		}
		return HTML.toString();
	}
	
	public String getCSS_DetailAMP(ParametrosDTO parametrosDTO){
		URL url;
		StringBuffer HTML=new StringBuffer();
		try {
			// get URL content
			String conectar=parametrosDTO.getURL_WEBSERVER_CSS_AMP();
			//String conectar="http://QROPC2WEB07.tmx-internacional.net/portal/unotv/utils/amp.css";
			logger.debug("Conectandose a: "+conectar);
			url = new URL(conectar);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));
			String inputLine;
			/*String fileName = "C:/pruebas/test.html";
			/File file = new File(fileName);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);*/

			while ((inputLine = br.readLine()) != null) {
				HTML.append(inputLine+"\n");
				//bw.write(inputLine);
			}
			//bw.close();
			br.close();
			
		} catch (MalformedURLException e) {
			logger.error("Error getCSS_DetailAMP MalformedURLException: ",e);
		} catch (IOException e) {
			logger.error("Error getCSS_DetailAMP IOException: ",e);
		}
		return HTML.toString();
	}
}