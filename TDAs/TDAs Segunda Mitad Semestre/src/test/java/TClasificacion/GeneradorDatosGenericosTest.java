/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TClasificacion;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class GeneradorDatosGenericosTest {
    
    public GeneradorDatosGenericosTest() {
    }
    @Test
    public void testGenerarDatosAleatoriosGenerico() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos();
        int[] ex = generador.generarDatosAleatorios();
        assertEquals(ex.length, 32000);
    }
    @Test
    public void testGenerarDatosAleatoriosCantElementos() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos(4);
        int[] ex = generador.generarDatosAleatorios();
        assertEquals(ex.length, 4);
        
        generador = new GeneradorDatosGenericos(500);
        ex = generador.generarDatosAleatorios();
        assertEquals(ex.length, 500);
    }
    @Test
    public void testGenerarDatosAleatoriosSinElementos() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos(0);
        int[] ex = generador.generarDatosAleatorios();
        assertEquals(ex.length, 0);
    }
    @Test
    public void testGenerarDatosAscendentesGenerico() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos();
        int[] ex = generador.generarDatosAscendentes();
        assertEquals(ex.length, 32000);
    }
    @Test
    public void testGenerarDatosAscendentesCantElementos() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos(4);
        int[] ex = generador.generarDatosAscendentes();
        assertEquals(ex.length, 4);
        
        generador = new GeneradorDatosGenericos(500);
        ex = generador.generarDatosAscendentes();
        assertEquals(ex.length, 500);
    }
    @Test
    public void testGenerarDatosAscendentesSinElementos() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos(0);
        int[] ex = generador.generarDatosAscendentes();
        assertEquals(ex.length, 0);
    }
    @Test
    public void testGenerarDatosDescendentesGenerico() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos();
        int[] ex = generador.generarDatosDescendentes();
        assertEquals(ex.length, 32000);
    }
    @Test
    public void testGenerarDatosDescendentesCantElementos() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos(4);
        int[] ex = generador.generarDatosDescendentes();
        assertEquals(ex.length, 4);
        
        generador = new GeneradorDatosGenericos(500);
        ex = generador.generarDatosDescendentes();
        assertEquals(ex.length, 500);
    }
    @Test
    public void testGenerarDatosDescendentesSinElementos() {
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos(0);
        int[] ex = generador.generarDatosDescendentes();
        assertEquals(ex.length, 0);
    }
}
