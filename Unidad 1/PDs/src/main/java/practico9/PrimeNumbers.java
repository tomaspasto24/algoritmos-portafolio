/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico9;

/**
 *
 * @author TomasUcu
 */

// mismo numero y 1

public class PrimeNumbers {
    public static boolean isPrime(long n) {
        int contador = 2;
        boolean primo = true;
        int resto;
        int numero = 0;
        int valorParImpar = 0;
        
        while(contador < n) {
            resto = (int) (n % contador);
            if(Integer.valueOf(resto).equals(0)) {
                primo = false;
            }
            contador++;
        }
        
        if(primo){
            while(numero <= n){
                System.out.println("numero primo: " + numero);
                valorParImpar += numero;
                numero += 2;
            }
        } else {
            while(numero <= n){
                System.out.println("numero no primo: " + numero);
                valorParImpar += numero;
                numero += 3;
            }
        }
        
        System.out.println(valorParImpar);
        
        return primo;
    }
    
    public static void main(String[] args) {
        System.out.println(isPrime(10));
        System.out.println(isPrime(5));
    }
}
