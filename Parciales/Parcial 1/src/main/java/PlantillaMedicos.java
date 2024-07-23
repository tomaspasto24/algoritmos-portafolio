
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class PlantillaMedicos extends TArbolBB<Medico> implements IPlantillaMedicos {

    @Override
    public TArbolBB obtenerDirectorio(String laEspecialidad) {
        TArbolBB<Medico> arbol = new TArbolBB<>();
        if(getRaiz() != null) {
            return getRaiz().obtenerDirectorio(arbol, laEspecialidad);
        }
        return arbol;
    }
}
