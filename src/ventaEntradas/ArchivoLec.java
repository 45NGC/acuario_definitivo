//Escribe en el archivo

package ventaEntradas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoLec {
    
    static final String ruta ="data\\ventas\\";
    //Atributos
    private String tamaño;
    private String tipo;
    private String pago;
    private String fecha;
    
    public void setTamaño(String tamaño){
        this.tamaño = tamaño;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setPago(String pago){
        this.pago = pago;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public void Escribir(){
        try{
            BufferedWriter in = new BufferedWriter (new FileWriter (ruta+"ventas.txt", true));
            in.write(this.fecha);
            in.newLine();
            in.write(this.pago);
            in.newLine();
            in.write(this.tamaño);
            in.newLine();
            in.write(this.tipo);
            in.newLine();
            in.close();
        }catch(IOException ioe) {}
        
        
    }
    public static void main(String[] args) {
        
        
        
        
        
    }
}
