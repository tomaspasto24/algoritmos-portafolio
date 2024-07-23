package uy.edu.ucu.aed2;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ernesto
 */
public class TLineaAerea extends TGrafoDirigido implements IVerificarConectividad {

    public TLineaAerea(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public LinkedList<Comparable> aeropuertosNoAccesiblesDesdeTodos() {
        LinkedList<Comparable> verticesNoAccesibles = new LinkedList<>();
        LinkedList<Comparable> verticesAccesibles = new LinkedList<>();

        for (TVertice v : this.getVertices().values()) {
            if (!v.getVisitado()) {
                v.bpf(verticesAccesibles); // Modificación en bpf.
            }
        }
        
        for (TVertice v : this.getVertices().values()) {
            Comparable vEti = v.getEtiqueta();
            if (verticesAccesibles.contains(vEti)) {
                verticesNoAccesibles.add(vEti);
            }
        }
        
        if(verticesAccesibles.size() == verticesNoAccesibles.size()) {
            return null;
        } else {
            return verticesNoAccesibles;
        }
    }

}
