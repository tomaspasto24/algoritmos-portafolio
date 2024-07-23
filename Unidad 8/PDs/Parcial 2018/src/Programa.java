
import java.util.Collection;
import java.util.LinkedList;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] lineasActores = ManejadorArchivosGenerico.leerArchivo("src/actores.txt", true);
        LinkedList actores = new LinkedList();
        for (String s : lineasActores) {
            actores.add(s);
        }
        
        String[] lineasPeliculas = ManejadorArchivosGenerico.leerArchivo("src/en_pelicula.txt", true);
        LinkedList peliculas = new LinkedList();
        for (String s : lineasPeliculas) {
            String[] datos = s.split(",");
            peliculas.add(new TArista(datos[0], datos[1], Integer.parseInt(datos[2])));
        }
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(actores, peliculas);

        LinkedList<TVertice> losActores = new LinkedList<>();
        TAristas lasPeliculas = new TAristas();
        TGrafoNoDirigido gkb = new TGrafoNoDirigido(losActores, lasPeliculas);

        String actorZZ1 = ""; // se indicará en el pizarrón
        Collection<TVertice> contactos1 = gkb.listarContactos(actorZZ1, 1);
        // 
        
        
        String actorZZ2 = ""; // se indicará en el pizarrón
        Collection<TVertice> contactos2 = gkb.listarContactos(actorZZ2, 2);

        // escribir los resultados al archivo "salida.txt"
        // emitir un archivo de salida, "salida.txt" con la lista de contactos obtenida
    }
}
