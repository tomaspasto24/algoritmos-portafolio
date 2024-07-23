/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ListaDoblementeEnlazada;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class ListaDoblementeEnlazadaTest {
    
    public ListaDoblementeEnlazadaTest() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada();
        assertNull(lista.primero);
    }

    @Test
    public void testInsertar() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada();
        lista.insertar(new NodoDoblementeEnlazado<>(1, 1));
        lista.insertar(new NodoDoblementeEnlazado<>(2, 2));
        lista.insertar(new NodoDoblementeEnlazado<>(3, 3));
        lista.insertar(new NodoDoblementeEnlazado<>(4, 4));
        
        assertEquals(lista.imprimir(","), "1,2,3,4,");
        
        assertEquals(lista.buscar(4).getAnterior().getDato(), 3);
        assertNull(lista.buscar(4).getSiguiente());
        assertEquals(lista.buscar(3).getAnterior().getDato(), 2);
        assertEquals(lista.buscar(3).getSiguiente().getDato(), 4);
        assertEquals(lista.buscar(2).getAnterior().getDato(), 1);
        assertEquals(lista.buscar(2).getSiguiente().getDato(), 3);
        assertNull(lista.buscar(1).getAnterior());
    }
    
    @Test
    public void testEliminar() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada();
        lista.insertar(new NodoDoblementeEnlazado<>(1, 1));
        lista.insertar(new NodoDoblementeEnlazado<>(2, 2));
        lista.insertar(new NodoDoblementeEnlazado<>(3, 3));
        lista.insertar(new NodoDoblementeEnlazado<>(4, 4));
        
        lista.eliminar(3);
        
        assertEquals(lista.buscar(2).getSiguiente().getDato(), 4);
        assertEquals(lista.buscar(2).getAnterior().getDato(), 1);
        assertEquals(lista.buscar(4).getAnterior().getDato(), 2);
    }
    
    @Test
    public void testEliminarCasosBorde() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada();
        lista.insertar(new NodoDoblementeEnlazado<>(1, 1));
        lista.insertar(new NodoDoblementeEnlazado<>(2, 2));
        lista.insertar(new NodoDoblementeEnlazado<>(3, 3));
        lista.insertar(new NodoDoblementeEnlazado<>(4, 4));
        
        lista.eliminar(1);
        
        assertNotNull(lista.primero);
        assertNull(lista.primero.getAnterior());
        assertEquals(lista.primero.getDato(), 2);
        assertEquals(lista.primero.getSiguiente().getDato(), 3);

        lista.eliminar(4);
        
        assertNotNull(lista.buscar(3));
        assertNull(lista.buscar(3).getSiguiente());
        assertEquals(lista.buscar(3).getAnterior().getDato(), 2);
    }

    @Test
    public void testCantElementos() {        
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada();
        lista.insertar(new NodoDoblementeEnlazado<>(1, 1));
        lista.insertar(new NodoDoblementeEnlazado<>(2, 2));
        lista.insertar(new NodoDoblementeEnlazado<>(3, 3));
        lista.insertar(new NodoDoblementeEnlazado<>(4, 4));
        
        assertEquals(lista.cantElementos(), 4);
    }

    @Test
    public void testEsVacia() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada();
        
        assertTrue(lista.esVacia());
        
        lista.insertar(new NodoDoblementeEnlazado<>(1, 1));
        lista.insertar(new NodoDoblementeEnlazado<>(2, 2));
        lista.insertar(new NodoDoblementeEnlazado<>(3, 3));
        lista.insertar(new NodoDoblementeEnlazado<>(4, 4));
        
        assertFalse(lista.esVacia());
    }

    @Test
    public void testInsertarOrdenado() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada();
        lista.insertarOrdenado(new NodoDoblementeEnlazado<>(10, 10));
        lista.insertarOrdenado(new NodoDoblementeEnlazado<>(5, 5));
        lista.insertarOrdenado(new NodoDoblementeEnlazado<>(2, 2));
        lista.insertarOrdenado(new NodoDoblementeEnlazado<>(8, 8));
        lista.insertarOrdenado(new NodoDoblementeEnlazado<>(99, 99));
        lista.insertarOrdenado(new NodoDoblementeEnlazado<>(1, 1));
        
        assertEquals(lista.imprimir(","), "1,2,5,8,10,99,");
    }
}
