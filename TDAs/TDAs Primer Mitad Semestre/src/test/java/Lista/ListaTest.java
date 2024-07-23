/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Lista;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author TomasUcu
 */
public class ListaTest {
    
    public ListaTest() {
    }
    
    @Test
    public void testInsertarPrimero() {
        Lista<Integer> lista = new Lista<>();
        Nodo nodoPrimero = new Nodo(1, 1);
        
        lista.insertar(nodoPrimero);
        
        assertEquals(lista.retornarPrimero().getDato(), nodoPrimero.getDato());
        assertEquals(lista.retornarPrimero().getEtiqueta(), nodoPrimero.getEtiqueta());
        assertNull(lista.retornarPrimero().getSiguiente());
    }
    
    @Test
    public void testInsertar() {
        Lista<Integer> lista = new Lista<>();
        Nodo nodoPrimero = new Nodo(1, 1);
        Nodo nodo2 = new Nodo(2, 2);
        Nodo nodo3 = new Nodo(3, 3);
        
        lista.insertar(nodoPrimero);
        lista.insertar(nodo2);
        lista.insertar(nodo3);
        
        assertNotNull(lista.retornarPrimero().getSiguiente());
        assertNotNull(lista.retornarPrimero().getSiguiente().getSiguiente());
        assertNull(lista.retornarPrimero().getSiguiente().getSiguiente().getSiguiente());
        assertEquals(lista.imprimir(), "1, 2, 3, ");
    }

    @Test
    public void testBuscarConElementosUsandoInsertar() {
        Lista<Integer> lista = new Lista<>();
        Nodo nodo1 = new Nodo(1, 1);
        Nodo nodo2 = new Nodo(2, 2);
        Nodo nodo3 = new Nodo(3, 3);        
        Nodo nodo4 = new Nodo(4, 4);        
        Nodo nodo5 = new Nodo(5, 5); 
  
        lista.insertar(nodo1);
        lista.insertar(nodo2);
        lista.insertar(nodo3);
        lista.insertar(nodo4);
        lista.insertar(nodo5);
        
        assertEquals(lista.buscar(3).getDato(), nodo3.getDato());
        assertNull(lista.buscar(80));
    }
    
    @Test
    public void testBuscarSinElementos() {
        Lista<Integer> lista = new Lista<>();
        
        assertNotNull(lista);
        assertNull(lista.buscar(5));
    }
    
    @Test
    public void testBuscarSinInsertar() {
        Lista<Integer> lista = cargarLista();
        
        assertEquals(lista.buscar(3).getDato(), 3);
        assertNull(lista.buscar(8));
    }
    
    @Test
    public void testEliminarListaVacia() {
        Lista<Integer> lista = new Lista<>();
        assertFalse(lista.eliminar("Test"));
        assertFalse(lista.eliminar(4));
    }
    
    @Test
    public void testEliminarVariosElementos() {

        Lista<Integer> lista = cargarLista();
        
        assertEquals(lista.imprimir(), "1, 2, 3, 4, 5, ");

        assertTrue(lista.eliminar(3));
        assertEquals(lista.imprimir(), "1, 2, 4, 5, ");

        assertTrue(lista.eliminar(1));
        assertEquals(lista.imprimir(), "2, 4, 5, ");

        assertTrue(lista.eliminar(5));
        assertEquals(lista.imprimir(), "2, 4, ");

        assertFalse(lista.eliminar(3));
        assertEquals(lista.imprimir(), "2, 4, ");        
    }

    @Test
    public void testImprimirConSeparador() {
        Lista<Integer> lista = cargarLista();
        
        assertEquals(lista.imprimir("/"), "1/2/3/4/5/");
    }

    @Test
    public void testCantElementos() {
        Lista<Integer> lista = cargarLista();
        assertEquals(lista.cantElementos(), 5);
    }

    @Test
    public void testEsVacia() {
        Lista<Integer> lista = cargarLista();
        
        assertFalse(lista.esVacia());
        
        lista.eliminar(1);
        lista.eliminar(2);
        lista.eliminar(3);
        lista.eliminar(4);
        lista.eliminar(5);
        assertTrue(lista.esVacia());
        
        lista = new Lista<>();
        
        assertTrue(lista.esVacia());
    }

