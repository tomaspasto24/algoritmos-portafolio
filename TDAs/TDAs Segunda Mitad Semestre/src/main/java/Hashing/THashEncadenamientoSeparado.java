/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hashing;

import TArbolTrie.TNodo;
import TArbolTrie.TLista;

/**
 *
 * @author nmais
 */
public class THashEncadenamientoSeparado implements IHash {

    private final TLista[] arr;

    public THashEncadenamientoSeparado(int capacidad) {
        this.arr = new TLista[capacidad];
    }

    /*
    Retorno -1 si no esta en el hash. Si esta, retorno la cantidad de comparaciones que realizo.
     */
    @Override
    public int buscarComparaciones(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        TLista xLista = this.arr[hash];
        if (xLista == null) {
            return -1;
        } else if (xLista.esVacia()) {
            return -1;
        } else {
            return xLista.buscarComparaciones(unaClave);
        }
    }

    @Override
    public boolean buscar(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        TLista xLista = this.arr[hash];
        if (xLista == null) {
            return false;
        } else if (xLista.esVacia()) {
            return false;
        } else {
            TNodo encontrado = xLista.buscar(unaClave);
            return encontrado != null;
        }
    }

    /*
    Retorna -1 si no esta en el hash
     */
    @Override
    public int buscarPosicion(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        TLista xLista = this.arr[hash];
        if (xLista == null) {
            return -1;
        } else if (!xLista.esVacia()) {
            if (xLista.buscar(unaClave) != null) {
                return hash;
            }
        }
        return -1;
    }

    //Esta implementacion no tiene un TNodoHash
    @Override
    public int buscarNodo(int unaClave) {
        return -1;
    }

    @Override
    public TNodo buscarNodoEnLista(int unaClave) {

        int hash = this.funcionHashing(unaClave);
        TLista xLista = this.arr[hash];
        if (xLista == null) {
            return null;
        } else if (xLista.esVacia()) {
            return null;
        } else {
            TNodo encontrado = xLista.buscar(unaClave);
            return encontrado;
        }
    }

    /*
    Retorna -1 si no se inserto o 1 si se inserto.
     */
    @Override
    public int insertar(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        TLista xLista = this.arr[hash];
        if (xLista == null) {
            xLista = new TLista();
            TNodo xNodo = new TNodo(unaClave, unaClave);
            xLista.insertar(xNodo);
            this.arr[hash] = xLista;
            return 1;
        } else if (xLista.buscar(unaClave) == null) {
            TNodo xNodo = new TNodo(unaClave, unaClave);
            xLista.insertar(xNodo);
            return 1;
        }
        return -1;
    }

    @Override
    public boolean seInserto(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        TLista xLista = this.arr[hash];
        if (xLista == null) {
            xLista = new TLista();
            TNodo xNodo = new TNodo(unaClave, unaClave);
            xLista.insertar(xNodo);
            this.arr[hash] = xLista;
            return true;
        } else if (xLista.buscar(unaClave) == null) {
            TNodo xNodo = new TNodo(unaClave, unaClave);
            xLista.insertar(xNodo);
            return true;
        }
        return false;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return (int) (this.arr.length * (((float) unaClave / 7) % 1));
    }

    @Override
    public int cantidadElementos() {
        int cant = 0;
        for (TLista arr1 : this.arr) {
            if (arr1 != null) {
                cant += arr1.cantElementos();
            }
        }
        return cant;
    }

}
