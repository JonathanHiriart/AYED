package Parciales.Parcial6;

import TP1.EJ8.Queue;
import TP2.EJ1.BinaryTree;

public class TestParcialArbol6 {
    public static void main(String[] args) {
        // Crear nodos
        ParcialArbol6 parcial = new ParcialArbol6();
        BinaryTree<Integer> arbol = new BinaryTree<>(2);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo5_2 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo11 = new BinaryTree<>(11);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);

        // Armar estructura
        arbol.addLeftChild(nodo7);
        arbol.addRightChild(nodo5);
        nodo7.addLeftChild(nodo2);
        nodo7.addRightChild(nodo6);
        nodo5.addRightChild(nodo9);
        nodo6.addLeftChild(nodo5_2);
        nodo6.addRightChild(nodo11);
        nodo9.addLeftChild(nodo4);

        parcial.arbol = arbol;

        // Probar método minEnNivelAB
        BinaryTree<Integer> resultLevel2 = parcial.minEnNivelAB(2);
        System.out.println("Mínimo en nivel 2: " + (resultLevel2 != null ? resultLevel2.getData() : "null"));

        BinaryTree<Integer> resultLevel3 = parcial.minEnNivelAB(3);
        System.out.println("Mínimo en nivel 3: " + (resultLevel3 != null ? resultLevel3.getData() : "null"));

        BinaryTree<Integer> resultLevel4 = parcial.minEnNivelAB(4);
        System.out.println("Mínimo en nivel 4: " + (resultLevel4 != null ? resultLevel4.getData() : "null"));

        parcial.arbol = new BinaryTree<>();
        BinaryTree<Integer> resultEmpty = parcial.minEnNivelAB(1);
        System.out.println("Mínimo en árbol vacío: " + (resultEmpty != null ? resultEmpty.getData() : "null"));

        parcial.arbol = null;
        BinaryTree<Integer> resultNull = parcial.minEnNivelAB(1);
        System.out.println("Mínimo en árbol nulo: " + (resultNull != null ? resultNull.getData() : "null"));
    }
}