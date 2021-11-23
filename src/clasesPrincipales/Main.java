package clasesPrincipales;

import afundidos.*;
import mundoMarino.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mundoMarino.Empleado;
import mundoMarino.Tienda;
import mundoMarino.Producto;
import mundoMarino.productos.Comida;
import mundoMarino.productos.Peluche;
import ventaEntradas.Taquilla;

public class Main {

    //Rutas de acceso a los ficheros
    static final String rutaCliente ="data\\clientes.dat";
    static final String rutaEmpleados = "data\\Empleados.dat";

    public static void main(String[]args) throws IOException{
        Teclado t = new Teclado();
        int opcionMenuPrincipal;
        boolean fin=false;

        do{
            opcionMenuPrincipal = menuPrincipal();
            switch (opcionMenuPrincipal){
                case 1 :
                    menuClientes(t);
                    break;
                case 2:
                    ventaDeEntradas();
                    break;
                case 3:
                    eventos();
                    break;
                case 4:
                    tienda();
                    break;
                case 5:
                    peceras();
                    break;
                case 6:
                    peces();
                    break;
                case 7:
                    menuPrincipalEmpleados();
                    break;
                case 8:
                    fin = true;
                    break;
            }
        }while(!fin);

    }

    static int menuPrincipal() throws IOException{
        Teclado t = new Teclado();
        int opcion;
        System.out.println();
        System.out.println("Seleccione una opcion :");
        System.out.println();
        System.out.println("1 - Clientes");
        System.out.println("2 - Venta de entradas");
        System.out.println("3 - Eventos");
        System.out.println("4 - Tienda");
        System.out.println("5 - Peceras");
        System.out.println("6 - Peces");
        System.out.println("7 - Empleados");
        System.out.println("8 - Fin");
        System.out.println();
        do{
            System.out.println("Seleccione una opcion (1-8) : ");
            opcion = t.leerInt();
        }while(opcion<1 || opcion>8);

        return opcion;
    }

    
   /* INICIO CLIENTES */

   static void menuClientes(Teclado t)throws IOException {

    int opcion;
    do{
        do{
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("MENU CLIENTES");
            System.out.println();
            System.out.println("1: Consultar datos entrada cliente");
            System.out.println("2: Consultar datos salida cliente");
            System.out.println("3: Consultar la valoracion de un cliente");
            System.out.println("4: Consultar la informacion personal de un cliente");
            System.out.println("5: Salir");
            System.out.println();

            System.out.println("Seleccione una opcion (5 para terminar) : ");
            opcion=t.leerInt();
        }while(opcion<1 || opcion>8);
        switch(opcion) {

            case 1:
                entradaCliente();
                break;
            case 2:
                salidaCliente();
                break;
            case 3:
                valoracionCliente();
                break;
            case 4:
                mostrarCliente();
                break;
            case 5:
                System.out.print("Has elegido la opcion salir");
                break;
        }
    }while(opcion!=5);
}

