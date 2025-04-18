package TP2.EJ4;

import TP2.EJ1.BinaryTree;

public class Profundidad {

    public int sumaMayorRetardo(BinaryTree<Integer> ab, int resultado){
        if (ab.isEmpty()){ // primer caso : arbol vacio
            return resultado;
        }
        resultado+=ab.getData(); // sumo el contenido actual

        if (ab.hasLeftChild() && ab.hasRightChild()){ // segundo caso : eleccion de rama
            if (ab.getLeftChild().getData() < ab.getRightChild().getData()){ // derecho > izquierdo
                return sumaMayorRetardo(ab.getRightChild(),resultado);

            }else{
                return sumaMayorRetardo(ab.getLeftChild(),resultado);
            }
        }
        if (ab.isLeaf()){ // tercer caso : es el ultimo
            return resultado;
        }
        return resultado;
    }
}
