/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColaCircular;

/**
 *
 * @author juan-
 */
public class ColaCircular<T> {
    
    public Nodo[] cola = new Nodo[3];
    private int prox = 0;
    private int primero = 0;
    private int cont = 0;
    
    public boolean esVacia(){
        return cont == 0;
    }
    
    public boolean esLlena(){
        return cont == cola.length; 
    }
    
    public boolean insertar(Nodo elem){
        if (!this.esLlena()){
            cola[prox] = elem;
            prox = (prox + 1) % cola.length;
            cont ++;
            return true;
        }
        return false;
    }
    
    public boolean eliminar(){
        if (!this.esVacia()){
            cola[primero] = null;
            primero = (primero + 1) % cola.length;
            cont --;
            return true;
        }
        return false;
    }
    
    public Nodo<T> buscarEtiqueta(Comparable etiqueta){
        if (!this.esVacia()){
            for (int i = 0; i < cola.length; i++){
                if (cola[i] != null){
                    Nodo elem = cola[i];
                    if (elem.getEtiqueta().equals(etiqueta)){
                        return elem;
                    }
                }
            }
        }
        return null;
    }
    
    public Nodo<T> buscarIndice(int indice){
        if (!this.esVacia()){
            if (indice >= 0 && indice < cola.length){
                return cola[indice];
            }
            return null;
        }
        return null;
    }
    
    public String imprimir(String separador) {
        String aux = "";
        if (this.esVacia()) {
            return "";
        } 
        else {
            for (int i = 0; i < cola.length; i++){
                if (cola[i] != null){
                    Nodo elem = cola[i];
                    aux = aux + elem.getEtiqueta()+ separador;
                }
            }
            return aux;
        }
    }
    
     public int cantElementos() {
        int contador = 0;
            if (this.esVacia()) {
                return 0;
            } 
            else {
                for (int i = 0; i < cola.length; i++){
                    if (cola[i] != null){
                        contador ++;
                    }
                }
            }
        return contador;
    }
}
