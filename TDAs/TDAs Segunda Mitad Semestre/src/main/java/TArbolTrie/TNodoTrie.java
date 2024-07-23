package TArbolTrie;

import TArbolTrie.INodoTrie;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    //DECLARO EL LARGO DEL ABECEDARIO
    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private ILista<Integer> paginas;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        paginas = new TLista();
        esPalabra = false;
    }

    /*
    ESTA PENSADO PARA HACERLO CON UN ABECEDARIO DE 26 LETRAS.
    Dada una palabra la inserta en el trie. Al ultimo nodo le asigna que es fin de palabra
    Si la palabra ya existe, no la cambia.
     */
    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (indice >= 0 && indice < CANT_CHR_ABECEDARIO) {
                if (nodo.hijos[indice] == null) {
                    nodo.hijos[indice] = new TNodoTrie();
                }
                nodo = nodo.hijos[indice];
            }

        }
        nodo.esPalabra = true;
    }

    @Override
    public void insertarConPagina(String unaPalabra, int pagina) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (indice >= 0 && indice < CANT_CHR_ABECEDARIO) {
                if (nodo.hijos[indice] == null) {
                    nodo.hijos[indice] = new TNodoTrie();
                }
                nodo = nodo.hijos[indice];
            }

        }
        nodo.esPalabra = true;
        nodo.paginas.insertar(new TNodo<>(pagina, pagina));
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                String pagAparece = " ";
                if (nodo.paginas.esVacia() == false) {
                    TNodo aux = nodo.paginas.getPrimero();
                    while (aux != null) {
                        if (aux.getSiguiente() != null) {
                            pagAparece += aux.getEtiqueta().toString() + ",";
                        } else {
                            pagAparece += aux.getEtiqueta().toString();
                        }
                        aux = aux.getSiguiente();
                    }
                }
                System.out.println(s + pagAparece);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private void predecirAux(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo.esPalabra) {
            palabras.add(s);
        }
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (nodo.hijos[c] != null) {
                predecirAux(s + (char) (c + 'a'), palabras, nodo.hijos[c]);
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie aux = this.buscarPrefijo(prefijo);
        if (aux != null) {
            aux.predecirAux(prefijo, palabras, aux);
        }
    }

    @Override
    public int buscar(String s) {
        int cont = 0;
        TNodoTrie nodoActual = this;
        char[] partes = s.toCharArray();
        for (char m : partes) {
            TNodoTrie unHijo = nodoActual.obtenerHijo(m);
            cont++;
            if (unHijo != null) {
                nodoActual = unHijo;
            } else {
                return cont;
            }
        }
        if (nodoActual.esPalabra) {
            return cont;
        } else {
            return 0;
        }
    }

    @Override
    public TNodoTrie buscarPalabra(String s) {
        TNodoTrie nodoActual = this;
        char[] partes = s.toCharArray();
        for (char m : partes) {
            TNodoTrie unHijo = nodoActual.obtenerHijo(m);
            if (unHijo != null) {
                nodoActual = unHijo;
            }
            else
            {
                return null;
            }
        }
        if (nodoActual.esPalabra) {
            return nodoActual;
        } else {
            return null;
        }
    }

    @Override
    public TNodoTrie buscarPrefijo(String s) {
        TNodoTrie nodoActual = this;
        char[] partes = s.toCharArray();
        String validacion = "";
        for (char m : partes) {
            TNodoTrie unHijo = nodoActual.obtenerHijo(m);
            if (unHijo != null) {
                nodoActual = unHijo;
                validacion += m;
            }
            else
            {
                return null;
            }
        }
        if (validacion.equals(s)) {
            return nodoActual;
        }
        return null;
    }

    @Override
    public TNodoTrie obtenerHijo(char m) {
        int index = m - 'a';
        if (index >= 0 && index <= 25) {
            return this.hijos[index];
        }
        return null;
    }

    @Override
    public int buscarRecursivo(String palabra, int indice, int longitud) {
        char c = palabra.charAt(indice);
        TNodoTrie nodoLetra = this.obtenerHijo(c);

        if (nodoLetra != null && this.esPalabra) {
            return longitud;
        }

        if (nodoLetra == null) {
            return 0;
        }

        return nodoLetra.buscarRecursivo(palabra, indice + 1, longitud + 1);
    }

    @Override
    public void construirIndice(String unaPalabra, int pagina) {
        TNodoTrie nodo = this.buscarPalabra(unaPalabra);
        if (nodo != null) {
            if (nodo.paginas.buscar(pagina) == null) {
                nodo.paginas.insertar(new TNodo<>(pagina, pagina));
            }
        }
    }

    @Override
    public void indizarLibro(String archivoLibro) {
        String[] lineasLibro = ManejadorArchivosGenerico.leerArchivo(archivoLibro);
        int pagina = 1;
        int lineas = 0;
        for (String linea : lineasLibro) {
            if (lineas == 50) {
                lineas = 0;
                pagina++;
            }
            String[] palabras = linea.split(" ");
            for (String palabra : palabras) {
                construirIndice(palabra, pagina);
            }
            lineas++;
        }
    }

    @Override
    public int cantPalabras() {
        int cont = 0;
        if (this.esPalabra) {
            cont++;
        }
        if (this.hijos != null) {
            for (int i = 0; i < CANT_CHR_ABECEDARIO; i++) {
                if (this.hijos[i] != null) {
                    cont += this.hijos[i].cantPalabras();
                }
            }
        }

        return cont;
    }
}
