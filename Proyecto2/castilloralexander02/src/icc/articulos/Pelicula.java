package icc.articulos;

/**
 * Subclase que permite generar datos particulares para un tipo de articulo llamado Pelicula
 * @author Alexander Adalid Castillo Romero
 * @version 1.0
 */


public class Pelicula extends Articulo {
    protected int filmacion;
    protected String actorActrizPrincipal;
    /**
     * Clase que extiende el titulo y genero de la superclase y dos parametros adicionales que requiere la pelicula
     * @param titulo parametro heredado de la superclase Articulo
     * @param genero parametro heredado de la superclase Articulo
     * @param filmacion parametro de tipo int que registra cuando se filmo la pelicula
     * @param actorAtrizPrincial parametro de tipo String que registra quien es el o la actriz principal de la pelicula
     */
    
    public Pelicula(String titulo, String genero, int filmacion, String actorAtrizPrincial) {
        /**
         * Constructor de la clase Pelicula con parametros heredados y parametro propios de la clase pelicula
         */
        super(titulo, genero);
        this.filmacion=filmacion;
        this.actorActrizPrincipal=actorAtrizPrincial;
    }
    
    /**
     * Constructor de la clase pelicula
     */
    public Pelicula() {

    }

    /**
     * metodo que permite obtener el momento de filmacion de la pelicula
     * @return devuelve un int que indica cuando se filmo la pelicula
     */
    public int fimlacion() {
        return this.filmacion;
    }

    /**
     * Metodo que permite obtener el actor o actriz principal de una pelicula
     * @return devuelve un String con el actor o actriz  principal de la pelicula
     */
    public String actorActrizPrincipal() {
        return this.actorActrizPrincipal;
    }

    /**
     * metodo que permite registrar cuando se filmo una pelicula 
     * @param filmacion parametro que recibe el momento de filmacion
     */

    public void setFilmacion(int filmacion) {
        this.filmacion = filmacion;
    }

    /**
     * Metodo que permite registrar quien es el actor o actriz princial
     * @param actorActrizPrincipal parametro que recibe el nombre del actor o actriz principal 
     */
    
    public void setActorActrizPrincipal(String actorActrizPrincipal) {
        this.actorActrizPrincipal = actorActrizPrincipal;
    }

    /**
     * Metodo que permite generar una cadena con los datos de la pelicula para guardarla en el archivo .csv correspondiente
     * @return devuelve una cadena de texto con los datos de la pelicula ordenados y separados por comas
     */

    public String newPelicula() {
        String peliculaNueva = (titulo + "," + genero + "," + actorActrizPrincipal + "," + filmacion); 
        return peliculaNueva;
    }
}
