package mx.com.amx.unotv.workflow.dto;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

public class ContentDTO implements Cloneable{
	
	
	public static void main(String [] args){
		System.out.println("Hola");
	}
	
	private Logger logger=Logger.getLogger(ContentDTO.class);
	
	private String fcIdContenido;
	private String fcIdCategoria;
	private String fcNombre;
	private String fcTitulo;
	private String fcDescripcion;
	private String fcEscribio;
	private String fcLugar;
	private String fcFuente;
	private String fcIdTipoNota;
	private String fcImgPrincipal;
	private String fcPieFoto;
	private String fcIdVideoYouTube;
	private String fcIdVideoOoyala;
	private String fcIdPlayerOoyala;
	private String clGaleriaImagenes;
	private String fcImgInfografia;
	private String clRtfContenido;
	private Timestamp fdFechaPublicacion;
	private String fcTags;
	private String fcKeywords;
	private int fiBanInfinito;
	private int fiBanVideoViral;
	private int fiBanNoTeLoPierdas;
	private int fiBanPatrocinio;
	private String fcPatrocinioBackGround;
	private String fcPatrocinioColorTexto;
	
	private String fcFecha;
	private String fcHora;
	
	private String fcTipoSeccion;
	private String fcSeccion;
	private String fcNombreCategoria;
	private String fcUrl;
	private String fcFriendlyURLSeccion;
	private String fcFriendlyURLCategoria;
	
	private String fcTituloComentario;
	private String[] fcTagsApp;
	
	private String fcPaisRegistro;
	private String placeGallery;
	private String fcPCode;
	
	private String fcSourceVideo;
	private String fcAlternateTextVideo;
	private String fcDurationVideo;
	private String fcFileSizeVideo;
	
