/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut3_ta2_ej1;

/**
 *
 * @author TomasUcu
 */
public class ListaOrdenada<T> extends Lista<T> {
    
    public void insertarOrdenado(Nodo<T> nodo) {
        if (this.esVacia()) {
            return;
        }
        
        Nodo<T> aux = primero;
        while(aux.getSiguiente() != null) {
            int comp = aux.compareTo(nodo.getEtiqueta());
            if (comp > 0) {
                nodo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nodo);
            }
            aux = aux.getSiguiente();
        }
    }
    
}
