/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Pila;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class PilaTest {
    
    public PilaTest() {
    }
    
    @Test
    public void testPopVacio() {
        Pila<Integer> pila = new Pila<>();
        assertNull(pila.pop());
    }

    @Test
    public void testPop() {
        Pila<Integer> pila = new Pila<>();
        pila.insertar(new Nodo(1,1));
        pila.insertar(new Nodo(2,2));
        pila.insertar(new Nodo(3,3));
        pila.insertar(new Nodo(4,4));
        pila.insertar(new Nodo(5,5));
        
        assertEquals(pila.pop().getDato(), 5);
        assertEquals(pila.pop().getDato(), 4);
        assertEquals(pila.pop().getDato(), 3);
        assertEquals(pila.pop().getDato(), 2);
        assertEquals(pila.pop().getDato(), 1);
    }
}
