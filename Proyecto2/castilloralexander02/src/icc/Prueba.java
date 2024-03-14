
package icc;

/**
 * 
 * Clase principal para gestionar colecciones de articulos como libros, discos o peliculas
 * 
 * @author Alexander Adalid Castillo Romero
 * @version 1.0
 */

import java.util.Scanner; // Clase que permite ingresar datos al usuario
import java.util.StringTokenizer; // Clase que permite dividir las cadens de los archivos separadas por comas
import java.util.InputMismatchException; //Clase que permite manejar la excepcion para la entrada de datos erronea

import icc.files.ReaderWriter; //Clase que permite leer y escribir sobre archivos .csv
import icc.modeloBusqueda.Busqueda; //Clase que permite realizar busquedas especificas en los archivos
import icc.articulos.Disco; //Clase que permite crear discos
import icc.articulos.Libro; //Clase que permite creoar libros
import icc.articulos.Pelicula; //Clase que permite generar peliculas

public class Prueba {
    /**
     * Clase principal para la ejecucion del programa
     * @param args Cadena de argumentos que puede recibir el metodo main
     */
    public static void main(String[] args) {
        /**
         * Metodo main para la ejecucion del programa
         */



        System.out.println("Bienvenido, este programa es un gestor de articulos de entretenimiento"); //Mensaje de bienvenida unico al ejecutar el programa 

        /**
         * Inicializa el metodo scanner para utilizarlo a lo largo del programa
         */
        Scanner scan = new Scanner(System.in);
        int opcion;
        do { //Ciclo do que inicia el menu principal y seguira corriendo mientras el usuario no exprese la instruccion de salir
            try{ //Bloque try-catch para atrapar excepciones sobre entradas de datos erroneas
        System.out.println("1. Gestionar libros");                      //menu principal
        System.out.println("2. Gestionar discos");
        System.out.println("3. Gestionar peliculas.");
        System.out.println("0. Salir");
        opcion = scan.nextInt();                            //variable para escoger la opcion deseada
        scan.nextLine();     


        
        
        if (opcion > 3 || opcion < 0) {
            System.out.println("Ingresa una opcion valida");
        } //condicional que permite enviar un mensaje si el usuario introduce un dato no contemplado pero del tipo correcto
            switch (opcion) { //ciclo switch que despliega los casos del menu pirncipal
                case 1:

                String archivoLibros = "libros.csv";   //Nombre del archivo donde se almacena la coleccion de libros
                int opcionCaso1;
                do {
                    try{
                System.out.println("1. Consulta por autor.");                   //menu que muestra las opciones disponibles para los libros
                System.out.println("2. Consulta por tema.");
                System.out.println("3. Consulta por titulo.");
                System.out.println("4. Consulta completa.");
                System.out.println("5. Añadir libro.");
                System.out.println("0. Regresar al menu anterior.");
                opcionCaso1 = scan.nextInt(); 
                scan.nextLine();
                
                if (opcionCaso1 > 5 || opcionCaso1 < 0) { 
                System.out.println("Ingresa una opcion valida");
                    } //condicional que permite enviar un mensaje si el usuario introduce un dato no contemplado pero del tipo correcto

                switch (opcionCaso1) {          //ciclo switch que despliega un submenu para el caso 1 del menu principal
                    /**
                     * Este ciclo requiere un int para escoger la opcion deseada, al igual que el resto de ciclos switch
                     */
                    case 1:                                                                                                 //Permite hacer una busqueda de un libro basado en su autor
                    
                    System.out.println("Dame el autor a consultar:");
                    String autorConsulta = scan.nextLine();
                    
                    Busqueda busquedaAutor = new Busqueda();
                    busquedaAutor.busquedaDato1(archivoLibros, "titulo", "genero", "autor", "tema", autorConsulta);         //se llama al metodo busquedaDato1 y se le dan los parametros para obtener al autor del libro
                    
                        break;
                    case 2:
                    System.out.println("Dame el tema a consultar:");                                                        //Permite hacer una busqueda de un libro basado en su tema
                    String temaConsulta = scan.nextLine();
                    
                    Busqueda busquedaTema = new Busqueda();
                    busquedaTema.busquedaDato3(archivoLibros, "titulo", "genero", "autor", "tema", temaConsulta);           //se llama al metodo busquedaDato3 y se le dan los parametros para obtener al autor del libro
                        break;
                    case 3:
                    System.out.println("Dame el titulo a consultar:");                                                              //Permite hacer una busqueda de un libro basado en su titulo
                    String tituloConsulta = scan.nextLine();
                    Busqueda busquedaTitulo = new Busqueda();
                    busquedaTitulo.busquedaDato2(archivoLibros, "titulo", "genero", "autor", "tema", tituloConsulta);   //se llama al metodo busquedaDato2 y se le dan los parametros para obtener al autor del libro
                        break;
                    case 4:
                    System.out.println("Esta es tu coleccion de libros:");                                  //Permite mostrar toda la coleccion de libros guarada en el archivo csv correspondiente
                    System.out.println();

                    Busqueda consultaCompleta = new Busqueda();                                              

                    consultaCompleta.coleccionCompleta(archivoLibros, "titulo", "genero", "autor", "tema"); //lama al metodo coleccionCompleta, le da los parametros necesarios y se despliega la coleccion de libros
                    
                    
                        break;
                    case 5:                                                                     //Caso que permite registrar un nuevo libro



                    boolean tituloRepetido = false;
                    Libro libro = new Libro();                                                  //se genera el nuevo objeto

                     if (libro.coleccionLlena(archivoLibros,"libros") == true) {            //Metodo que permite que el libro se registre solo si la coleccion tiene menos de 32 elementos

                    
                    System.out.println("Dame el título del libro");                                                            //Se registra el titulo del libro
                    String titulo = scan.nextLine();
                    String[] lines = ReaderWriter.read("libros.csv");
                    tituloRepetido = false;

                    
                    for (String line : lines) {                                                                                     //Realiza una comparacione entre los titulos registrados y el introducido por el usuario para verificar si hay un objeto con ese titulo
                        StringTokenizer tokenizer = new StringTokenizer(line, ",");
                            String tituloNuevo = tokenizer.nextToken();
                            if (tituloNuevo.equals(titulo)) {
                                tituloRepetido = true;
                            }
                        }
                            if (tituloRepetido) {                                                                                     //Si existe una repeticion se notifica el usuario y se finaliza el caso, si no existe se registra el titulo del libro
                                System.out.println("Ya existe un elemento en la coleccion con ese titulo");
                                tituloRepetido = false;
                                break;
                            } else {
                                libro.setTitulo(titulo);
                            }
                        
                    
                } else {
                     break;
                    }
                        
                    
                    /**
                     * El resto de meotodos reciben strings y registran el dato correspondiente a cada campo
                     */

                    
                    
                    System.out.println("Dame el genero del libro");
                    String genero = scan.nextLine();
                    libro.setGenero(genero);
                    
                    System.out.println("Dame el autor del libro");
                    String autor = scan.nextLine();
                    libro.setAutor(autor);
                    
                    System.out.println("Dame el tema del libro");
                    String tema = scan.nextLine();
                    libro.setTema(tema);
                    ReaderWriter.write(libro.newLibro(), "libros.csv"); //Al finalizar se da formato a los datos introducidos con el metodo newLibro() y ese formato se registra en el archivo correspondiente

                        break;
                }


                    } catch (InputMismatchException c1) {                               //Bloque catch para determinar que sucede en caso de que el usuario introduzca algo que no sea un entero
                    System.out.println("Por favor, ingresa una entrada valida");
                    scan.nextLine();
                    opcionCaso1 = 9;
                }
                } while (opcionCaso1 != 0);
                    break;



                case 2:

                /**
                 * Caso del submenu que permite registrar nuevos discos
                 */
                    String archivoDiscos = "discos.csv";                    //se declara el nombre del archivo en el que se guardaran los discos
                    int opcionCaso2;
                do {                                                        //ciclo do while que permite ejecutar el menu hasta que el usuario exprese que desea regresar al menu anterior
                    try {
                System.out.println("1. Consulta por interprete.");          //Menu de opciones para la coleccion de discos
                System.out.println("2. Consulta por genero.");
                System.out.println("3. Consulta por mas de 10 pistas.");
                System.out.println("4. Consulta completa.");
                System.out.println("5. Añadir disco");
                System.out.println("0. Regresar al menu anterior.");
                opcionCaso2 = scan.nextInt(); 
                scan.nextLine();
                if (opcionCaso2 > 5 || opcionCaso2 < 0) {
                System.out.println("Ingresa una opcion valida");
                    }                                                       //condicional que permite enviar un mensaje si el usuario introduce un dato no contemplado pero del tipo correcto

                switch (opcionCaso2) {                                         //Estructura switch que permite realizar las acciones dadas por el menu
                    case 1:
                    System.out.println("Dame el interprete a consultar:");                                                          //Recibe un string del usuario para buscar los discos de cierto interprete
                    String interpreteConsulta = scan.nextLine();

                    Busqueda busquedaInterprete = new Busqueda();
                    busquedaInterprete.busquedaDato1(archivoDiscos, "Titulo", "Genero", "Interprete", "Numero de Pistas", interpreteConsulta);      //Llama al metodo busquedaDato1 para ver si existe algun elemento que coincida y desplegar su informacion
                        break;
                    case 2:
                    System.out.println("Dame el genero a consultar:");                                                          //Recibe una cadena del usuario para saber que interprete buscar
                    String generoConsulta = scan.nextLine();

                    Busqueda busquedaGenero = new Busqueda();                                                   
                    busquedaGenero.busquedaDato4(archivoDiscos, "Titulo", "Genero", "Interprete", "Numero de Pistas", generoConsulta); //Llama al metodo busquedaDato4 para ver si existe algun elemento que coincida y desplegar su informacion
                    System.out.println(generoConsulta);
                        break;
                    case 3:
                    System.out.println("Estos son los discos con más de 10 pistas:");               //caso que permite desplegar la informacion de los discos con mas de 10 pistas
                    
                    String[] lineas = ReaderWriter.read(archivoDiscos);                                 //Genera un arreglo de cadenas con los datos del archivo, luego separa cada linea en elementos divididos por comas, los almacena, hace el conteo de pistas y despliega la informacion de aquellos que tienen  mas de 10
                    for (String linea : lineas) {

                        StringTokenizer tokenizer = new StringTokenizer(linea, ",");
                        if (tokenizer.countTokens() == 4) {
                            String titulo = tokenizer.nextToken();
                            String genero = tokenizer.nextToken();
                            String autor = tokenizer.nextToken();
                            String tema = tokenizer.nextToken();

                            int conteoPistas = Integer.parseInt(tema);  //Como el dato esta almacenado en cadena se convierte de entero a str para poder cumplir la condicion

                            if (conteoPistas > 10) {                                                            //condicional que permite imprimir la informacion del disco si cumple la condicion
                            System.out.println("Titulo " + ": " + titulo);
                            System.out.println("Genero " + ": " + genero);
                            System.out.println("Interprete " + ": " + autor);
                            System.out.println("Numero de pistas " + ": " + tema);
                            System.out.println();
                            }

                        }
                        
                        
                    }



                        break;
                    case 4:
                    System.out.println("Esta es tu coleccion de discos:");                                      //Casi que despliega la coleccion completa
                    System.out.println();

                    Busqueda coleccionDiscos = new Busqueda();
                    coleccionDiscos.coleccionCompleta(archivoDiscos, "Titulo", "Genero", "Interprete", "Numero de Pistas");     //Se llama al metodo coleccion completa, se le dan los parametros requeridos y despliega todos los discos almacenados
                        break;





                    case 5:

                    /**
                     * Caso que permite generar un Disco nuevo solo bajo ciertas condiciones
                     */





                    Disco disco = new Disco();                                                                          //se genera el nuevo objeto 
                    if (disco.coleccionLlena(archivoDiscos, "discos") == true) {                        //condicional que permite generar un nuevo disco solos i el metodo coleccionLlena determina que hay espacio para ello
                    boolean tituloRepetido = false;

                    

                    System.out.println("Dame el título del disco");                                                     //se solicita el titulo del disco
                    String titulo = scan.nextLine();


                    String[] lines = ReaderWriter.read("discos.csv");                                               //Se almacena la informacion del archivo correspondiente
                    for (String line : lines) {                                                                               //Ciclo que permite analizar la infromacion de los discos para verificar si existe un titulo repetido
                        StringTokenizer tokenizer = new StringTokenizer(line, ",");
                            String tituloNuevo = tokenizer.nextToken();
                            if (tituloNuevo.equals(titulo)) {
                                tituloRepetido = true;
                            } 
                        }
                        if (tituloRepetido) {
                        System.out.println("Ya existe un elemento en la coleccion con ese titulo");                                            //se informa al usuario si hay repeticion y se cierra el caso
                        tituloRepetido = false;
                        break;
                        } else {
                            disco.setTitulo(titulo);                                                                                            //si no hay repeticion se guarda la informacion del disco
                        }


                        


                } else {
                    break;
                }

                /**
                 * El resto de metodos obtienen la informacion de manera simple
                 */
                    

                    System.out.println("Dame el genero del disco");
                    String genero = scan.nextLine();
                    disco.setGenero(genero);

                    System.out.println("Dame el interprete del disco");
                    String interprete = scan.nextLine();
                    disco.setInterprete(interprete);


                    /**
                     * El metodo para obtener el numero de pistas requiere de un bloque try-catch en caso de que el usuario ingrese algo que no es un int
                     */
                    int numeroPistas;
                    try {
                    System.out.println("Dame el numero de pistas del disco");
                    numeroPistas = scan.nextInt();
                    scan.nextLine();
                    } catch (InputMismatchException pd) {                                           //mensaje que se imprime si la entrada no es valida
                        System.out.println("Ese no es un numero de pistas valido");
                        break;
                    }
                    while (numeroPistas < 1) {
                        System.out.println("Ingresa un numero de pistas valido");                   //mensaje que se imprime si se da un numero de pistas negativo
                        numeroPistas = scan.nextInt();
                    }
                    disco.setNumeroPistas(numeroPistas);
                






                    
                    ReaderWriter.write(disco.newDisco(), archivoDiscos);                                        //se escribe sobre el archivo el nuevo disco con el formato adecuado
                        break;
                }

                } catch (InputMismatchException c2) {                                                               //bloque catch que determina que hacer en caso de que la opcion sea equivoca
                System.out.println("Por favor, ingresa una entrada valida");
                scan.nextLine();
                opcionCaso2 = 9;
                }
                } while (opcionCaso2 != 0);
                    break;



                case 3:                         

                /**
                 * caso que permite gestionar la coleccion de peliculas
                 */

                String archivoPeliculas = "peliculas.csv";                          //archivo de peliculas
                int opcionCaso3;
                do {                                                                                            //ciclo do que permite ejecutar el menu hasta que el usuario exprese que desea salir al anterior
                    try {                                                                                                   // bloque try que permite gestionar las excepciones si se introduce un valor que no es del tipo correcto
                System.out.println("1. Consulta por año.");                                                                 //opciones disponibles para el caso 3
                System.out.println("2. Consulta por actores o actrices que aparezcan en mas de una pelicula.");
                System.out.println("3. Consulta por genero.");
                System.out.println("4. Consulta completa.");
                System.out.println("5. Añadir pelicula");
                System.out.println("0. Regresar al menu anterior.");
                opcionCaso3 = scan.nextInt(); 
                scan.nextLine();

                if (opcionCaso3 > 5 || opcionCaso3 < 0) {
                System.out.println("Ingresa una opcion valida");
                    }                                                                                           //condicional que envia un mensaje en caso de que el usuario ingrese un int no contemplado

                switch (opcionCaso3) {
                    case 1:                                                                                      //metodo que permite consultar una pelicula por cuandon se filmo
                    System.out.println("Dame el año a consultar:");

                    try {                                                                                          //bloque try que permite manejar una situacion en la que el usuario ingrese un dato que no es int

                    int añoConsulta = scan.nextInt();
                    scan.nextLine();
                    String filmacionConsulta = Integer.toString(añoConsulta);                                                           //metodo que convierte el int almacenado de cuando se filmo a string
                    Busqueda busquedaFilmacion = new Busqueda();
                    busquedaFilmacion.busquedaDato3(archivoPeliculas, "Titulo", "Genero", "Actor o actriz principal", "Año de filmacion", filmacionConsulta);   //metodo que busca la informacion en base a los parametros dados por el usuario

                    } catch (InputMismatchException ba) {
                        System.out.println("El formato no es correcto");
                        break;                                                                              //bloque catch en caso de que el usuario no introduzca un int
                    }
                    
                        break;






                        /**
                         * El resto de casos funcionan de manera sencilla con los metodos busquedaDato
                         */
                    case 2:
                    System.out.println("Dame el nombre del actor o actriz a consultar:");
                    String actoresConsulta = scan.nextLine();
                    
                    Busqueda busquedaActorActriz = new Busqueda();
                    busquedaActorActriz.busquedaDato1(archivoPeliculas, "Titulo", "Genero", "Actor o actriz principal", "Año de filmacion", actoresConsulta);
                        break;
                    case 3:
                    System.out.println("Dame el genero a consultar:");
                    String generoConsulta = scan.nextLine();
                    
                    Busqueda generoBusqueda = new Busqueda();
                    generoBusqueda.busquedaDato4(archivoPeliculas, "Titulo", "Genero", "Actor o actriz principal", "Año de filmacion", generoConsulta);

                        break;
                    case 4:
                    System.out.println("Esta es tu coleccion de peliculas:");
                    Busqueda coleccionPeliculos = new Busqueda();
                    coleccionPeliculos.coleccionCompleta(archivoPeliculas, "Titulo", "Genero", "Actor o actriz principal", "Año de filmacion");
                        break;




                    case 5:

                    /**
                     * este caso permite generar una nueva pelicula, el funcionamiento es identico al de la generacion de discos, solo que en lugar de manejar el error de int para las pistas, se hace para cuando se filmo la pelicula
                     */

                    Pelicula pelicula = new Pelicula();

                    if (pelicula.coleccionLlena(archivoPeliculas, "peliculas") == true) {   //metodo que verifica si existe espacio para registrar una nueva pelicula





                    

                    
                    
                    
                    System.out.println("Dame el título de la pelicula");
                    String titulo = scan.nextLine();


                    String[] lines = ReaderWriter.read("peliculas.csv");
                    boolean tituloRepetido = false;


                    for (String line : lines) {                                                                                     //ciclo que verifica si el titulo esta repetido y termina el caso si es que ya hay un titulo igual
                        StringTokenizer tokenizer = new StringTokenizer(line, ",");
                            String tituloNuevo = tokenizer.nextToken();
                            if (tituloNuevo.equals(titulo)) {
                            tituloRepetido = true;
                            }
                    }
                    
                    if (tituloRepetido) {
                        System.out.println("Ya existe un elemento en la coleccion con ese titulo");
                        tituloRepetido = false;
                        break;
                    } else {
                                pelicula.setTitulo(titulo);
                    }
                        
                        

                } else {
                    break;
                }
                    
                    System.out.println("Dame el genero de la pelicula");
                    String genero = scan.nextLine();
                    pelicula.setGenero(genero);

                    System.out.println("Dame el actor o actriz principal de la pelicula");
                    String actorActriz = scan.nextLine();
                    pelicula.setActorActrizPrincipal(actorActriz);

                try {                                                                                       //bloque try que maneja la excepcion en caso de no se introduzca un int
                    System.out.println("Dame el año de filmacion de la pelicula:");
                    int filmacion = scan.nextInt();
                    scan.nextLine();
                    pelicula.setFilmacion(filmacion);
                    } catch (InputMismatchException np) {
                    System.out.println("Fromato invalido");
                    break;
                }

                    ReaderWriter.write(pelicula.newPelicula(), archivoPeliculas);
                    


                        break;
                    
                    
                }

                } catch (InputMismatchException c3) {
            System.out.println("Por favor, ingresa una entrada valida");
            scan.nextLine();
            opcionCaso3 = 9;
        }
                } while (opcionCaso3 != 0);

                    break;


                case 0:                                                                                     //mensaje de salida del menu principal 
                    System.out.println("Vuelve pronto!");
                    break;
            }

        } catch (InputMismatchException a) {                                            //bloque catch que maneja la excepcion en caso de que no se ingrese un int
            System.out.println("Por favor, ingresa una entrada valida");
            scan.nextLine();
            opcion = 9;
        }
            
        } while (opcion != 0);
        
        
        
    }
    

}
    
    

