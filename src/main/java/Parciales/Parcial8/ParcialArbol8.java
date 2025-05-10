package Parciales.Parcial8;

import TP3.EJ1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArbol8 {
    GeneralTree<Integer> arbol;
    public List<Integer> camino(int num){
        List<Integer> resultado = new ArrayList<>();
        if(arbol!=null && !arbol.isEmpty()){
            if(recorrer(arbol,resultado,new ArrayList<>(),num)){
                return resultado;
            }
        }
        return resultado;
    }
    private boolean recorrer(GeneralTree<Integer> nodo , List<Integer> res,List<Integer> caminoActual, int num){
        if(!nodo.isLeaf()){
            List<GeneralTree<Integer>>hijos= nodo.getChildren();
            if(hijos.size()>= num){
                caminoActual.add(nodo.getData());
                for(GeneralTree<Integer> hijo:hijos){
                    if(recorrer(hijo,res,caminoActual,num)){
                        return true;
                    }
                }
            }
        }
        if(nodo.isLeaf()){
            caminoActual.add(nodo.getData());
            res.addAll(caminoActual);
            return true;
        }

        return false;
    }
}
