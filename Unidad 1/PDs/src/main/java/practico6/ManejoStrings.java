/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author TomasUcu
 */
public class ManejoStrings {
    public static void transformarTextoT9(String rutaArchivo) throws FileNotFoundException, IOException {
        File archivo = new File (rutaArchivo);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader (fr);
        
        FileWriter fw = new FileWriter("salida",true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        String linea = br.readLine();
        while (linea != null) {
            for(int i = 0; i < linea.length(); i++) {
                char c = linea.charAt(i);
                for (digito d: digito.values()) {
                    if(d.letras.contains(Character.toString(c))) {
                        bw.write(d.numero);
                    }
                }
            }

            linea = br.readLine();
        }
        bw.close();
        fw.close();
    }
}

enum digito {
    D("DEF", 3),
    A("ABC", 2),
    G("GHI", 4),
    J("JKL", 5),
    M("MNO", 6),
    P("PQRS", 7),
    T("TUV", 8),
    W("WXYZ", 9),
    ESP(" ", 0),
    PUN(".", 1);
    
    public String letras;
    public int numero;
    
    digito(String l, int n) {
        this.letras = l;
        this.numero = n;
    }
}
