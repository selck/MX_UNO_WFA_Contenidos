package mx.com.amx.unotv.workflow.dto;

import java.sql.Timestamp;

public class PushAMP {
	
	private String fcIdContenido;
	private Timestamp fdFechaPublicacion;
	private String fcTitulo;
	private String fcTipoSeccion;
	private String fcSeccion;
	private String fcIdCategoria;
	private String fcNombre;
	
	private String htmlAMP;

	/**
	 * @return el fcIdContenido
	 */
	public String getFcIdContenido() {
		return fcIdContenido;
	}

	/**
	 * @param fcIdContenido el fcIdContenido a establecer
	 */
	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}

	/**
	 * @return el fdFechaPublicacion
	 */
	public Timestamp getFdFechaPublicacion() {
		return fdFechaPublicacion;
	}

	/**
	 * @param fdFechaPublicacion el fdFechaPublicacion a establecer
	 */
	public void setFdFechaPublicacion(Timestamp fdFechaPublicacion) {
		this.fdFechaPublicacion = fdFechaPublicacion;
	}

	/**
	 * @return el fcTitulo
	 */
	public String getFcTitulo() {
		return fcTitulo;
	}

	/**
	 * @param fcTitulo el fcTitulo a establecer
	 */
	public void setFcTitulo(String fcTitulo) {
		this.fcTitulo = fcTitulo;
	}

	/**
	 * @return el fcTipoSeccion
	 */
	public String getFcTipoSeccion() {
		return fcTipoSeccion;
	}

	/**
	 * @param fcTipoSeccion el fcTipoSeccion a establecer
	 */
	public void setFcTipoSeccion(String fcTipoSeccion) {
		this.fcTipoSeccion = fcTipoSeccion;
	}

	/**
	 * @return el fcSeccion
	 */
	public String getFcSeccion() {
		return fcSeccion;
	}

	/**
	 * @param fcSeccion el fcSeccion a establecer
	 */
	public void setFcSeccion(String fcSeccion) {
		this.fcSeccion = fcSeccion;
	}

	/**
	 * @return el fcIdCategoria
	 */
	public String getFcIdCategoria() {
		return fcIdCategoria;
	}

	/**
	 * @param fcIdCategoria el fcIdCategoria a establecer
	 */
	public void setFcIdCategoria(String fcIdCategoria) {
		this.fcIdCategoria = fcIdCategoria;
	}

	/**
	 * @return el fcNombre
	 */
	public String getFcNombre() {
		return fcNombre;
	}

	/**
	 * @param fcNombre el fcNombre a establecer
	 */
	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}

	/**
	 * @return el htmlAMP
	 */
	public String getHtmlAMP() {
		return htmlAMP;
	}

	/**
	 * @param htmlAMP el htmlAMP a establecer
	 */
	public void setHtmlAMP(String htmlAMP) {
		this.htmlAMP = htmlAMP;
	}
	
	
	
}
