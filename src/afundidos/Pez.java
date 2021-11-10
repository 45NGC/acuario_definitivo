package afundidos;
public class Pez {
    private int ID = 0;
    private String especie  = "";
    private boolean tipoDeAgua = false;
    private int codigoDePiscina = 0;

    public Pez(int ID, String especie, boolean tipoDeAgua, int codigoDePiscina) {
        this.ID = ID;
        this.especie = especie;
        this.tipoDeAgua = tipoDeAgua;
        this.codigoDePiscina = codigoDePiscina;
    }

    public void mostrarPecera() {
        System.out.println(codigoDePiscina);
    }

    public void mostrarDatos() {
        System.out.println("# Datos del pez con codigo " + this.ID);
        System.out.println(" - Especie: " + this.especie);
        if (this.tipoDeAgua)
            System.out.println(" - Tipo de agua: dulce");
        else
            System.out.println(" - Tipo de agua: salada");
        System.out.println(" - Código de la piscina contenedora: " + codigoDePiscina);
    }

}
