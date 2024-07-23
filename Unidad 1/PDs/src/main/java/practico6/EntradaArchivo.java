/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author TomasUcu
 */
public class EntradaArchivo {
    public static void leerEntradaArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        File archivo = new File (rutaArchivo);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader (fr);
        
        int entero = Integer.parseInt(br.readLine());
        float flotante = Float.parseFloat(br.readLine());
        String nombre = br.readLine();
        
        System.out.println("El entero leído es: " + entero);
        System.out.println("El número de punto flotante es: " + flotante);
        System.out.println("La cadena leída es " + nombre);
        System.out.println("¡Hola "+ nombre +"! La suma de "+ entero +" y "+ flotante +"es "+ (entero + flotante) +".");
    }
}

