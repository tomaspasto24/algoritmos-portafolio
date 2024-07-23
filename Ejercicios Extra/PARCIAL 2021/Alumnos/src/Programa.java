
import java.util.LinkedList;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TGrafoNoDirigido grafo = UtilGrafos.cargarGrafo("src/servidores.txt", "src/enlaces.txt", true, TGrafoNoDirigido.class);
        LinkedList<TVertice> lista = grafo.rutaMenosSaltos("ALB", "GSP");
        
        lista.forEach(c -> System.out.println(c.getEtiqueta()));
    }
}
