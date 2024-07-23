/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TArbolGenerico;

/**
 *
 * @author nmais
 */
public class TArbolGenerico<T> implements IArbolGenerico {

    protected INodoArbolGenerico<T> raiz;

    public TArbolGenerico() {
        this.raiz = null;
    }

    @Override
    public INodoArbolGenerico buscar(Comparable etiqueta) {
        if (this.raiz != null) {
            return this.raiz.buscar(etiqueta);
        }
        return null;
    }

    // Insertar nodo con etiqueta y etiqueta del padre.
    @Override
    public boolean insertar(Comparable etiqueta, Comparable etiquetaPadre) {
        if (this.raiz != null) {
            return this.raiz.insertar(etiqueta, etiquetaPadre);
        }

        INodoArbolGenerico<T> nodo = new TNodoArbolGenerico(etiqueta, null);
        this.raiz = nodo;
        return true;
    }
    
    // Insertar nodo con etiqueta y etiqueta del padre.
    @Override
    public boolean insertar(TNodoArbolGenerico nodo, Comparable etiquetaPadre) {
        if (this.raiz != null) {
            return this.raiz.insertar(nodo, etiquetaPadre);
        }
        return false;
    }

    @Override
    public String listarIndentado() {
        if (this.raiz != null) {
            return this.raiz.listarIndentado();
        }
        return "";
    }

    @Override
    public int cantElementos() {
        if(this.raiz != null)
        {
            return this.raiz.cantElementos();
        }
        return 0;
    }

}
