
import java.util.Collection;
import java.util.LinkedList;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        TGrafoNoDirigido grafo = UtilGrafos.cargarGrafo("src/actores.txt", "src/en_pelicula.txt", false, TGrafoNoDirigido.class);
        String actorZZ1 = ""; // se indicará en el pizarrón
        Collection<TVertice> contactos1 = grafo.listarContactos("Kevin_Bacon", 3);
        for(TVertice v : contactos1) {
            System.out.println(v.getEtiqueta() + " grado: " + v.getNumBacon());
        }
    }
}
