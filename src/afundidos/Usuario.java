package afundidos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(" - Fecha de nacimiento: "+dateFormat.format(date));
        System.out.println(" - Ocupacion: ");
        if(ocupacion=='C') {
            System.out.println("    - Cliente");
        }else{
            System.out.println("    - Empleado");
        }
    }
}



