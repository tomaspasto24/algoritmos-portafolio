/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TArbolGenerico;

/**
 *
 * @author nmais
 */
public interface IArbolGenerico<T> {
    
    public INodoArbolGenerico<T> buscar(Comparable etiqueta);
    
    public boolean insertar(Comparable etiqueta, Comparable etiquetaPadre);
    
    public boolean insertar(TNodoArbolGenerico<T> nodo, Comparable etiquetaPadre);
    
    public String listarIndentado();
    
    public int cantElementos();
    
}