    static void entradaCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c= new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        try {
            fich.seek(numVisitante * c.tamano());
        }catch (IOException ioe){
            fich.seek(Integer.MAX_VALUE);
        }
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatosEntrada();
        else
            System.out.println("El registro buscado no existe.");
        fich.close();
    }

    static void salidaCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c = new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        try {
            fich.seek(numVisitante * c.tamano());
        }catch (IOException ioe){
            fich.seek(Integer.MAX_VALUE);
        }
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatosSalida();
        else
            System.out.println("El registro buscado no existe.");
        fich.close();
    }

    static void mostrarCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c= new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        try {
            fich.seek(numVisitante * c.tamano());
        }catch (IOException ioe){
            fich.seek(Integer.MAX_VALUE);
        }
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatos();
        else
            System.out.println("El registro buscado no existe.");
        fich.close();
    }

    static void valoracionCliente()throws IOException{
        Teclado t= new Teclado();
        int opcion;

        do{
            do{
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("  Elige una opcion");
                System.out.println();
                System.out.println("1: Valoracion de un cliente determinado");
                System.out.println("2: Media de las valoraciones(de todos los clientes)");
                System.out.println("3: Salir");
                System.out.println();

                System.out.println("Seleccione una opcion (3 para terminar) : ");
                opcion=t.leerInt();
            }while(opcion<1 || opcion>3);
            switch(opcion) {

                case 1:
                    valoracionIndividual();
                    break;
                case 2:
                    valoracionTotal();
                    break;
                case 3:
                    System.out.print("Has elegido la opcion salir");
                    break;
            }
        }while(opcion!=3);
    }
    
    static void valoracionIndividual()throws IOException{
        Teclado t= new Teclado();
        Cliente c= new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        try {
            fich.seek(numVisitante * c.tamano());
        }catch (IOException ioe){
            fich.seek(Integer.MAX_VALUE);
        }
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatosValoracion();
        else
            System.out.println("El registro buscado no existe.");
        fich.close();
    }

    static void valoracionTotal() throws IOException {
        int i=0, totalValoracion=0;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"r");
        do {
            i++;
            Cliente c = new Cliente (0,"", "", "", "","", 0, "", "",0);
            try {
                fich.seek(i * c.tamano());
            }catch (IOException ioe){
                fich.seek(Integer.MAX_VALUE);
            }
            if(c.leerDeArchivo(fich)) {
                break;
            }
            totalValoracion += c.getvaloracion();
        } while(true);
        System.out.println("Media de valoraciones: "+(totalValoracion/i));
    }

    /* FINAL CLIENTES */

    static void ventaDeEntradas() throws IOException {
        Taquilla taquilla = new Taquilla();
        taquilla.Menu();
    }

    static void eventos() throws IOException{
        System.out.println("Creando un nuevo evento");
        Teclado t = new Teclado();

        System.out.print(" - Introduce el nombre: ");
        String nombre = t.leerString();

        System.out.print(" - Introduce el precio de la entrada: ");
        float precio = t.leerFloat();

        System.out.print(" - Introduce la duración del evento: ");
        float duracion = t.leerFloat();

        System.out.print(" - Introduce el requisito de edad: ");
        int requisitoEdad = t.leerInt();

        System.out.print(" - Introduce el número de entradas disponibles: ");
        int contadorEntradas = t.leerInt();

        System.out.print(" - Introduce el aforo máximo: ");
        int aforo = t.leerInt();

        int dia = -1;
        while (dia<1 || dia > 31) {
            System.out.print(" - Introduce el día: ");
            dia = t.leerInt();
        }

        int mes = -1;
        while (mes<1 || mes > 12) {
            System.out.print(" - Introduce el mes: ");
            mes = t.leerInt();
        }

        int anho = -1;
        while (anho<2000 || anho > 9999) {
            System.out.print(" - Introduce el año: ");
            anho = t.leerInt();
        }

        Evento evento = new Evento(nombre, new Date(anho, mes, dia), precio, duracion, requisitoEdad, contadorEntradas, aforo);

        evento.mostrarDatos();
    }

    static void tienda() throws IOException {
        Teclado t = new Teclado();

        System.out.println("Bienvenido a la tienda del acuario:\n"+
                "El programa simula la gestión de la tienda del acuario.\n"+
                "Los artículos sólo se pueden vender si están disponibles en la tienda\n"+
                "El usuario puede:\n"+
                "\t Comprar productos de los existentes.\n"+
                "\t Añadir nuevos productos a la cesta.\n"+
                "\t Consultar el importe de la cuenta.");

        boolean continuar=true;
        int lecturaProducto, lecturaCantidad; //Variables para seleccionar el producto y la cantidad que se quiere comprar

        //Se instancian y cargan los productos
        Producto peluche1 = new Peluche("Pez Globo", 16.43, 10, true, "relleno");
        Producto peluche2 = new Peluche("Tiburón", 9.99, 12, true, "rígido");
        Producto chocolateBlanco = new Comida("Chocolate Edición Acuario", 4.55, 4, true, true);
        Producto golosinaMedusa = new Comida("Medusa Golosa", 0.45, 200, true, true);

        //Creamos el array "catálogo" para contener los productos. Su dimensión viene del número de veces que se instancia el constructor Producto.
        Producto[] catalogo = new Producto[Producto.dimensionArray];
        //Se crea el objeto gestión para trabajar (mostrar, vender productos, y mostrar caja)
        Tienda gestion = new Tienda();

        catalogo[0] = peluche1;
        catalogo[1] = peluche2;
        catalogo[2] = chocolateBlanco;
        catalogo[3] = golosinaMedusa;

        do {
            System.out.println("\n\nIntroduzca la opción que desea realizar:\n"
                    +"1. Mostrar productos\n"
                    +"2. Vender productos\n"
                    +"3. Mostrar caja\n"
                    +"SALIR --> Pulse cualquier otro número\n"
            );
            switch (t.leerInt()) {
                case 1 -> gestion.mostrarProductos(catalogo);
                case 2 -> {
                    System.out.println("¿Que producto desea comprar?");
                    gestion.mostrarNombreProductos(catalogo);
                    lecturaProducto = t.leerInt();
                    System.out.println("¿Cuánta cantidad desea vender?");
                    lecturaCantidad = t.leerInt();
                    //Se carga el producto y la cantidad solicitada por el usuario
                    gestion.venderProducto(catalogo, lecturaProducto, lecturaCantidad);
                }
                case 3 -> System.out.println(gestion.mostrarCaja() + " €");
                default -> continuar = false;
            }

        } while(continuar);
    }

    static void peceras() throws IOException{
        System.out.println(" # Iniciando el registro de pecera");
        Teclado t = new Teclado();

        System.out.print(" - Introduce el ID: ");
        int id = t.leerInt();

        String tipoDeAgua = "none";

        while(!tipoDeAgua.equals("dulce") && !tipoDeAgua.equals("salada")) {
            System.out.print(" - Introduce el tipo de agua que tiene (Dulce/Salada): ");
            tipoDeAgua = t.leerString().toLowerCase();
        }

        boolean tipoDeAguaBool = (tipoDeAgua.equals("dulce"));

        System.out.print(" - Introduce la descripción de la pecera: ");
        String descripcion = t.leerString();

        System.out.print(" - Introduce la temperatura de la pecera: ");
        float temperatura = t.leerFloat();

        System.out.print(" - Introduce el tamaño de la pecera: ");
        float tamano = t.leerFloat();

        System.out.println(" -- Se inicializa el registro de peces para la pecera");

        Pez[] finalarrayPeces = peces();

        Pecera pecera = new Pecera(id, tipoDeAguaBool, descripcion, temperatura, tamano, finalarrayPeces);

        pecera.mostrarCaracteristicas();
        pecera.listarPeces();
    }

    static Pez[] peces() throws IOException{ // Se inicia el registro de peces y devuelve una lista con todos.
        System.out.println("# Inicia el registro de peces: ");
        List<Pez> arrayPeces = new ArrayList<Pez>();
        boolean fin = false;
        while(!fin) {
            System.out.println("Creando un nuevo pez");
            Teclado t = new Teclado();

            System.out.print(" - Introduce el ID: ");
            int id = t.leerInt();

            System.out.print(" - Introduce el nombre de la especie: ");
            String especie = t.leerString();

            String tipoDeAgua = "none";

            while(!tipoDeAgua.equals("dulce") && !tipoDeAgua.equals("salada")) {
                System.out.print(" - Introduce el tipo de agua que necesita (Dulce/Salada): ");
                tipoDeAgua = t.leerString().toLowerCase();
            }

            boolean tipoDeAguaBool = (tipoDeAgua.equals("dulce"));

            System.out.print(" - Introduce el ID de la piscina contenedora: ");
            int piscinaContenedora = t.leerInt();

            Pez pez = new Pez(id, especie, tipoDeAguaBool, piscinaContenedora);

            arrayPeces.add(pez);
            String opcion = "null";
            while (!opcion.equals("s") && !opcion.equals("n")) {
                System.out.print(" -- Desea añadir otro pez? (S/N): ");
                opcion = t.leerString().toLowerCase();
            }
            fin = opcion.equals("n");
        }

        Pez[] finalArrayPeces = new Pez[ arrayPeces.size() ];
        arrayPeces.toArray( finalArrayPeces );

        for (Pez pez : finalArrayPeces) // Muestra los datos de todos los peces
            pez.mostrarDatos();

        return finalArrayPeces;
    }

    static void menuPrincipalEmpleados() throws IOException{
        Teclado entrada=new Teclado();
        boolean fin=false;
        int opcionMenuEmpleados;
        do{
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("MENU EMPLEADOS");
            System.out.println();
            System.out.println("1- Listar empleados");
            System.out.println("2- Añadir un empleado");
            System.out.println("3- Cambiar un empleado");
            System.out.println();
            do{
                System.out.println("Seleccione una opcion (0 para terminar) : ");
                opcionMenuEmpleados=entrada.leerInt();
            }while(opcionMenuEmpleados<0 || opcionMenuEmpleados>3);

            switch (opcionMenuEmpleados){
                case 0 :
                    fin=true;
                    break;
                case 1 :
                    listaEmpledos();
                    break;
                case 2 :
                    anadirEmpleado();
                    break;
                case 3 :
                    cambiarDatosEmpleado();
                    break;
            }
        }while(!fin);
    }

    static void listaEmpledos() throws IOException{
        RandomAccessFile ficheroRandom = new RandomAccessFile(rutaEmpleados, "r");
        FileReader lector = new FileReader (rutaEmpleados);
        BufferedReader br = new BufferedReader(lector);
        int i;
        String linea;
        // Este for recorre el fichero 'empleados' y en caso de que no sean nulos los imprime
        // Cuando se encuentra una linea null se termina el for
        for(i=1;i<ficheroRandom.length();i++){
            ficheroRandom.seek(i);
            linea=br.readLine();

            if(linea!=null){
                System.out.println();
                System.out.println("Empleado "+i+" : "+linea);
                System.out.println();
            }
        }
        ficheroRandom.close();
    }

    static void anadirEmpleado() throws IOException {
        Teclado t = new Teclado();
        int otro, confirmacion;
        String datosEmpleado;
        boolean fin = false;

        // Le pedimos los datos del empleado al usuario, que son los siguientes:
        // id - nombreApellidos - dni - tipoTrabajo - horasTrabajo - sueldo - vacaciones - valoracion

        String nombreApellidos, dni, tipoTrabajo;
        int id, horasTrabajo, sueldo, vacaciones, valoracion;

        // A continuacion se nos presenta un bucle do-while para introducir empleados
        do {
            // Instanciamos el fichero random, el buffered reader, y el buffered writer
            RandomAccessFile ficheroRandom = new RandomAccessFile(rutaEmpleados, "rw");
            FileReader lector = new FileReader (rutaEmpleados);
            FileWriter escritor = new FileWriter(rutaEmpleados, true);
            BufferedReader br = new BufferedReader(lector);
            BufferedWriter bw = new BufferedWriter(escritor);

            // Introducimos el id, en caso de que el usuario no introduza el numero 0
            // el programa regresa al menu empleados
            do {
                System.out.println("Introduza el ID del empleado (4 numeros)");
                System.out.println("Si no desea introducir ningun empleado teclee 0");
                id = t.leerInt();
            } while ((id < 1000 || id > 9999) && id != 0);

            if (id == 0) {
                fin = true;
            } else {

                do {
                    System.out.println("Introduza el nombre y los apellidos del empleado :");
                    nombreApellidos = t.leerString();
                } while (nombreApellidos.length() > 40);

                do {
                    System.out.println("Introduza el DNI del empleado :");
                    dni = t.leerString();
                } while (dni.length() != 9);

                do {
                    System.out.println("Introduza el tipo de trabajo desempeñado por el empleado :");
                    tipoTrabajo = t.leerString();
                } while (tipoTrabajo.length() > 40);

                do {
                    System.out.println("Introduza las horas de trabajo del empleado :");
                    horasTrabajo = t.leerInt();
                } while (horasTrabajo > 8);

                do {
                    System.out.println("Introduza el numero de dias de vacaciones del empleado :");
                    vacaciones = t.leerInt();
                } while (vacaciones < 35);

                do {
                    System.out.println("Introduza el sueldo del empleado :");
                    sueldo = t.leerInt();
                } while (sueldo < 900);

                do {
                    System.out.println("Introduza la valoracion del empleado :");
                    valoracion = t.leerInt();
                } while (valoracion > 10 || valoracion < 0);


                datosEmpleado = id + "   " + nombreApellidos + "   " + dni + "   " + tipoTrabajo + "   " + horasTrabajo + "   " + sueldo + "   " + vacaciones + "   " + valoracion;
                // Mostramos al usuario los valores introducidos y le preguntamos si desearia cancelar la introduccion de los mismos
                do {
                    System.out.println(datosEmpleado);
                    System.out.println("¿Desea introducir los siguientes datos?  (1=si 0=no) : ");
                    confirmacion = t.leerInt();
                } while (confirmacion > 1 || confirmacion < 0);

                if (confirmacion == 0) {
                    System.out.println("La introduccion del empleado fue cancelada");
                } else {
                    // Creamos un empleado
                    Empleado empleado = new Empleado(id, nombreApellidos, dni, tipoTrabajo, horasTrabajo, sueldo, vacaciones, valoracion);
                    // Este do-while recorre el fichero 'empleados' y en caso de que encuentre una linea nula (vacia)
                    // termina el bucle y el escritor se posiciona en la linea determinada
                    String linea;
                    do{
                        linea = br.readLine();
                    }while(linea != null);


                    // Escribimos los datos del empleado en una linea nueva del archivo gracias a '\n'
                    bw.write("\n"+datosEmpleado);
                    // Guardamos los cambios
                    bw.flush();
                }

                // Damos la opcion al usuario de introducir otro empleado
                do {
                    System.out.println("¿Desea introducir otro empleado?  (1=si 0=no) : ");
                    otro = t.leerInt();
                } while (otro > 1 || otro < 0);
                if (otro == 0) {
                    fin = true;
                }
            }
            ficheroRandom.close();
        } while (!fin);
    }

    static void cambiarDatosEmpleado(){
        System.out.println();
        System.out.println("Si desea eliminar o cambiar los datos de un empleado puede hacerlo en el siguiente directorio: "+rutaEmpleados);
        System.out.println();
    }
}
