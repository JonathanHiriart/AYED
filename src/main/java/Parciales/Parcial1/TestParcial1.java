package Parciales.Parcial1;

import TP3.EJ1.GeneralTree;

import java.util.List;

public class TestParcial1 {
    public static void main(String[] args) {
        // Construimos el árbol según tu descripción
        GeneralTree<Integer> root = new GeneralTree<>(10);

        // Primer nivel
        GeneralTree<Integer> n8 = new GeneralTree<>(8);
        GeneralTree<Integer> n5n = new GeneralTree<>(-5);
        root.addChild(n8);
        root.addChild(n5n);

        // Segundo nivel (hijos de 8)
        GeneralTree<Integer> n5 = new GeneralTree<>(5);
        GeneralTree<Integer> n22 = new GeneralTree<>(22);
        n8.addChild(n5);
        n8.addChild(n22);

        // Segundo nivel (hijos de -5)
        GeneralTree<Integer> n19 = new GeneralTree<>(19);
        n5n.addChild(n19);

        // Tercer nivel (hijos de 5)
        GeneralTree<Integer> n6n = new GeneralTree<>(-6);
        GeneralTree<Integer> n2 = new GeneralTree<>(2);
        GeneralTree<Integer> n6 = new GeneralTree<>(6);
        n5.addChild(n6n);
        n5.addChild(n2);
        n5.addChild(n6);

        // Tercer nivel (hijos de 22)
        GeneralTree<Integer> n28 = new GeneralTree<>(28);
        GeneralTree<Integer> n55 = new GeneralTree<>(55);
        GeneralTree<Integer> n18 = new GeneralTree<>(18);
        n22.addChild(n28);
        n22.addChild(n55);
        n22.addChild(n18);

        // Tercer nivel (hijos de 19)
        GeneralTree<Integer> n4 = new GeneralTree<>(4);
        GeneralTree<Integer> n2b = new GeneralTree<>(2);
        GeneralTree<Integer> n8b = new GeneralTree<>(8);
        n19.addChild(n4);
        n19.addChild(n2b);
        n19.addChild(n8b);

        // Ejecutamos el método
        ParcialArboles p = new ParcialArboles(root);
        List<Integer> lista = p.nivel(3);

        if (!lista.isEmpty()) {
            System.out.println("Camino encontrado:");
            for (Integer valor : lista) {
                System.out.print(valor + " ");
            }
        } else {
            System.out.println("No se encontró un camino que cumpla la condición.");
        }
    }
}