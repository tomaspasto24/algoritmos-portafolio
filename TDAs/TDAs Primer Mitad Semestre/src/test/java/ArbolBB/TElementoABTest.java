/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ArbolBB;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class TElementoABTest {
    @Test
    public void testObtenerMenorClaveConInsertar() {
        ElementoAB<Integer> nodo1 = new ElementoAB(3, 3);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo3 = new ElementoAB(10, 10);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        ElementoAB<Integer> nodo5 = new ElementoAB(20, 20);
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(nodo1);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        
        assertEquals(arbol.obtenerMenorClave(), 1);
    }
    
    @Test
    public void testObtenerMenorClaveConArbolVacio() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        
        assertEquals(arbol.obtenerMenorClave(), null);
    }
    
    @Test
    public void testObtenerMenorClaveSinInsertar() {
        ElementoAB<Integer> nodo1 = new ElementoAB(7, 7);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        
        nodo2.setHijoDer(nodo1);
        nodo2.setHijoIzq(nodo4);
        
        ArbolBB<Integer> arbol = new ArbolBB<>(nodo2);
        
        
        assertEquals(arbol.obtenerMenorClave(), 1);
    }
    
    @Test
    public void testObtenerMayorClaveConInsertar() {
        ElementoAB<Integer> nodo1 = new ElementoAB(3, 3);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo3 = new ElementoAB(10, 10);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        ElementoAB<Integer> nodo5 = new ElementoAB(20, 20);
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(nodo1);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        
        assertEquals(arbol.obtenerMayorClave(), 20);
    }
    
    @Test
    public void testObtenerMayorClaveConArbolVacio() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        
        assertEquals(arbol.obtenerMayorClave(), null);
    }
    
    @Test
    public void testObtenerMayorClaveSinInsertar() {
        ElementoAB<Integer> nodo1 = new ElementoAB(7, 7);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        
        nodo2.setHijoDer(nodo1);
        nodo2.setHijoIzq(nodo4);
        
        ArbolBB<Integer> arbol = new ArbolBB<>(nodo2);
        
        
        assertEquals(arbol.obtenerMayorClave(), 7);
    }
    
    @Test
    public void testobtenerClaveAnteriorADada() {
        ElementoAB<Integer> nodo1 = new ElementoAB(3, 3);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo3 = new ElementoAB(10, 10);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        ElementoAB<Integer> nodo5 = new ElementoAB(20, 20);
        ElementoAB<Integer> nodo6 = new ElementoAB(-2, -2);
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(nodo1);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        arbol.insertar(nodo6);
        
        assertEquals(arbol.obtenerClaveAnteriorADada(20), 10);
        assertEquals(arbol.obtenerClaveAnteriorADada(5), 3);
        assertEquals(arbol.obtenerClaveAnteriorADada(1), 3);
        assertEquals(arbol.obtenerClaveAnteriorADada(-2), 1);
    }
    
    @Test
    public void testcantidadNodosPorAltura() {
        ElementoAB<Integer> nodo1 = new ElementoAB(3, 3);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo3 = new ElementoAB(10, 10);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        ElementoAB<Integer> nodo5 = new ElementoAB(20, 20);
        ElementoAB<Integer> nodo6 = new ElementoAB(-2, -2);
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(nodo1);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        arbol.insertar(nodo6);
        
        assertEquals(arbol.cantidadNodosPorAltura(2), 2);
        assertEquals(arbol.cantidadNodosPorAltura(0), 1);
        assertEquals(arbol.cantidadNodosPorAltura(3), 1);
    }
    
    @Test
    public void testlistarHojasConNivel() {
        ElementoAB<Integer> nodo1 = new ElementoAB(3, 3);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo3 = new ElementoAB(10, 10);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        ElementoAB<Integer> nodo5 = new ElementoAB(20, 20);
        ElementoAB<Integer> nodo6 = new ElementoAB(-2, -2);
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(nodo1);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        arbol.insertar(nodo6);
        
        arbol.listarHojasConNivel();
    }
    
    @Test
    public void testVerificarSiEsBusqueda() {
         ElementoAB<Integer> nodo1 = new ElementoAB(3, 3);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo3 = new ElementoAB(10, 10);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        ElementoAB<Integer> nodo5 = new ElementoAB(20, 20);
        ElementoAB<Integer> nodo6 = new ElementoAB(-2, -2);
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(nodo1);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        arbol.insertar(nodo6);
        
        assertTrue(arbol.verificarSiEsBusqueda());
    }
    
    @Test
    public void testVerificarSiEsBusquedaFalso() {
        ElementoAB<Integer> nodo1 = new ElementoAB(3, 3);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo3 = new ElementoAB(10, 10);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        ElementoAB<Integer> nodo5 = new ElementoAB(20, 20);
        ElementoAB<Integer> nodo6 = new ElementoAB(-2, -2);
        ArbolBB<Integer> arbol = new ArbolBB<>();
        nodo1.setHijoDer(nodo6);
        nodo1.setHijoIzq(nodo3);
        arbol.insertar(nodo1);
        
        assertFalse(arbol.verificarSiEsBusqueda());
    }
    
    @Test
    public void testDuplicar() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        
        IArbolBB<Integer> arbol2 = arbol.duplicar();
        
        assertNotEquals(arbol, arbol2);
        
        arbol.insertar(new ElementoAB<>(1,1));
        arbol.insertar(new ElementoAB<>(2,2));
        arbol.insertar(new ElementoAB<>(3,3));
        
        arbol2 = arbol.duplicar();
        
        assertNotEquals(arbol, arbol2);
        assertEquals(arbol2.inOrden(), "1, 2, 3");
    }

    @Test
    public void testCantDeNodos() {
        ElementoAB<Integer> nodo1 = new ElementoAB(3, 3);
        ElementoAB<Integer> nodo2 = new ElementoAB(5, 5);
        ElementoAB<Integer> nodo3 = new ElementoAB(10, 10);
        ElementoAB<Integer> nodo4 = new ElementoAB(1, 1);
        ElementoAB<Integer> nodo5 = new ElementoAB(20, 20);
        ElementoAB<Integer> nodo6 = new ElementoAB(-2, -2);
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(nodo1);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        arbol.insertar(nodo6);
        
        assertNotNull(arbol.raiz);
        assertEquals(arbol.cantidadDeNodos(), 6);
        assertEquals(arbol.cantidadDeAristas(), 7);
    }
}
