package icc.modeloBusqueda;

/**
 * Clase que permite realizar busquedas en los archivos de texto y desplegar ya sea las colecciones completas o los datos de un solo articulo que coincida con la busqueda solicitada
 *
 * @author Alexande Adalid Castillo Romero
 * @version 1.0
 */

import java.util.StringTokenizer; //Clase que permite separar los datos de cada articulo registrado en los csv
import icc.files.ReaderWriter;


public class Busqueda {
    /**
     *  Constructor de la clase
     */

    public Busqueda(){}

    /**
     * Metodo que permite imprimir todos los elementos de una coleccion de articulos
     * @param archivoColeccion parametro que indica en que archivo buscar la coleccion
     * @param dato1 parametro que indica cual es el dato que se va a imprimir en primer lugar
     * @param dato2 parametro que indica cual es el dato que se va a imprimir en segundo lugar
     * @param dato3 parametro que indica cual es el dato que se va a imprimir en tercer lugar
     * @param dato4 parametro que indica cual es el dato que se va a imprimir en cuarto lugar
     */

    public void coleccionCompleta(String archivoColeccion, String dato1, String dato2, String dato3, String dato4) {
        String[] lineas = ReaderWriter.read(archivoColeccion); // Crea un arreglo que contiene las lineas de texto en el archivo csv
                    for (String linea : lineas) { //ciclo for con operador ternario que corre mientras haya lineas que leer

                        StringTokenizer tokenizer = new StringTokenizer(linea, ","); //metodo que permite obtener los datos que estan entre las comas
                        if (tokenizer.countTokens()==4) { //ciclo for que cuenta los elementos en cada cadena y lo separa en 4 datos distintos
                            String titulo = tokenizer.nextToken();
                            String genero = tokenizer.nextToken();
                            String autor = tokenizer.nextToken();
                            String tema = tokenizer.nextToken();

                        System.out.println(dato1 + ": " + titulo); //imprie los datos de cada elemento en la coleccion
                        System.out.println(dato2 + ": " + genero);
                        System.out.println(dato3 + ": " + autor);
                        System.out.println(dato4 + ": " + tema);
                        System.out.println();

                        }


                    }
    }

    /**
     * Metodo que permite hacer una busqueda del dato del token numero 3, funciona basicamente como la impresion de la busqueda completa pero este imprime solo los datos que coincidan con la busqueda
     * @param nombreArchivo parametro de tipo String que indica el nombre del archivo sobre el que se hara la busqeda
     * @param dato1 parametro que indica cual es el dato que se va a imprimir en primer lugar
     * @param dato2 parametro que indica cual es el dato que se va a imprimir en segundo lugar
     * @param dato3 parametro que indica cual es el dato que se va a imprimir en tercer lugar
     * @param dato4 parametro que indica cual es el dato que se va a imprimir en cuarto lugar
     * @param dato1consulta parametro de tipo String que muestra el dato que solicito el usuario para comprobar si coincide con alguno existente en el archivo
     */

    public void busquedaDato1(String nombreArchivo, String dato1, String dato2, String dato3, String dato4, String dato1consulta) {
        String[] lineas = ReaderWriter.read(nombreArchivo);
                    for (String linea : lineas) {

                        StringTokenizer tokenizer = new StringTokenizer(linea, ",");
                        if (tokenizer.countTokens()==4) {
                            String titulo = tokenizer.nextToken();
                            String genero = tokenizer.nextToken();
                            String autor = tokenizer.nextToken();
                            String tema = tokenizer.nextToken();

                        if (dato1consulta.equals(autor)) { //condicional que permite imprimir los datos de un articulo si hay alguna coincidencia con la busqueda que hizo el usuario

                        System.out.println(dato1 + ": " + titulo);
                        System.out.println(dato2 + ": " + genero);
                        System.out.println(dato3 + ": " + autor);
                        System.out.println(dato4 + ": " + tema);
                        System.out.println();
                        }

                        }
    }
}

    /**
     * Metodo que permite hacer una busqueda del dato del token numero 1, funciona basicamente como la impresion de la busqueda completa pero este imprime solo los datos que coincidan con la busqueda
     * @param nombreArchivo parametro de tipo String que indica el nombre del archivo sobre el que se hara la busqeda
     * @param dato1 parametro que indica cual es el dato que se va a imprimir en primer lugar
     * @param dato2 parametro que indica cual es el dato que se va a imprimir en segundo lugar
     * @param dato3 parametro que indica cual es el dato que se va a imprimir en tercer lugar
     * @param dato4 parametro que indica cual es el dato que se va a imprimir en cuarto lugar
     * @param dato2consulta parametro de tipo String que muestra el dato que solicito el usuario para comprobar si coincide con alguno existente en el archivo
     */

