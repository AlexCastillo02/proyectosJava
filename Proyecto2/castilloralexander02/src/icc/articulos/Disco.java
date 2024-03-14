package icc.articulos;
/**
 * Subclase que permite generar datos particulares para un tipo de articulo llamado Disco
 * @author Alexander Adalid Castillo Romero
 * @version 1.0
 */


 public class Disco extends Articulo {
    protected int numeroPistas;
    protected String interprete;

    /**
     * La clase disco requiere 2 parametros adicionales, que son el numero de pistas y el nombre del interprete
     * @param titulo parametro que viene de la superclase Articulo para el titulo de un articulo en particular, en este caso un disco
     * @param genero parametro que viene de la superclase Articulo para el genero de un articulo en particular, en este caso un disco
     * @param numeroPistas parametro que regsitra el numero de pistas de un disco
     * @param interprete parametro que registra el nombre del intreprete de un disco
     */

    
    public Disco(String titulo, String genero, int numeroPistas, String interprete) {
        /**
         * Constructor de la subclase disco que hereda parametros de la superclase Articulo
         */
        super(titulo, genero);
        this.numeroPistas=numeroPistas;
        this.interprete=interprete;
        
    }

    public Disco() {
        /**
         * Constructor de la clase Disco
         */

    }

    /**
     * Metodo que permite obtener el numero de pistas de un objeto de tipo disco
     * @return devuelve un int que incluye el numero de pistas
     */
    public int numeroPistas() {
        return this.numeroPistas;
    }

    /**
     * Metodo que permite obtener el interprete de un disco
     * @return devuelve un String con el nombre del interprete
     */
    public String interprete() {
        return this.interprete;
    }

    /**
     * Metodo que permite registrar el nombre del interprete del disco
     * @param interprete String que contiene el nombre del interprete
     */

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    /**
     * Metodo que permite registrar el numero de pistas de un disco
     * @param numeroPistas parametro qde tipo int que registra el numero de pistas
     */

    public void setNumeroPistas(int numeroPistas) {
        this.numeroPistas = numeroPistas;
    }

    /**
     * Metodo que permite crear una cadena de texto para despues guardarla en el archivo csv con los datos del disco separados por comas
     * @return devuelve una cadena de texto con los datos del disco creado separados por comas
     */

    public String newDisco() {
        String discoNuevo = (titulo + "," + genero + "," + interprete + "," + numeroPistas); 
        return discoNuevo;
    }

}