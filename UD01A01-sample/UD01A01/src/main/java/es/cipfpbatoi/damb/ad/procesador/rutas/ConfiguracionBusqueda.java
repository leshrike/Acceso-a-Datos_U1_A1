package es.cipfpbatoi.damb.ad.procesador.rutas;

public class ConfiguracionBusqueda {
	
	private String rutaInicial;
	private String filtroNombre;
	private String copiarDirectorio;
	
	private boolean buscarRecursivamente;
	private boolean mostrarArchivosOcultos;
	
	public ConfiguracionBusqueda() {
		super();
	}
	
	// Ruta Inicial 
	
	public String getRutaInicial() {
		return this.rutaInicial;
	}
	public void setRutaInicial(String rutaInicial) {
		this.rutaInicial = rutaInicial;
	}
	
	// Flitro de nombres
	
	public String getFiltroNombre() {
		return this.filtroNombre;
	}
	public void setFiltroNombre(String filtroNombre) {
		this.filtroNombre = filtroNombre;
	}
	
	// Busqueda recursiva
	
	public boolean isBuscarRecursivamente() {
		return this.buscarRecursivamente;
	}
	public void setBuscarRecursivamente(boolean buscarRecursivamente) {
		this.buscarRecursivamente = buscarRecursivamente;
	}
	
	// archivos ocultos
	
	public boolean isMostrarArchivosOcultos() {
		return this.mostrarArchivosOcultos;
	}
	public void setMostrarArchivosOcultos(boolean mostrarArchivosOcultos) {
		this.mostrarArchivosOcultos = mostrarArchivosOcultos;
	}
	
	// copia de archivos
	public String getCopiarDirectorio() {
		return this.copiarDirectorio;
	}
	public void setCopiarDirectorio(String copiarDirectorio) {
		this.copiarDirectorio = copiarDirectorio;
	}
	
}	

