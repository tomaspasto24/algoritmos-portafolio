/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author TomasUcu
 */
public class ContadorPalabras {
    public static String[] palabrasComunes(String direccionArchivo) throws FileNotFoundException, IOException {
        
        File archivo = new File(direccionArchivo);
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        
        // En la primera linea del archivo txt se ingresa palabras1 y en la segunda palabras2.
        String texto = br.readLine();
        String[] palabras1 = texto.split(" ");
        
        texto = br.readLine();
        String[] palabras2 = texto.split(" ");

        
        int len = (palabras1.length > palabras2.length) ? palabras2.length : palabras1.length;
        String[] elementsCommon = new String[len];
        
        for(int i = 0, contElements = 0; i < palabras1.length; i++) {
            for(int j = 0; j < palabras2.length; j++) {
                if(palabras1[i].equalsIgnoreCase(palabras2[j])) {
                    elementsCommon[contElements++] = palabras1[i].toLowerCase();
                }
            }
        } 
        return elementsCommon;
    }    
    
    public static void main(String[] args) throws IOException {
        for( String i : palabrasComunes("Lineas.txt")){
            System.out.println(i);
        }
    }
}
/*
Lenguaje natural: se leen las lineas del archivo (la primera corresponde al primer array y la segunda al segundo array)
luego se obtiene el entero de la longitud del array que es más chico (mediante operador ternario) y se crea el array
donde se van a obtener los elementos en común, con la capacidad máxima de la variable anteriormente mencionada.
Después se recorre ambos arrays y en caso de ser iguales los elementos, se agregan al array de elementos comunes.
Mayúsculas y minúsculas están contempladas en el ejercicio.
*/
