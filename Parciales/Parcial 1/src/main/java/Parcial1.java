
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class Parcial1 {
    
    private static Path FILE_ROOT_PATH = Paths.get("src/main/java/");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlantillaMedicos hospital = new PlantillaMedicos();
   
        String[] lineasMedicos = ManejadorArchivosGenerico.leerArchivo(FILE_ROOT_PATH.resolve("medicos.txt").toString());
        Medico medico;
        for (String l : lineasMedicos) {
            String[] datos = l.split(",");
            medico = new Medico(Integer.valueOf(datos[0]), datos[1], datos[2], Integer.valueOf(datos[3]));
            TElementoAB<Medico> nuevoNodo = new TElementoAB<>(medico.getCedula(), medico);
            hospital.insertar(nuevoNodo);
        }
        System.out.println("Medicos en el hospital: " + hospital.obtenerTamanio());
        
        LinkedList<Medico> medicos = hospital.preOrden();
        
        System.out.println("Medicos en la planilla: " + medicos.size());
        
        for(Medico med : medicos) {
            System.out.println("Número de CI: " + med.getCedula());
        }

        Medico med1 = hospital.buscar(8948).getDatos();
        System.out.println("Medico: " + med1.getNombre() + " Especialidad: " + med1.getEspecialidad() + " CI: " + med1.getCedula() + " Ingreso: " + med1.getIngreso());
        Medico med2 = hospital.buscar(5683).getDatos();
        System.out.println("Medico: " + med2.getNombre() + " Especialidad: " + med2.getEspecialidad() + " CI: " + med2.getCedula() + " Ingreso: " + med2.getIngreso());
        Medico med3 = hospital.buscar(822).getDatos();
        System.out.println("Medico: " + med3.getNombre() + " Especialidad: " + med3.getEspecialidad() + " CI: " + med3.getCedula() + " Ingreso: " + med3.getIngreso());
        
        TArbolBB<Medico> medicosEspecialidad = hospital.obtenerDirectorio("Gastroenterologia");
        
        ListaOrdenada<Medico> lista = new ListaOrdenada<>();
        int contadorMed = 0;
        
        for(Medico medicoEsp : medicosEspecialidad.postOrden()) {
            lista.insertarOrdenado(new Nodo(medicoEsp.getNombre(), medicoEsp));
            contadorMed++;
        }
        
        String[] arrMedicos = new String[contadorMed];
        
        contadorMed = 0;
        
        Nodo<Medico> nodoActual = (Nodo)lista.primero;
        
        while(nodoActual != null) {
            Medico m = (Medico)nodoActual.getDato();
            arrMedicos[contadorMed++] = "Medico: " + m.getNombre() + " Especialidad: " + m.getEspecialidad() + " CI: " + m.getCedula() + " Ingreso: " + m.getIngreso();
            nodoActual = nodoActual.getSiguiente();
        }
        
        System.out.println("Cantidad de médicos en el directorio de especialidad: " + arrMedicos.length);
        ManejadorArchivosGenerico.escribirArchivo("src/main/java/medicos_policlinica.txt", arrMedicos);
        
        
        /*



*/
    }
    
    private static void escribirArchivoDeMedicos(String nombreArchivo, LinkedList<Medico> contenido) {
        String[] datosDeMedicos = contenido.stream().map(m -> m.imprimirDatos()).toArray(s -> new String[s]);
        String nombreCompletoArchivo = FILE_ROOT_PATH.resolve(nombreArchivo).toString();
        
        ManejadorArchivosGenerico.escribirArchivo(nombreCompletoArchivo, datosDeMedicos);
    }

}
