package Parciales.Parcial2;

import TP2.EJ1.BinaryTree;

public class ParcialArboles2 {
    BinaryTree<Integer> arbol;

    public BinaryTree<Integer> nuevoTree(){
        if(arbol== null|| arbol.isEmpty()){
            return null;
        }
        return copiarArbol(arbol);
    }
    private BinaryTree<Integer> copiarArbol(BinaryTree<Integer> nodo){
        BinaryTree<Integer> nuevo = new BinaryTree<>(nodo.getData());
        if(nodo.hasLeftChild()){
            int suma = nodo.getLeftChild().getData()+ nodo.getData(); // hago la suma del padre con el hijo izquierdo
            BinaryTree<Integer> nuevoHijoIzquierdo = new BinaryTree<>(suma);
            nuevo.addLeftChild(nuevoHijoIzquierdo);
            nuevo.addLeftChild(copiarArbol(nodo.getLeftChild())); // agrego el izquierdo modificado y llamo a la recursividad con el nodo izquierdo
        }
        if(nodo.hasRightChild()){
            BinaryTree<Integer> nuevoHijoDerecho = new BinaryTree<>(nodo.getRightChild().getData());
            nuevo.addRightChild(nuevoHijoDerecho);
            nuevo.addRightChild(copiarArbol(nodo.getRightChild()));
        }
        return nuevo;
    }
}
