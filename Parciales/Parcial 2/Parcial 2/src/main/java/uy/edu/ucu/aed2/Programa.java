package uy.edu.ucu.aed2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<TVertice> vertices = new LinkedList();
        LinkedList<TArista> aristas = new LinkedList();
        String[] aeropuertosString = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed2/aeropuertos.txt", true);
        String[] vuelosString = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed2/vuelos.txt", true);
        
        for(String v : aeropuertosString) {
            vertices.add(new TVertice(v));
        }
        
        for(String a : vuelosString) {
            String[] dato = a.split(",");
            aristas.add(new TArista(dato[0], dato[1], Double.parseDouble(dato[2])));
        }
        
        TLineaAerea aereo = new TLineaAerea(vertices, aristas);
        
        LinkedList<Comparable> lista = aereo.aeropuertosNoAccesiblesDesdeTodos();
        String[] texto = new String[lista.size()];

        int i = 0;
        for (Comparable comp : lista) {
            texto[i++] = comp.toString();
        }

        ManejadorArchivosGenerico.escribirArchivo("src/main/java/uy/edu/ucu/aed2/salida.txt", texto);
    }

}
