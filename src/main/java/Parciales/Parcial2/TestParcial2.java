package Parciales.Parcial2;

import TP2.EJ1.BinaryTree;

public class TestParcial2 {
    public static void main(String[] args) {
        // Construir el árbol dado: 1 (raíz), hijos 2 y 3; 2 → 4; 3 → 5 y 6; 5 → 7
        BinaryTree<Integer> arbol = new BinaryTree<>(1);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);

        arbol.addLeftChild(nodo2);
        arbol.addRightChild(nodo3);
        nodo2.addLeftChild(nodo4);
        nodo3.addLeftChild(nodo5);
        nodo3.addRightChild(nodo6);
        nodo5.addLeftChild(nodo7);

        // Imprimir árbol original
//        System.out.println("Árbol original:\n" + arbol.toString());

        // Crear copia con ParcialArboles2
        ParcialArboles2 copiar = new ParcialArboles2();
        copiar.arbol = arbol;
        BinaryTree<Integer> arbolCopia = copiar.nuevoTree();

        // Imprimir árbol copiado
        System.out.println("Árbol copiado:\n" + arbolCopia.toString());

        // Verificar valores esperados (según tu implementación actual)
        System.out.println("Raíz: " + arbolCopia.getData()); // 1
        System.out.println("Hijo izquierdo raíz: " + arbolCopia.getLeftChild().getData()); // 2+1=3
        System.out.println("Hijo derecho raíz: " + arbolCopia.getRightChild().getData()); // 3
        System.out.println("Hijo izquierdo de 2: " + arbolCopia.getLeftChild().getLeftChild().getData()); // 4 (sin suma recursiva)
        System.out.println("Hijo izquierdo de 3: " + arbolCopia.getRightChild().getLeftChild().getData()); // 5 (sin suma recursiva)
        System.out.println("Hijo derecho de 3: " + arbolCopia.getRightChild().getRightChild().getData()); // 6
        System.out.println("Hijo izquierdo de 5: " + arbolCopia.getRightChild().getLeftChild().getLeftChild().getData()); // 7 (sin suma recursiva)

        // Prueba adicional con métodos existentes
        System.out.println("Árbol copiado espejo:\n" + arbolCopia.espejo().toString());
        arbolCopia.entreNiveles(1, 1); // Mostrar nivel 1
    }
}