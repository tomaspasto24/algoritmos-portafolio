package TArbolTrie;

/**
 *
 * @author ernesto
 * @param <T>
 */
public class TNodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private TNodo<T> siguiente = null;

    public TNodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    
     @Override
    public T getDato() {
        return this.dato;
    }

     /**
     *
     * @param dato
     * 
     */
    
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    @Override
    public TNodo<T> clonar() {
        return new TNodo<>(this.etiqueta, this.dato);
    }

    public boolean equals(TNodo unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    @Override
    public TNodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(TNodo<T> nodo) {
        this.siguiente = nodo;
    }
}
