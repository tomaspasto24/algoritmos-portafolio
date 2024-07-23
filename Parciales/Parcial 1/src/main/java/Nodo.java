/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TomasUcu
 */
public class Nodo<T> implements INodo {
    
    private Comparable etiqueta;
    private T dato;
    private INodo siguiente;
    
    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }
    
    @Override
    public Object getDato() {
        return dato;
    }

    @Override
    public Nodo getSiguiente() {
        return (Nodo)siguiente;
    }

    @Override
    public void setSiguiente(Nodo nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(etiqueta);
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        Integer i = this.etiqueta.compareTo(etiqueta);
        if(i < 0) return -1;
        else if(i == 0) return 0; 
        else return 1;
    }
    
    public Nodo<T> clone() {
        Nodo<T> nuevoNodo = new Nodo(this.etiqueta, this.dato);
        nuevoNodo.setSiguiente((Nodo)this.siguiente);
        return nuevoNodo;
    }
    
}
