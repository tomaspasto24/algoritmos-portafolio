/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico5;

/**
 *
 * @author TomasUcu
 */
public class MetodosStrings {
    public static void main(String[] args) {
        String cadena = " Hola es una prueba";
        System.out.println(cadena.substring(5, 10));
        
        for(String string : cadena.split(" ")) {
            System.out.println(string);
        }
        
        
        System.out.println(cadena.subSequence(2, 4));
        System.out.println(cadena.trim());
        System.out.println(cadena.indexOf("H"));
        System.out.println(cadena.indexOf("a"));
        System.out.println(cadena.contains("una"));
        System.out.println(cadena.replace("una", "uno"));
        System.out.println(cadena.replaceAll("a", "o"));
        System.out.println(cadena.replaceFirst("es", "no es"));

    }
}

/* 

Ejercicio 8:
    a)La capacidad inicial de StringBuilder es 25.

Ejercicio 9:
    a) Mostraría 32.
    b) Devolvería 'e'
    c) hannah.charAt(15)

Ejercicio 10:
    a) "car"

Ejercicio 11:
    "eola"
    "h2la"
    "h ola"
    "holaste"
    "holaama"
*/