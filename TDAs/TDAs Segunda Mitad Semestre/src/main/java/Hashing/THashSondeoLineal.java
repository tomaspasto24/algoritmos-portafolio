/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hashing;

import TArbolTrie.TNodo;

/**
 *
 * @author nmais
 */
public class THashSondeoLineal implements IHash {

    private final Integer[] arr;

    public THashSondeoLineal(int capacidad) {
        this.arr = new Integer[capacidad];
    }

    @Override
    public int insertar(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[hash] == null) {
                //TNodoHash<Integer> xInsertar = new TNodoHash<>(unaClave, unaClave);
                this.arr[hash] = unaClave;
                return i + 1;
            } else if (this.arr[hash].equals(unaClave)) {
                return i + 1;
            }
            hash = (hash + 1) % this.arr.length;
        }
        return this.arr.length;
    }
    
    @Override
    public boolean seInserto(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        for (Integer arr1 : this.arr) {
            if (this.arr[hash] == null) {
                //TNodoHash<Integer> xInsertar = new TNodoHash<>(unaClave, unaClave);
                this.arr[hash] = unaClave;
                return true;
            } else if (this.arr[hash].equals(unaClave)) {
                break;
            }
            hash = (hash + 1) % this.arr.length;
        }
        return false;
    }
    
    @Override
    public int funcionHashing(int unaClave) {
        return (int) (this.arr.length * (((float) unaClave / 7) % 1));
    }

    @Override
    public int buscarComparaciones(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[hash] == null) {
                return i + 1;
            } else if (this.arr[hash].equals(unaClave)) {
                return i + 1;
            }
            hash = (hash + 1) % this.arr.length;
        }
        return this.arr.length;
    }

    /*
    Retorna la poscion del array en la que se encuentra el nodo con la clave
    buscada.
    En caso de no encontrarla retorna -1.
    */
    @Override
    public int buscarPosicion(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        for (Integer arr1 : this.arr) {
            if (this.arr[hash] == null) {
                break;
            } else if (this.arr[hash].equals(unaClave)) {
                return hash;
            }
            hash = (hash + 1) % this.arr.length;
            hash = (hash + 1) * hash % this.arr.length;
        }
        return -1;
    }

     /*
    Retorna la clave en caso de encontrarla.
    En caso de no encontrarla retorna -1.
     */
    @Override
    public int buscarNodo(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        for (Integer arr1 : this.arr) {
            if (this.arr[hash] == null) {
                break;
            } else if (this.arr[hash].equals(unaClave)) {
                return this.arr[hash];
            }
            hash = (hash + 1) % this.arr.length;
        }
        return -1;
    }

    

    @Override
    public boolean buscar(int unaClave) {
        int hash = this.funcionHashing(unaClave);
        for (Integer arr1 : this.arr) {
            if (this.arr[hash] == null) {
                break;
            } else if (this.arr[hash].equals(unaClave)) {
                return true;
            }
            hash = (hash + 1) % this.arr.length;
        }
        return false;
    }
    /*
    Retorna siempre null ya que no tenemos objetos de tipo TNodo.
    Esto es para la implementacion THashEncadenamientoSeparado
    */

    @Override
    public TNodo buscarNodoEnLista(int unaClave) {
        return null;
    }

    @Override
    public int cantidadElementos() {
        int cant = 0;
        for (Integer arr1 : this.arr) {
            if(arr1 != null)
            {
                cant ++;
            }
        }
        return cant;
    }
    
}
