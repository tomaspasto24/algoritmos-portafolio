/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico9;

/**
 *
 * @author TomasUcu
 */
public class Factorial {
    public static int calcularFactorial(int num) {
        int calculoFactorial = 1;
        
        for(int i = 1; i <= num; i++) {
            calculoFactorial *= i;
        }
        
        return calculoFactorial;
    }
    
    public static void main(String[] args) {
        System.out.println(calcularFactorial(3));
    }
}
