/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pila;

/**
 *
 * @author TomasUcu
 * @param <T>
 */
public class Pila<T> extends Lista<T> {
    
    //Inserta al principio.
    @Override
    public void insertar(Nodo<T> nodo) {
        nodo.setSiguiente((Nodo)this.primero);
        this.setPrimero(nodo);
    }
    
    //Elimina y devuelve al principio.
    public INodo<T> pop() {
        if(this.primero == null) {
            return null;
        }
        INodo<T> nodoActual = this.primero;
        INodo<T> nodoProx = nodoActual.getSiguiente();
        
        this.setPrimero((Nodo)nodoProx);
        nodoActual.setSiguiente(null);
        
        return nodoActual;
    }

    @Override
    public Nodo<T> retornarPrimero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean eliminar(Comparable clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override    
    public ILista ordenaParesImpares() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override    
    public boolean insertarOrdenado(Nodo<T> nodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}