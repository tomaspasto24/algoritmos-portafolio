/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TomasUcu
 */
public class ListaOrdenada<T> implements ILista<T> {
    
    protected INodo<T> primero;
    
    public ListaOrdenada() {
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        insertarOrdenado(nodo);
    }

    @Override
    public Nodo buscar(Comparable clave) {
        if(primero == null) {
            return null;
        }
        
        INodo nodoActual = primero;
        while(nodoActual != null) {
            if(nodoActual.getEtiqueta().equals(clave)) {
                return (Nodo)nodoActual;
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
        
        INodo<T> nodoActual = this.primero;
        INodo<T> nodoProx = nodoActual.getSiguiente();
        
        if(nodoActual.getEtiqueta().equals(clave)) {
            this.setPrimero((Nodo)nodoProx);
            nodoActual.setSiguiente(null);
            return true;
        }
        
        while(nodoProx != null) {
            if(nodoProx.getEtiqueta().equals(clave)) {
                nodoActual.setSiguiente(nodoProx.getSiguiente());
                nodoProx.setSiguiente(null);
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
        
        INodo nodoActual = this.primero;
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
        
        INodo nodoActual = this.primero;
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
        INodo nodoActual = this.primero;
        
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
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public Nodo retornarPrimero() {
        return (Nodo)this.primero;
    }
    
    public boolean insertarOrdenado(Nodo<T> nodo) {
        Nodo<T> nodoInsertar = nodo.clone();
        if(this.primero == null) {
            this.primero = nodoInsertar;
            primero.setSiguiente(null);
            return true;
        } else {
            
            INodo nodoActual = this.primero;            
            if(nodoActual.getEtiqueta().compareTo(nodoInsertar.getEtiqueta()) >= 0) {
                nodoInsertar.setSiguiente((Nodo)this.primero);
                this.primero = nodoInsertar;
                return true;
            }
            
            while(nodoActual.getSiguiente() != null) {
                if(nodoActual.getSiguiente().getEtiqueta().compareTo(nodoInsertar.getEtiqueta()) > 0) {
                    nodoInsertar.setSiguiente(nodoActual.getSiguiente());
                    nodoActual.setSiguiente((Nodo)nodoInsertar);
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            nodoInsertar.setSiguiente(null);
            nodoActual.setSiguiente((Nodo)nodoInsertar);
            return true;
        }
    }
    
    public ListaOrdenada<T> concatenarListaOrdenada(ListaOrdenada<T> lista) {
        ListaOrdenada<T> otraLista = lista;
        
        INodo<T> nodoActual = primero;
        while(nodoActual != null) {
            if(otraLista.buscar(nodoActual.getEtiqueta()) == null) {
                otraLista.insertarOrdenado((Nodo<T>)nodoActual);
            }
            nodoActual = nodoActual.getSiguiente();
        }
        
        return otraLista;
        
    }
}
