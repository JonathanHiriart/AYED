package Parciales.Parcial2;

import TP2.EJ1.BinaryTree;

public class TestParcial2 {
    public static void main(String[] args) {



        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> n1 = new BinaryTree<>(2);
        BinaryTree<Integer> n2 = new BinaryTree<>(3);
        BinaryTree<Integer> h1 = new BinaryTree<>(4);
        BinaryTree<Integer> h2 = new BinaryTree<>(5);
        BinaryTree<Integer> h3 = new BinaryTree<>(6);
        BinaryTree<Integer> h4 = new BinaryTree<>(7);

        raiz.addLeftChild(n1);
        raiz.addRightChild(n2);

        n1.addLeftChild(h1);


        n2.addLeftChild(h2);
        n2.addRightChild(h3);

        h2.addLeftChild(h4);

        ParcialArboles2 prueba = new ParcialArboles2(raiz);
        System.out.println(raiz);
        System.out.println(prueba.nuevoTree());
    }

}