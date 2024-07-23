/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico5;

/**
 *
 * @author TomasUcu
 */
public class ConversionStringNumeros {
    public static void main(String[] args) {
        // convert strings to numbers
        float a = (Float.valueOf(args[0])).floatValue(); 
        float b = (Float.valueOf(args[1])).floatValue();     
        
        // this program requires two 
        // arguments on the command line 
        if (args.length == 2 && a > 0 && b > 0) {

            // do some arithmetic
            System.out.println("a + b = " +
                               (a + b));
            System.out.println("a - b = " +
                               (a - b));
            System.out.println("a * b = " +
                               (a * b));
            System.out.println("a / b = " +
                               (a / b));
            System.out.println("a % b = " +
                               (a % b));
        } else {
            System.out.println("This program " +
                "requires two command-line arguments.");
        }
    }
}

/* 
    En caso de querer modificar el código para aceptar solo enteros positivos, se tendría que adicionar al conidicional if como se muestra anteriormente.
*/