package TP2.EJ6;

import TP2.EJ1.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> arbol= new BinaryTree<>();

    public Transformacion(BinaryTree<Integer> arbol){
        this.arbol=arbol;
    }
    public BinaryTree<Integer> suma () {
        tranformar(arbol);
        return arbol;
    }
    private int tranformar(BinaryTree<Integer>ab) {
        if (ab.isEmpty()) {
            return 0;
        }
        int padre = ab.getData();
        int left = 0;
        int right= 0;
        if (ab.hasLeftChild()) {
            left = tranformar(ab.getLeftChild());
        }
        if (ab.hasRightChild()) {
            right = tranformar(ab.getRightChild());
        }
        ab.setData(left + right);
        return padre + left + right;
    }

}
