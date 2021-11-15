package clasesPrincipales;

import mundoMarino.*;

import java.io.*;

import mundoMarino.GestionTienda;
import mundoMarino.Producto;
import mundoMarino.productos.Comida;
import mundoMarino.productos.Peluche;
import ventaEntradas.Menu;

public class Main {

    //Rutas de acceso a los ficheros
    static final String rutaCliente ="acuario_definitivo\\data\\clientes.dat";
    static final String rutaEmpleados = "acuario_definitivo\\data\\Empleados.txt";

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
                    menuPrincipalempleados();
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

    static void eventos(){

    }

    static void tienda() throws IOException{

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
            switch (Teclado.leerInt()) {
                case 1 : 
                    gestion.mostrarProductos(catalogo);
                case 2 : {
                    System.out.println("¿Que producto desea comprar?");
                    gestion.mostrarNombreProductos(catalogo);
                    lecturaProducto = Teclado.leerInt();
                    System.out.println("¿Cuánta cantidad desea vender?");
                    lecturaCantidad = Teclado.leerInt();
                    //Se carga el producto y la cantidad solicitada por el usuario
                    gestion.venderProducto(catalogo, lecturaProducto, lecturaCantidad);
                }
                case 3 : System.out.println(gestion.mostrarCaja() + " €");
                default : continuar = false;
            }

        } while(continuar);
    }

    static void peceras(){

    }

    static void peces(){

    }

    static void menuPrincipalempleados() throws IOException{
        File fichero = new File(rutaEmpleados);
        FileReader lector = new FileReader (rutaEmpleados);
        FileWriter escritor = new FileWriter(rutaEmpleados);
        BufferedReader br = new BufferedReader(lector);
        BufferedWriter bw = new BufferedWriter(escritor);
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
            System.out.println("2- Eliminar un empleado");
            System.out.println();
            do{
                System.out.println("Seleccione una opcion (0 para terminar) : ");
                opcionMenuEmpleados=entrada.leerInt();
            }while(opcionMenuEmpleados<0 || opcionMenuEmpleados>2);

            switch (opcionMenuEmpleados){
                case 0 -> fin=true;
                case 1 -> listaEmpledos(br);
                case 2 -> anadirEmpleado(br, bw, fichero);
                case 3 ->cambiarEmpleado();
            }
        }while(!fin);
    }

    static void listaEmpledos(BufferedReader br) throws IOException{
        int i;
        String linea=" ";
        // Este for recorre el fichero 'empleados' y en caso de que no sean nulos los imprime
        // Cuando se encuentra una linea null se termina el for
        for(i=1;linea!=null;i++){
            linea=br.readLine();

            if(linea!=null){
                System.out.println();
                System.out.println("Empleado "+i+" : "+linea);
                System.out.println();
            }
        }
    }

    static void anadirEmpleado(BufferedReader br,BufferedWriter bw, File fichero) throws IOException{
        Teclado t = new Teclado();
        int i, otro, confirmacion;
        String linea,datosEmpleado;
        boolean fin=false;

        // Le pedimos los datos del empleado al usuario, que son los siguientes:
        // id - nombreApellidos - dni - tipoTrabajo - horasTrabajo - sueldo - vacaciones - valoracion

        String nombreApellidos, dni, tipoTrabajo;
        int id, horasTrabajo, sueldo, vacaciones, valoracion;

        // A continuacion se nos presenta un bucle do-while para introducir empleados
        do{
            // Introducimos el id, en caso de que el usuario no introduza el numero 0
            // el programa regresa al menu empleados
            do{
                System.out.println("Introduza el ID del empleado (4 numeros)");
                System.out.println("Si no desea introducir ningun empleado teclee 0");
                id=t.leerInt();
            }while((id<1000 || id>9999) && id!=0);

            if(id==0){
                fin=true;
            }else{

                do{
                    System.out.println("Introduza el nombre y los apellidos del empleado :");
                    nombreApellidos=t.leerString();
                }while(nombreApellidos.length()<40);

                do{
                    System.out.println("Introduza el DNI del empleado :");
                    dni=t.leerString();
                }while(dni.length()!=9);

                do{
                    System.out.println("Introduza el tipo de trabajo desempeñado por el empleado :");
                    tipoTrabajo=t.leerString();
                }while(tipoTrabajo.length()<40);

                do{
                    System.out.println("Introduza las horas de trabajo del empleado :");
                    horasTrabajo=t.leerInt();
                }while(horasTrabajo>8);

                do{
                    System.out.println("Introduza el numero de dias de vacaciones del empleado :");
                    vacaciones=t.leerInt();
                }while(vacaciones<35);

                do{
                    System.out.println("Introduza el sueldo del empleado :");
                    sueldo=t.leerInt();
                }while(sueldo>8);

                do{
                    System.out.println("Introduza la valoracion del empleado :");
                    valoracion=t.leerInt();
                }while(valoracion>10 || valoracion<0);



                datosEmpleado=id+"   "+nombreApellidos+"   "+dni+"   "+tipoTrabajo+"   "+horasTrabajo+"   "+sueldo+"   "+vacaciones+"   "+valoracion;
                // Mostramos al usuario los valores introducidos y le preguntamos si desearia cancelar la introduccion de los mismos
                do{
                    System.out.println(datosEmpleado);
                    System.out.println("¿Desea introducir los siguientes datos?  (1=si 0=no) : ");
                    confirmacion=t.leerInt();
                }while(confirmacion>1 || confirmacion<0);

                if(confirmacion==0){
                    System.out.println("La introduccion del empleado fue cancelada");
                }else{

                    // Este for recorre el fichero 'empleados' y en caso de que encuentre una linea nula (vacia)
                    // termina el for y el escritor se posiciona en la linea determinada
                    for(i=1;i < fichero.length();i++){
                        linea=br.readLine();
                        if(linea == null){
                            bw.write(id+"   "+nombreApellidos+"   "+dni+"   "+tipoTrabajo+"   "+horasTrabajo+"   "+sueldo+"   "+vacaciones+"   "+valoracion);
                        }
                    }

                }

                // Damos la opcion al usuario de introducir otro empleado
                do{
                    System.out.println("¿Desea introducir otro empleado?  (1=si 0=no) : ");
                    otro=t.leerInt();
                }while(otro>1 || otro<0);
                if(otro==0){
                    fin=true;
                }
            }

        }while(!fin);

    }

    static void cambiarEmpleado(){
        System.out.println();
        System.out.println("Si desea eliminar o cambiar los datos de un empleado puede hacerlo en el siguiente directorio: "+rutaEmpleados);
        System.out.println();
    }


}
