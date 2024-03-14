package icc.articulos;

import icc.files.ReaderWriter;

/**
 * Clase que construye un esquema general de un articulo de cualquier coleccion
 * @author Alexander Adalid Castillo Romero
 * @version 1.0
 */

public class Articulo {
    protected String titulo;
    protected String genero;

    /** Constructor para la clase Articulo
     * @param titulo parametro que recibe el nombre del articulo
     * @param genero parametro que recibe el genero del articulo
     */
    public Articulo (String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
    }

    /**
     * Constructor de la clase Articulo
     */
    public Articulo () {

    }

    /**
     * Metodo que regresa el titulo del articulo
     * @return regresa el titulo del articulo en formato String
     */
    public String titulo() {
        return this.titulo;
    }

    /**
     * Metodo para obtener el genero del articulo
     * @return devuelve el genero del articulo en formato String
     */

    public String genero() {
        return this.genero;
    }
    /**
     * Metodo que permite registrar el titulo del articulo y requiere un parametro de tipo String
     * @param titulo parametro que registra el titulo del articulo
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo que registra el genero del articulo y recibe un parametro de tipo String
     * @param genero parametro que contiene el genero del articulo
     */

    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Metodo que hace un conteo de las lineas en un archivo .csv para verificar si ya existen mas de 32 articulos en ella o si aun es posible escribir nuevos articulos
     * @param nombreArchivo parametro que recibe el nombre del archivo a verificar 
     * @param nombreColeccion parametro que recibe el nombre de la coleccion que se esta verificando para, en caso de estar llena, indicarlo en un mensaje acotado a cada coleccion
     * @return devuelve un boolean que indica si la coleccion esta llena o si aun se pueden escribir archivos sobre ella
     */

    public boolean coleccionLlena(String nombreArchivo, String nombreColeccion) {
        boolean espacioDisponible = true; // Variable que determina si aun queda espacio disponible para registrar nuevos objetos inicializada como verdadera
        int contador = 0;
        String[] elementos = ReaderWriter.read(nombreArchivo);                          // Genera un arreglo de cadenas con los datos que estan en el archivo de la coleccion
        for (String lineasConteo : elementos) {                                         //ciclo for que lee las lineas en el archivo de texto
            contador ++;
        }                                                                
            if (contador < 32) {                                                        // condicional que cambia la disponibilidad de espacio si hay menos de 32 articulos registrados
            espacioDisponible = true; 
            } else {
                System.out.println("Tu coleccion de " + nombreColeccion + " esta llena"); //en caso de que la coleccion este llena se imprime este mensaje
                espacioDisponible = false;
            }
        
        return espacioDisponible;

    }


}
