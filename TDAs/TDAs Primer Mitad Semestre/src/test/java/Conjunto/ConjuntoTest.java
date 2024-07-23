/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Conjunto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class ConjuntoTest {
    
    public ConjuntoTest() {
    }

    @Test
    public void testUnionAmbosVacios() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        Conjunto<Integer> union = conjunto1.union(conjunto2);
        
        assertTrue(union.esVacia());
    }

    @Test
    public void testUnionUnoVacio1() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto1.insertar(new Nodo(1, 1));
        
        Conjunto<Integer> union = conjunto1.union(conjunto2);
        
        assertFalse(union.esVacia());
    }

    @Test
    public void testUnionUnoVacio2() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        
        Conjunto<Integer> union = conjunto1.union(conjunto2);
        
        assertFalse(union.esVacia());
    }

    @Test
    public void testUnionVariosElementosDisjuntos() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(3, 3));
        conjunto2.insertar(new Nodo(4, 4));
        
        conjunto1.insertar(new Nodo(5, 5));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(7, 7));
        
        Conjunto<Integer> union = conjunto1.union(conjunto2);
        
        assertFalse(union.esVacia());
        assertEquals(union.cantElementos(), 7);
    }

    @Test
    public void testUnionVariosElementosIguales() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(6, 6));
        conjunto2.insertar(new Nodo(5, 5));
        
        conjunto1.insertar(new Nodo(5, 5));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(7, 7));
        
        Conjunto<Integer> union = conjunto1.union(conjunto2);
        
        assertFalse(union.esVacia());
        assertEquals(union.cantElementos(), 5);
    }
    
    @Test
    public void testUnionMismosElementos() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(6, 6));
        conjunto2.insertar(new Nodo(5, 5));
        
        conjunto1.insertar(new Nodo(1, 1));
        conjunto1.insertar(new Nodo(2, 2));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(5, 5));
        
        Conjunto<Integer> union = conjunto1.union(conjunto2);
        
        assertFalse(union.esVacia());
        assertEquals(union.cantElementos(), 4);
    }
    
    @Test
    public void testInterseccionAmbosVacios() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        Conjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);
        
        assertTrue(interseccion.esVacia());
    }

    @Test
    public void testInterseccionUnoVacio1() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto1.insertar(new Nodo(1, 1));
        
        Conjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);
        
        assertTrue(interseccion.esVacia());
    }

    @Test
    public void testInterseccionUnoVacio2() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        
        Conjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);
        
        assertTrue(interseccion.esVacia());
    }

    @Test
    public void testInterseccionVariosElementosDisjuntos() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(3, 3));
        conjunto2.insertar(new Nodo(4, 4));
        
        conjunto1.insertar(new Nodo(5, 5));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(7, 7));
        
        Conjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);
        
        assertTrue(interseccion.esVacia());
        assertEquals(interseccion.cantElementos(), 0);
    }

    @Test
    public void testInterseccionVariosElementosIguales() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(6, 6));
        conjunto2.insertar(new Nodo(5, 5));
        
        conjunto1.insertar(new Nodo(5, 5));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(7, 7));
        
        Conjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);
        
        assertFalse(interseccion.esVacia());
        assertEquals(interseccion.cantElementos(), 2);
    }
    
    @Test
    public void testInterseccionMismosElementos() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(6, 6));
        conjunto2.insertar(new Nodo(5, 5));
        
        conjunto1.insertar(new Nodo(1, 1));
        conjunto1.insertar(new Nodo(2, 2));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(5, 5));
        
        Conjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);
        
        assertFalse(interseccion.esVacia());
        assertEquals(interseccion.cantElementos(), 4);
    }
    
    @Test
    public void testDiferenciaSimetricaAmbosVacios() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        Conjunto<Integer> diferenciaSimetrica = conjunto1.diferenciaSimetrica(conjunto2);
        
        assertTrue(diferenciaSimetrica.esVacia());
    }

    @Test
    public void testDiferenciaSimetricaUnoVacio1() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto1.insertar(new Nodo(1, 1));
        
        Conjunto<Integer> diferenciaSimetrica = conjunto1.diferenciaSimetrica(conjunto2);
        
        assertNotNull(diferenciaSimetrica.primero);
        assertEquals(diferenciaSimetrica.primero.getEtiqueta(), 1);
    }

    @Test
    public void testDiferenciaSimetricaUnoVacio2() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        
        Conjunto<Integer> diferenciaSimetrica = conjunto1.diferenciaSimetrica(conjunto2);
        
        assertNotNull(diferenciaSimetrica.primero);
        assertEquals(diferenciaSimetrica.primero.getEtiqueta(), 1);
    }

    @Test
    public void testDiferenciaSimetricaVariosElementosDisjuntos() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(3, 3));
        conjunto2.insertar(new Nodo(4, 4));
        
        conjunto1.insertar(new Nodo(5, 5));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(7, 7));
        
        Conjunto<Integer> diferenciaSimetrica = conjunto1.diferenciaSimetrica(conjunto2);
        
        assertFalse(diferenciaSimetrica.esVacia());
        assertEquals(diferenciaSimetrica.cantElementos(), 7);
        assertEquals(diferenciaSimetrica.imprimir(","), "1,2,3,4,5,6,7,");
    }

    @Test
    public void testDiferenciaSimetricaVariosElementosIguales() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(6, 6));
        conjunto2.insertar(new Nodo(5, 5));
        
        conjunto1.insertar(new Nodo(5, 5));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(7, 7));
        
        Conjunto<Integer> diferenciaSimetrica = conjunto1.diferenciaSimetrica(conjunto2);
        
        assertFalse(diferenciaSimetrica.esVacia());
        assertEquals(diferenciaSimetrica.cantElementos(), 3);
        assertEquals(diferenciaSimetrica.imprimir(","), "1,2,7,");
    }
    
    @Test
    public void testDiferenciaSimetricaMismosElementos() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        
        conjunto2.insertar(new Nodo(1, 1));
        conjunto2.insertar(new Nodo(2, 2));
        conjunto2.insertar(new Nodo(6, 6));
        conjunto2.insertar(new Nodo(5, 5));
        
        conjunto1.insertar(new Nodo(1, 1));
        conjunto1.insertar(new Nodo(2, 2));
        conjunto1.insertar(new Nodo(6, 6));
        conjunto1.insertar(new Nodo(5, 5));
        
        Conjunto<Integer> diferenciaSimetrica = conjunto1.diferenciaSimetrica(conjunto2);
        
        assertTrue(diferenciaSimetrica.esVacia());
        assertEquals(diferenciaSimetrica.cantElementos(), 0);
    } 
    
}
