package TP3.EJ9;

import TP3.EJ1.GeneralTree;

public class TestParcialArboles {
    public static void main(String[] args) {

        // 🌳 Árbol 1: Debe retornar true
        GeneralTree<Integer> raiz1 = new GeneralTree<>(12);

        GeneralTree<Integer> n12a = new GeneralTree<>(12);
        GeneralTree<Integer> n25a = new GeneralTree<>(25);

        // Subárbol izquierdo
        GeneralTree<Integer> n35a = new GeneralTree<>(35);
        GeneralTree<Integer> n14 = new GeneralTree<>(14);
        GeneralTree<Integer> n33a = new GeneralTree<>(33);

        n14.addChild(new GeneralTree<>(35)); // 35 hijo de 14

        // Hijos de 12 izquierdo
        n12a.addChild(n35a);
        n12a.addChild(n14);
        n12a.addChild(n33a);

        // Subárbol derecho (nodo 33)
        n33a.addChild(new GeneralTree<>(35));
        n33a.addChild(new GeneralTree<>(83));
        n33a.addChild(new GeneralTree<>(90));
        n33a.addChild(new GeneralTree<>(33));

        // Subárbol derecho
        n25a.addChild(new GeneralTree<>(25));

        // Armo el árbol raíz
        raiz1.addChild(n12a);
        raiz1.addChild(n25a);

        boolean resultado1 = ParcialArboles.esDeSeleccion(raiz1);
        System.out.println("Árbol 1 (debería ser true): " + resultado1);


        // 🌳 Árbol 2: Debe retornar false
        GeneralTree<Integer> raiz2 = new GeneralTree<>(12);

        GeneralTree<Integer> n12b = new GeneralTree<>(12);
        GeneralTree<Integer> n25b = new GeneralTree<>(25);

        // Subárbol izquierdo (acá metemos el nodo 18 que rompe)
        GeneralTree<Integer> n35b = new GeneralTree<>(35);
        GeneralTree<Integer> n18 = new GeneralTree<>(18);
        GeneralTree<Integer> n33b = new GeneralTree<>(33);

        // Hijos de nodo 18 (este está mal porque 14 < 18 y no cumple)
        n18.addChild(new GeneralTree<>(35));
        n18.addChild(new GeneralTree<>(14));
        n18.addChild(new GeneralTree<>(18));
        n18.addChild(new GeneralTree<>(33));

        // Hijos de 33
        n33b.addChild(new GeneralTree<>(35));
        n33b.addChild(new GeneralTree<>(83));
        n33b.addChild(new GeneralTree<>(90));
        n33b.addChild(new GeneralTree<>(33));

        // Hijos de 12 izquierdo
        n12b.addChild(n35b);
        n12b.addChild(n18); // El 18 rompe
        n12b.addChild(n33b);

        // Subárbol derecho
        n25b.addChild(new GeneralTree<>(25));

        // Armo el árbol raíz
        raiz2.addChild(n12b);
        raiz2.addChild(n25b);

        boolean resultado2 = ParcialArboles.esDeSeleccion(raiz2);
        System.out.println("Árbol 2 (debería ser false): " + resultado2);
    }
}
