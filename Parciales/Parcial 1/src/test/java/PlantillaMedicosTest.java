/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TomasUcu
 */
public class PlantillaMedicosTest {
    
    public PlantillaMedicosTest() {
    }

    @Test
    public void testArbolVacio() {
        PlantillaMedicos medicos = new PlantillaMedicos();
        
        TArbolBB<Medico> directorioEspecialidad = medicos.obtenerDirectorio("Neurologia");
        
        assertNotNull(directorioEspecialidad);
        assertNull(directorioEspecialidad.getRaiz());
    }
    
    @Test
    public void testArbolUnSoloElementoEspecialidadFalsa() {
        PlantillaMedicos medicos = new PlantillaMedicos();
        Medico med1 = new Medico(9291, "Tomas Silva", "Fonoaudiologia", 2021);
        
        medicos.insertar(new TElementoAB<>(med1.getCedula(), med1));
        
        TArbolBB<Medico> directorioEspecialidad = medicos.obtenerDirectorio("Neurologia");
        
        assertNotNull(directorioEspecialidad); 
        assertNull(directorioEspecialidad.getRaiz());
    }
    
    @Test
    public void testArbolUnSoloElementoEspecialidadVerdadera() {
        PlantillaMedicos medicos = new PlantillaMedicos();
        Medico med1 = new Medico(9291, "Tomas Silva", "Fonoaudiologia", 2021);
        
        medicos.insertar(new TElementoAB<>(med1.getCedula(), med1));
        
        TArbolBB<Medico> directorioEspecialidad = medicos.obtenerDirectorio("Fonoaudiologia");
        
        assertNotNull(directorioEspecialidad); 
        assertNotNull(directorioEspecialidad.getRaiz());
        assertEquals(med1, directorioEspecialidad.getRaiz().getDatos());
    }
    
    @Test
    public void testArbolVariosElementosEspecialidadVerdadera() {
        PlantillaMedicos medicos = new PlantillaMedicos();
        Medico med1 = new Medico(9291, "Tomas Silva", "Otra cosa", 2021);
        Medico med2 = new Medico(2, "Aictoria Teran", "Fonoaudiologia", 2021);
        Medico med3 = new Medico(3, "No me da el tiempo", "Mecanografia", 2021);
        Medico med4 = new Medico(4, "Ricky Fo", "Fonoaudiologia", 2021);
        
        medicos.insertar(new TElementoAB<>(med1.getCedula(), med1));
        medicos.insertar(new TElementoAB<>(med2.getCedula(), med2));
        medicos.insertar(new TElementoAB<>(med3.getCedula(), med3));
        medicos.insertar(new TElementoAB<>(med4.getCedula(), med4));
        
        TArbolBB<Medico> directorioEspecialidad = medicos.obtenerDirectorio("Fonoaudiologia");
        
        assertNotNull(directorioEspecialidad); 
        assertNotNull(directorioEspecialidad.getRaiz());
        assertEquals(med2, directorioEspecialidad.getRaiz().getDatos());
    }
}
