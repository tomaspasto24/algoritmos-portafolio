package Conjunto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends Lista<T> implements IConjunto {
    
    @Override
    public Conjunto union(Conjunto otroConjunto) {
        if(this.esVacia()) return otroConjunto;
        if( otroConjunto.esVacia()) return this;

        INodo nodoA = this.primero;
        while(nodoA != null) {
            if(otroConjunto.buscar(nodoA.getEtiqueta()) == null) {
                otroConjunto.insertarOrdenado((Nodo)nodoA);
            }
            nodoA = nodoA.getSiguiente();
        }
        return otroConjunto;
    }

    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
        Conjunto<T> conjunto = new Conjunto();        
        if(this.esVacia() || otroConjunto.esVacia()) return conjunto;
        INodo nodoActual = this.primero;
        
        while(nodoActual != null) {
            if(otroConjunto.buscar(nodoActual.getEtiqueta()) != null) {
                conjunto.insertarOrdenado((Nodo)nodoActual);
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return conjunto;
    }
    
    @Override
    public Conjunto diferenciaSimetrica(Conjunto otroConjunto) {
        Conjunto<T> conjunto = new Conjunto();
        
        if (this.esVacia()) return otroConjunto;
        else if (otroConjunto.esVacia()) return this;
        
        INodo nodoActual = this.primero;
        while(nodoActual != null) {
            if(otroConjunto.buscar(nodoActual.getEtiqueta()) == null) {
                conjunto.insertarOrdenado((Nodo)nodoActual);
            }
            nodoActual = nodoActual.getSiguiente();
        }
        
        INodo nodoAux = otroConjunto.primero;
        while(nodoAux != null) {
            if(this.buscar(nodoAux.getEtiqueta()) == null) {
                conjunto.insertarOrdenado((Nodo)nodoAux);
            }
            nodoAux = nodoAux.getSiguiente();
        }
        return conjunto;
    }

    @Override
    public Conjunto complemento(Conjunto conjuntoUniversal) {
        Conjunto<T> conjunto = new Conjunto();
        
        if (this.esVacia()) return conjuntoUniversal;
        else if (conjuntoUniversal.esVacia()) return conjunto;
        
        INodo nodoActual = conjuntoUniversal.primero;
        
        while(nodoActual != null) {
            if(buscar(nodoActual.getEtiqueta()) == null) {
                conjunto.insertarOrdenado((Nodo)nodoActual);
            }
            nodoActual = nodoActual.getSiguiente();
        }
        
        return conjunto;    
    }

    @Override
    public Conjunto diferencia(Conjunto otroConjunto) {
        Conjunto<T> conjunto = new Conjunto();
        
        if (this.esVacia() || otroConjunto.esVacia()) return this;
        
        INodo nodoActual = this.primero;
        while(nodoActual != null) {
            if(otroConjunto.buscar(nodoActual.getEtiqueta()) == null) {
                conjunto.insertarOrdenado((Nodo)nodoActual);
            }
            nodoActual = nodoActual.getSiguiente();
        }
     
        return conjunto;
    }
    
}
