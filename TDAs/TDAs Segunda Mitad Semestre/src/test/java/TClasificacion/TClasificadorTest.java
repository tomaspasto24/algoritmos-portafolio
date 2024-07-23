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
public class TClasificadorTest {

    private TClasificador clasificador = new TClasificador();

    public TClasificadorTest() {
    }

    @Test
    public void testOrdenarPorInsercionPocosDatos() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52};
        int[] ordenados = clasificador.clasificar(elementos, 1);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorInsercionDatosDuplicados() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52, 52, 36};
        int[] ordenados = clasificador.clasificar(elementos, 1);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 36);
        assertEquals(ordenados[2], 40);
        assertEquals(ordenados[3], 52);
        assertEquals(ordenados[4], 52);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorInsercionDatosOrdenadosAlReves() {
        int[] elementos = new int[]{36, 40, 52, 55, 70, 99};
        int[] ordenados = clasificador.clasificar(elementos, 1);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorShellPocosDatos() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52};
        int[] ordenados = clasificador.clasificar(elementos, 2);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorShellDatosDuplicados() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52, 52, 36};
        int[] ordenados = clasificador.clasificar(elementos, 2);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 36);
        assertEquals(ordenados[2], 40);
        assertEquals(ordenados[3], 52);
        assertEquals(ordenados[4], 52);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorShellDatosOrdenadosAlReves() {
        int[] elementos = new int[]{36, 40, 52, 55, 70, 99};
        int[] ordenados = clasificador.clasificar(elementos, 2);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorBurbujaPocosDatos() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52};
        int[] ordenados = clasificador.clasificar(elementos, 3);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorBurbujaDatosDuplicados() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52, 52, 36};
        int[] ordenados = clasificador.clasificar(elementos, 3);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 36);
        assertEquals(ordenados[2], 40);
        assertEquals(ordenados[3], 52);
        assertEquals(ordenados[4], 52);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorBurbujaDatosOrdenadosAlReves() {
        int[] elementos = new int[]{36, 40, 52, 55, 70, 99};
        int[] ordenados = clasificador.clasificar(elementos, 3);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorQuickSortPocosDatos() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52};
        int[] ordenados = clasificador.clasificar(elementos, 4);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorQuickSortDatosDuplicados() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52, 52, 36};
        int[] ordenados = clasificador.clasificar(elementos, 4);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 36);
        assertEquals(ordenados[2], 40);
        assertEquals(ordenados[3], 52);
        assertEquals(ordenados[4], 52);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorQuickSortDatosOrdenadosAlReves() {
        int[] elementos = new int[]{36, 40, 52, 55, 70, 99};
        int[] ordenados = clasificador.clasificar(elementos, 4);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorQuickSortSinAlturaPocosDatos() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52};
        clasificador.quicksortSinAltura(elementos, 0, elementos.length - 1);

        assertEquals(elementos[0], 36);
        assertEquals(elementos[1], 40);
        assertEquals(elementos[2], 52);
        assertEquals(elementos[3], 55);
        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorQuickSortSinAlturaDatosDuplicados() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52, 52, 36};
        clasificador.quicksortSinAltura(elementos, 0, elementos.length - 1);

        assertEquals(elementos[0], 36);
        assertEquals(elementos[1], 36);
        assertEquals(elementos[2], 40);
        assertEquals(elementos[3], 52);
        assertEquals(elementos[4], 52);
        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorQuickSortSinAlturaDatosOrdenadosAlReves() {
        int[] elementos = new int[]{36, 40, 52, 55, 70, 99};
        clasificador.quicksortSinAltura(elementos, 0, elementos.length - 1);

        assertEquals(elementos[0], 36);
        assertEquals(elementos[1], 40);
        assertEquals(elementos[2], 52);
        assertEquals(elementos[3], 55);
        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorHeapSortPocosDatos() {
        int[] elementos = new int[]{55, 40, 36, 70, 99};
        clasificador.clasificar(elementos, 5);
        System.out.println(Arrays.toString(elementos));
        assertEquals(elementos[0], 36);
        assertEquals(elementos[1], 40);
        assertEquals(elementos[2], 55);
        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorHeapSortDatosDuplicados() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52, 52, 36};
        int[] ordenados = clasificador.clasificar(elementos, 5);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 36);
        assertEquals(ordenados[2], 40);
        assertEquals(ordenados[3], 52);
        assertEquals(ordenados[4], 52);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorHeapSortDatosOrdenadosAlReves() {
        int[] elementos = new int[]{36, 40, 52, 55, 70, 99};
        int[] ordenados = clasificador.clasificar(elementos, 5);
        System.out.println(Arrays.toString(ordenados));
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorHeapSortDatosAleatorios() {
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        int[] elementos = gen.generarDatosAleatorios();
        clasificador.clasificar(elementos, 5);
        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorHeapSortDatosAscendentes() {
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        int[] elementos = gen.generarDatosAscendentes();
        clasificador.clasificar(elementos, 5);

        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorHeapSortDatosDescendentes() {
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        int[] elementos = gen.generarDatosDescendentes();
        clasificador.clasificar(elementos, 5);
        assertTrue(clasificador.estaOrdenado(elementos));
    }
    
    @Test
    public void testOrdenarPorRadixPocosDatos() {
        int[] elementos = new int[]{55, 40, 36, 70, 99};
        clasificador.clasificar(elementos, 6);
        System.out.println(Arrays.toString(elementos));
        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorRadixDatosDuplicados() {
        int[] elementos = new int[]{55, 40, 36, 70, 99, 52, 52, 36};
        int[] ordenados = clasificador.clasificar(elementos, 6);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 36);
        assertEquals(ordenados[2], 40);
        assertEquals(ordenados[3], 52);
        assertEquals(ordenados[4], 52);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorRadixDatosOrdenadosAlReves() {
        int[] elementos = new int[]{36, 40, 52, 55, 70, 99};
        int[] ordenados = clasificador.clasificar(elementos, 6);
        System.out.println(Arrays.toString(ordenados));
        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testOrdenarPorRadixDatosAleatorios() {
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        int[] elementos = gen.generarDatosAleatorios();
        clasificador.clasificar(elementos, 6);
        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorRadixDatosAscendentes() {
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        int[] elementos = gen.generarDatosAscendentes();
        clasificador.clasificar(elementos, 6);

        assertTrue(clasificador.estaOrdenado(elementos));
    }

    @Test
    public void testOrdenarPorRadixDatosDescendentes() {
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        int[] elementos = gen.generarDatosDescendentes();
        clasificador.clasificar(elementos, 6);
        assertTrue(clasificador.estaOrdenado(elementos));
    }
    

    @Test
    public void testOrdenarPorRadix3digitos() {
        int[] elementos = new int[]{552, 403, 363, 701, 992, 523, 524, 364};
        int[] ordenados = clasificador.clasificar(elementos, 6);

        assertTrue(clasificador.estaOrdenado(ordenados));
    }

    @Test
    public void testSeleccionDirecta() {
        int[] elementos = new int[]{36, 40, 52, 55, 70, 99};
        int[] ordenados = clasificador.clasificar(elementos, 7);

        assertEquals(ordenados[0], 36);
        assertEquals(ordenados[1], 40);
        assertEquals(ordenados[2], 52);
        assertEquals(ordenados[3], 55);
        assertTrue(clasificador.estaOrdenado(ordenados));
    }
}
