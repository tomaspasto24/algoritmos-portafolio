/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Cola;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class ColaTest {
    
    public ColaTest() {
    }
    
    @Test
    public void testPopVacio() {
        Cola<Integer> cola = new Cola<>();
        assertNull(cola.pop());
    }
    
    @Test
    public void testPop() {
        Cola<Integer> cola = new Cola<>();
        cola.insertar(new Nodo(1,1));
        cola.insertar(new Nodo(2,2));
        cola.insertar(new Nodo(3,3));
        cola.insertar(new Nodo(4,4));
        cola.insertar(new Nodo(5,5));
        
        assertEquals(cola.pop().getDato(), 1);
        assertEquals(cola.pop().getDato(), 2);
        assertEquals(cola.pop().getDato(), 3);
        assertEquals(cola.pop().getDato(), 4);
        assertEquals(cola.pop().getDato(), 5);
    }
    
    @Test
    public void testPop1() {
        Cola<Integer> cola = new Cola<>();
        cola.insertar(new Nodo(1,1));
        assertEquals(cola.ultimo, cola.primero);

        cola.insertar(new Nodo(2,2));
        assertEquals(cola.ultimo.getDato(), 2);
        
        cola.insertar(new Nodo(3,3));
        assertEquals(cola.ultimo.getDato(), 3);

        cola.insertar(new Nodo(4,4));
        assertEquals(cola.ultimo.getDato(), 4);

        cola.insertar(new Nodo(5,5));
        assertEquals(cola.ultimo.getDato(), 5);
        
        cola.pop();
        assertEquals(cola.primero.getDato(), 2);
        assertEquals(cola.ultimo.getDato(), 5);
        
        cola.pop();
        assertEquals(cola.primero.getDato(), 3);
        
        cola.pop();
        assertEquals(cola.primero.getDato(), 4);
        
        cola.pop();
        assertEquals(cola.primero.getDato(), 5);
       
        cola.pop();
        assertNull(cola.primero);
        
        
        assertNull(cola.pop());
        assertNull(cola.primero);
    }

    @Test
    public void testImprimirCola() {
        Cola<Integer> cola = new Cola<>();
        cola.insertar(new Nodo(1,1));
        cola.insertar(new Nodo(2,2));
        cola.insertar(new Nodo(3,3));
        cola.insertar(new Nodo(4,4));
        cola.insertar(new Nodo(5,5));
    }
}
