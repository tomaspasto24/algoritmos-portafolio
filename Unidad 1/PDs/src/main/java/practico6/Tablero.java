/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico6;

/**
 *
 * @author TomasUcu
 */
public class Tablero {
    public static void imprimirTablero(int largo, int ancho) {
        for (int i = 0; i < largo; i++ ) {
            for (int j = 0; j < ancho; j++ ) {
                if (j == ancho - 1) {
                    System.out.println("#");                    
                } else {
                    System.out.print("#");                    
                }
            }
        }
    }
    
    public static void main(String[] args) {
        imprimirTablero(2, 500);
    }
}