	/**
	 * @return the fcIdContenido
	 */
	public String getFcIdContenido() {
		return fcIdContenido;
	}
	/**
	 * @param fcIdContenido the fcIdContenido to set
	 */
	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}
	/**
	 * @return the fcIdCategoria
	 */
	public String getFcIdCategoria() {
		return fcIdCategoria;
	}
	/**
	 * @param fcIdCategoria the fcIdCategoria to set
	 */
	public void setFcIdCategoria(String fcIdCategoria) {
		this.fcIdCategoria = fcIdCategoria;
	}
	/**
	 * @return the fcNombre
	 */
	public String getFcNombre() {
		return fcNombre;
	}
	/**
	 * @param fcNombre the fcNombre to set
	 */
	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}
	/**
	 * @return the fcTitulo
	 */
	public String getFcTitulo() {
		return fcTitulo;
	}
	/**
	 * @param fcTitulo the fcTitulo to set
	 */
	public void setFcTitulo(String fcTitulo) {
		this.fcTitulo = fcTitulo;
	}
	/**
	 * @return the fcDescripcion
	 */
	public String getFcDescripcion() {
		return fcDescripcion;
	}
	/**
	 * @param fcDescripcion the fcDescripcion to set
	 */
	public void setFcDescripcion(String fcDescripcion) {
		this.fcDescripcion = fcDescripcion;
	}
	/**
	 * @return the fcEscribio
	 */
	public String getFcEscribio() {
		return fcEscribio;
	}
	/**
	 * @param fcEscribio the fcEscribio to set
	 */
	public void setFcEscribio(String fcEscribio) {
		this.fcEscribio = fcEscribio;
	}
	/**
	 * @return the fcLugar
	 */
	public String getFcLugar() {
		return fcLugar;
	}
	/**
	 * @param fcLugar the fcLugar to set
	 */
	public void setFcLugar(String fcLugar) {
		this.fcLugar = fcLugar;
	}
	/**
	 * @return the fcFuente
	 */
	public String getFcFuente() {
		return fcFuente;
	}
	/**
	 * @param fcFuente the fcFuente to set
	 */
	public void setFcFuente(String fcFuente) {
		this.fcFuente = fcFuente;
	}
	/**
	 * @return the fcIdTipoNota
	 */
	public String getFcIdTipoNota() {
		return fcIdTipoNota;
	}
	/**
	 * @param fcIdTipoNota the fcIdTipoNota to set
	 */
	public void setFcIdTipoNota(String fcIdTipoNota) {
		this.fcIdTipoNota = fcIdTipoNota;
	}
	/**
	 * @return the fcImgPrincipal
	 */
	public String getFcImgPrincipal() {
		return fcImgPrincipal;
	}
	/**
	 * @param fcImgPrincipal the fcImgPrincipal to set
	 */
	public void setFcImgPrincipal(String fcImgPrincipal) {
		this.fcImgPrincipal = fcImgPrincipal;
	}
	/**
	 * @return the fcPieFoto
	 */
	public String getFcPieFoto() {
		return fcPieFoto;
	}
	/**
	 * @param fcPieFoto the fcPieFoto to set
	 */
	public void setFcPieFoto(String fcPieFoto) {
		this.fcPieFoto = fcPieFoto;
	}
	/**
	 * @return the fcIdVideoYouTube
	 */
	public String getFcIdVideoYouTube() {
		return fcIdVideoYouTube;
	}
	/**
	 * @param fcIdVideoYouTube the fcIdVideoYouTube to set
	 */
	public void setFcIdVideoYouTube(String fcIdVideoYouTube) {
		this.fcIdVideoYouTube = fcIdVideoYouTube;
	}
	/**
	 * @return the fcIdVideoOoyala
	 */
	public String getFcIdVideoOoyala() {
		return fcIdVideoOoyala;
	}
	/**
	 * @param fcIdVideoOoyala the fcIdVideoOoyala to set
	 */
	public void setFcIdVideoOoyala(String fcIdVideoOoyala) {
		this.fcIdVideoOoyala = fcIdVideoOoyala;
	}
	/**
	 * @return the fcIdPlayerOoyala
	 */
	public String getFcIdPlayerOoyala() {
		return fcIdPlayerOoyala;
	}
	/**
	 * @param fcIdPlayerOoyala the fcIdPlayerOoyala to set
	 */
	public void setFcIdPlayerOoyala(String fcIdPlayerOoyala) {
		this.fcIdPlayerOoyala = fcIdPlayerOoyala;
	}
	/**
	 * @return the clGaleriaImagenes
	 */
	public String getClGaleriaImagenes() {
		return clGaleriaImagenes;
	}
	/**
	 * @param clGaleriaImagenes the clGaleriaImagenes to set
	 */
	public void setClGaleriaImagenes(String clGaleriaImagenes) {
		this.clGaleriaImagenes = clGaleriaImagenes;
	}
	/**
	 * @return the fcImgInfografia
	 */
	public String getFcImgInfografia() {
		return fcImgInfografia;
	}
	/**
	 * @param fcImgInfografia the fcImgInfografia to set
	 */
	public void setFcImgInfografia(String fcImgInfografia) {
		this.fcImgInfografia = fcImgInfografia;
	}
	/**
	 * @return the clRtfContenido
	 */
	public String getClRtfContenido() {
		return clRtfContenido;
	}
	/**
	 * @param clRtfContenido the clRtfContenido to set
	 */
	public void setClRtfContenido(String clRtfContenido) {
		this.clRtfContenido = clRtfContenido;
	}
	/**
	 * @return the fdFechaPublicacion
	 */
	public Timestamp getFdFechaPublicacion() {
		return fdFechaPublicacion;
	}
	/**
	 * @param fdFechaPublicacion the fdFechaPublicacion to set
	 */
	public void setFdFechaPublicacion(Timestamp fdFechaPublicacion) {
		this.fdFechaPublicacion = fdFechaPublicacion;
	}
	/**
	 * @return the fcTags
	 */
	public String getFcTags() {
		return fcTags;
	}
	/**
	 * @param fcTags the fcTags to set
	 */
	public void setFcTags(String fcTags) {
		this.fcTags = fcTags;
	}
	/**
	 * @return the fcKeywords
	 */
	public String getFcKeywords() {
		return fcKeywords;
	}
	/**
	 * @param fcKeywords the fcKeywords to set
	 */
	public void setFcKeywords(String fcKeywords) {
		this.fcKeywords = fcKeywords;
	}
	/**
	 * @return the fiBanInfinito
	 */
	public int getFiBanInfinito() {
		return fiBanInfinito;
	}
	/**
	 * @param fiBanInfinito the fiBanInfinito to set
	 */
	public void setFiBanInfinito(int fiBanInfinito) {
		this.fiBanInfinito = fiBanInfinito;
	}
	/**
	 * @return the fiBanVideoViral
	 */
	public int getFiBanVideoViral() {
		return fiBanVideoViral;
	}
	/**
	 * @param fiBanVideoViral the fiBanVideoViral to set
	 */
	public void setFiBanVideoViral(int fiBanVideoViral) {
		this.fiBanVideoViral = fiBanVideoViral;
	}
	/**
	 * @return the fiBanNoTeLoPierdas
	 */
	public int getFiBanNoTeLoPierdas() {
		return fiBanNoTeLoPierdas;
	}
	/**
	 * @param fiBanNoTeLoPierdas the fiBanNoTeLoPierdas to set
	 */
	public void setFiBanNoTeLoPierdas(int fiBanNoTeLoPierdas) {
		this.fiBanNoTeLoPierdas = fiBanNoTeLoPierdas;
	}
	/**
	 * @return the fiBanPatrocinio
	 */
	public int getFiBanPatrocinio() {
		return fiBanPatrocinio;
	}
	/**
	 * @param fiBanPatrocinio the fiBanPatrocinio to set
	 */
	public void setFiBanPatrocinio(int fiBanPatrocinio) {
		this.fiBanPatrocinio = fiBanPatrocinio;
	}
	/**
	 * @return the fcPatrocinioBackGround
	 */
	public String getFcPatrocinioBackGround() {
		return fcPatrocinioBackGround;
	}
	/**
	 * @param fcPatrocinioBackGround the fcPatrocinioBackGround to set
	 */
	public void setFcPatrocinioBackGround(String fcPatrocinioBackGround) {
		this.fcPatrocinioBackGround = fcPatrocinioBackGround;
	}
	/**
	 * @return the fcPatrocinioColorTexto
	 */
	public String getFcPatrocinioColorTexto() {
		return fcPatrocinioColorTexto;
	}
	/**
	 * @param fcPatrocinioColorTexto the fcPatrocinioColorTexto to set
	 */
	public void setFcPatrocinioColorTexto(String fcPatrocinioColorTexto) {
		this.fcPatrocinioColorTexto = fcPatrocinioColorTexto;
	}
	/**
	 * @return the fcFecha
	 */
	public String getFcFecha() {
		return fcFecha;
	}
	/**
	 * @param fcFecha the fcFecha to set
	 */
	public void setFcFecha(String fcFecha) {
		this.fcFecha = fcFecha;
	}
	/**
	 * @return the fcHora
	 */
	public String getFcHora() {
		return fcHora;
	}
	/**
	 * @param fcHora the fcHora to set
	 */
	public void setFcHora(String fcHora) {
		this.fcHora = fcHora;
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
	 * @return el fcNombreCategoria
	 */
	public String getFcNombreCategoria() {
		return fcNombreCategoria;
	}
	
	/**
	 * @param fcNombreCategoria el fcNombreCategoria a establecer
	 */
	public void setFcNombreCategoria(String fcNombreCategoria) {
		this.fcNombreCategoria = fcNombreCategoria;
	}
	
	/**
	 * @return el fcUrl
	 */
	public String getFcUrl() {
		return fcUrl;
	}
	/**
	 * @param fcUrl el fcUrl a establecer
	 */
	public void setFcUrl(String fcUrl) {
		this.fcUrl = fcUrl;
	}
	
	/**
	 * @return el fcTituloComentario
	 */
	public String getFcTituloComentario() {
		return fcTituloComentario;
	}
	/**
	 * @param fcTituloComentario el fcTituloComentario a establecer
	 */
	public void setFcTituloComentario(String fcTituloComentario) {
		this.fcTituloComentario = fcTituloComentario;
	}
	/**
	 * @return el fcTagsApp
	 */
	public String[] getFcTagsApp() {
		return fcTagsApp;
	}
	/**
	 * @param fcTagsApp el fcTagsApp a establecer
	 */
	public void setFcTagsApp(String[] fcTagsApp) {
		this.fcTagsApp = fcTagsApp;
	}
	
	/**
	 * @return el fcFriendlyURLSeccion
	 */
	public String getFcFriendlyURLSeccion() {
		return fcFriendlyURLSeccion;
	}
	/**
	 * @param fcFriendlyURLSeccion el fcFriendlyURLSeccion a establecer
	 */
	public void setFcFriendlyURLSeccion(String fcFriendlyURLSeccion) {
		this.fcFriendlyURLSeccion = fcFriendlyURLSeccion;
	}
	/**
	 * @return el fcFriendlyURLCategoria
	 */
	public String getFcFriendlyURLCategoria() {
		return fcFriendlyURLCategoria;
	}
	/**
	 * @param fcFriendlyURLCategoria el fcFriendlyURLCategoria a establecer
	 */
	public void setFcFriendlyURLCategoria(String fcFriendlyURLCategoria) {
		this.fcFriendlyURLCategoria = fcFriendlyURLCategoria;
	}
	
	/**
	 * @return el fcPaisRegistro
	 */
	public String getFcPaisRegistro() {
		return fcPaisRegistro;
	}
	/**
	 * @param fcPaisRegistro el fcPaisRegistro a establecer
	 */
	public void setFcPaisRegistro(String fcPaisRegistro) {
		this.fcPaisRegistro = fcPaisRegistro;
	}
	
	/**
	 * @return el placeGallery
	 */
	public String getPlaceGallery() {
		return placeGallery;
	}
	/**
	 * @param placeGallery el placeGallery a establecer
	 */
	public void setPlaceGallery(String placeGallery) {
		this.placeGallery = placeGallery;
	}
	/**
	 * @return el fcPCode
	 */
	public String getFcPCode() {
		return fcPCode;
	}
	/**
	 * @param fcPCode el fcPCode a establecer
	 */
	public void setFcPCode(String fcPCode) {
		this.fcPCode = fcPCode;
	}
	/**
	 * @return el fcSourceVideo
	 */
	public String getFcSourceVideo() {
		return fcSourceVideo;
	}
	/**
	 * @param fcSourceVideo el fcSourceVideo a establecer
	 */
	public void setFcSourceVideo(String fcSourceVideo) {
		this.fcSourceVideo = fcSourceVideo;
	}
	/**
	 * @return el fcAlternateTextVideo
	 */
	public String getFcAlternateTextVideo() {
		return fcAlternateTextVideo;
	}
	/**
	 * @param fcAlternateTextVideo el fcAlternateTextVideo a establecer
	 */
	public void setFcAlternateTextVideo(String fcAlternateTextVideo) {
		this.fcAlternateTextVideo = fcAlternateTextVideo;
	}
	/**
	 * @return el fcDurationVideo
	 */
	public String getFcDurationVideo() {
		return fcDurationVideo;
	}
	/**
	 * @param fcDurationVideo el fcDurationVideo a establecer
	 */
	public void setFcDurationVideo(String fcDurationVideo) {
		this.fcDurationVideo = fcDurationVideo;
	}
	/**
	 * @return el fcFileSizeVideo
	 */
	public String getFcFileSizeVideo() {
		return fcFileSizeVideo;
	}
	/**
	 * @param fcFileSizeVideo el fcFileSizeVideo a establecer
	 */
	public void setFcFileSizeVideo(String fcFileSizeVideo) {
		this.fcFileSizeVideo = fcFileSizeVideo;
	}
	public String toString() {
		
		String NEW_LINE = System.getProperty("line.separator");
		StringBuffer result=new StringBuffer();
		result.append(" [Begin of Class] " + NEW_LINE);
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		result.append(" fcIdContenido: _" + this.getFcIdContenido() + "_" + NEW_LINE);
		result.append(" fcIdCategoria: _" + this.getFcIdCategoria() + "_" + NEW_LINE);
		result.append(" fcNombre: _" + this.getFcNombre() + "_" + NEW_LINE);
		result.append(" fcTitulo: _" + this.getFcTitulo() + "_" + NEW_LINE);
		result.append(" fcDescripcion: _" + this.getFcDescripcion() + "_" + NEW_LINE);
		result.append(" fcEscribio: _" + this.getFcEscribio() + "_" + NEW_LINE);
		result.append(" fcLugar: _" + this.getFcLugar() + "_" + NEW_LINE);
		result.append(" fcFuente: _" + this.getFcFuente() + "_" + NEW_LINE);
		result.append(" fcIdTipoNota: _" + this.getFcIdTipoNota() + "_" + NEW_LINE);
		result.append(" fcImgPrincipal: _" + this.getFcImgPrincipal() + "_" + NEW_LINE);
		result.append(" fcPieFoto: _" + this.getFcPieFoto() + "_" + NEW_LINE);
		result.append(" fcIdVideoYouTube: _" + this.getFcIdVideoYouTube() + "_" + NEW_LINE);
		result.append(" fcIdVideoOoyala: _" + this.getFcIdVideoOoyala() + "_" + NEW_LINE);
		result.append(" fcIdPlayerOoyala: _" + this.getFcIdPlayerOoyala() + "_" + NEW_LINE);
		result.append(" clGaleriaImagenes: _" + this.getClGaleriaImagenes() + "_" + NEW_LINE);
		result.append(" fcImgInfografia: _" + this.getFcImgInfografia() + "_" + NEW_LINE);
		result.append(" clRtfContenido_" + this.getClRtfContenido() + "_" + NEW_LINE);
		result.append(" fdFechaPublicacion: _" + this.getFdFechaPublicacion() + "_" + NEW_LINE);
		result.append(" fcTags: _" + this.getFcTags() + "_" + NEW_LINE);
		result.append(" fcKeywords	: _" + this.getFcKeywords() + "_" + NEW_LINE);
		result.append(" fiBanInfinito: _" + this.getFiBanInfinito() + "_" + NEW_LINE);
		result.append(" fiBanVideoViral: _" + this.getFiBanVideoViral() + "_" + NEW_LINE);
		result.append(" fiBanNoTeLoPierdas: _" + this.getFiBanNoTeLoPierdas() + "_" + NEW_LINE);
		result.append(" fiBanPatrocinio: _" + this.getFiBanPatrocinio() + "_" + NEW_LINE);
		result.append(" fcPatrocinioBackGround: _" + this.getFcPatrocinioBackGround() + "_" + NEW_LINE);
		result.append(" fcPatrocinioColorTexto: _" + this.getFcPatrocinioColorTexto() + "_" + NEW_LINE);
		result.append(" fcFecha: _" + this.getFcFecha() + "_" + NEW_LINE);
		result.append(" fcHora: _" + this.getFcHora() + "_" + NEW_LINE);
		result.append(" fcTipoSeccion: _" + this.getFcTipoSeccion() + "_" + NEW_LINE);
		result.append(" fcSeccion: _" + this.getFcSeccion() + "_" + NEW_LINE);
		result.append(" fcNombreCategoria: _" + this.getFcNombreCategoria() + "_" + NEW_LINE);
		result.append(" fcUrl: _" + this.getFcUrl() + "_" + NEW_LINE);
		result.append(" fcFriendlyURLSeccion: _" + this.getFcFriendlyURLSeccion() + "_" + NEW_LINE);
		result.append(" fcFriendlyURLCategoria: _" + this.getFcFriendlyURLCategoria() + "_" + NEW_LINE);
		result.append(" fcTituloComentario: _" + this.getFcTituloComentario() + "_" + NEW_LINE);
		result.append(" fcTagsApp: _" + this.getFcTags() + "_" + NEW_LINE);
		result.append(" fcPaisRegistro: _" + this.getFcPaisRegistro() + "_" + NEW_LINE);
		result.append(" placeGallery: _" + this.getPlaceGallery() + "_" + NEW_LINE);
		result.append(" fcPCode: _" + this.getFcPCode() + "_" + NEW_LINE);
		result.append(" [End of Class] " + NEW_LINE);
		result.append("}");
		NEW_LINE = null;

		return result.toString();
	}	
	
	/*@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return super.clone();
	}*/
	@Override
	public ContentDTO clone() {
		try {
			return (ContentDTO) super.clone();
		} catch (CloneNotSupportedException e) {		
			logger.error("Error al hacer el clon");
			return null;
		}
	}
}