    public void busquedaDato2(String nombreArchivo, String dato1, String dato2, String dato3, String dato4, String dato2consulta) {
        String[] lineas = ReaderWriter.read(nombreArchivo);
                    for (String linea : lineas) {

                        StringTokenizer tokenizer = new StringTokenizer(linea, ",");
                        if (tokenizer.countTokens()==4) {
                            String titulo = tokenizer.nextToken();
                            String genero = tokenizer.nextToken();
                            String autor = tokenizer.nextToken();
                            String tema = tokenizer.nextToken();

                        if (dato2consulta.equals(titulo)) { //condicional que permite imprimir los datos de un articulo si hay alguna coincidencia con la busqueda que hizo el usuario

                        System.out.println(dato1 + ": " + titulo);
                        System.out.println(dato2 + ": " + genero);
                        System.out.println(dato3 + ": " + autor);
                        System.out.println(dato4 + ": " + tema);
                        System.out.println();
                        }

                        }
    }
}

    /**
     * Metodo que permite hacer una busqueda del dato del token numero 4, funciona basicamente como la impresion de la busqueda completa pero este imprime solo los datos que coincidan con la busqueda
     * @param nombreArchivo parametro de tipo String que indica el nombre del archivo sobre el que se hara la busqeda
     * @param dato1 parametro que indica cual es el dato que se va a imprimir en primer lugar
     * @param dato2 parametro que indica cual es el dato que se va a imprimir en segundo lugar
     * @param dato3 parametro que indica cual es el dato que se va a imprimir en tercer lugar
     * @param dato4 parametro que indica cual es el dato que se va a imprimir en cuarto lugar
     * @param dato3consulta parametro de tipo String que muestra el dato que solicito el usuario para comprobar si coincide con alguno existente en el archivo
     */


    public void busquedaDato3(String nombreArchivo, String dato1, String dato2, String dato3, String dato4, String dato3consulta) {
        String[] lineas = ReaderWriter.read(nombreArchivo);
                    for (String linea : lineas) {

                        StringTokenizer tokenizer = new StringTokenizer(linea, ",");
                        if (tokenizer.countTokens()==4) {
                            String titulo = tokenizer.nextToken();
                            String genero = tokenizer.nextToken();
                            String autor = tokenizer.nextToken();
                            String tema = tokenizer.nextToken();

                        if (dato3consulta.equals(tema)) { //condicional que permite imprimir los datos de un articulo si hay alguna coincidencia con la busqueda que hizo el usuario

                        System.out.println(dato1 + ": " + titulo);
                        System.out.println(dato2 + ": " + genero);
                        System.out.println(dato3 + ": " + autor);
                        System.out.println(dato4 + ": " + tema);
                        System.out.println();
                        }

                        }
    }
}

    /**
     * Metodo que permite hacer una busqueda del dato del token numero 2, funciona basicamente como la impresion de la busqueda completa pero este imprime solo los datos que coincidan con la busqueda
     * @param nombreArchivo parametro de tipo String que indica el nombre del archivo sobre el que se hara la busqeda
     * @param dato1 parametro que indica cual es el dato que se va a imprimir en primer lugar
     * @param dato2 parametro que indica cual es el dato que se va a imprimir en segundo lugar
     * @param dato3 parametro que indica cual es el dato que se va a imprimir en tercer lugar
     * @param dato4 parametro que indica cual es el dato que se va a imprimir en cuarto lugar
     * @param dato4consulta parametro de tipo String que muestra el dato que solicito el usuario para comprobar si coincide con alguno existente en el archivo
     */


    public void busquedaDato4(String nombreArchivo, String dato1, String dato2, String dato3, String dato4, String dato4consulta) {
        String[] lineas = ReaderWriter.read(nombreArchivo);
                    for (String linea : lineas) {

                        StringTokenizer tokenizer = new StringTokenizer(linea, ",");
                        if (tokenizer.countTokens()==4) {
                            String titulo = tokenizer.nextToken();
                            String genero = tokenizer.nextToken();
                            String autor = tokenizer.nextToken();
                            String tema = tokenizer.nextToken();

                        if (dato4consulta.equals(genero)) { //condicional que permite imprimir los datos de un articulo si hay alguna coincidencia con la busqueda que hizo el usuario

                        System.out.println(dato1 + ": " + titulo);
                        System.out.println(dato2 + ": " + genero);
                        System.out.println(dato3 + ": " + autor);
                        System.out.println(dato4 + ": " + tema);
                        System.out.println();
                        }

                        }
    }
}
}
