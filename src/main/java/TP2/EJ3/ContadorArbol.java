package TP2.EJ3;

import TP2.EJ1.BinaryTree;

import javax.swing.*;
import java.util.ArrayList;

public class ContadorArbol {
    private BinaryTree<Integer> arbol ;

    public ArrayList<Integer> numeroPares(){
        ArrayList<Integer> estructura = new ArrayList<>();
        parInOrden(arbol,estructura);
        parPostOrden(arbol,estructura);
        return estructura;
    }
    private void parInOrden(BinaryTree<Integer> ab, ArrayList<Integer> lista){
        if (ab.isEmpty()){
            return;
        }
        if (ab.hasLeftChild()){
            parInOrden(ab.getLeftChild(),lista);
        }
        if (ab.getData() % 2 == 0){
            lista.add(ab.getData());
        }
        if (ab.hasRightChild()){
            parInOrden(ab.getRightChild(),lista);
        }
    }
    private void parPostOrden(BinaryTree<Integer> ab , ArrayList<Integer> lista){
        if (ab.isEmpty()){
            return;
        }
        if (ab.hasLeftChild()){
            parPostOrden(ab.getLeftChild(),lista);
        }
        if (ab.hasRightChild()){
            parPostOrden(ab.getRightChild(),lista);
        }
        if (ab.getData()% 2 == 0){
            lista.add(ab.getData());
        }
    }
}
