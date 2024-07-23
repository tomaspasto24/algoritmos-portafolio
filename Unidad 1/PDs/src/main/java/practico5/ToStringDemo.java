/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico5;

/**
 *
 * @author TomasUcu
 */
public class ToStringDemo {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
        int dot = s.indexOf('.');
        System.out.println(dot + " digits " +
        "before decimal point.");
        System.out.println( (s.length() - dot - 1) +
        " digits after decimal point.");
    }
}

/* 
    La salida al ejecutar el código es: 
        3 digits before decimal point.
        2 digits after decimal point.

    Se declara un double d, en la siguiente linea se lo convierte en string,
    luego se usa el método indexOf (que devuelve el indice del char indicado)
    ingresado . como parámetro. La primer salida de texto es de la concadenación
    de la posición del . con digits before decimal point. La segunda salida es
    el método length del número convertido a string menos el indice del . menos 
    1 concadenado con digits after decimal point.
*/
