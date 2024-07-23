/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uy.edu.ucu.aed2;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TomasUcu
 */
public class TLineaAereaTest {
    
    public TLineaAereaTest() {
    }

    @Test
    public void testAeropuertosNoAccesiblesDesdeTodosGrafoVacio() {
        LinkedList<TVertice> vertices = new LinkedList();
        LinkedList<TArista> aristas = new LinkedList();          
        TLineaAerea lineaAerea = new TLineaAerea(vertices, aristas);
        LinkedList<Comparable> aeropuertosNoAccesibles = lineaAerea.aeropuertosNoAccesiblesDesdeTodos();
        
        assertNull(aeropuertosNoAccesibles);
    }

    @Test
    public void testAeropuertosNoAccesiblesDesdeTodosGrafoUnSoloElemento() {
        LinkedList<TVertice> vertices = new LinkedList();
        LinkedList<TArista> aristas = new LinkedList();          
        
        vertices.add(new TVertice("1"));
        
        TLineaAerea lineaAerea = new TLineaAerea(vertices, aristas);
        
        
        LinkedList<Comparable> aeropuertosNoAccesibles = lineaAerea.aeropuertosNoAccesiblesDesdeTodos();
        
        assertNull(aeropuertosNoAccesibles);
    }

    @Test
    public void testAeropuertosNoAccesiblesDesdeTodosGrafoVariosElementosConAeropuertosInaccesibles() {
        LinkedList<TVertice> vertices = new LinkedList();
        LinkedList<TArista> aristas = new LinkedList();          
        
        vertices.add(new TVertice("1"));
        vertices.add(new TVertice("2"));
        vertices.add(new TVertice("3"));
        vertices.add(new TVertice("4"));
        vertices.add(new TVertice("5"));
        
        aristas.add(new TArista("1", "2", 0));
        aristas.add(new TArista("1", "3", 0));
        aristas.add(new TArista("3", "4", 0));
        aristas.add(new TArista("5", "2", 0));
        
        TLineaAerea lineaAerea = new TLineaAerea(vertices, aristas);
        
        
        LinkedList<Comparable> aeropuertosNoAccesibles = lineaAerea.aeropuertosNoAccesiblesDesdeTodos();
        
        assertEquals(2, aeropuertosNoAccesibles.size());
    }

    @Test
    public void testAeropuertosNoAccesiblesDesdeTodosGrafoVariosElementosConAeropuertosAccesibles() {
        LinkedList<TVertice> vertices = new LinkedList();
        LinkedList<TArista> aristas = new LinkedList();          
        
        vertices.add(new TVertice("1"));
        vertices.add(new TVertice("2"));
        vertices.add(new TVertice("3"));
        
        aristas.add(new TArista("1", "2", 0));
        aristas.add(new TArista("2", "3", 0));
        aristas.add(new TArista("3", "1", 0));

        TLineaAerea lineaAerea = new TLineaAerea(vertices, aristas);
        
        
        LinkedList<Comparable> aeropuertosNoAccesibles = lineaAerea.aeropuertosNoAccesiblesDesdeTodos();
        
        assertNull(aeropuertosNoAccesibles);      
    }
}
