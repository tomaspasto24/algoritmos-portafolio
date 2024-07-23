package Conjunto;


/**
 *
 * @author ernesto
 * @param <T>
 */
public interface IConjunto<T> {
    public Conjunto union (Conjunto otroConjunto);

    public Conjunto interseccion (Conjunto otroConjunto);
    
    //Elementos que contienen a uno u otro, no ambos
    public Conjunto diferenciaSimetrica (Conjunto otroConjunto);
    
    // Seria todos los objetos que estan en this pero no en otroConjunto.
    public Conjunto diferencia (Conjunto otroConjunto);
    
    public Conjunto complemento (Conjunto conjuntoUniversal);
}
