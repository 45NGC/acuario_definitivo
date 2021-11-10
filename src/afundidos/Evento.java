package afundidos;
import java.util.Date;
public class Evento {
    private String nombre="";
    private Date fecha=new Date();
    private float precio=0;
    private float duracion=0;
    private int requisitoEdad=0;
    private int contadorEntradas=0;
    private int aforo=0;

    public Evento(String nombre, Date fecha, float precio, float duracion, int requisitoEdad, int contadorEntradas, int aforo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.precio = precio;
        this.duracion = duracion;
        this.requisitoEdad = requisitoEdad;
        this.contadorEntradas = contadorEntradas;
        this.aforo = aforo;
    }

    public void mostrarDatos() {
        System.out.println("## Datos del evento");
        System.out.println(" - Nombre: " +  nombre);
        System.out.println(" - Fecha: " + fecha);
        System.out.println(" - Precio: " + precio);
        System.out.println(" - Requisito de edad: " + requisitoEdad);
        System.out.println(" - Contador de entradas: " + contadorEntradas);
        System.out.println(" - Aforo: " + aforo);
    }

    public void mostrarRequisito(){
        System.out.println(" - Requisito de edad: " + requisitoEdad);
    }

    public void comprobarAforo(){
        if (contadorEntradas<aforo)
            System.out.println(" - Pueden pasar :" + (aforo-contadorEntradas) + "personas");
        else
            System.out.println(" - No se admiten mas personas");

    }
}
