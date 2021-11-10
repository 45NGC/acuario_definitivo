package afundidos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Utility {
    public static int getEdad(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Se define un formato de fecha para convertir las fechas a un String

        Date fechaActual = new Date(); // Se obtiene la fecha actual

        // Se convierten las dos fechas a Strings
        String stringFechaNacimiento = dateFormat.format(date);
        String stringFechaActual = dateFormat.format(fechaActual);
        
        // Se obtienen los valores de las fechas como ints
        int currentYear=Integer.parseInt(stringFechaActual.substring(0,4));
        int userYear=Integer.parseInt(stringFechaNacimiento.substring(0,4));
        int currentMonth=Integer.parseInt(stringFechaActual.substring(5,7));
        int userMonth=Integer.parseInt(stringFechaNacimiento.substring(5,7));
        int currentDay=Integer.parseInt(stringFechaActual.substring(8,10));
        int userDay=Integer.parseInt(stringFechaNacimiento.substring(8,10));
        
        int edad;

        edad=currentYear-userYear;

        // Se añade un año de edad en función de la diferencia de meses
        if (userMonth>currentMonth){
            edad+=1;
        }else if(userMonth==currentMonth && userDay>=currentDay){
            edad+=1;
        }

        return edad;
    }
}