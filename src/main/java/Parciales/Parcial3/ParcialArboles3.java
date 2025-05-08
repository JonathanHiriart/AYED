package Parciales.Parcial3;

import TP2.EJ1.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles3 {

    public List<Integer> resolver(BinaryTree<Integer> arbol,int min){
        List<Integer> resultado = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();
        int cantPares= 0;
        if(arbol==null || arbol.isEmpty()){
            return null;
        }
        recorrido(arbol,aux,resultado,min,cantPares);
        return resultado;
    }
    private void recorrido(BinaryTree<Integer>nodo, List<Integer>caminoActual,List<Integer> res,int min,int cantPares){
        if (!res.isEmpty())return; // si tiene algo res es decir que encontramos el camino
        caminoActual.add(nodo.getData()); // agrego
        if (nodo.getData()%2 ==0){
            cantPares++;
        }
        if (cantPares >= min) { // si el nodo actual cumplio
            res.addAll(caminoActual); // actualizo mi resutlado
            return;
        } // si no cumple y soy un hoja tengo que removerlo
        if(nodo.isLeaf()){
            caminoActual.removeLast();
        }else {
            if(nodo.hasLeftChild() ){
                recorrido(nodo.getLeftChild(),caminoActual,res,min,cantPares);
            }
            if(nodo.hasRightChild()){
                recorrido(nodo.getRightChild(),caminoActual,res,min,cantPares);
            }
        }
    }
}
