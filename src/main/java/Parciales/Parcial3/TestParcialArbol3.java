package Parciales.Parcial3;

import TP2.EJ1.BinaryTree;
import java.util.List;

public class TestParcialArbol3 {
    public static void main(String[] args) {
        // Crear el segundo árbol del enunciado (raíz 7, min=3)
        BinaryTree<Integer> arbol = new BinaryTree<>(7);
        BinaryTree<Integer> nodo56 = new BinaryTree<>(56);
        BinaryTree<Integer> nodo25 = new BinaryTree<>(25);
        BinaryTree<Integer> nodo38 = new BinaryTree<>(38);
        BinaryTree<Integer> nodo31 = new BinaryTree<>(31);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo87 = new BinaryTree<>(87);
        BinaryTree<Integer> nodo77 = new BinaryTree<>(77);
        BinaryTree<Integer> nodo94 = new BinaryTree<>(94);
        BinaryTree<Integer> nodo16 = new BinaryTree<>(16);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo43 = new BinaryTree<>(43);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(10);

        // Construir el árbol
        arbol.addLeftChild(nodo56);
        arbol.addRightChild(nodo25);
        nodo56.addLeftChild(nodo38);
        nodo56.addRightChild(nodo31);
        nodo25.addLeftChild(nodo5);
        nodo25.addRightChild(nodo6);
        nodo38.addLeftChild(nodo87);
        nodo38.addRightChild(nodo77);
        nodo31.addLeftChild(nodo94);
        nodo77.addLeftChild(nodo16);
        nodo77.addRightChild(nodo2);
        nodo16.addLeftChild(nodo43);
        nodo2.addLeftChild(nodo1);
        nodo43.addLeftChild(nodo9);
        nodo43.addRightChild(nodo10);

        // Probar el método resolver
        ParcialArboles3 parcial = new ParcialArboles3();
        int min = 3;
        List<Integer> resultado = parcial.resolver(arbol, min);

        // Imprimir resultado
        System.out.println("Camino esperado: [7, 56, 38, 77, 16]");
        System.out.println("Camino obtenido: " + resultado);
    }
}