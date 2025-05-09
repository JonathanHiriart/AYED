package Parciales.Parcial2;

import TP2.EJ1.BinaryTree;

public class ParcialArboles2 {
    BinaryTree<Integer> arbol;

    public ParcialArboles2(BinaryTree<Integer> raiz) {
        this.arbol=raiz;
    }

    public BinaryTree<Integer> nuevoTree(){
        if(arbol== null|| arbol.isEmpty()){
            return null;
        }
        int padre = arbol.getData();
        BinaryTree<Integer> copia = new BinaryTree<>();
        copiarArbol(arbol,copia,padre);
        return copia;
    }
    private void copiarArbol(BinaryTree<Integer> nodo,BinaryTree<Integer> copia,int padre){
        if(nodo.hasLeftChild()){
            BinaryTree<Integer> nuevoHijoIzquierdo = nodo.getLeftChild();
            nuevoHijoIzquierdo.setData(nodo.getData() + padre); // creo un hijo y le sumo con el padre
            copia.addLeftChild(nuevoHijoIzquierdo);
            copiarArbol(nodo.getLeftChild(),copia.getLeftChild(),nodo.getData());
        }
        if(nodo.hasRightChild()){
            BinaryTree<Integer> nuevoHijoDerecho = nodo.getRightChild();
            copia.addRightChild(nuevoHijoDerecho);
            copiarArbol(nodo.getRightChild(),copia.getRightChild(),nodo.getData());
        }
    }
}
