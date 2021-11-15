package clasesPrincipales;

import java.io.IOException;

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

    }

    static void eventos(){

    }

    static void tienda(){

    }

    static void peceras(){

    }

    static void peces(){

    }

    static void empleados(){

    }
}
