package afundidos;

public class Pecera {
    private int id;
    private boolean tipo_agua;
    private String descripcion;
    private float temperatura;
    private float tamaño;
    private Pez peces[];

    public Pecera(int id, boolean tipo_agua, String descripcion, float temperatura, float tamano, Pez[] peces){
        this.id=id;
        this.tipo_agua=tipo_agua;
        this.descripcion=descripcion;
        this.temperatura=temperatura;
        this.tamaño=tamano;
        this.peces=peces;
    }

    public void listar_peces(){
        System.out.println("## Datos de todos los peces de la piscina " + this.id);
        for(Pez pez : peces){
            pez.mostrarDatos();
        }
    }

    public void mostrar_caracteristicas(){
        System.out.println("## Datos de la piscina " + this.id);
        if (this.tipo_agua)
            System.out.println(" - Tipo de agua: dulce");
        else
            System.out.println(" - Tipo de agua: salada");
        System.out.println(" - Descripcion: " + this.descripcion);
        System.out.println(" - Temperatura: " + this.temperatura);
        System.out.println(" - Tamaño: " + this.tamaño);
    }

}