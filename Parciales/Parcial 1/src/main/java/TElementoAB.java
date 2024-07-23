import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private Medico datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, Medico unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB getHijoDer() {
        return hijoDer;
    }

  
   

    @Override
    public void inOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.add(this.getDatos());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return (T)datos;
    }

    @Override
    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

 

    
    @Override
    public void preOrden(LinkedList<T> unaLista) {
        unaLista.add(this.getDatos());
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    @Override
    public void postOrden(LinkedList<T> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
        unaLista.add(this.getDatos());
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        int comp = this.etiqueta.compareTo(unaEtiqueta);
        if (comp < 0) {
            if (this.hijoDer == null) {
                return null;
            }
            return this.hijoDer.buscar(unaEtiqueta);
        } else if (comp > 0) {
            if (this.hijoIzq == null) {
                return null;
            }
            return this.hijoIzq.buscar(unaEtiqueta);
        } else {
            return this;
        }
    }

    @Override
    public boolean insertar(TElementoAB elemento) {
        int comp = this.getEtiqueta().compareTo(elemento.getEtiqueta());
        if (comp < 0)
        {
            if(this.hijoDer == null) {
                this.hijoDer = elemento;
                return true;
            } else {
                boolean res = this.hijoDer.insertar(elemento);
                return res;
            }
        } else if (comp > 0) {
            if(this.hijoIzq == null) {
                this.hijoIzq = elemento;
                return true;
            } else {
                boolean res = this.hijoIzq.insertar(elemento);
                return res;
            }
        }    
        return false;
    }


    @Override
    public int obtenerTamanio() {
        int contador = 1;
        
        if(hijoIzq != null) {
            contador += hijoIzq.obtenerTamanio();
        }
        
        if(hijoDer != null) {
            contador += hijoDer.obtenerTamanio();
        }
        
        return contador;
    }
    
    public TArbolBB<Medico> obtenerDirectorio(TArbolBB<Medico> arbol, String laEspecialidad) {
        Medico med = (Medico)this.datos;
        
        if(med.getEspecialidad().equalsIgnoreCase(laEspecialidad)) {
            arbol.insertar(new TElementoAB<>(med.getNombre(), med));
        }
                
        if(this.hijoIzq != null) {
            this.hijoIzq.obtenerDirectorio(arbol, laEspecialidad);
        }

        if(this.hijoDer != null) {
            this.hijoDer.obtenerDirectorio(arbol, laEspecialidad);
        }
        
        return arbol;
    }

}
