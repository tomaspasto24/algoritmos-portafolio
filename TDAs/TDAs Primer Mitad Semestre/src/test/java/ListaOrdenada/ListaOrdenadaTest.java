/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ListaOrdenada;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class ListaOrdenadaTest {
    
    public ListaOrdenadaTest() {
    }

    @Test
    public void testInsertarOrdenado() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        Nodo nodo1 = new Nodo(30, 30);
        Nodo nodo2 = new Nodo(2, 2);
        Nodo nodo3 = new Nodo(1, 1);        
        Nodo nodo4 = new Nodo(5, 5);        
        Nodo nodo5 = new Nodo(8, 8); 
        Nodo nodo6 = new Nodo(0, 0); 
  
        lista.insertar(nodo1);
        lista.insertar(nodo2);
        lista.insertar(nodo3);
        lista.insertar(nodo4);
        lista.insertar(nodo5);
        lista.insertar(nodo6);
        
        assertEquals(lista.imprimir(), "0, 1, 2, 5, 8, 30, ");
    }

    @Test
    public void testConcatenarListaOrdenada() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        ListaOrdenada<Integer> lista2 = new ListaOrdenada<>();
        Nodo nodo1 = new Nodo(30, 30);
        Nodo nodo2 = new Nodo(2, 2);
        Nodo nodo3 = new Nodo(1, 1);        
        Nodo nodo4 = new Nodo(5, 5);        
        Nodo nodo5 = new Nodo(8, 8); 
        Nodo nodo6 = new Nodo(0, 0); 
        
        Nodo nodo7 = new Nodo(10, 10); 
        Nodo nodo8 = new Nodo(2, 2); 
        Nodo nodo9 = new Nodo(0, 0); 
        Nodo nodo10 = new Nodo(-4, -4); 
  
        lista.insertar(nodo1);
        lista.insertar(nodo2);
        lista.insertar(nodo3);
        lista.insertar(nodo4);
        lista.insertar(nodo5);
        lista.insertar(nodo6);
        
        lista2.insertar(nodo7);
        lista2.insertar(nodo8);
        lista2.insertar(nodo9);
        lista2.insertar(nodo10);
        
        assertEquals(lista.concatenarListaOrdenada(lista2).imprimir(), "-4, 0, 1, 2, 5, 8, 10, 30, ");        
    }
    
}
