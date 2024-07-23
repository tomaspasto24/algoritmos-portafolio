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
public interface INodoTrie {

    //Imprmie el la letra de cada nodo y las paginas en caso de ser palabra 
    void imprimir();

    //Insertar una palabra en el trie
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
    
    //Devuelve la cantidad de comparaciones
    int buscar(String s); 
    
    /*
    Devuelve la cantidad de comparaciones. Usando un metodo recursivo
    */
    int buscarRecursivo(String palabra, int indice, int longitud);

    /*
    Retorna una lista de con todas las palabras que contienen como prefijo al pasado por parametro
    */
    void predecir(String prefijo, LinkedList<String> palabras);
    
    /*
    Dado un libro, le agrega a todas las palabras del trie en que pagina se encuentran.
    */
    void indizarLibro(String archivoLibro);

    /*
    Devuelve el nodo en el que esta la letra pasada por parametro
    */
    TNodoTrie obtenerHijo(char m);
    
    /*
    Devuelve la cantidad de palabras que tiene el trie.
    */
    int cantPalabras();
    


}
