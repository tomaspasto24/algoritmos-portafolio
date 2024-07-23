package TArbolTrieHashMap;

import TArbolTrieHashMap.INodoTrieHashMap;
import java.util.Collection;
import java.util.LinkedList;
import java.util.HashMap;

public class TNodoTrieHashMap implements INodoTrieHashMap {

    private char letra;
    private HashMap<Comparable, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap(char pLetra) {
        letra = pLetra;
        hijos = new HashMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap actual = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            TNodoTrieHashMap nodo = new TNodoTrieHashMap(unaPalabra.charAt(c));
            if (c + 1 == unaPalabra.length()) {
                nodo.esPalabra = true;
            }
            if (!actual.hijos.containsKey(unaPalabra.charAt(c))) {
                actual.hijos.put(unaPalabra.charAt(c), nodo);
            }
            actual = actual.hijos.get(unaPalabra.charAt(c));
        }
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            Collection siguientes = nodo.hijos.values();
            for (var aux : siguientes) {
                if (aux != null) {
                    TNodoTrieHashMap xNodo = (TNodoTrieHashMap) aux;
                    imprimir(s + xNodo.letra, xNodo);
                }
            }
        }
    }

    @Override
    public void imprimir() {

        imprimir("", this);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (null != null) {
                if (nodo.hijos.containsKey(s.charAt(c))) {
                    return null;
                }
            }
            nodo = nodo.hijos.get(s.charAt(c));
        }
        return nodo;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo.esPalabra) {
            palabras.add(s);
        }
        Collection siguientes = nodo.hijos.values();
        for (var aux : siguientes) {
            if (aux != null) {
                TNodoTrieHashMap xNodo = (TNodoTrieHashMap) aux;
                predecir(s + xNodo.letra, palabras, xNodo);
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap aux = this.buscarNodoTrie(prefijo);
        if (aux != null) {
            aux.predecir(prefijo, palabras, aux);
        }
    }

    @Override
    public int buscar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
