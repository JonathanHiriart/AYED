package Parciales.Parcial6;

import TP1.EJ8.Queue;
import TP2.EJ1.BinaryTree;

import java.util.List;

public class ParcialArbol6 {
    BinaryTree<Integer> arbol;
    public BinaryTree<Integer> minEnNivelAB(int n) {
        if (this.arbol == null || this.arbol.isEmpty()) {
            return null;
        }
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        int nivelActual = 1;
        BinaryTree<Integer> nodoMinimo = null;
        while (!cola.isEmpty()) {

            int cantNodoEnNivel = cola.size();
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < cantNodoEnNivel; i++) {
                BinaryTree<Integer> nodoActual = cola.dequeue();

                if (nodoActual.isLeaf()) {// si el nodo es una hoja y estoy en el nivel n actualizo el minimo
                    if (nodoActual.getData() < min && n == nivelActual) {
                        min = nodoActual.getData();
                        nodoMinimo = nodoActual;
                    }
                }else {
                    if (nodoActual.hasLeftChild()) {
                        cola.enqueue(nodoActual.getLeftChild());
                    }
                    if (nodoActual.hasRightChild()) {
                        cola.enqueue(nodoActual.getRightChild());
                    }
                }
            }
            nivelActual++;
        }
        return nodoMinimo;
    }

}
