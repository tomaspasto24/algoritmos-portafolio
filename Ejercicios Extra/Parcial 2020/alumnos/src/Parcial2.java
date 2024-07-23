
import java.util.TreeSet;

public class Parcial2 {

    public static void main(String[] args) {

        // CREAR EL GRAFO CON PERSONAS.TXT y CONTACTOS.TXT
        TGrafoContagios grafoTrazabilidad = (TGrafoContagios) UtilGrafos.cargarGrafo(
                "src/personas.txt",
                "src/contactos.txt",
                false, TGrafoContagios.class);

        String personaCOVID = "Kevin_Bacon";
        int maxDistancia = 5;
        TAnillosContagio anillos = grafoTrazabilidad.anillosDeProbablesContagiados(personaCOVID, maxDistancia);

        int cantidad = 0;

        cantidad += anillos.obtenerAnillo(4).size();
        cantidad += anillos.obtenerAnillo(3).size();
        cantidad += anillos.obtenerAnillo(2).size();
        cantidad += anillos.obtenerAnillo(1).size();

        System.out.println("Cantidad contactos: " + cantidad);

        String[] listaLineaArchivos = new String[cantidad + 4];

        int linea = 0;
        for (int i = 1; i <= 4; i++) {
            TreeSet<String> anillo = anillos.obtenerAnillo(i);
            listaLineaArchivos[linea++] = "Distancia de contacto" + i + "\n";
            for (String o : anillo) {
                listaLineaArchivos[linea++] = o;
            }
        }

        ManejadorArchivosGenerico.escribirArchivo("src/anillos.txt", listaLineaArchivos);
    }
}
