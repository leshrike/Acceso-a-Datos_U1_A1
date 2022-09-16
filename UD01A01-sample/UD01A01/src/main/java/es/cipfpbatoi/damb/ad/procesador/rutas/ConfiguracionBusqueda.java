package es.cipfpbatoi.damb.ad.procesador.rutas;

import java.io.File;
import java.io.FileFilter;


public class ConfiguracionBusqueda {
	
	private String rutaInicial;
	private String filtroNombre;
	
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
	
	public boolean checkDirectorio(String ruta) {
		
		File archivo = new File (ruta);
		
		boolean esCarpeta;
		
			if (!archivo.exists() && !archivo.isDirectory()) {
				
				esCarpeta = false;
				return esCarpeta;
				
			}else {
				esCarpeta = true;
				return esCarpeta;
			}
		
	}
	
	public File[] listaArchivos (String ruta) {
		
		File archivo = new File (ruta);
		
			FileFilter filtroArchivo = new FileFilter(){
				
				public boolean accept (File file){
					if (file.exists()) {	
						return true;
					}
					return false;
				}		
			};
		
		File[] archivos = archivo.listFiles(filtroArchivo);
		
		return archivos;
	}
}	

