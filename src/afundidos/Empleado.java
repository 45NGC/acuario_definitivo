package afundidos;

import java.util.Date;

public class Empleado extends Usuario{
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
            System.out.println(" - Trabajando");
        }else{
            System.out.println(" - De baja o en vacaciones");
        }
    }

    public void verInfoEmpleado(){
        mostrarDatos();
        System.out.println(" - Horas totales: " + horasTotales);
        System.out.println(" - Departamento asignado: " + dptoAsignado);
        estado();
    }

    public void verHorasTotales(){
        this.horasTotales+=(horaDeEntrada-horaDeSalida);
    }
}