package ventaEntradas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public static void Venta() {
        int opcion=0;
        int otra=1;
        Scanner ent = new Scanner(System.in);
       
        do{
            System.out.println("Que quieres hacer");
            System.out.println("1= Comprar entradas \n2= Historial de ventas \n3= Beneficios \nOtro= Salir");
            
            try{
               opcion = ent.nextInt(); //Falta asegurar la entrada 
            }catch(InputMismatchException ime){
                opcion=4;}
                
            switch(opcion){ //Las opciones del menu
                case 1: //1= Comprar entradas
                    VentaEntrada.Entrada();
                    break;
                case 2: //2= Historial de ventas
                    System.out.println("1= Ventas de hoy, 3= Ventas de dia especifico, 2= Ventas totales");
                    
                    do{ //Asegura que la opcion exista.
                        try{
                        opcion = ent.nextInt();
                        }catch(InputMismatchException ime){
                            ent.next();
                            opcion=4;
                        }
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
                            ArchivosRead.read(1,false,""); //read tiene que recibir fecha
                            break;
                    }
            
                    break;
                    
                case 3: //Beneficios
                    System.out.println("1= Beneficios de hoy, 2= Beneficios de dia especifico, 3= Beneficios totales");
                    do{//Asegura que la opcion exista.
                        try{
                        opcion = ent.nextInt();
                        }catch(InputMismatchException ime){
                            ent.next();
                            opcion=4;
                        }
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
                            ArchivosRead.read(1,true,""); //read tiene que recibir fecha
                            break;
                    }
                case 4:
                    otra = 0;
            }
        
          
        }while(otra==1);
        
    }



}
