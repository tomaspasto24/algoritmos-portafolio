/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Hashing;

import TArbolTrie.TNodo;

/**
 *
 * @author nmais
 */
public interface IHash {
    
    public int buscarComparaciones(int unaClave);
    
    public boolean buscar(int unaClave);
    
    public int buscarPosicion(int unaClave);
    
    public int buscarNodo(int unaClave);
    
    public TNodo buscarNodoEnLista(int unaClave);
    
    public int insertar(int unaClave);
    
    public boolean seInserto(int unaClave);
    
    public int funcionHashing(int unaClave);
    
    public int cantidadElementos();

}
