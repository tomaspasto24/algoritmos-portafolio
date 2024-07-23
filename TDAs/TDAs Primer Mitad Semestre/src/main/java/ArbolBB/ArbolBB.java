/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBB;

/**
 *
 * @author santi
 * @param <T>
 */
public class ArbolBB<T> implements IArbolBB<T> {
    
    protected ElementoAB<T> raiz;
    
    public ArbolBB() {
        this.raiz = null;
    }
    
    public ArbolBB(ElementoAB raiz) {
        super();
        this.raiz = raiz;
    }
    
    /**
     * Intenta insertar un elemento en el árbol,
     * imprimiendo la cantidad de llamadas recursivas para ello.
     * @param unElemento El elemento.
     * @return true si el elemento ha sido insertado.
     */
    @Override
    // Hay que hacer que devuelva una Tupla<Boolean, Integer> también
    public Tupla<Boolean, Integer> insertar(ElementoAB<T> unElemento) {
        if(raiz == null)
        {
            raiz = unElemento;
            System.out.println(1);
            return new Tupla<>(true, 1);
        }
        else
        {
            var res = raiz.insertar(unElemento);
            if (!res.primero) {
                res.segundo = 0;
                return res;
            }
            res.segundo++;
            System.out.println(res.segundo);
            return res;
        }
    }

    @Override
    public Tupla<ElementoAB<T>, Integer> buscar(Comparable unaEtiqueta) {
        if (raiz != null) {
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public String preOrden() {
        if (this.raiz != null) {
            return this.raiz.preOrden();
        }
        return "";
    }

    @Override
    public String inOrden() {
        if (this.raiz != null) {
            return this.raiz.inOrden();
        }
        return "";
    }

    @Override
    public String postOrden() {
        if (this.raiz != null) {
            return this.raiz.postOrden();
        }
        return "";
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return;
        }
        raiz = raiz.eliminar(unaEtiqueta);
    }
    
    @Override
    public int altura() {
        if (this.raiz != null) {
            return this.raiz.altura();
        }
        return -1;
    }
    
    @Override
    public int tamanio() {
        if (this.raiz != null) {
            return this.raiz.tamanio();
        }
        return 0;
    }
    
    @Override
    public int cantHojas() {
        if (this.raiz != null) {
            return this.raiz.cantHojas();
        }
        
        return 0;
    }
    
    @Override
    public int nivelDe(Comparable etiqueta) {
        if (this.raiz != null) {
            return this.raiz.nivelDe(etiqueta);
        }
        return -1;
    }
    
    public Comparable obtenerMenorClave() {
        if(raiz != null) {
            return raiz.obtenerMenorClave();
        }
        return null;
    }
    
    public Comparable obtenerMayorClave() {
        if(raiz != null) {
            return raiz.obtenerMayorClave();
        }
        return null;
    }

    public Comparable obtenerClaveAnteriorADada(Comparable clave) {
        if(raiz != null) {
            return raiz.obtenerClaveAnteriorADada(clave);
        }
        return null;
    }
    
    public Integer cantidadNodosPorAltura(int altura) {
        if(raiz != null) {
            return raiz.cantidadNodosPorAltura(altura);
        }
        return null;        
    }
    
    public void listarHojasConNivel() {
        if(raiz != null) {
            raiz.listarHojasConNivel(0);
        }
    }
    
    public boolean verificarSiEsBusqueda() {
        if(raiz != null) {
            return raiz.verificarSiEsBusqueda();
        }
        return false;
    }

    @Override
    public IArbolBB<T> duplicar() {
        return new ArbolBB<>(raiz);
    }
    
    @Override
    public int cantidadDeAristas() {
        if(raiz != null) {
            return raiz.cantidadDeAristas();
        }
        return 0;
    }
    
    @Override
    public int cantidadDeNodos() {
        if(raiz != null) {
            return raiz.cantidadDeNodos();
        }
        return 0;
    }

    @Override
    public int cantNodosInternosCompletos() {
        if(raiz != null) {
            return raiz.cantNodosInternosCompletos();
        }
        return 0;
    }

    @Override
    public boolean verificarSiEsCompleto() {
        if(raiz != null) {
            return raiz.verificarSiEsCompleto();
        }
        return false;
    }

    @Override
    public boolean verificarSiSonHermanos(Comparable elemento1, Comparable elemento2) {
        if(raiz != null && !elemento1.equals(elemento2)) {
            return raiz.verificarSiSonHermanos(elemento1, elemento2);
        }
        return false;
    }
}
