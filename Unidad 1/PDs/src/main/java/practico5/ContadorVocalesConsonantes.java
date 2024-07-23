/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico5;

/**
 *
 * @author TomasUcu
 */
public class ContadorVocalesConsonantes {
    public static void contador(String frase) {
        
        int consonantsCont = 0;
        int vowelsCont = 0;
        
        for(int i = 0; i < frase.length(); i++) {
            
            char character = frase.charAt(i);
            
            if (Character.isLetter(character)) {
                for(Vowel c : Vowel.values()) {
                    if( c.valor == character ) {
                        vowelsCont++;
                        break;
                    }
                    if( c.equals(c.U) ) {
                        consonantsCont++;
                    }
                }
            }
        }
        
        System.out.println("Vocales: " + vowelsCont);
        System.out.println("Consonantes: " + consonantsCont);
    }
    
    public static void main(String[] args) {
        contador("Hola mundo");
    }
} 

enum Vowel {
    A('a'), 
    E('e'), 
    I('i'), 
    O('o'), 
    U('u');
    
    public char valor;
    
    private Vowel(char v) {
        this.valor = v;
    }
}