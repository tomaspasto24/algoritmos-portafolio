/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TArbolGenerico;

/**
 *
 * @author nmais
 */
public interface INodoArbolGenerico<T> {
    
    public TNodoArbolGenerico<T> buscar(Comparable etiqueta);
    
    public boolean insertar(Comparable etiqueta, Comparable etiquetaPadre);
    
    public boolean insertar(TNodoArbolGenerico<T> nodo, Comparable etiquetaPadre);
    
    public String listarIndentado();
    
    public int cantElementos();
    
    public TNodoArbolGenerico<T> getPrimerHijo();
    
    public TNodoArbolGenerico<T> getSigHermano();
    
    public void setSigHermano(TNodoArbolGenerico hermano);
    
    public void setPrimerHijo(TNodoArbolGenerico hijo);
    
    public Comparable getEtiqueta();

    public T getDato();
}
