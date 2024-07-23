/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico1;

/**
 *
 * @author TomasUcu
 */
public class Contador {
    
    public static void main(String[] args) {
        mostrarContador();
    }    
    
    static final int MAX_CONT = 50;
    static int incremento = 1;
    static int contador = 1;
    
    public static void mostrarContador() {
        while(contador <= MAX_CONT) {
            System.out.println(contador);
            contador += incremento;
        }
        
        System.out.println("Do-While:");
        
        contador = 1;
        
        do {
            System.out.println(contador);
            contador += incremento;
        } while(contador <= MAX_CONT);
        
        System.out.println("For:");
        
        contador = 1;
                
        for(; contador <= MAX_CONT; contador++) {
            System.out.println(contador);
        }
    }
}
