package TArbolTrieHashMap;
import TArbolTrieHashMap.TNodoTrieHashMap;
import java.util.LinkedList;


public class TTrieHashMap implements ITrieHashMap {

    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap(' ');
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> lista = new LinkedList();
        if(raiz != null) {
            raiz.predecir(prefijo, lista);
        }
        return lista;
    }
    
    
}
