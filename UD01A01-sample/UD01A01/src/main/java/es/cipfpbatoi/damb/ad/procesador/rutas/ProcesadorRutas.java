package es.cipfpbatoi.damb.ad.procesador.rutas;

import java.io.File;

public class ProcesadorRutas {
	
	public static StringBuilder procesarRuta(ConfiguracionBusqueda configuracionBusqueda) {
		
		StringBuilder resultadoProceso = new StringBuilder();
		
		resultadoProceso.append("Vamos a buscar en la ruta: " + configuracionBusqueda.getRutaInicial() + "\n");
		
			if (configuracionBusqueda.checkDirectorio(configuracionBusqueda.getRutaInicial())) {
				
				resultadoProceso.append("Procesando directorio...\n");
				
				File [] listadoArchivos = configuracionBusqueda.listaArchivos(configuracionBusqueda.getRutaInicial());
				
				for (File archivo : listadoArchivos) {
					
					resultadoProceso.append("Se ha encontrado un fichero en la ruta: " + archivo.getPath() + ", con el nombre " + archivo.getName() + " y de tipo " + archivo.getName().lastIndexOf(".")+". \n");
				}
									
			} else {
				
				resultadoProceso.append("La ruta introducida corresponde a un fichero \n");
			}
			
		return resultadoProceso;
	}

}
