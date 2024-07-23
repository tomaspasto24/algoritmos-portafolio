package TArbolTrie;

public class TLista<T> implements ILista<T> {

    protected TNodo<T> primero;

    public TLista() {
        primero = null;
    }

    //Metodo insertar, se asume que se pasa un nodo nuevo, el cual no es nulo.
    // Se inserta al final de la lista
    @Override
    public void insertar(TNodo<T> nodo) {
        if (nodo != null) {
            if (esVacia()) {
                this.primero = nodo;
            } else {
                INodo<T> aux = this.primero;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(nodo);
            }
        }

    }

    //Retorno un clon del elemento encontrado.
    @Override
    public TNodo<T> buscar(Comparable clave) {
        if (!esVacia()) {
            TNodo<T> aux = this.primero;
            while (aux != null && !aux.getEtiqueta().equals(clave)) {
                aux = aux.getSiguiente();
            }
            //Significa que lo encontre
            if (aux != null) {
                return aux.clonar();
            }
        }
        return null;
    }
    
    //Retorno -1 si no lo encontre
    public int buscarComparaciones(Comparable clave) {
        int xComparaciones = 0;
        if (!esVacia()) {
            TNodo<T> aux = this.primero;
            while (aux != null && !aux.getEtiqueta().equals(clave)) {
                aux = aux.getSiguiente();
                xComparaciones++;
            }
            //Significa que lo encontre
            if (aux != null) {
                return xComparaciones;
            }
            else
            {
                return -1;
            }
        }
        return -1;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        boolean seElimino = false;
        if (!esVacia()) {
            INodo<T> aux = this.primero;
            if (aux.getEtiqueta().equals(clave)) {
                this.primero = this.primero.getSiguiente();
                return true;
            }
            INodo<T> auxSig = aux.getSiguiente();
            while (auxSig != null && !auxSig.getEtiqueta().equals(clave)) {
                aux = auxSig;
                auxSig = auxSig.getSiguiente();
            }
            //Significa que lo encontre
            if (auxSig != null) {
                seElimino = true;
                aux.setSiguiente(auxSig.getSiguiente());
            }
        }
        return seElimino;
    }

    @Override
    public int eliminarDuplicados(Comparable clave) {
        int seEliminaron = 0;
        if (!esVacia()) {
            INodo<T> aux = this.primero;
            if (aux.getEtiqueta().equals(clave)) {
                this.primero = this.primero.getSiguiente();
                aux = this.primero;
                seEliminaron++;
            }
            if (aux != null) {
                INodo<T> auxSig = aux.getSiguiente();
                while (auxSig != null) {
                    if (auxSig.getEtiqueta().equals(clave) ) {
                        seEliminaron++;
                        aux.setSiguiente(auxSig.getSiguiente());
                        auxSig = auxSig.getSiguiente();
                    } else {
                        aux = auxSig;
                        auxSig = auxSig.getSiguiente();
                    }
                }
                if(aux.getEtiqueta().equals(clave))
                {
                    this.primero = null;
                    seEliminaron++;
                }
            }
        }
        return seEliminaron;
    }

    @Override
    public String imprimir() {
        String result = "";
        if (!this.esVacia()) {
            TNodo<T> aux = primero;
            result = primero.getEtiqueta().toString();
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                result = result + " " + aux.getEtiqueta().toString();
            }
        }
        return result;
    }

    @Override
    public String imprimir(String separador) {
        String result = "";
        if (!this.esVacia()) {
            TNodo<T> aux = primero;
            result = primero.getEtiqueta().toString();
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                result = result + separador + aux.getEtiqueta().toString();
            }
        }
        return result;
    }

    @Override
    public int cantElementos() {
        int cant = 0;
        if (!esVacia()) {
            INodo<T> aux = this.primero;
            while (aux != null) {
                cant++;
                aux = aux.getSiguiente();
            }
        }
        return cant;
    }

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    @Override
    public void setPrimero(TNodo<T> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public TNodo<T> getPrimero() {
        return this.primero;
    }

}
