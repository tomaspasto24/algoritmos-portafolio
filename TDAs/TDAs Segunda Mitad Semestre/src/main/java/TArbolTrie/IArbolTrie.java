package TArbolTrie;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface IArbolTrie {

    
     

    //Imprmie el la letra de cada nodo y las paginas en caso de ser palabra 
    void imprimir();
    /*
    Insertar una palabra en el trie.
    Precondicion: No insertar palabras repetidas.
    */
    void insertar(String unaPalabra);

    //Insertar una palabra y la pagina en la que se encuentra.
    void insertarConPagina(String unaPalabra, int pagina);

    //Dada una palabra, le agregamos una pagina.
    void construirIndice(String unaPalabra, int pagina);

    /*
    Devuelve el ultimo nodo de la palabra pasada por parametro.
    En caso de que no este, retorna null
    */
    TNodoTrie buscarPalabra(String unaPalabra);
    
    /*
    Devuelve el ultimo nodo del prefijo a buscar. 
    Si el prefijo no esta, retorna null.
    */
    TNodoTrie buscarPrefijo(String prefijo);
    
    //Devuelve la cantidad de comparaciones. Usando un metodo iterativo.
    int buscar(String s);
    
    /*
    Devuelve la cantidad de comparaciones. Usando un metodo recursivo
    */
    int buscarRecursivo(String palabra);

    /*
    Retorna una lista de con todas las palabras que contienen como prefijo al pasado por parametro
    */
    LinkedList<String> predecir(String prefijo);
    
    /*
    Dado un libro, le agrega a todas las palabras del trie en que pagina se encuentran.
    */
    void indizarLibro(String archivoLibro);

    /*
    Devuelve la cantidad de palabras que tiene el trie.
    */
    int cantPalabras();
    
    
}
