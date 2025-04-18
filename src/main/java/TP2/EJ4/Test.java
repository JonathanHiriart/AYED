package TP2.EJ4;

import TP2.EJ1.BinaryTree;

public class Test {
    public static void main(String[] args) {
        // Crear el árbol binario
        BinaryTree<Integer> root = new BinaryTree<>(10);
        BinaryTree<Integer> leftChild = new BinaryTree<>(2);
        BinaryTree<Integer> rightChild = new BinaryTree<>(3);

        BinaryTree<Integer> leftLeftChild = new BinaryTree<>(5);
        BinaryTree<Integer> leftRightChild = new BinaryTree<>(4);
        BinaryTree<Integer> rightLeftChild = new BinaryTree<>(9);
        BinaryTree<Integer> rightRightChild = new BinaryTree<>(8);

        BinaryTree<Integer> leftLeftLeftChild = new BinaryTree<>(7);
        BinaryTree<Integer> leftLeftRightChild = new BinaryTree<>(8);
        BinaryTree<Integer> leftRightLeftChild = new BinaryTree<>(5);
        BinaryTree<Integer> leftRightRightChild = new BinaryTree<>(6);

        BinaryTree<Integer> rightLeftLeftChild = new BinaryTree<>(12);
        BinaryTree<Integer> rightLeftRightChild = new BinaryTree<>(8);
        BinaryTree<Integer> rightRightLeftChild = new BinaryTree<>(2);
        BinaryTree<Integer> rightRightRightChild = new BinaryTree<>(1);

        // Construir el árbol
        root.addLeftChild(leftChild);
        root.addRightChild(rightChild);

        leftChild.addLeftChild(leftLeftChild);
        leftChild.addRightChild(leftRightChild);
        rightChild.addLeftChild(rightLeftChild);
        rightChild.addRightChild(rightRightChild);

        leftLeftChild.addLeftChild(leftLeftLeftChild);
        leftLeftChild.addRightChild(leftLeftRightChild);
        leftRightChild.addLeftChild(leftRightLeftChild);
        leftRightChild.addRightChild(leftRightRightChild);

        rightLeftChild.addLeftChild(rightLeftLeftChild);
        rightLeftChild.addRightChild(rightLeftRightChild);
        rightRightChild.addLeftChild(rightRightLeftChild);
        rightRightChild.addRightChild(rightRightRightChild);

        // Crear una instancia de la clase Profundidad
        Profundidad profundidad = new Profundidad();

        // Probar el método sumaMayorRetardo
        int resultado = profundidad.sumaMayorRetardo(root, 0);
        System.out.println("La suma mayor retardo es: " + resultado);
    }
}