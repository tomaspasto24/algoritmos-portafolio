
import java.util.Collection;
import java.util.LinkedList;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

// cargar grafo con actores y relaciones
        LinkedList<TVertice> losActores = new LinkedList<>();
        TAristas lasPeliculas = new TAristas();
        TGrafoNoDirigido gkb = new TGrafoNoDirigido(losActores, lasPeliculas);

        String actorZZ1 = ""; // se indicará en el pizarrón
        Collection<TVertice> contactos1 = gkb.listarContactos(actorZZ1, 1);
        // escribir los resultados al archivo "salida.txt"

        String actorZZ2 = ""; // se indicará en el pizarrón
        Collection<TVertice> contactos2 = gkb.listarContactos(actorZZ2, 2);

        // escribir los resultados al archivo "salida.txt"
        // emitir un archivo de salida, "salida.txt" con la lista de contactos obtenida
    }
}
