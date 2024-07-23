package TArbolTrie;

import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        palabra = comprobar(palabra);
        raiz.insertar(palabra);
    }

    private String comprobar(String cadena) {
        cadena = cadena.toLowerCase();
        char[] partes = cadena.toCharArray();
        StringBuilder string = new StringBuilder();
        int cont = 0;

        for (char c : partes) {
            int index = c - 'a';
            if (index >= 0 && index <= 25) {
                string.append(c);
            }
        }
        return string.toString();
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz != null) {
            palabra = comprobar(palabra);
            return raiz.buscar(palabra);
        }
        return 0;
    }

    @Override
    public int buscarRecursivo(String palabra) {
        if (this.raiz != null) {
            palabra = comprobar(palabra);
            return this.raiz.buscarRecursivo(palabra, 0, 1);
        }
        return 0;
    }

    @Override
    public void insertarConPagina(String unaPalabra, int pagina) {
        if (this.raiz != null) {
            unaPalabra = comprobar(unaPalabra);
            this.raiz.insertarConPagina(unaPalabra, pagina);
        }
    }

    @Override
    public void construirIndice(String unaPalabra, int pagina) {
        if (this.raiz != null) {
            this.raiz.construirIndice(unaPalabra, pagina);
        }
    }

    @Override
    public TNodoTrie buscarPalabra(String s) {
        if (this.raiz != null) {
            s = comprobar(s);
            return this.raiz.buscarPalabra(s);
        }
        return null;
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        if (this.raiz != null) {
            LinkedList<String> palabras = new LinkedList<>();
            prefijo = comprobar(prefijo);
            this.raiz.predecir(prefijo, palabras);
            if(palabras.size() <=0)
            {
                return null;
            }
            return palabras;
        }
        return null;
    }

    @Override
    public void indizarLibro(String archivoLibro) {
        if (this.raiz != null) {
            this.raiz.indizarLibro(archivoLibro);
        }
    }

    @Override
    public TNodoTrie buscarPrefijo(String s) {
        if (this.raiz != null) {
            s = comprobar(s);
            return this.raiz.buscarPrefijo(s);
        }
        return null;
    }

    @Override
    public int cantPalabras() {
        if(this.raiz != null)
        {
            return this.raiz.cantPalabras();
        }
        return 0;
    }

}
