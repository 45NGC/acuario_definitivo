//Calcula descuentos por persona y grupo
package ventaEntradas;

public class Calculos {
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
