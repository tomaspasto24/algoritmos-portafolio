/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDoblementeEnlazada;

import Lista.*;

/**
 *
 * @author TomasUcu
 */
public class NodoDoblementeEnlazado<T> {
    
    private Comparable etiqueta;
    private T dato;
    private NodoDoblementeEnlazado<T> siguiente;
    private NodoDoblementeEnlazado<T> anterior;
    
    public NodoDoblementeEnlazado(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }
    
    public Object getDato() {
        return dato;
    }

    public NodoDoblementeEnlazado getSiguiente() {
        return (NodoDoblementeEnlazado)siguiente;
    }

    public NodoDoblementeEnlazado getAnterior() {
        return (NodoDoblementeEnlazado)anterior;
    }
    
    public void setSiguiente(NodoDoblementeEnlazado nodo) {
        this.siguiente = nodo;
    }

    public void setAnterior(NodoDoblementeEnlazado nodo) {
        this.anterior = nodo;
    }

    public void imprimir() {
        System.out.println(dato.toString());
    }

    public void imprimirEtiqueta() {
        System.out.println(etiqueta);
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public int compareTo(Comparable etiqueta) {
        Integer i = this.etiqueta.compareTo(etiqueta);
        if(i < 0) return -1;
        else if(i == 0) return 0; 
        else return 1;
    }
    
    public NodoDoblementeEnlazado<T> clone() {
        NodoDoblementeEnlazado<T> nuevoNodo = new NodoDoblementeEnlazado(this.etiqueta, this.dato);
        nuevoNodo.setSiguiente((NodoDoblementeEnlazado)this.siguiente);
        nuevoNodo.setAnterior((NodoDoblementeEnlazado)this.anterior);
        return nuevoNodo;
    }
    
}
