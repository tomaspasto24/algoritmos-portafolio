/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ListaArray;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author juan-
 */
public class ListaArrayTest {
    
    public ListaArrayTest() {
    }

    /**
     * Test of esVacia method, of class ListaArray.
     */
    @Test
    public void testEsVacia() {
        ListaArray lista = new ListaArray();
        ListaArray lista2 = new ListaArray();
      
        Nodo elem = new Nodo("1", null);
        
        lista.insertar(elem);
        
        assertFalse(lista.esVacia());
        assertTrue(lista2.esVacia());
    }

    /**
     * Test of esLlena method, of class ListaArray.
     */
    @Test
    public void testEsLlena() {
        ListaArray lista = new ListaArray();
        ListaArray lista2 = new ListaArray();
      
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("1", null);
        Nodo elem3 = new Nodo("1", null);
        Nodo elem4 = new Nodo("1", null);
        Nodo elem5 = new Nodo("1", null);
        Nodo elem6 = new Nodo("1", null);
        Nodo elem7 = new Nodo("1", null);
        Nodo elem8 = new Nodo("1", null);
        Nodo elem9 = new Nodo("1", null);
        Nodo elem10 = new Nodo("1", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        lista.insertar(elem5);
        lista.insertar(elem6);
        lista.insertar(elem7);
        lista.insertar(elem8);
        lista.insertar(elem9);
        lista.insertar(elem10);
        
        lista2.insertar(elem9);
        lista2.insertar(elem10);
        
        assertTrue(lista.esLlena());
        assertFalse(lista2.esLlena());
    }

    /**
     * Test of insertar method, of class ListaArray.
     */
    @Test
    public void testInsertar() {
        ListaArray lista = new ListaArray();
      
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("1", null);
        Nodo elem3 = new Nodo("3", null);
        Nodo elem4 = new Nodo("1", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        
        assertEquals(4,lista.cantElementos());
        assertFalse(lista.esVacia());
        assertEquals(elem2, lista.buscarIndice(1));
        assertEquals(elem3, lista.buscarEtiqueta("3"));

    }
    
    @Test
    public void testInsertarConRedimensionamiento() {
        ListaArray lista = new ListaArray();
      
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("1", null);
        Nodo elem3 = new Nodo("3", null);
        Nodo elem4 = new Nodo("1", null);
        Nodo elem5 = new Nodo("1", null);
        Nodo elem6 = new Nodo("1", null);
        Nodo elem7 = new Nodo("1", null);
        Nodo elem8 = new Nodo("1", null);
        Nodo elem9 = new Nodo("1", null);
        Nodo elem10 = new Nodo("1", null);
        Nodo elem11 = new Nodo("1", null);
        Nodo elem12 = new Nodo("1", null);
        Nodo elem13 = new Nodo("13", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        lista.insertar(elem5);
        lista.insertar(elem6);
        lista.insertar(elem7);
        lista.insertar(elem8);
        lista.insertar(elem9);
        lista.insertar(elem10);
        lista.insertar(elem11);
        lista.insertar(elem12);
        lista.insertar(elem13);
        
        assertEquals(13,lista.cantElementos());
        assertFalse(lista.esVacia());
        assertEquals(elem12, lista.buscarIndice(11));
        assertEquals(elem13, lista.buscarEtiqueta("13"));

    }
    
    /**
     * Test of eliminar method, of class ListaArray.
     */
    @Test
    public void testEliminarIndice() {
        ListaArray lista = new ListaArray();
      
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        Nodo elem4 = new Nodo("4", null);
        Nodo elem5 = new Nodo("5", null);
        Nodo elem6 = new Nodo("6", null);
        Nodo elem7 = new Nodo("7", null);
        Nodo elem8 = new Nodo("8", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        lista.insertar(elem5);
        lista.insertar(elem6);
        lista.insertar(elem7);
        lista.insertar(elem8);
        
        assertEquals(8,lista.cantElementos());
        assertEquals("1,2,3,4,5,6,7,8,",lista.imprimir(","));
        
        assertTrue(lista.eliminarIndice(5));
        assertFalse(lista.eliminarIndice(15));
        
        lista.eliminarIndice(5);
        
        assertEquals(6,lista.cantElementos());
        assertEquals("1,2,3,4,5,8,",lista.imprimir(","));
        
    }

    /**
     * Test of buscarEtiqueta method, of class ListaArray.
     */
    @Test
    public void testBuscarEtiqueta() {
        ListaArray lista = new ListaArray();
        
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        Nodo elem4 = new Nodo("4", null);
        Nodo elem5 = new Nodo("5", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        lista.insertar(elem5);
        
        assertEquals(elem3, lista.buscarEtiqueta("3"));
        assertEquals(null, lista.buscarEtiqueta("47"));
    }

    /**
     * Test of buscarIndice method, of class ListaArray.
     */
    @Test
    public void testBuscarIndice() {
        ListaArray lista = new ListaArray();
        
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        Nodo elem4 = new Nodo("4", null);
        Nodo elem5 = new Nodo("5", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        lista.insertar(elem5);
        
        assertEquals(elem4, lista.buscarIndice(3));
        assertEquals(null, lista.buscarIndice(6));
    }

    /**
     * Test of imprimir method, of class ListaArray.
     */
    @Test
    public void testImprimir() {
        ListaArray lista = new ListaArray();
      
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        Nodo elem4 = new Nodo("4", null);
        Nodo elem5 = new Nodo("5", null);
        Nodo elem6 = new Nodo("6", null);
        Nodo elem7 = new Nodo("7", null);
        Nodo elem8 = new Nodo("8", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        lista.insertar(elem5);
        lista.insertar(elem6);
        lista.insertar(elem7);
        lista.insertar(elem8);
        
        assertEquals("1,2,3,4,5,6,7,8,",lista.imprimir(","));
    }

    /**
     * Test of cantElementos method, of class ListaArray.
     */
    @Test
    public void testCantNodos() {
        ListaArray lista = new ListaArray();
      
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        Nodo elem4 = new Nodo("4", null);
        Nodo elem5 = new Nodo("5", null);
        Nodo elem6 = new Nodo("6", null);
        Nodo elem7 = new Nodo("7", null);
        Nodo elem8 = new Nodo("8", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        lista.insertar(elem5);
        lista.insertar(elem6);
        lista.insertar(elem7);
        lista.insertar(elem8);
        
        assertEquals(8,lista.cantElementos());
    }

    /**
     * Test of eliminarEtiqueta method, of class ListaArray.
     */
    @Test
    public void testEliminarEtiqueta() {
        ListaArray lista = new ListaArray();
      
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        Nodo elem4 = new Nodo("4", null);
        Nodo elem5 = new Nodo("5", null);
        Nodo elem6 = new Nodo("6", null);
        Nodo elem7 = new Nodo("7", null);
        Nodo elem8 = new Nodo("8", null);
        
        lista.insertar(elem);
        lista.insertar(elem2);
        lista.insertar(elem3);
        lista.insertar(elem4);
        lista.insertar(elem5);
        lista.insertar(elem6);
        lista.insertar(elem7);
        lista.insertar(elem8);
        
        assertEquals(8,lista.cantElementos());
        assertEquals("1,2,3,4,5,6,7,8,",lista.imprimir(","));
        
        assertTrue(lista.eliminarEtiqueta("5"));
        assertFalse(lista.eliminarEtiqueta("15"));
        
        lista.eliminarEtiqueta("5");
        
        assertEquals(7,lista.cantElementos());
        assertEquals("1,2,3,4,6,7,8,",lista.imprimir(","));
    }
    
}
