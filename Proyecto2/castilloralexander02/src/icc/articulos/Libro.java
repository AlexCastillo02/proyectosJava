package icc.articulos;

/**
 * Subclase que permite generar datos particulares para un tipo de articulo llamado Libro
 * @author Alexander Adalid Castillo Romero
 * @version 1.0
 */

public class Libro extends Articulo{
    protected String autor;
    protected String tema;

    /**
     * La clase libro recibe 2 parametros adicionales al titulo y genero, que son un autor y tema
     * @param titulo Parametro de la superclase que recibe el titulo del libro
     * @param genero Parametro de la superclase que recibe el genero del libro
     * @param autor Parametro propio de la clase libro que registra su autor
     * @param tema parametro propio de la clase libro que registra el tema
     */

    

    public Libro(String titulo, String genero, String autor, String tema) {
        /**
         * Constructor de la clase libro que registra sus parametros propios y 2 parametros de la superclase
         */
        super(titulo, genero);
        this.autor=autor;
        this.tema=tema;
    }

    public Libro() {
        /**
         * Constructor de la clase libro
         */

    }

    /**
     * Metodo que devuelve un String que contiene al autor del libro
     * @return String que contiene al autor
     */
    public String autor() {
        return this.autor;
    }

    /**
     * Metodo que devuelve el tema del libro
     * @return String que posse el tema del libro
     */

    public String tema() {
        return this.tema;
    }

    /**
     * Metodo que permite registrar el autor del libro
     * @param autor parametro String con el autor del libro
     */

    public void setAutor(String autor) {
        this.autor=autor;
    }

    /**
     * Metodo que permite registrar el tema del libro
     * @param tema parametro String que contiene el tema del libro
     */

    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * Metodo que genera una cadena para guardar un libro en el archivo .csv correspondiente
     * @return devuelve la cadena con los datos separados por comas para registrar en el archivo .csv
     */

    public String newLibro() {
        String libroNuevo = (titulo + "," + genero + "," + autor + "," + tema); 
        return libroNuevo;
    }
}