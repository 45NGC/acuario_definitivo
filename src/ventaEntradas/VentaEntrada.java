//Recoge informacion de las ventas
package ventaEntradas;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import clasesPrincipales.Teclado;

public class VentaEntrada {
    static void Entrada() throws IOException {
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

                precio = Calculos.indi(edad,tipo); //Se lo manda para descuentos individuales
                precioTot+=precio; //Suma todos los pagos de las personas

                System.out.println("¿Hay otra persona en el mismo grupo? 1=si, otro=no");
                
                //Si opcion = 1 continua, cualquier otra cosa lo rompe
                    opcion=teclado.leerInt();
                    if(opcion==1){
                        bucle=true;
                    }else{bucle=false;}


            }while(bucle==true);

            if(tamano>1){ //Si es un grupo le hace un descuento
            precioTot=Calculos.multi(tamano,precioTot);
            }

            //Cogiendo la fecha actual
            Date fecha = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  //la convertimos a ese formato
            String strFecha = dateFormat.format(fecha); //La pasamos a str

            //System.out.println(strFecha + precioTot + tamaño + tipo);       
            ArchivoLec cliente = new ArchivoLec();

            //Mandar datos al escritor
            cliente.setFecha(strFecha);
            cliente.setPago(String.valueOf(precioTot));
            cliente.setTamano(String.valueOf(tamano));
            cliente.setTipo(String.valueOf(tipo));

            //Escribir
            cliente.Escribir();
            
            System.out.println("¿Quieres comprar otra entrada?\n1=Si otro=No");  //Otra entrada
            try{ //Si algo que no sea nº se rompe
                otro=teclado.leerInt();
            }catch(InputMismatchException ime){
                ent.next();
                otro=2;
            }
            
        }while(otro==1);
        
        
        
        
    }
 
}
