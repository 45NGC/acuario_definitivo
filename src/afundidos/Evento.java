package afundidos;
import java.util.Date;
public class Evento {
    private String nombre="";
    private Date fecha=new Date();
    private float precio=0;
    private float duracion=0;
    private int requisito_edad=0;
    private int contador_entradas=0;
    private int aforo=0;

    public Evento(String nombre, Date fecha, float precio, float duracion, int requisito_edad, int contador_entradas, int aforo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.precio = precio;
        this.duracion = duracion;
        this.requisito_edad = requisito_edad;
        this.contador_entradas = contador_entradas;
        this.aforo = aforo;
    }

    public void MostrarDatos() {
        System.out.println("## Datos del evento");
        System.out.println(" - Nombre: " +  nombre);
        System.out.println(" - Fecha: " + fecha);
        System.out.println(" - Precio: " + precio);
        System.out.println(" - Requisito de edad: " + requisito_edad);
        System.out.println(" - Contador de entradas: " + contador_entradas);
        System.out.println(" - Aforo: " + aforo);
    }

    public void Comprobar_requisito(){
        System.out.println(requisito_edad);
    }

    public void Comprobar_aforo(){
        if (contador_entradas<aforo)
            System.out.println("Pueden pasar :"+(aforo-contador_entradas)+"personas");
        else
            System.out.println("No se admiten mas personas");

    }
}
