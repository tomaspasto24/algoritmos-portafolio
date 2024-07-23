/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico2;

/**
 *
 * @author TomasUcu
 */
public class ContenedorNumeros {
    public static void main(String args[]) {
        NumberHolder contenedor = new NumberHolder();
        contenedor.anInt = 22;
        contenedor.aFloat = 3.22f;
        System.out.println(contenedor.anInt);
        System.out.println(contenedor.aFloat);
    }
}

class NumberHolder {
    public int anInt;
    public float aFloat;
}