    @Test
    public void testSetPrimero() {
        Lista<Integer> lista = cargarLista();
        lista.setPrimero(new Nodo(10, 10));
        
        assertEquals(lista.primero.getDato(), 10);
        assertEquals(lista.primero.getEtiqueta(), 10);
        assertNull(lista.primero.getSiguiente());
    }

    @Test
    public void testOrdenaParesImpares() {
        Lista<Integer> lista = cargarLista();
        ILista<Integer> listaOrdenada = lista.ordenaParesImpares();
        assertEquals(listaOrdenada.imprimir(), "1, 3, 5, 2, 4, ");
    }

    @Test
    public void testInsertarOrdenado() {
        Lista<Integer> lista = new Lista<>();
        Nodo nodo1 = new Nodo(8, 8);
        Nodo nodo2 = new Nodo(3, 3);
        Nodo nodo3 = new Nodo(0, 0);        
        Nodo nodo4 = new Nodo(5, 5);        
        Nodo nodo5 = new Nodo(1, 1);
        Nodo nodo6 = new Nodo(10, 10);
        
        lista.insertarOrdenado(nodo1);
        lista.insertarOrdenado(nodo2);
        lista.insertarOrdenado(nodo3);
        lista.insertarOrdenado(nodo4);
        lista.insertarOrdenado(nodo5);
        lista.insertarOrdenado(nodo6);
        
        assertEquals(lista.imprimir(), "0, 1, 3, 5, 8, 10, ");
    }

    @Test
    public void testEliminarDuplicados() {
        Lista<Integer> lista = cargarLista();
        lista.insertar(new Nodo(2, 2));
        lista.insertar(new Nodo(3, 3));
        
        assertEquals(lista.imprimir(), "1, 2, 3, 4, 5, 2, 3, ");
        assertEquals(lista.eliminarDuplicados().imprimir(), "1, 2, 3, 4, 5, ");
    }
    
    @Test
    public void testEliminarDuplicadosVacio() {
        Lista<Integer> lista = new Lista();
        
        assertEquals(lista.imprimir(), "Lista vacía.");
        assertEquals(lista.eliminarDuplicados().imprimir(), "Lista vacía.");
    }
    
    @Test
    public void testConcatenarLista() {
        Lista<Integer> lista1 = cargarLista();
        Lista<Integer> lista2 = cargarLista();
        lista2.insertar(new Nodo(80, 80));
        lista2.insertar(new Nodo(82, 82));
        
        assertEquals(lista1.concatenarLista(lista2).imprimir(), "1, 2, 3, 4, 5, 80, 82, ");
    }
    
    @Test
    public void testConcatenarListaUnaVacia() {
        Lista<Integer> lista1 = new Lista();
        Lista<Integer> lista2 = cargarLista();
        
        assertEquals(lista1.concatenarLista(lista2).imprimir(), "1, 2, 3, 4, 5, ");
    }
    
    @Test
    public void testConcatenarListaUnaVacia1() {
        Lista<Integer> lista2 = new Lista();
        Lista<Integer> lista1 = cargarLista();
        
        assertEquals(lista1.concatenarLista(lista2).imprimir(), "1, 2, 3, 4, 5, ");
    }

    @Test
    public void testConcatenarListaAmbasVacia() {
        Lista<Integer> lista1 = new Lista();
        Lista<Integer> lista2 = new Lista();
        
        assertEquals(lista1.concatenarLista(lista2).imprimir(), "Lista vacía.");
    }
    
    public Lista<Integer> cargarLista() {
        Lista<Integer> lista = new Lista<>();
        Nodo nodo1 = new Nodo(1, 1);
        Nodo nodo2 = new Nodo(2, 2);
        Nodo nodo3 = new Nodo(3, 3);        
        Nodo nodo4 = new Nodo(4, 4);        
        Nodo nodo5 = new Nodo(5, 5); 
  
        nodo1.setSiguiente(nodo2);
        nodo2.setSiguiente(nodo3);
        nodo3.setSiguiente(nodo4);
        nodo4.setSiguiente(nodo5);
        nodo5.setSiguiente(null);
        
        lista.primero = nodo1;
        return lista;
    }
}
