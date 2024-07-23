/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ColaCircular;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author juan-
 */
public class ColaCircularTest {
    
    public ColaCircularTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of esVacia method, of class ColaCircular.
     */
    @Test
    public void testEsVacia() {
        ColaCircular cola = new ColaCircular();
        ColaCircular cola2 = new ColaCircular();
        Nodo elem = new Nodo("1", null);
        
        cola.insertar(elem);
        
        assertEquals(false, cola.esVacia());
        assertEquals(true, cola2.esVacia());
    }

    /**
     * Test of esLlena method, of class ColaCircular.
     */
    @Test
    public void testEsLlena() {
        ColaCircular cola = new ColaCircular();
        ColaCircular cola2 = new ColaCircular();
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("1", null);
        Nodo elem3 = new Nodo("1", null);
        
        cola.insertar(elem);
        cola.insertar(elem2);
        cola.insertar(elem3);
        
        cola2.insertar(elem3);
        
        assertEquals(true, cola.esLlena());
        assertEquals(false, cola2.esLlena());
    }

    /**
     * Test of insertar method, of class ColaCircular.
     */
    @Test
    public void testInsertar() {
        ColaCircular cola = new ColaCircular();
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        
        cola.insertar(elem);
        cola.insertar(elem2);
        cola.insertar(elem3);
        
        assertEquals(false, cola.esVacia());
        assertEquals(true, cola.esLlena());
        assertEquals(elem2, cola.buscarEtiqueta("2"));
        
    }

    /**
     * Test of eliminar method, of class ColaCircular.
     */
    @Test
    public void testEliminar() {
        ColaCircular cola = new ColaCircular();
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        
        cola.insertar(elem);
        cola.insertar(elem2);
        cola.insertar(elem3);
        
        assertEquals(elem, cola.buscarEtiqueta("1"));
        assertEquals(true, cola.esLlena());
        
        cola.eliminar();
        
        assertEquals(false, cola.esLlena());
        assertEquals(null, cola.buscarEtiqueta("1"));
    }

    /**
     * Test of buscarEtiqueta method, of class ColaCircular.
     */
    @Test
    public void testBuscarEtiqueta() {
        ColaCircular cola = new ColaCircular();
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        
        cola.insertar(elem);
        cola.insertar(elem2);
        cola.insertar(elem3);
        
        assertEquals(elem, cola.buscarEtiqueta("1"));
        assertEquals(elem3, cola.buscarEtiqueta("3"));
    }

    /**
     * Test of buscarIndice method, of class ColaCircular.
     */
    @Test
    public void testBuscarIndice() {
        ColaCircular cola = new ColaCircular();
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        
        cola.insertar(elem);
        cola.insertar(elem2);
        cola.insertar(elem3);
        
        assertEquals(elem, cola.buscarIndice(0));
        assertEquals(elem3, cola.buscarIndice(2));
        assertEquals(null, cola.buscarIndice(-1));
        assertEquals(null, cola.buscarIndice(5));
    }

    /**
     * Test of imprimir method, of class ColaCircular.
     */
    @Test
    public void testImprimir() {
        ColaCircular cola = new ColaCircular();
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        Nodo elem3 = new Nodo("3", null);
        
        cola.insertar(elem);
        cola.insertar(elem2);
        cola.insertar(elem3);
        
        String exp = "1,2,3,";
        assertEquals(exp, cola.imprimir(","));
        
        cola.eliminar();
        String exp2 = "2,3,";
        assertEquals(exp2, cola.imprimir(","));
    }

    /**
     * Test of cantElementos method, of class ColaCircular.
     */
    @Test
    public void testCantElementos() {
        ColaCircular cola = new ColaCircular();
        Nodo elem = new Nodo("1", null);
        Nodo elem2 = new Nodo("2", null);
        
        cola.insertar(elem);
        cola.insertar(elem2);
        
        assertEquals(2,cola.cantElementos());
    }
    
}
