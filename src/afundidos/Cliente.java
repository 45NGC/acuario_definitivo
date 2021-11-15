package afundidos;

import java.util.Date;

class ClienteAF extends Usuario{
    private boolean estado; // Estado del cliente
    private int contadorVisitas = 0;

    public ClienteAF(int id, String nombre, Date date, String password, char ocupacion, boolean estado, int contador) {
        super(id, nombre, date, password, ocupacion);
        this.estado = estado;
        this.contadorVisitas = contador;
    }

    public void verInfoCliente() { // Muestra la información del cliente
        mostrarDatos();
        System.out.println(" - Estado: " + estado);
        System.out.println(" - Visitas: " + contadorVisitas);
    }

    public void verPromociones(){ // Se muestra una promoción aplicada en base a la edad
        int edad = Utility.getEdad(date); // Obtiene la edad utilizando la función de la clase Utility
        if (edad<13){
            System.out.println(" - Descuento del 50%!!!!!");
        } else if (edad<21) {
            System.out.println(" - Descueto del 20%!!");
        } else if (edad>59) {
            System.out.println(" - Descuento del 30%!!!");
        } else {
            System.out.println(" - No hay descuento...");
        }
    }

    public void incrementarContadorVisitas(){
        this.contadorVisitas+=1;
    }
}
