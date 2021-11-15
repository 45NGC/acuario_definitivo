//Hecho por Jacobo
//Lee del archivo
package ventaEntradas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArchivosRead {
 
    static final String ruta = "data\\ventas\\";
    static void read(int op,boolean benef, String strFecha) {
        //op - Si dia especifico o total.
        //benef - Si enseña los beneficios o no.
        
        String fecha;
        String precio;
        String tamano;
        String tipo;
        String fechaAux="";
        int contador=0;
        double preciotot=0;
        
        try{
            
            BufferedReader sal = new BufferedReader(new FileReader(ruta+"Ventas.txt"));
        
            System.out.println("Fecha      Precio  Tamaño Tipo");
            fecha=sal.readLine();
            while(fecha!=null){
                precio=sal.readLine();
                tamano=sal.readLine();
                tipo=sal.readLine();
                
                 if(op==1){
                        System.out.println(fecha+" | "+precio+" | "+tamano+" | "+tipo);
                        preciotot+=Double.parseDouble(precio);
                        
                        if(!fecha.equalsIgnoreCase(fechaAux)){
                        contador+=1;
                        
                        }
                    }else if(op==2&&fecha.equalsIgnoreCase(strFecha)){ //Si la fecha de la entrada coincide con la actual
                        System.out.println(fecha+" | "+precio+" | "+tamano+" | "+tipo);
                        preciotot+=Double.parseDouble(precio);;
                        }

                fechaAux=fecha;
                fecha=sal.readLine();
            }
            System.out.println("Numero de dias = " + contador + " Ganado = " + preciotot);
        }catch(IOException ioe){}
        
        if(benef==true){ //Enseña los beneficios
            beneficios(preciotot,contador);
        }
    }
    
    
    
    static void fechaEsp(boolean benef){ //Pregunta una fecha y se la manda a read
        
        Scanner ent = new Scanner(System.in);
        int dia=0; int mes=0; int año=0;
        
        System.out.println("Año:");
        
        do{ //Si algo no es un nº o < 0 lo vuelve a preguntar
            try{
                año=ent.nextInt();
            }catch(InputMismatchException ime){
                año=-2;
            }
            
            if(año<0){System.out.println("Año invalido");}
        }while(año < 0);
        
        System.out.println("Mes:");
        
        do{ //Comprueba que el nº sea posible
            try{ //Comprueba que sea numero
                mes=ent.nextInt();}
            catch(InputMismatchException ime){
                ent.next();
                mes=45;
            }
            
            if(mes<1 || mes>12){
                System.out.println("Ese mes no existe");
            }
        }while(mes<1 || mes>12);
        
        
        System.out.println("Dia:");
        do{ //Comprueba que el nº sea posible
            try{ //Comprueba que sea numero
                dia=ent.nextInt();}
            catch(InputMismatchException ime){
                ent.next();
                dia=45;
            }
            
            if(dia<1 || dia>31){
                System.out.println("Ese dia no existe");
            }
        }while(dia<1 || dia>31);
        
        String strFecha = "" + año + "-" + mes + "-" + dia;
        
        read(2,benef,strFecha);
    }
    
    static void fechaAct(boolean benef){ //Coge la fecha actual y se la manda a read
        Date fechaAct = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  //la convertimos a ese formato
        String strFecha = dateFormat.format(fechaAct); //La pasamos a str
        
        read(2,benef, strFecha);
    }
    
    static void beneficios(double precio,int contador){
        double mant = 200;
        double coste = mant*contador;
        System.out.println(coste + " - " + precio);
        
        double benef = precio - coste;
        
        System.out.println("Beneficios= " + benef);
    }
}
