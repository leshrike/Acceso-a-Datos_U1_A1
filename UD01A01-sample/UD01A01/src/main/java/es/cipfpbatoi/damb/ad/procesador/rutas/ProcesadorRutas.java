package es.cipfpbatoi.damb.ad.procesador.rutas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProcesadorRutas {

	public static StringBuilder procesarRuta(ConfiguracionBusqueda configuracionBusqueda) {

		StringBuilder resultadoProceso = new StringBuilder();

		String rutaInicial = configuracionBusqueda.getRutaInicial();

		resultadoProceso.append("Vamos a buscar en la ruta: " + configuracionBusqueda.getRutaInicial() + "\n");

		if (checkDirectorio(rutaInicial)) {

			if (configuracionBusqueda.isBuscarRecursivamente()) {

				File[] listaDirectorios = getDirectorios(rutaInicial);

				for (File directorio : listaDirectorios) {

					getDirectorios(directorio.getAbsolutePath());
					resultadoProceso.append("Directorio " + directorio.getAbsoluteFile() + ". \n");
					
				}

			} else {

				File[] archivos = getFicherosFiltrados(rutaInicial, configuracionBusqueda.getFiltroNombre(),
						configuracionBusqueda.isMostrarArchivosOcultos());

				for (File archivo : archivos) {

					resultadoProceso.append("El archivo " + archivo.getName() + " se encuentra en " + archivo.getPath()
							+ " y es de tipo: " + getExtension(archivo.getPath()) + ". \n");
					
					if (configuracionBusqueda.getCopiarDirectorio() != "") {
						
						File destinoCopia = new File (configuracionBusqueda.getCopiarDirectorio());
						
						if (destinoCopia.exists()) {
							
							copiarArchivo(archivo.getAbsolutePath(),destinoCopia.getAbsolutePath());
							
							System.out.println("Se copia el archivo  " + archivo.getName() + " a " + destinoCopia.getAbsolutePath() + ". \n" );
						}	
					}
					
				}
			}
		}
		return resultadoProceso;
	}

	public static File[] getFicherosFiltrados(String ruta, String filtro, boolean ocultos) {

		File archivo = new File(ruta);

		FileFilter archivosFiltrados = new FileFilter() {

			public boolean accept(File archivo) {

				if (archivo.isFile() && archivo.exists() && archivo.getName().contains(filtro)) {

					if (!ocultos && !archivo.isHidden()) {

						return true;

					} else if (ocultos && !archivo.isHidden() || archivo.isHidden()) {

						return true;
					}
				}
				return false;
			}
		};

		File[] archivos = archivo.listFiles(archivosFiltrados);

		return archivos;
	}

	public static File[] getDirectorios(String ruta) {

		File carpeta = new File(ruta);
			
			FileFilter listadoCarpetas = new FileFilter() {
				
				public boolean accept(File carpeta) {

						if (carpeta.exists() && carpeta.isDirectory()) {
							System.out.println(carpeta.getAbsoluteFile());
							getDirectorios(carpeta.getAbsolutePath());
							
							return true;
						}
						
						return false;	
				}
			};
		File[] carpetas = carpeta.listFiles(listadoCarpetas) ;
		return carpetas;
//
//		if (list != null) {
//			for (File f : list) {
//				if (f.isDirectory()) {
//					System.out.println(f.getAbsoluteFile());
//					getDirectorios(f.getAbsolutePath());
//				}
//			}
//		}
//
//		return list;
	}

	public static String getExtension(String ruta) {

		String extension = "";

		File archivo = new File(ruta);

		if (archivo.getName().lastIndexOf(".") >= 0) {

			extension = archivo.getPath().substring(archivo.getPath().lastIndexOf(".") + 1);
		}

		return extension;
	}

	public static void copiarArchivo(String origen, String destino) {
		File archivoOrigen = new File (origen);
		File archivoDestino = new File (destino);
		
		String a_destino = "$archivoDestino.getAbsolutePath()/$archivoOrigen.getName()" ;
		
		try {
			
			InputStream entrada = new BufferedInputStream(new FileInputStream(archivoOrigen.getName()));
			OutputStream salida = new BufferedOutputStream(new FileOutputStream(a_destino));
			
			byte[] buffer = new byte[1024];
			int i;
			
			while ((i = entrada.read(buffer)) > 0) {
				salida.write(buffer, 0 , i);
				salida.flush();
			}
			
			entrada.close();
			salida.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public static boolean checkDirectorio(String ruta) {

		File archivo = new File(ruta);

		boolean esCarpeta;

		if (!archivo.exists() && !archivo.isDirectory()) {

			esCarpeta = false;
			return esCarpeta;

		} else {
			esCarpeta = true;
			return esCarpeta;
		}

	}
}