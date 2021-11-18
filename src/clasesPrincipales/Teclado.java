package clasesPrincipales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {

    String leerString() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        return (br.readLine());
    }

    public int leerInt() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int entero;
        String datosIntroducidos=br.readLine();
        try{
            entero=Integer.parseInt(datosIntroducidos);
        }catch (NumberFormatException nfe){
            entero=Integer.MIN_VALUE;
        }
        return (entero);
    }

    float leerFloat() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        float decimal;
        String datosIntroducidos=br.readLine();
        try{
            decimal=Float.parseFloat(datosIntroducidos);
        }catch (NumberFormatException nfe){
            decimal=Float.MIN_VALUE;
        }
        return (decimal);
    }
}