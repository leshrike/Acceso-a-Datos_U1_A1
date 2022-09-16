# Acceso-a-Datos_U1_A1

Implementa las clases y algoritmos necesarios para completar la aplicación JavaFX proporcionada en el fichero adjunto.

La aplicación mostrará un listado de los archivos contenidos en la carpeta seleccionada, indicando la ruta en la que se encuentra, el nombre del fichero, y la extensión.

Opción "Buscar dentro de los directorios":

Si no se marca, se deberán mostrar únicamente los ficheros que se encuentran en el directorio seleccionado, no tiendo en cuenta las carpetas.
Si se marca, se deberán mostrar todos los ficheros que se encuentran en el árbol del directorio seleccionado (se debe buscar dentro de las carpetas que se encuentren).
Opción "Mostrar archivos ocultos":

Si no se marca, se deberán mostrar únicamente los ficheros encontrados, que no estén configurados como ocultos, ignorando el resto.
Si se marca, se deberán mostrar todos los ficheros encontrados.
En caso de que se indique un filtro de búsqueda, se deben mostrar únicamente los ficheros que contengan en su nombre la cadena introducida.

[Opcional] En caso de que esté marcado el check 'Buscar dentro de los directorios',

[Opcional] Añadir un nuevo selector de ruta, para seleccionar una ruta destino, y copiar los ficheros encontrados en el directorio destino, respetando el árbol de directorios original. Si la carpeta indicada no existe, deberá crearse.

Requisitos:

La aplicación deberá utilizar la interfaz FileFilter.
La entrega se realizará enviando el código fuente de la solución, comprimido en un fichero ZIP.
La parte opcional se debe implementar utilizando las clases de flujos de entrada/salida sobre ficheros (FileInputStream /FileOutputStream).
