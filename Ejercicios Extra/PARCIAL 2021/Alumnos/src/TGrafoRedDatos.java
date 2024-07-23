
import java.util.Collection;
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
public class TGrafoRedDatos extends TGrafoNoDirigido implements IGrafoRedDatos {

    public TGrafoRedDatos(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public LinkedList<TVertice> rutaMenosSaltos(Comparable origen, Comparable destino) {
        LinkedList<TVertice> res = new LinkedList();
        TCaminos caminos = todosLosCaminos(origen, destino);
        int min = Integer.MAX_VALUE;
        TCamino minimoCamino = null;

        for (TCamino c : caminos.getCaminos()) {
            if (c.getOtrosVertices().size() < min) {
                min = c.getOtrosVertices().size();
                minimoCamino = c;
            }
        }

        res.add(buscarVertice(origen));
        for (Comparable com : minimoCamino.getOtrosVertices()) {
            res.add(buscarVertice(com));
        }
        return res;
    }

}
