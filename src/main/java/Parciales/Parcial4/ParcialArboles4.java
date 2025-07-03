package Parciales.Parcial4;

import TP1.EJ8.Queue;
import TP3.EJ1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles4 {
    public List<Integer> caminoEleccion(GeneralTree<Integer>arbol){
        List<Integer> resultado = new ArrayList<>();
        if(arbol==null || arbol.isEmpty()){
            return resultado;
        }
        resultado.add(arbol.getData());
        recorridoEleccion(arbol,resultado);
        return resultado;

    }
    private boolean recorridoEleccion(GeneralTree<Integer>nodo, List<Integer> res){
        int posSig = nodo.getData();
        int posActual = 0;
        if(nodo.isLeaf()){
            return false;
        }else {
            List<GeneralTree<Integer>> hijos = nodo.getChildren();
            // si no es una hoja tengo que ir hijo que contiene la infacion del padre
            for(GeneralTree<Integer> hijo:hijos){
                posActual++;
                if(posActual== posSig){
                    res.add(hijo.getData());
                    recorridoEleccion(hijo, res);
                }
            }
        }
        return false;
    }
}