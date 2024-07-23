
import java.util.LinkedList;
import java.util.Queue;

public class TVertice<T> implements IVertice, IVerticeContagio {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int numDist = 0;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return this.adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public int getNumDist() {
        return numDist;
    }

    public void setNumDist(int numDist) {
        this.numDist = numDist;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public T getDatos() {
        return datos;
    }

    public boolean conectadoCon(TVertice destino) {
        boolean tempResult = false;
        setVisitado(true);
        if (this == destino) {
            return true;
        }
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                tempResult = vertAdy.conectadoCon(destino);
                if (tempResult) {
                    break;
                }
            }
        }
        return tempResult;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public void obtenerAnillos(TAnillosContagio losAnillos, int maxDistancia) {
        this.setVisitado(true);
        losAnillos.agregarContagio(0, this.getEtiqueta().toString());
        Queue<TVertice> cola = new LinkedList<>();
        cola.offer(this);
        int i = 0;

        while (!cola.isEmpty() && i <= maxDistancia) {
            TVertice x = cola.poll();
            for (Object adyOb : x.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) adyOb;
                TVertice y = ady.getDestino();

                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    losAnillos.agregarContagio(i, y.getEtiqueta().toString());
                    cola.offer(y);
                }
            }
            i++;
        }
    }

}
