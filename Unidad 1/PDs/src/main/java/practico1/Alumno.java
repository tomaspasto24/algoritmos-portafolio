/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico1;

/**
 *
 * @author TomasUcu
 */
        
public class Alumno {
    
    private String nombre;
    
    public Alumno(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }
    
    public static void main(String[] args) {
        System.out.println(recorrer("Tom as"));
        System.out.println(getValor());    
        System.out.println(getPrimerCaracter("Palabra")); 
        System.out.println(paraAString(3)); 
    }
        
    public static int recorrer(String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }   
        return res;
    }
        
    public static int getValor() {
        int vector[] = { 6, 16, 26, 36, 46, 56, 66, 76 };
        int idx = 7;
        return vector[idx];
    }
    
    public static char getPrimerCaracter(String palabra) {
        return (palabra.charAt(0));
    }

    public static String paraAString(int a) {
        Object x1 = new Integer(a);
        return x1.toString();
    }
}

/* 
    a) La firma del constructor alumno no tiene parámetro y al atributo nombre se
    asigna null, pero en el método getNombreAdmiracion se útiliza a nombre
    dando por hecho que es un string.
    
    b) El problema del método recorrer es que en la inicialización del for
       la variable i comienza en 1 y termina en la igualdad de lo que devuelva
       el length del string. Para arreglar, i recorre de 0 a lenght - 1 
       inclusive.

    c) El problema es que el indice indicado está fuera del rango del vector.

    d) La función creaba un nuevo string que terminaba siendo vacío, nunca usaba
       el parámetro ingresado.
       
    e) Se estaba intentando hacer un casteo.
*/