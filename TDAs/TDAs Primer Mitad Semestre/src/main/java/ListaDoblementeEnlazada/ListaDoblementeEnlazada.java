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
public class ListaDoblementeEnlazada<T> implements ILista<T> {
    
    protected NodoDoblementeEnlazado<T> primero;
    
    public ListaDoblementeEnlazada() {
    }

    @Override
    public void insertar(NodoDoblementeEnlazado<T> nodo) {
        NodoDoblementeEnlazado<T> nodoInsertar = nodo.clone();
        if(this.primero == null) {
            this.primero = nodoInsertar;
            primero.setSiguiente(null);
            primero.setAnterior(null);
        } else {
            NodoDoblementeEnlazado<T> nodoActual = this.primero;
            while(nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoInsertar.setAnterior(nodoActual);
            nodoActual.setSiguiente(nodoInsertar);            
            nodoInsertar.setSiguiente(null);
        }
    }

    @Override
    public NodoDoblementeEnlazado buscar(Comparable clave) {
        if(primero == null) {
            return null;
        }
        
        NodoDoblementeEnlazado<T> nodoActual = primero;
        while(nodoActual != null) {
            if(nodoActual.getEtiqueta().equals(clave)) {
                return (NodoDoblementeEnlazado)nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if(primero == null) {
            return false;
        }       
        
        NodoDoblementeEnlazado<T> nodoActual = this.primero;
        NodoDoblementeEnlazado<T> nodoProx = nodoActual.getSiguiente();
        
        if(nodoActual.getEtiqueta().equals(clave)) {
            this.setPrimero((NodoDoblementeEnlazado)nodoProx);
            primero.setAnterior(null);
            nodoActual.setSiguiente(null);
            return true;
        }
        
        while(nodoProx != null) {
            if(nodoProx.getEtiqueta().equals(clave)) {
                nodoActual.setSiguiente(nodoProx.getSiguiente());
                if(nodoProx.getSiguiente() != null) nodoProx.getSiguiente().setAnterior(nodoActual);
                nodoProx.setSiguiente(null);
                nodoProx.setAnterior(null);
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
            nodoProx = nodoProx.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        if(this.primero == null) {
            return "Lista vacía.";
        }      
        
        String cadena = "";
        
        NodoDoblementeEnlazado<T> nodoActual = this.primero;
        while(nodoActual != null) {
            cadena = cadena + nodoActual.getEtiqueta().toString()+ ", ";
            nodoActual = nodoActual.getSiguiente();
        }
        return cadena.toString();
    }

    @Override
    public String imprimir(String separador) {
        if(primero == null) {
            return "Lista vacía.";
        }      
        
        String cadena = "";
        
        NodoDoblementeEnlazado<T> nodoActual = this.primero;
        while(nodoActual != null) {
            cadena = cadena + nodoActual.getEtiqueta().toString() + separador;
            nodoActual = nodoActual.getSiguiente();
        }
        return cadena.toString();
    }

    @Override
    public int cantElementos() {
        if(primero == null) {
            return 0;
        }      
        
        Integer cantidad = 0;
        NodoDoblementeEnlazado<T> nodoActual = this.primero;
        
        while(nodoActual != null) {
            cantidad++;
            nodoActual = nodoActual.getSiguiente();
        }
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return (this.primero == null) ? true : false; 
    }

    @Override
    public void setPrimero(NodoDoblementeEnlazado<T> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public NodoDoblementeEnlazado retornarPrimero() {
        return (NodoDoblementeEnlazado)this.primero;
    }
    
    public boolean insertarOrdenado(NodoDoblementeEnlazado<T> nodo) {
        NodoDoblementeEnlazado<T> nodoInsertar = nodo.clone();
        if(this.primero == null) {
            this.primero = nodoInsertar;
            primero.setSiguiente(null);
            primero.setAnterior(null);
            return true;
        } else {
            
            NodoDoblementeEnlazado<T> nodoActual = this.primero;            
            if(nodoActual.getEtiqueta().compareTo(nodoInsertar.getEtiqueta()) >= 0) {
                this.primero.setAnterior(nodoInsertar);
                nodoInsertar.setSiguiente((NodoDoblementeEnlazado)this.primero);
                nodoInsertar.setAnterior(null);
                this.primero = nodoInsertar;
                return true;
            }
            
            while(nodoActual.getSiguiente() != null) {
                if(nodoActual.getSiguiente().getEtiqueta().compareTo(nodoInsertar.getEtiqueta()) > 0) {
                    nodoActual.getSiguiente().setAnterior(nodoInsertar);
                    nodoInsertar.setSiguiente(nodoActual.getSiguiente());
                    nodoInsertar.setAnterior(nodoActual);
                    nodoActual.setSiguiente((NodoDoblementeEnlazado)nodoInsertar);
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            nodoInsertar.setSiguiente(null);
            nodoInsertar.setAnterior(nodoActual);
            nodoActual.setSiguiente((NodoDoblementeEnlazado)nodoInsertar);
            return true;
        }
    }
    
    public ILista<T> eliminarDuplicados() {
        ILista<T> listaSinDuplicados = new ListaDoblementeEnlazada<>();
        
        NodoDoblementeEnlazado<T> nodoActual = primero;
        while(nodoActual != null) {
            if(listaSinDuplicados.buscar(nodoActual.getEtiqueta()) == null) {
                listaSinDuplicados.insertar((NodoDoblementeEnlazado<T>)nodoActual);
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return listaSinDuplicados;
    }
    
    public ILista<T> concatenarLista(ILista<T> lista) {
        ILista<T> otraLista = lista;
        NodoDoblementeEnlazado<T> nodoActual = primero;
        while(nodoActual != null) {
            if(otraLista.buscar(nodoActual.getEtiqueta()) == null) {
                otraLista.insertar((NodoDoblementeEnlazado<T>)nodoActual);
            }
            nodoActual = nodoActual.getSiguiente();
        }
        
        return otraLista;
    }
}
