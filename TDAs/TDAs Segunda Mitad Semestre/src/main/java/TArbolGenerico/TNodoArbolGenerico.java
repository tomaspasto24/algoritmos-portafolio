/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TArbolGenerico;

/**
 *
 * @author nmais
 */
public class TNodoArbolGenerico<T> implements INodoArbolGenerico {

    protected Comparable etiqueta;
    protected T dato;
    protected TNodoArbolGenerico primerHijo;
    protected TNodoArbolGenerico siguienteHermano;

    public TNodoArbolGenerico(Comparable pEtiqueta, T pDato) {
        this.etiqueta = pEtiqueta;
        this.dato = pDato;
        this.primerHijo = null;
        this.siguienteHermano = null;
    }

    @Override
    public TNodoArbolGenerico buscar(Comparable etiqueta) {
        if (this.etiqueta.equals(etiqueta)) {
            return this;
        } else {
            TNodoArbolGenerico hijo = this.getPrimerHijo();
            TNodoArbolGenerico res = null;
            while (hijo != null) {
                res = hijo.buscar(etiqueta);
                if (res != null) {
                    return res;
                } else {
                    hijo = hijo.getSigHermano();
                }
            }
            return res;
        }
    }

    @Override
    public boolean insertar(Comparable etiqueta, Comparable etiquetaPadre) {
        INodoArbolGenerico<T> padre = this.buscar(etiquetaPadre);
        if (padre != null) {
            TNodoArbolGenerico aux = padre.getPrimerHijo();
            TNodoArbolGenerico<T> nodoInsertar = new TNodoArbolGenerico(etiqueta, null);
            if (aux == null) {
                padre.setPrimerHijo(nodoInsertar);
            } else {
                while (aux.getSigHermano() != null) {
                    aux = aux.getSigHermano();
                }
                aux.setSigHermano(nodoInsertar);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean insertar(TNodoArbolGenerico nodo, Comparable etiquetaPadre) {
        INodoArbolGenerico<T> padre = this.buscar(etiquetaPadre);
        if (padre != null) {
            TNodoArbolGenerico aux = padre.getPrimerHijo();
            if (aux == null) {
                padre.setPrimerHijo(nodo);
            } else {
                while (aux.getSigHermano() != null) {
                    aux = aux.getSigHermano();
                }
                aux.setSigHermano(nodo);
            }
            return true;
        }
        return false;
    }


    @Override
    public String listarIndentado() {
        StringBuilder s = new StringBuilder();
        listarIndentadoAux(0, s);
        return s.toString();
        
    }
    
    private void listarIndentadoAux(int tabs, StringBuilder s)
    {
        s.append("\t".repeat(tabs)).append(this.getEtiqueta().toString()).append("\n");
        if(this.getPrimerHijo() != null)
        {
            this.getPrimerHijo().listarIndentadoAux(tabs+1, s);
        }
        if(this.getSigHermano()!= null)
        {
            this.getSigHermano().listarIndentadoAux(tabs, s);
        }
    }

    @Override
    public TNodoArbolGenerico getPrimerHijo() {
        return this.primerHijo;
    }

    @Override
    public TNodoArbolGenerico getSigHermano() {
        return this.siguienteHermano;
    }

    @Override
    public void setSigHermano(TNodoArbolGenerico hermano) {
        this.siguienteHermano = hermano;
    }

    @Override
    public void setPrimerHijo(TNodoArbolGenerico hijo) {
        this.primerHijo = hijo;
    }

    @Override
    public int cantElementos() {
        if (this.getPrimerHijo() == null) {
            return 1;
        } else {
            INodoArbolGenerico hijo = this.getPrimerHijo();
            int res = 1;
            while (hijo != null) {
                res += hijo.cantElementos();
                hijo = hijo.getSigHermano();
            }
            return res;
        }
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

}
