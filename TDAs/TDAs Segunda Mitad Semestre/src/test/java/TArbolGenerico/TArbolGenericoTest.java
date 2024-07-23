/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TArbolGenerico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class TArbolGenericoTest {
    
    public TArbolGenericoTest() {
    }

    @Test
    public void testBuscar() {
    }

    @Test
    public void testInsertar_Comparable_Comparable() {
        TArbolGenerico arbol = new TArbolGenerico();
        arbol.insertar("1", null);  
        arbol.insertar("5", "1");  
        arbol.insertar("6", "1");  
        arbol.insertar("3", "6");  
        arbol.insertar("2", "5");  
        System.out.println(arbol.listarIndentado());
        System.out.println(arbol.cantElementos());
    }

    @Test
    public void testInsertar_TNodoArbolGenerico_Comparable() {
    }

    @Test
    public void testListarIndentado() {
    }

    @Test
    public void testCantElementos() {
    }
    
}
