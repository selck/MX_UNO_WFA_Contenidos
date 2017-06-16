package mx.com.amx.unotv.workflow.dto;

public class WrapperJsonDetail {

	private NoticiaDTO noticia;
	private String mensaje;
	private String codigo;
	private String causa_error;
	
	/**
	 * @return the noticia
	 */
	public NoticiaDTO getNoticia() {
		return noticia;
	}
	/**
	 * @param noticia the noticia to set
	 */
	public void setNoticia(NoticiaDTO noticia) {
		this.noticia = noticia;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the causa_error
	 */
	public String getCausa_error() {
		return causa_error;
	}
	/**
	 * @param causa_error the causa_error to set
	 */
	public void setCausa_error(String causa_error) {
		this.causa_error = causa_error;
	}
	
	

}
