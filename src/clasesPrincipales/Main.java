package clasesPrincipales;

import mundoMarino.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.RandomAccess;

import afundidos.Evento;
import afundidos.Pecera;
import afundidos.Pez;
import mundoMarino.GestionTienda;
import mundoMarino.Producto;
import mundoMarino.productos.Comida;
import mundoMarino.productos.Peluche;
import ventaEntradas.Menu;

public class Main {

    //Rutas de acceso a los ficheros
    static final String rutaCliente ="acuario_definitivo\\data\\clientes.dat";
    static final String rutaEmpleados = "data\\Empleados.dat";

    public static void main(String[]args) throws IOException{
        Teclado t = new Teclado();
        int opcionMenuPrincipal;
        boolean fin=false;

        do{
            opcionMenuPrincipal = menuPrincipal();
            switch (opcionMenuPrincipal){
                case 1 :
                    clientes();
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
                    empleados();
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

    static void clientes(){
            
    }

    static void ventaDeEntradas(){
        Menu.Venta();
    }

    static void eventos() throws IOException{
        System.out.println("Creando un nuevo evento");
        Teclado t = new Teclado();

        System.out.println("Introduce el nombre");
        String nombre = t.leerString();

        System.out.println("Introduce el precio de la entrada");
        float precio = t.leerFloat();

        System.out.println("Introduce la duración del evento");
        float duracion = t.leerFloat();

        System.out.println("Introduce el requisito de edad");
        int requisitoEdad = t.leerInt();

        System.out.println("Introduce el número de entradas disponibles");
        int contadorEntradas = t.leerInt();

        System.out.println("Introduce el aforo máximo");
        int aforo = t.leerInt();

        System.out.println("Introduce el día");
        int dia = t.leerInt();

        System.out.println("Introduce el mes");
        int mes = t.leerInt();

        System.out.println("Introduce el año");
        int anho = t.leerInt();

        Evento evento = new Evento(nombre, new Date(anho, mes, dia), precio, duracion, requisitoEdad, contadorEntradas, aforo);

        evento.mostrarDatos();
    }

    static void tienda() throws IOException{
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
        GestionTienda gestion = new GestionTienda();

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
                case 1 : 
                    gestion.mostrarProductos(catalogo);
                case 2 : {
                    System.out.println("¿Que producto desea comprar?");
                    gestion.mostrarNombreProductos(catalogo);
                    lecturaProducto = t.leerInt();
                    System.out.println("¿Cuánta cantidad desea vender?");
                    lecturaCantidad = t.leerInt();
                    //Se carga el producto y la cantidad solicitada por el usuario
                    gestion.venderProducto(catalogo, lecturaProducto, lecturaCantidad);
                }
                case 3 : System.out.println(gestion.mostrarCaja() + " €");
                default : continuar = false;
            }

        } while(continuar);
    }

    static void peceras() throws IOException{
        System.out.println("Creando una nueva pecera");
        Teclado t = new Teclado();

        System.out.println("Introduce el ID");
        int id = t.leerInt();

        String tipoDeAgua = "none";

        while(!tipoDeAgua.equals("dulce") && !tipoDeAgua.equals("salada")) {
            System.out.println("Introduce el tipo de agua que tiene (Dulce/Salada)");
            tipoDeAgua = t.leerString().toLowerCase();
        }

        boolean tipoDeAguaBool = (tipoDeAgua.equals("dulce"));

        System.out.println("Introduce la descripción de la pecera");
        String descripcion = t.leerString();

        System.out.println("Introduce la temperatura de la pecera");
        float temperatura = t.leerFloat();

        System.out.println("Introduce el tamaño de la pecera");
        float tamano = t.leerFloat();

        List<Pez> arrayPeces = new ArrayList<Pez>();

        boolean fin = false;

        System.out.println("Se inicializa el registro de peces para la pecera");
        while(!fin) { // Se crea un array de peces
            Pez pez = peces();
            arrayPeces.add(pez);
            String opcion = "null";
            while (!opcion.equals("s") && !opcion.equals("n")) {
                System.out.println("Desea añadir otro pez? (S/N)");
                opcion = t.leerString().toLowerCase();
            }
            fin = opcion.equals("n");
        }

        Pez[] finalarrayPeces = new Pez[ arrayPeces.size() ];
        arrayPeces.toArray( finalarrayPeces );

        Pecera pecera = new Pecera(id, tipoDeAguaBool, descripcion, temperatura, tamano, finalarrayPeces);

        pecera.mostrarCaracteristicas();
        pecera.listarPeces();
    }

    static Pez peces() throws IOException{
        System.out.println("Creando un nuevo pez");
        Teclado t = new Teclado();

        System.out.println("Introduce el ID");
        int id = t.leerInt();

        System.out.println("Introduce el nombre de la especie");
        String especie = t.leerString();

        String tipoDeAgua = "none";

        while(!tipoDeAgua.equals("dulce") && !tipoDeAgua.equals("salada")) {
            System.out.println("Introduce el tipo de agua que necesita (Dulce/Salada)");
            tipoDeAgua = t.leerString().toLowerCase();
        }

        boolean tipoDeAguaBool = (tipoDeAgua.equals("dulce"));

        System.out.println("Introduce el ID de la piscina contenedora");
        int piscinaContenedora = t.leerInt();

        Pez pez = new Pez(id, especie, tipoDeAguaBool, piscinaContenedora);

        pez.mostrarDatos();

        return pez;
    }

    static void empleados() throws IOException{

    }
}
