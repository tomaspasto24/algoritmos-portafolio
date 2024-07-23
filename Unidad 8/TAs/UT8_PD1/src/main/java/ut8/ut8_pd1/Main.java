package ut8.ut8_pd1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author TomasUcu
 */
public class Main {
    public static void main(String[] args) {
        TVertice v1 = new TVertice("a");
        TVertice v2 = new TVertice("b");
        TVertice v3 = new TVertice("c");
        TVertice v4 = new TVertice("d");
        TVertice v5 = new TVertice("e");
        TVertice v6 = new TVertice("f");
        TVertice v7 = new TVertice("g");
        
        ArrayList<TVertice> vertices = new ArrayList();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);
        
        TArista a1 = new TArista("a", "b", 1);
        TArista a2 = new TArista("a", "e", 1);
        TArista a3 = new TArista("b", "e", 1);
        TArista a4 = new TArista("b", "d", 1);
        TArista a5 = new TArista("c", "e", 1);
        TArista a6 = new TArista("c", "f", 1);
        TArista a7 = new TArista("c", "g", 1);
        
        
        ArrayList<TArista> aristas = new ArrayList();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        System.out.println("Ejercicio Bea: ");
        grafo.bea().forEach( (ar) -> { System.out.println( ar.getEtiqueta() ); });
    }
}
