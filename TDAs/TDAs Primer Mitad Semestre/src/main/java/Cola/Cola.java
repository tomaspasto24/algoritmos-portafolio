/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cola;

/**
 *
 * @author TomasUcu
 * @param <T>
 */
public class Cola<T> extends Lista<T> {
    protected INodo<T> ultimo;
    
    // Inserta al final.
    @Override
    public void insertar(Nodo<T> nodo) {
        if(primero == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
            ultimo.setSiguiente(null);   
        }
    }
    
    // Elimina y devuelve al principio.
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
    public boolean eliminar(Comparable clave) {
        this.pop();
        return true;
    }
    @Override
    public ILista ordenaParesImpares() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    @Override
    public boolean insertarOrdenado(Nodo<T> nodo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}        

