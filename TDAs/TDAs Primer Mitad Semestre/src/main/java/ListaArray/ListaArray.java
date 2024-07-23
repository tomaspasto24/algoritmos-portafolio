/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaArray;

/**
 *
 * @author juan-
 */
public class ListaArray<T> {
    
    public Nodo[] lista = new Nodo[10];
    private Nodo<T> primero = null;
    private int indice = 0;
    
    public boolean esVacia(){
        return this.primero == null;
    }
    
    public boolean esLlena(){
        return (this.buscarIndice(lista.length - 1) != null);
    }
    
    public boolean insertar(Nodo elem){
        if (indice == 0){
            lista[indice] = elem;
            primero = elem;
            indice ++;
            return true;
        }
        if (!this.esLlena()){
            lista[indice] = elem;
            indice ++;
            return true;
        }
        else{
            this.redimensionar();
            lista[indice] = elem;
            indice ++;
            return true;
        }
    }
    
    public boolean eliminarIndice(int ind){
        if (!this.esVacia()){
            if (ind >= 0 && ind < lista.length){
                //lista[ind] = null;
                this.reacomodar(ind);
                indice--;
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean eliminarEtiqueta(Comparable etiqueta){
        if(!this.esVacia()){
           for (int i = 0; i < lista.length; i++){
                if (lista[i] != null){
                    Nodo elem = lista[i];
                    if (elem.getEtiqueta().equals(etiqueta)){
                        //lista[i] = null;
                        this.reacomodar(i);
                        indice--;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public Nodo<T> buscarEtiqueta(Comparable etiqueta){
        if (!this.esVacia()){
            for (int i = 0; i < lista.length; i++){
                if (lista[i] != null){
                    Nodo elem = lista[i];
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
            if (indice >= 0 && indice < lista.length){
                return lista[indice];
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
            for (int i = 0; i < lista.length; i++){
                if (lista[i] != null){
                    Nodo elem = lista[i];
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
                for (int i = 0; i < lista.length; i++){
                    if (lista[i] != null){
                        contador ++;
                    }
                }
            }
        return contador;
    }
    
    private void redimensionar(){
        Nodo[] lista2 = new Nodo[lista.length * 2];
        
        for (int i = 0; i < lista.length; i++ ){
            lista2[i] = lista[i];
        }
        lista = lista2;
    }
    
    private void reacomodar(int ind2){
       for (int i = ind2; i < lista.length; i++){
           if (lista[i] == null){
               break;
           }
           lista[i] = lista[i+1];
        }   
    }

}
