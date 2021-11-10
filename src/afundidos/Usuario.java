package afundidos;
import java.util.Date;
public class Usuario {
    int id;
    String nombre;
    Date date;
    String password;
    char ocupacion;

    public Usuario(int id, String nombre, Date date, String password, char ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.date = date;
        this.password = password;
        this.ocupacion = ocupacion;
    }

    public void mostrarDatos(){ // Muestra los datos del usuario
        System.out.println("## Datos del usuario");
        System.out.println(" - ID: "+id);
        System.out.println(" - Nombre: "+ nombre);
        System.out.println(" - Fech_nacimiento: "+date);
        System.out.println(" - Ocupacion: ");
        if(ocupacion=='C') {
            System.out.println("    -Cliente");
        }else{
            System.out.println("    -Empleado");
        }
    }
}

class Cliente extends Usuario{
    private boolean estado; // Estado del cliente
    private int contadorVisitas = 0;

    public Cliente(int id, String nombre, Date date, String password, char ocupacion, boolean estado, int contador) {
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

class Empleado extends Usuario{
    private String dptoAsignado;
    private float horaDeEntrada;
    private float horaDeSalida;
    private float horasTotales;
    private boolean estado;

    public Empleado(int id, String nombre, Date date, String password, char ocupacion, String dptoAsignado, float horaDeEntrada, float horaDeSalida, float horasTotales, boolean estado) {
        super(id, nombre, date, password, ocupacion);
        this.dptoAsignado = dptoAsignado;
        this.horaDeEntrada = horaDeEntrada;
        this.horaDeSalida = horaDeSalida;
        this.horasTotales = horasTotales;
        this.estado = estado;
    }

    public void totalHoras(){
        System.out.println(horasTotales);
    }

    public void estado(){
        if(estado){
            System.out.println(" - Trabajando.");
        }else{
            System.out.println(" - De baja o en vacaciones.");
        }
    }

    public void verInfoEmpleado(){
        mostrarDatos();
        System.out.println(" - Horas totales: " + horasTotales);
        System.out.println(" - Departamento asignado: " + dptoAsignado);
        estado();
    }

    public void verHorasTotales(){
        horasTotales+=(horaDeEntrada-horaDeSalida);
    }
}
