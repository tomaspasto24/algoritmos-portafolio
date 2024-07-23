/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ArbolBB_sin_tupla;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class ArbolBBTest {
    
    public ArbolBBTest() {
    }

    @Test
    public void testInsertarElementos() {
        ArbolBB<Integer> arbol = new ArbolBB();
        arbol.insertar(new ElementoAB(5, 5));
        arbol.insertar(new ElementoAB(3, 3));
        arbol.insertar(new ElementoAB(6, 6));
        arbol.insertar(new ElementoAB(4, 4));
        
        assertEquals(arbol.raiz.getHijoDer().getEtiqueta(), 6);
        assertEquals(arbol.raiz.getHijoIzq().getHijoDer().getEtiqueta(), 4);
    }
    
    @Test
    public void testVacioInOrden() {
        var arbol = new ArbolBB<Object>();
        
        var orden = arbol.inOrden();
        
        assertEquals("", orden);
    }
    
    @Test
    public void testInOrdenWithOneElement() {
        var arbol = new ArbolBB<Integer>(new ElementoAB<>(1, 1));
        
        var orden = arbol.inOrden();
        
        assertEquals("1", orden);
    }
    
    @Test
    public void testInOrdenWithElementInLeft() {
        var el = new ElementoAB<Integer>(5, 5);
        el.setHijoIzq(new ElementoAB<>(2, 2));
        var arbol = new ArbolBB<Integer>(el);
        
        var orden = arbol.inOrden();
        
        assertEquals("2, 5", orden);
    }

    @Test
    public void testInOrdenWithElementInRight() {
        var el = new ElementoAB<Integer>(2, 2);
        el.setHijoDer(new ElementoAB<>(5, 5));
        var arbol = new ArbolBB<Integer>(el);
        
        var orden = arbol.inOrden();
        
        assertEquals("2, 5", orden);
    }

    @Test
    public void testInOrdenWithFiveElements() {
        var arbol = new ArbolBB<Integer>();
        
        for (int i : new int[] {5, 2, 6, 3, 4}) {
            arbol.insertar(new ElementoAB<>(i, i));
        }
        
        var orden = arbol.inOrden();
        
        assertEquals("2, 3, 4, 5, 6", orden);
    }
    
    @Test
    public void testTamanioVacio() {
	var arbol = new ArbolBB<Object>();

	var tamanio = arbol.tamanio();

	assertEquals(0, tamanio);
    }

    @Test
    public void testTamanioConRaiz() {
        var raiz = new ElementoAB<>(1, 1);
	var arbol = new ArbolBB<Integer>(raiz);

	var tamanio = arbol.tamanio();

	assertEquals(1, tamanio);
    }

    @Test
    public void testTamanioConRaizEHijoIzquierdo() {
        var hijoIzq = new ElementoAB<>(0, 0);
        var raiz = new ElementoAB<>(1, 1);
        raiz.setHijoIzq(hijoIzq);
	var arbol = new ArbolBB<Integer>(raiz);

	var tamanio = arbol.tamanio();

	assertEquals(2, tamanio);
    }

    @Test
    public void testAlturaArbolVacio (){
        ArbolBB arbol = new ArbolBB<Integer> ();
        
        int alt = arbol.altura();
        
        assertEquals(-1,alt);
    }
    
    
    @Test
    public void testAlturaUnElemento(){
        ArbolBB arbol = new ArbolBB<Integer> ();
        arbol.insertar(new ElementoAB(1,1));
        int alt = arbol.altura();
        
        assertEquals(0,alt);
    }

    @Test
    public void testAltura5Elementos(){
        ArbolBB arbol = new ArbolBB<Integer> ();

        ElementoAB el = new ElementoAB(2,2);    
        arbol.raiz = el;
        ElementoAB el1 = new ElementoAB(1,1); 
        el.setHijoIzq(el1);
        ElementoAB el4 = new ElementoAB(4,4);
        el.setHijoDer(el4);
        ElementoAB el5 = new ElementoAB(5,5); 
        el4.setHijoDer(el5);
        ElementoAB el6 = new ElementoAB(6,6); 
        el5.setHijoDer(el6);
        
        int alt = arbol.altura();
        
        assertEquals(3,alt);
    }
    
    @Test
    public void testAlturaNoCambia(){
        ArbolBB arbol = new ArbolBB<Integer> ();

        ElementoAB el = new ElementoAB(2,2);    
        arbol.raiz = el;
        ElementoAB el1 = new ElementoAB(1,1); 
        el.setHijoIzq(el1);
        ElementoAB el4 = new ElementoAB(4,4);
        el.setHijoDer(el4);
        ElementoAB el5 = new ElementoAB(5,5); 
        el4.setHijoDer(el5);
        ElementoAB el6 = new ElementoAB(6,6); 
        el5.setHijoDer(el6);
        
        String preOrdenPreAltura = arbol.preOrden();
        String postOrdenPreAltura = arbol.postOrden();
        String inOrdenPreAltura = arbol.inOrden();
        
        
        arbol.altura();
        
        String preOrdenPostAltura = arbol.preOrden();
        String postOrdenPostAltura = arbol.postOrden();
        String inOrdenPostAltura = arbol.inOrden();
        
        assertEquals(preOrdenPostAltura,preOrdenPreAltura);
        assertEquals(postOrdenPostAltura,postOrdenPreAltura);
        assertEquals(inOrdenPostAltura,inOrdenPreAltura);
    }
    
    @Test
    public void testEliminar(){
        ArbolBB<Integer> arbol = new ArbolBB<>();
        ElementoAB el = new ElementoAB(12,12);    
        ElementoAB el1 = new ElementoAB(1,1); 
        ElementoAB el4 = new ElementoAB(25,25);
        ElementoAB el5 = new ElementoAB(14,14); 
        ElementoAB el6 = new ElementoAB(33, 33); 
        ElementoAB el7 = new ElementoAB(88, 88); 
        ElementoAB el8 = new ElementoAB(45, 45); 
        ElementoAB el9 = new ElementoAB(66, 66); 
        ElementoAB el10 = new ElementoAB(99, 99); 
        ElementoAB e113 = new ElementoAB(2, 2); 
        ElementoAB el14 = new ElementoAB(7, 7); 
        ElementoAB el12 = new ElementoAB(5, 5); 
        
        arbol.insertar(el);
        arbol.insertar(el1);
        arbol.insertar(el4);
        arbol.insertar(el5);
        arbol.insertar(el6);
        arbol.insertar(el7);
        arbol.insertar(el8);
        arbol.insertar(el9);
        arbol.insertar(el10);
        arbol.insertar(e113);
        arbol.insertar(el14);
        arbol.insertar(el12);
        
        String inOrden1 = arbol.inOrden();
        
        System.out.println(inOrden1);
        
        arbol.eliminar(99);
        arbol.eliminar(15);
        arbol.eliminar(2);
        arbol.eliminar(12);
        arbol.eliminar(33);
        arbol.eliminar(77);
        
        String inOrden2 = arbol.inOrden();
        
        System.out.println(inOrden2);
        System.out.println(arbol.preOrden());        
        System.out.println(arbol.postOrden());
        
        assertNull(arbol.buscar(99));
        assertNull(arbol.buscar(15));
        assertNull(arbol.buscar(2));
        assertNull(arbol.buscar(12));
        assertNull(arbol.buscar(33));
        assertNull(arbol.buscar(77));
        assertNotEquals(inOrden1, inOrden2);
    }    
    
    @Test
    public void testNivelDe() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(new ElementoAB<>(2, 2));
        arbol.insertar(new ElementoAB<>(5, 5));
        arbol.insertar(new ElementoAB<>(10, 10));
        arbol.insertar(new ElementoAB<>(1, 1));
        arbol.insertar(new ElementoAB<>(11, 11));
        
        assertEquals(arbol.nivelDe(10), 2);
        assertEquals(arbol.nivelDe(2), 0);
        assertEquals(arbol.nivelDe(5), 1);
        assertEquals(arbol.nivelDe(1), 1);
        assertEquals(arbol.nivelDe(11), 3);
    }
    
    @Test
    public void testCantNodosCompletos1NodoCompleto() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(new ElementoAB<>(2, 2));
        arbol.insertar(new ElementoAB<>(5, 5));
        arbol.insertar(new ElementoAB<>(10, 10));
        arbol.insertar(new ElementoAB<>(1, 1));
        arbol.insertar(new ElementoAB<>(11, 11));
        
        assertEquals(arbol.cantNodosInternosCompletos(), 1);
    }
    
    @Test
    public void testCantNodosCompletosVariosNodosCompletos() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(new ElementoAB<>(2, 2));
        arbol.insertar(new ElementoAB<>(5, 5));
        arbol.insertar(new ElementoAB<>(3, 3));
        arbol.insertar(new ElementoAB<>(10, 10));
        arbol.insertar(new ElementoAB<>(1, 1));
        arbol.insertar(new ElementoAB<>(11, 11));
        
        assertEquals(arbol.cantNodosInternosCompletos(), 2);
    }
    
    @Test
    public void testCantNodosCompletosVariosNodosCompletos2() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(new ElementoAB<>(2, 2));
        arbol.insertar(new ElementoAB<>(5, 5));
        arbol.insertar(new ElementoAB<>(3, 3));
        arbol.insertar(new ElementoAB<>(10, 10));
        arbol.insertar(new ElementoAB<>(1, 1));
        arbol.insertar(new ElementoAB<>(11, 11));
        arbol.insertar(new ElementoAB<>(9, 9));
        
        assertEquals(arbol.cantNodosInternosCompletos(), 3);
    }
    
    @Test
    public void testArbolEsCompletoVerdadero() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(new ElementoAB<>(2, 2));
        arbol.insertar(new ElementoAB<>(5, 5));
        arbol.insertar(new ElementoAB<>(3, 3));
        arbol.insertar(new ElementoAB<>(10, 10));
        arbol.insertar(new ElementoAB<>(1, 1));
        arbol.insertar(new ElementoAB<>(11, 11));
        arbol.insertar(new ElementoAB<>(9, 9));
        
        assertTrue(arbol.verificarSiEsCompleto());
    }
    
    @Test
    public void testArbolEsCompletoFalso() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(new ElementoAB<>(2, 2));
        arbol.insertar(new ElementoAB<>(5, 5));
        assertFalse(arbol.verificarSiEsCompleto());
        arbol.insertar(new ElementoAB<>(3, 3));
        arbol.insertar(new ElementoAB<>(10, 10));
        assertFalse(arbol.verificarSiEsCompleto());
        arbol.insertar(new ElementoAB<>(0, 0));
        arbol.insertar(new ElementoAB<>(11, 11));
        arbol.insertar(new ElementoAB<>(9, 9));
        arbol.insertar(new ElementoAB<>(1, 1));
        
        assertFalse(arbol.verificarSiEsCompleto());
    }
    
    @Test
    public void testVerificarSiSonHermanos() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(new ElementoAB<>(2, 2));
        arbol.insertar(new ElementoAB<>(5, 5));
        arbol.insertar(new ElementoAB<>(3, 3));
        arbol.insertar(new ElementoAB<>(10, 10));
        arbol.insertar(new ElementoAB<>(1, 1));
        arbol.insertar(new ElementoAB<>(11, 11));
        
        assertTrue(arbol.verificarSiSonHermanos(5, 1));
        assertTrue(arbol.verificarSiSonHermanos(1, 5));
        assertTrue(arbol.verificarSiSonHermanos(3, 10));
        assertTrue(arbol.verificarSiSonHermanos(10, 3));
    }
    
    @Test
    public void testVerificarSiSonHermanosFalse() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(new ElementoAB<>(2, 2));
        arbol.insertar(new ElementoAB<>(5, 5));
        arbol.insertar(new ElementoAB<>(3, 3));
        arbol.insertar(new ElementoAB<>(10, 10));
        arbol.insertar(new ElementoAB<>(1, 1));
        arbol.insertar(new ElementoAB<>(11, 11));
        
        assertFalse(arbol.verificarSiSonHermanos(2, 5));
        assertFalse(arbol.verificarSiSonHermanos(1, 3));
        assertFalse(arbol.verificarSiSonHermanos(10, 9));
        assertFalse(arbol.verificarSiSonHermanos(5, 3));
        assertFalse(arbol.verificarSiSonHermanos(12, 4));
        assertFalse(arbol.verificarSiSonHermanos(12, 2));
    }
    
}
