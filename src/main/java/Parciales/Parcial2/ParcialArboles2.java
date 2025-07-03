package Parciales.Parcial2;

import TP2.EJ1.BinaryTree;

public class ParcialArboles2 {
    BinaryTree<Integer> arbol;

    public ParcialArboles2(BinaryTree<Integer> raiz) {
        this.arbol=raiz;
    }

    public BinaryTree<Integer> nuevoTree() {
        if (arbol == null || arbol.isEmpty()) {
            return null;
        }
        BinaryTree<Integer> copia =new BinaryTree<>();
        copia.setData(arbol.getData());
        recorrido(arbol,copia);
        return copia;
    }
    private void recorrido(BinaryTree<Integer>nodoActual,BinaryTree<Integer> copia){
        if(nodoActual.hasLeftChild()){
            BinaryTree<Integer> nuevoHijoIzquierdo = new BinaryTree<>(nodoActual.getLeftChild().getData() + nodoActual.getData());
            copia.addLeftChild(nuevoHijoIzquierdo);
            recorrido(nodoActual.getLeftChild(),copia.getLeftChild());
        }
        if(nodoActual.hasRightChild()){
            BinaryTree<Integer> nuevoHijoDerecho = new BinaryTree<>(nodoActual.getRightChild().getData());
            copia.addRightChild(nuevoHijoDerecho);
            recorrido(nodoActual.getRightChild(),copia.getRightChild());
        }
    }
}
