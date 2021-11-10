package afundidos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    void mostrarDatos(){
        kb.printStr("## Datos del usuario");
        kb.printStr(" - ID: "+id);
        kb.printStr(" - Nombre: "+ nombre);
        kb.printStr(" - Fech_nacimiento: "+date);
        kb.printStr(" - Ocupacion: ");
        if(ocupacion=='C') {
            kb.printStr("    -Cliente");
        }else{
            kb.printStr("    -Empleado");
        }
    }
}

class Cliente extends Usuario{
    private boolean estado;
    private int contador_visitas;
    public Cliente(int id, String nombre, Date date, String password, char ocupacion, boolean estado, int contador) {
        super(id, nombre, date, password, ocupacion);
        this.estado=estado;
        this.contador_visitas=contador;
    }
    public void promociones(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date_now = new Date();
        String fecha_nac = dateFormat.format(date);
        String fecha_act = dateFormat.format(date_now);
        int years_now=Integer.parseInt(fecha_act.substring(0,4));
        int years=Integer.parseInt(fecha_nac.substring(0,4));
        int months_now=Integer.parseInt(fecha_act.substring(5,7));
        int months=Integer.parseInt(fecha_nac.substring(5,7));
        int days_now=Integer.parseInt(fecha_act.substring(8,10));
        int days=Integer.parseInt(fecha_nac.substring(8,10));

        int edad=kb.get_edad(years, years_now, months, months_now, days, days_now);

        if (edad<13){
            kb.printStr(" - Descuento del 50%!!!!!");
        }else if(edad<21){
            kb.printStr(" - Descueto del 20%!!");
        }else if(edad>59){
            kb.printStr(" - Descuento del 30%!!!");
        }else{
            kb.printStr(" - No hay descuento...");
        }

    }
    void incrementar_contador(){
        contador_visitas+=1;
    }
}

class Empleado extends Usuario{
    private String dpto_asignado;
    private float hora_entrada;
    private float hora_salida;
    private float horas_totales;
    private boolean estado;
    public Empleado(int id, String nombre, Date date, String password, char ocupacion, String dpto_asignado, float hora_entrada, float hora_salida, float horas_totales, boolean estado) {
        super(id, nombre, date, password, ocupacion);
        this.dpto_asignado=dpto_asignado;
        this.hora_entrada=hora_entrada;
        this.hora_salida=hora_salida;
        this.horas_totales=horas_totales;
        this.estado=estado;
    }

    void total_horas(){
        System.out.println(horas_totales);
    }

    public void estado(){
        if(estado){
            kb.printStr(" - Trabajando.");
        }else{
            kb.printStr(" - De baja o en vacaciones.");
        }
    }
    void ver_infoEmpleado(){
        mostrarDatos();
        System.out.println(" - Horas totales: "+horas_totales);
        estado();
    }
    void acumular_horas(){
        horas_totales+=(hora_entrada-hora_salida);
    }
}

class kb {
    public static void printStr(String text){
        System.out.println(text);
    }

    public static int get_edad(int y1, int y2, int m1, int m2, int d1, int d2){
        int edad;
        edad=y2-y1;
        if (m1>m2){
            edad+=1;
        }else if(m1==m2 && d1>=d2){
            edad+=1;
        }
        return edad;
    }
}
