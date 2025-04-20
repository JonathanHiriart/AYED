package TP2.EJ7;

import TP2.EJ1.BinaryTree;

public class Test {
    public static void main(String[] args) {
        // Crear nodos
        BinaryTree<Integer> n11 = new BinaryTree<>(11);
        BinaryTree<Integer> n55 = new BinaryTree<>(55);
        n55.addLeftChild(n11);

        BinaryTree<Integer> n4 = new BinaryTree<>(4);
        n4.addLeftChild(n55);

        BinaryTree<Integer> n18 = new BinaryTree<>(18);
        BinaryTree<Integer> n19 = new BinaryTree<>(19);
        n19.addLeftChild(n4);
        n19.addRightChild(n18);

        BinaryTree<Integer> n6 = new BinaryTree<>(6);
        BinaryTree<Integer> n23 = new BinaryTree<>(23);
        BinaryTree<Integer> nM3 = new BinaryTree<>(-3);
        n23.addLeftChild(nM3);

        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        n7.addLeftChild(n23);
        n7.addRightChild(n6);

        BinaryTree<Integer> nM5 = new BinaryTree<>(-5);
        nM5.addRightChild(n19);

        BinaryTree<Integer> root = new BinaryTree<>(2);
        root.addLeftChild(n7);
        root.addRightChild(nM5);

        // Crear instancia de ParcialArboles
        ParcialArboles parcial = new ParcialArboles(root);

        // Probar los casos del enunciado
        System.out.println("isLeftTree(7): " + parcial.isLeftTree(7));     // true
        System.out.println("isLeftTree(2): " + parcial.isLeftTree(2));     // false
        System.out.println("isLeftTree(-5): " + parcial.isLeftTree(-5));   // true
        System.out.println("isLeftTree(19): " + parcial.isLeftTree(19));   // false
        System.out.println("isLeftTree(-3): " + parcial.isLeftTree(-3));   // false
        System.out.println("isLeftTree(999): " + parcial.isLeftTree(999)); // false (no existe)
    }
}
