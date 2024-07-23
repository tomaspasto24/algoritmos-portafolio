/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hashing;

/**
 *
 * @author nmais
 */
public class TNodoHash<T> {

    protected int etiqueta;
    protected T dato;

    public TNodoHash(int pEtiqueta, T pDato) {
        this.etiqueta = pEtiqueta;
        this.dato = pDato;
    }

    public int getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(int pEtiqueta) {
        this.etiqueta = pEtiqueta;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T pDato) {
        this.dato = pDato;
    }

    public TNodoHash clonar()
    {
        return new TNodoHash(this.etiqueta, this.dato);
    }
}
