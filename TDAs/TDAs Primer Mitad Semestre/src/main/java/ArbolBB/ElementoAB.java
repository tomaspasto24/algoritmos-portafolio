/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBB;

/**
 *
 * @author santi
 */
public class ElementoAB<T> implements IElementoAB<T> {
    private Comparable etiqueta;
    private T datos;
    private ElementoAB<T> hijoIzq;
    private ElementoAB<T> hijoDer;

    public ElementoAB (Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    
    public ElementoAB (Comparable etiqueta, T datos, ElementoAB<T> hijoIzq, ElementoAB<T> hijoDer) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }
    
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public ElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public ElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(ElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(ElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public Tupla<ElementoAB<T>, Integer> buscar(Comparable unaEtiqueta) {
        return this.buscar(unaEtiqueta, 0);
    }
        
    private Tupla<ElementoAB<T>, Integer> buscar(Comparable unaEtiqueta, int prof) {
        int comp = this.etiqueta.compareTo(unaEtiqueta);
        if (comp < 0) {
            if (this.hijoDer == null) {
                return null;
            }
            return this.hijoDer.buscar(unaEtiqueta, prof + 1);
        } else if (comp > 0) {
            if (this.hijoIzq == null) {
                return null;
            }
            return this.hijoIzq.buscar(unaEtiqueta, prof + 1);
        } else {
            return new Tupla<>(this, prof);
        }
    }
    
    @Override
    public Tupla<Boolean, Integer> insertar(ElementoAB<T> elemento) {
        int comp = this.getEtiqueta().compareTo(elemento.getEtiqueta());
        if (comp < 0)
        {
            if(this.hijoDer == null) {
                this.hijoDer = elemento;
                return new Tupla<>(true, 1);
            } else {
                var res = this.hijoDer.insertar(elemento);
                res.segundo++;
                return res;
            }
        } else if (comp > 0) {
            if(this.hijoIzq == null) {
                this.hijoIzq = elemento;
                return new Tupla<>(true, 1);
            } else {
                var res = this.hijoIzq.insertar(elemento);
                res.segundo++;
                return res;
            }
        }    
        return new Tupla<>(false, 0);
    }
    
    @Override
    public String preOrden() {
        String thisValue = this.getEtiqueta().toString();
        
        String izqStr = "";
        if (this.hijoIzq != null) {
            izqStr = ", " + this.hijoIzq.preOrden();
        }
        
        String derStr = "";
        if (this.hijoDer != null) {
            derStr = ", " + this.hijoDer.preOrden();
        }
        
        return thisValue + izqStr + derStr;
    }

    @Override
    public String inOrden() {
        String izqStr = "";
        if (this.hijoIzq != null) {
            izqStr = this.hijoIzq.inOrden() + ", ";
        }
        
        String thisValue = this.getEtiqueta().toString();
        
        String derStr = "";
        if (this.hijoDer != null) {
            derStr = ", " + this.hijoDer.inOrden();
        }
        
        return izqStr + thisValue + derStr;
    }

    @Override
    public String postOrden() {
        String izqStr = "";
        if (this.hijoIzq != null) {
            izqStr = this.hijoIzq.postOrden() + ", ";
        }
        
        String derStr = "";
        if (this.hijoDer != null) {
            derStr = this.hijoDer.postOrden() + ", ";
        }
        
        String thisValue = this.getEtiqueta().toString();
        
        return izqStr + derStr + thisValue;
    }

    @Override
    public T getDatos() {
        return this.datos;
    }

    @Override
    public ElementoAB<T> eliminar(Comparable unaEtiqueta) {
        int comp = unaEtiqueta.compareTo(this.etiqueta);
        if (comp < 0) {
            if (hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        } else if (comp > 0) {
            if (hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        } else if (hijoIzq == null) {
            return hijoDer;
        } else if (hijoDer == null) {
            return hijoIzq;
        } else {
            ElementoAB<T> padre = this;
            ElementoAB<T> hijo = hijoIzq;
            while (hijo.getHijoDer() != null) {
                padre = hijo;
                hijo = hijo.getHijoDer();
            }
            if (padre != this) {
                padre.hijoDer = hijo.hijoIzq;
                hijo.hijoIzq = this.hijoIzq;
            }
            hijo.hijoDer = this.hijoDer;
            return hijo;
        }
    }
    
    @Override
    public int altura() {
        int altIzq = -1;
        int altDer = -1;
        
        if (this.hijoIzq != null) {
            altIzq = this.hijoIzq.altura();
        }
        if (this.hijoDer != null) {
            altDer = this.hijoDer.altura();
        }
        
        return Math.max(altIzq, altDer) + 1;
    }
    
    @Override
    public int tamanio() {
        int res = 1;
        
        if (this.hijoIzq != null) {
            res += this.hijoIzq.tamanio();
        }
        if (this.hijoDer != null) {
            res += this.hijoDer.tamanio();
        }
        
        return res;
    }
    
    public int cantHojas() {
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 1;
        }
        
        int res = 0;
        if (this.hijoIzq != null) {
            res = this.hijoIzq.cantHojas();
        }
        if (this.hijoDer != null) {
            res += this.hijoDer.cantHojas();
        }
        return res;
    }
    
    public int sumOneIfNotNeg1(int n) {
        if (n >= 0) {
            return n + 1;
        }
        return -1;
    }
    
    public int nivelDe(Comparable etiqueta) {
        int comp = etiqueta.compareTo(this.getEtiqueta());
        if (comp < 0) {
            if (this.hijoIzq != null) {
                return sumOneIfNotNeg1(this.hijoIzq.nivelDe(etiqueta));
            } else {
                return -1;
            }
        } else if (comp > 0) {
            if (this.hijoDer != null) {
                return sumOneIfNotNeg1(this.hijoDer.nivelDe(etiqueta));
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
    
    public Comparable obtenerMenorClave() {
        if(hijoIzq == null) {
            return etiqueta;
        }
        return hijoIzq.obtenerMenorClave();
    }
    
    public Comparable obtenerMayorClave() {
        if(hijoDer == null) {
            return etiqueta;
        }
        return hijoDer.obtenerMayorClave();
    }
    
    public Comparable obtenerClaveAnteriorADada(Comparable clave) {        
        int comp = etiqueta.compareTo(clave);
        
        if(comp < 0) {
            if(hijoDer != null) {
                if(hijoDer.etiqueta.equals(clave)) {
                    return etiqueta;
                }
                return hijoDer.obtenerClaveAnteriorADada(clave);
            } 
        } else {
            if(hijoIzq != null) {
                if(hijoIzq.etiqueta.equals(clave)) {
                    return etiqueta;
                }                
                return hijoIzq.obtenerClaveAnteriorADada(clave);
            }
        }
        return null;
    }
    
    public Integer cantidadNodosPorAltura(int altura) {
        if(altura == 0) {
            return 1;
        }
        
        int sum = 0;
        
        if(hijoIzq != null) {
            sum += hijoIzq.cantidadNodosPorAltura(altura - 1);
        }
        if(hijoDer != null) {
            sum += hijoDer.cantidadNodosPorAltura(altura - 1);
        }
        
        return sum;
    }

    public void listarHojasConNivel(int nivel) {        
        if(hijoIzq == null && hijoDer == null) {
            System.out.println("Nodo: " + etiqueta + " Nivel: " + nivel);
        }
        if (hijoIzq != null) {
            hijoIzq.listarHojasConNivel(nivel + 1);
        }
        if (hijoDer != null) {
            hijoDer.listarHojasConNivel(nivel + 1);            
        }
    }
    
    public boolean verificarSiEsBusqueda() {
        if(hijoIzq == null && hijoDer == null) {
            return true;
        }
        
        int compHijoIzq = (hijoIzq != null) ? etiqueta.compareTo(hijoIzq.etiqueta) : 1;
        int compHijoDer = (hijoDer != null) ? etiqueta.compareTo(hijoDer.etiqueta) : -1;
        
        boolean condicion = compHijoDer < 0 && compHijoIzq > 0;
        
        boolean condicionIzq = true;
        boolean condicionDer = true;
        if(hijoIzq != null) {
            condicionIzq = hijoIzq.verificarSiEsBusqueda();
        }
        
        if(hijoDer != null) {
            condicionDer = hijoDer.verificarSiEsBusqueda();
        }
        return condicion && condicionIzq && condicionDer;
    }

    @Override
    public IElementoAB<T> duplicar() {
        return new ElementoAB<>(etiqueta, datos, hijoIzq, hijoDer);
    }

    @Override
    public int cantidadDeAristas() {
        return this.cantidadDeNodos() + 1;
    }

    @Override
    public int cantidadDeNodos() {
        int contador = 1;
        
        if(hijoIzq != null) {
            contador += hijoIzq.cantidadDeNodos();
        }
        
        if(hijoDer != null) {
            contador += hijoDer.cantidadDeNodos();
        }
        
        return contador;
    }

    @Override
    public int cantNodosInternosCompletos() {
        int contador = (hijoIzq != null && hijoDer != null) ? 1 : 0;
        
        if(hijoIzq != null) {
            contador += hijoIzq.cantNodosInternosCompletos();
        }
        
        if(hijoDer != null) {
            contador += hijoDer.cantNodosInternosCompletos();
        }
        
        return contador;
    }

    @Override
    public boolean verificarSiEsCompleto() {
        if(hijoIzq == null && hijoDer == null) {
            return true;
        }
        
        if(hijoIzq != null && hijoDer != null) {
            return hijoIzq.verificarSiEsCompleto() && hijoDer.verificarSiEsCompleto();
        }
        
        return false;
    }

    @Override
    public boolean verificarSiSonHermanos(Comparable elemento1, Comparable elemento2) {
        
        boolean condicionIzq = false;
        boolean condicionDer = false;
        
        if(hijoIzq != null) {
            if(hijoIzq.etiqueta.equals(elemento1)) {
                return (hijoDer.etiqueta.equals(elemento2)) ? true : false;
            }             
            condicionIzq = hijoIzq.verificarSiSonHermanos(elemento1, elemento2);
        }
        
        if(hijoDer != null) {
            if (hijoDer.etiqueta.equals(elemento1)) {
                return (hijoIzq.etiqueta.equals(elemento2)) ? true : false;
            }
            condicionDer = hijoDer.verificarSiSonHermanos(elemento1, elemento2);
        }
        
        return condicionIzq || condicionDer;
    }
}
