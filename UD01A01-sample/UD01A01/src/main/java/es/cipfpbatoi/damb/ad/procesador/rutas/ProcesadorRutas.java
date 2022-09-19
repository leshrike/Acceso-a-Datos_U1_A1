package es.cipfpbatoi.damb.ad.procesador.rutas;

import java.io.File;
import java.io.FileFilter;

public class ProcesadorRutas {

	public static StringBuilder procesarRuta(ConfiguracionBusqueda configuracionBusqueda) {

		StringBuilder resultadoProceso = new StringBuilder();

		String rutaInicial = configuracionBusqueda.getRutaInicial();

		resultadoProceso.append("Vamos a buscar en la ruta: " + configuracionBusqueda.getRutaInicial() + "\n");

		if (checkDirectorio(rutaInicial)) {

			if (configuracionBusqueda.isBuscarRecursivamente()) {

				File[] carpetas = getDirectorios(rutaInicial);

				for (File carpeta : carpetas) {

					resultadoProceso.append("Directorio: " + carpeta.getName() + ". \n");
					
					getDirectorios(carpeta.getAbsolutePath());
				}

			} else {

				File[] archivos = getFicherosFiltrados(rutaInicial, configuracionBusqueda.getFiltroNombre(),
						configuracionBusqueda.isMostrarArchivosOcultos());

				for (File archivo : archivos) {

					resultadoProceso.append("El archivo " + archivo.getName() + " se encuentra en " + archivo.getPath()
							+ " y es de tipo: " + getExtension(archivo.getPath()) + ". \n");
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

					return true;
				}
				return false;
			}

		};

		File[] carpetas = carpeta.listFiles(listadoCarpetas);

		return carpetas;
	}

	public static String getExtension(String ruta) {

		String extension = "";

		File archivo = new File(ruta);

		if (archivo.getName().lastIndexOf(".") >= 0) {

			extension = archivo.getPath().substring(archivo.getPath().lastIndexOf(".") + 1);
		}

		return extension;
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