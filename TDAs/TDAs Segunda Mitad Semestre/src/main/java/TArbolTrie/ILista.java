package TArbolTrie;

public interface ILista<T> {

    /**
     * Metodo encargado de agregar un nodo al final de la lista. Se permite agregar elementos repetidos.
     * Para ello, se recorre la lista hasta el ultimo elemento y se "engancha" el nodo al final
     * Precondiciones: El nodo pasado por parametro no puede ser null
     * Postcondiciones: El resto de los elementos de la lista quedaran intactos en cuanto a orden y a contentido
     *
     * @param nodo - Nodo a agregar
     */
    public void insertar(TNodo<T> nodo);

    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada. En caso de haber mas de un elemento con la misma clave, se retornaara el primero encontrado.
     * Para ello, se recorrera la lista hasta que un nodo coincida en clave con la pasada por parametro. Una vez se encuentre dicho nodo se retornara.
     * Precondiciones:
     * Postcondiciones: No cambiara el orden ni contenido de los elementos de la lista.
     *                  El nodo buscado no se sacara de la lista.
     *
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public TNodo<T> buscar(Comparable clave);

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada. En caso de haber mas de un elemento con la misma clave, unicamente se eliminara el primero que se encunetre con la misma.
     * Para ello, se recorrera la lista de manera que una vez encontrado el nodo a eliminar (A parir de su clave), se "engancha" el anterior de dicho nodo con el siguiente de dicho nodo.
     * Precondiciones:
     * Postcondiciones: La lista cambiara ya que se eliminara el elemento, en caso de ser encontrado.
     *                  Unicamente se retorna ture si se elimino o no.    (Personalmente, considero que este metodo deberia retornar el nodo encontrado)
     *                  
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminaci�n haya sido efectuada con �xito.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Metodo encargado de imprimir en consola las claves de los nodos contenidos en la lista.
     * Para ello, se recorre la lista y se imprmie la clave que tiene cada nodo. En caso de que la lista este vacia, se imprime "".
     * Precondiciones:
     * Postcondiciones: La lista no cambia ni de orden ni de contenido de los nodos.
     *                  
     * @return 
     */
    public String imprimir();

    /**
     * Retorna un String con las claves separadas por el separador pasado por par�metro.
     * Para ello, se recorre la lista, se concaneta al string la clave de cada nodo y el separador pasado por parametro. En caso de que la lista este vacia, se retorna "".
     * Precondiciones:
     * Postcondiciones: La lista queda intacta, no sufre ningun cambio de orden ni de contenido.
     * @param separador Separa las claves
     * @return  Se retorna un string el cual contiene las claves de cada nodo y el separador previamente. Ejemplo con separador "/": clave1/clave2/..../etc
     */
    public String imprimir(String separador);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista este vac�a, retornar 0.
     * Para ello, recorre la lista con un nodo auxiliar para no modificarla. Por cada nodo de la lista que recorre, sube 1 a un contador de elementos.
     * Precondiciones: 
     * Postcondiciones: La lista no se modifica en los absoluto. El orden se mantiene y el contenido de cada nodo tambien.
     * 
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Indica si la lista contiene o no elementos.
     * Para ello, verifica si el primero es null.
     * Precondiciones:
     * Postcondiciones: Retorna True en caso de que primero = null. En caso contrario se retorna false.
     * 
     * @return Si tiene elementos o no.
     */
    public boolean esVacia();
    
    /**
     * Le asigna al primero de la lista el nodo pasado por parametro. 
     * Precondicion: 
     * Postcondicion: Se deja la lista con un unico elemento (el nodo pasado por parametro) en caso de que la lista este vacia.
     *                En caso de que la lista no este vacia, se agrega al principio y se desplazan los otros elementos.
     * @param unNodo 
     */
    public void setPrimero( TNodo<T> unNodo);
    
    /**
     * Retorna el primer elemento de la lista.
     * Precondicion:
     * Postcondicion: Se retorna el primer elemento de la lista en caso de que sea distinto de null, en caso de que sea una lista vacia, se retorna null.
     *
     * @return el primer nodo de la lista
     */
    public TNodo<T> getPrimero();

    public int eliminarDuplicados(Comparable clave);
}
