package ArbolBB;

public interface IElementoAB<T> {

   
    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public ElementoAB<T> getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public ElementoAB<T> getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(ElementoAB<T> elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(ElementoAB<T> elemento);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public Tupla<ElementoAB<T>, Integer> buscar(Comparable unaEtiqueta);

 

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public Tupla<Boolean, Integer> insertar(ElementoAB<T> elemento);

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden();

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @return String conteniendo el PostOrden
     */
    public String postOrden();

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos();
	
	 /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta
     * @return 
     */
    public ElementoAB<T> eliminar(Comparable unaEtiqueta);
    
    public int altura();
    
    public int tamanio();

    public int cantHojas();

    public int nivelDe(Comparable etiqueta);

    public Comparable obtenerMenorClave();

    public Comparable obtenerMayorClave();

    public Comparable obtenerClaveAnteriorADada(Comparable clave);

    public Integer cantidadNodosPorAltura(int altura);

    public void listarHojasConNivel(int nivel);

    public boolean verificarSiEsBusqueda();
    
    public IElementoAB<T> duplicar();
    
    public int cantidadDeAristas();
    
    public int cantidadDeNodos();  
    
    public int cantNodosInternosCompletos();
    
    public boolean verificarSiEsCompleto();
    
    public boolean verificarSiSonHermanos(Comparable elemento1, Comparable elemento2);
}

