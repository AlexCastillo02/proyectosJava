
package icc.files;

/**
 * Clase que permite leer y escribir sobre los archivos .csv
 * @author 
 * @version 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class ReaderWriter {
    /**
     * Metodo que analiza un archivo y devuelve un arreglo de Strings con los datos del archivo
     * @param fileName parametro que indica el nombre del archivo a leer
     * @return devuelve un arreglo de String
     */

    public static String[] read(String fileName)  {
        String line;
        LinkedList<String> l = null;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(fileName));
            l = new LinkedList<>();
            while ((line = in.readLine()) != null) {
                l.add(line);
            }
        } catch (FileNotFoundException e) {
            return new String[0];
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        return l.toArray(new String[l.size()]);
    }

    /**
     * Metodo que permite escribir sobre un archivo de tipo csv
     * @param articulo parametro que recibe un String que contiene los datos del articulo ordenados y separados por coma para registrarlos
     * @param fileName nombre del archivo csv sobre el que se escribira
     */

    public static void write(String articulo, String fileName) {
        FileWriter out = null;
        
        try {
            out = new FileWriter(fileName, true);
            out.write(articulo);
            out.write("\n");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
