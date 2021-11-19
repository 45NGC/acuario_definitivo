//Recoge informacion de las ventas
package ventaEntradas;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import clasesPrincipales.Teclado;

public class Taquilla {

    public static void Menu() throws IOException{
        int opcion=0;
        boolean otra =true;
        Teclado teclado = new Teclado();
        Registro registro = new Registro();


        do{
            System.out.println("Que quieres hacer");
            System.out.println("1= Comprar entradas \n2= Historial de ventas \n3= Beneficios \nOtro= Salir");


            opcion = teclado.leerInt();


            switch(opcion){ //Las opciones del menu
                case 1: //1= Comprar entradas
                    Entrada();
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
                            registro.fechaAct(false);
                            break;
                        case 2: // 2 = Ventas de dia especifico
                            registro.fechaEsp(false);
                            break;
                        case 3: // 3 = Ventas totales
                            registro.read(true,false,""); //read tiene que recibir fecha
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
                            registro.fechaAct(true);
                            break;
                        case 2: //2 = Beneficios de dia especifico
                            registro.fechaEsp(true);
                            break;
                        case 3: //3 = Beneficios totales
                            registro.read(true,true,""); //read tiene que recibir fecha
                            break;
                    }

                    break;
                default:
                    otra = false;
            }


        }while(otra==true);


    }

    static void Entrada() throws IOException {
        Registro registro = new Registro();

        int opcion;
        int tamano=0;
        int edad=0;
        double precio;
        double precioTot=0;
        int tipo;
        boolean bucle=false;
        int otro=0;

        Teclado teclado = new Teclado();
        Scanner ent = new Scanner(System.in);
        
        System.out.println("¿Tipo de entrada?"); //Aun que vengan en grupo el tipo de la entrada es el mismo
        System.out.println("1= Visita normal \n2= Visita guiada \n3= Visita a espectaculo");
        
        do{
            tipo = teclado.leerInt();
            if(tipo<1 || tipo>3){System.out.println("Tipo invalido");}
        }while(tipo<1 || tipo>3);
        
        
        do{ // Bucles de grupos
            do{ //Bucles de usuario por entrada grupal

                tamano += 1;

                System.out.println("¿Edad?");
                
                do{  //Asegura que la entrada sea mayor que 0 y nª
                    edad=teclado.leerInt();

                    if(edad<0){
                        System.out.println("Valor invalido");
                    }
                }while(edad<0);

                precio = indi(edad,tipo); //Se lo manda para descuentos individuales
                precioTot+=precio; //Suma todos los pagos de las personas

                System.out.println("¿Hay otra persona en el mismo grupo? 1=si, otro=no");
                
                //Si opcion = 1 continua, cualquier otra cosa lo rompe
                    opcion=teclado.leerInt();
                    if(opcion==1){
                        bucle=true;
                    }else{bucle=false;}


            }while(bucle==true);

            if(tamano>1){ //Si es un grupo le hace un descuento
            precioTot=multi(tamano,precioTot);
            }

            //Cogiendo la fecha actual
            Date fecha = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  //la convertimos a ese formato
            String strFecha = dateFormat.format(fecha); //La pasamos a str

            //System.out.println(strFecha + precioTot + tamaño + tipo);       


            //Mandar datos al escritor
            registro.setFecha(strFecha);
            registro.setPago(String.valueOf(precioTot));
            registro.setTamano(String.valueOf(tamano));
            registro.setTipo(String.valueOf(tipo));

            //Escribir
            registro.Escribir();
            
            System.out.println("¿Quieres comprar otra entrada?\n1=Si otro=No");  //Otra entrada
            try{ //Si algo que no sea nº se rompe
                otro=teclado.leerInt();
            }catch(InputMismatchException ime){
                ent.next();
                otro=2;
            }
            
        }while(otro==1);
        
        
        
        
    }

    static double indi(int edad, int tipo){
        double pago =0;

        switch(tipo){
            case(1):
                pago = 10;
                break;
            case(2):
                pago = 15;
                break;
            case(3):
                pago = 20;
                break;
        }

        if(edad<10){
            pago=pago*0.7;
        }else if(edad>50){
            pago=pago*0.5;
        }else if(edad>100){
            pago=0;
        }

        return pago;}

    static double multi(int tamaño, double precio){
        if (tamaño>=5 && tamaño<10) {
            precio=precio*0.9;
        }else if(tamaño>=10 && tamaño <15){
            precio=precio*0.8;
        }else if(tamaño>=15){
            precio=precio*0.7;
        }


        return precio;}

}
