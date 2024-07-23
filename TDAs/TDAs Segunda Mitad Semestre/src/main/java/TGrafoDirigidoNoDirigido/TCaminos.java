package TGrafoDirigidoNoDirigido;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author diego
 */
public class TCaminos {
    
    private Collection<TCamino> caminos;

    public TCaminos() {
        this.caminos = new LinkedList<>();
    }
    
    public String imprimirCaminos(){
        StringBuilder sb = new StringBuilder();
        for (TCamino camino : caminos){
            sb.append(camino.imprimirEtiquetas()).append("\n");
        }
        return sb.toString();
    }

    public void imprimirCaminosConsola(){
        System.out.println(imprimirCaminos());
    }

    public Collection<TCamino> getCaminos() {
        return caminos;
    }
        
    public TCamino caminoMenorCosto() {
        // "res" significa "resultado"
        TCamino res = null;
        double costo = Double.MAX_VALUE;
        for (TCamino camino : this.caminos) {
            if (camino.getCostoTotal() < costo) {
                costo = camino.getCostoTotal();
                res = camino;
            }
        }
        
        return res;
    }

}
