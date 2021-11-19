package ventaEntradas;

import java.io.IOException;

import clasesPrincipales.Teclado;


public class Menu {
    public void Venta() throws IOException {
        Taquilla taquilla = new Taquilla();
        taquilla.Menu();
    }
}
