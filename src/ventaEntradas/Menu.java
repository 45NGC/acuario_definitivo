package ventaEntradas;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import clasesPrincipales.Teclado;

public class Menu {
    
    public static void Venta() throws IOException {
        int opcion=0;
        boolean otra =true;
        Teclado teclado = new Teclado();



        do{
            System.out.println("Que quieres hacer");
            System.out.println("1= Comprar entradas \n2= Historial de ventas \n3= Beneficios \nOtro= Salir");
            

            opcion = teclado.leerInt();

                
            switch(opcion){ //Las opciones del menu
                case 1: //1= Comprar entradas
                    VentaEntrada.Entrada();
                    break;
                case 2: //2= Historial de ventas
                    System.out.println("1= Ventas de hoy, 2= Ventas de dia especifico, 3= Ventas totales");
                    
                    do{ //Asegura que la opcion exista.
                        opcion=teclado.leerInt();
                        if(opcion<1 || opcion >3){
                            System.out.println("Esa no es una opcion");
                        }
                        
                    }while(opcion<1 || opcion >3);
                    
                    switch(opcion){
                        case 1: // 1 = Ventas de hoy
                            ArchivosRead.fechaAct(false);
                            break;
                        case 2: // 2 = Ventas de dia especifico
                            ArchivosRead.fechaEsp(false);
                            break;
                        case 3: // 3 = Ventas totales
                            ArchivosRead.read(true,false,""); //read tiene que recibir fecha
                            break;
                    }
            
                    break;
                    
                case 3: //Beneficios
                    System.out.println("1= Beneficios de hoy, 2= Beneficios de dia especifico, 3= Beneficios totales");
                    do{//Asegura que la opcion exista.
                        opcion= teclado.leerInt();

                        if(opcion<1 || opcion >3){
                            System.out.println("Esa no es una opcion");
                        }
                    }while(opcion<1 || opcion >3);
                    
                    switch(opcion){
                        case 1: //1 = Beneficios de hoy
                            ArchivosRead.fechaAct(true);
                            break;
                        case 2: //2 = Beneficios de dia especifico
                            ArchivosRead.fechaEsp(true);
                            break;
                        case 3: //3 = Beneficios totales
                            ArchivosRead.read(true,true,""); //read tiene que recibir fecha
                            break;
                    }

                    break;
                default:
                    otra = false;
            }
        
          
        }while(otra==true);
        
    }



}
