package Parciales.Parcial5;

import TP3.EJ1.GeneralTree;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ParcialArbol5 {
    public List<Character> caminoPares(GeneralTree<Character> arbol ){
        List<Character> listaPares = new ArrayList<>();
        if(arbol==null || arbol.isEmpty()){
            return null;
        }
        recorridoCaminoPar(arbol,listaPares,new ArrayList<>());
        return listaPares;
    }
    private void recorridoCaminoPar(GeneralTree<Character>nodo,List<Character> listaPar, List<Character> aux){
        aux.add(nodo.getData());// agrego el nodo actual
        if (!nodo.isLeaf()){ // sino llego a una hoja recorro los hijos
            List<GeneralTree<Character>> hijos = nodo.getChildren();
            for(GeneralTree<Character> hijo: hijos){
                recorridoCaminoPar(hijo,listaPar,aux);
            }
        }
        if(nodo.isLeaf()){
            if(aux.size()%2 ==0){
                listaPar.add(' ');
                listaPar.addAll(aux);
            }
        }
        aux.removeLast();
    }
}
