package TP3.EJ2;

import TP3.EJ1.GeneralTree;

import java.util.List;

public class TestRecorridoAG {
    public static void main(String[] args) {
        // Crear el árbol
        GeneralTree<Integer> root = new GeneralTree<>(12);

        GeneralTree<Integer> n7 = new GeneralTree<>(7);
        GeneralTree<Integer> n19 = new GeneralTree<>(19);
        GeneralTree<Integer> n5 = new GeneralTree<>(5);

        root.addChild(n7);
        root.addChild(n19);
        root.addChild(n5);

        GeneralTree<Integer> n9 = new GeneralTree<>(9);
        GeneralTree<Integer> n14 = new GeneralTree<>(14);

        n7.addChild(n9);
        n7.addChild(n14);

        GeneralTree<Integer> n11 = new GeneralTree<>(11);
        GeneralTree<Integer> n2 = new GeneralTree<>(2);

        n9.addChild(n11);
        n9.addChild(n2);

        GeneralTree<Integer> n17 = new GeneralTree<>(17);
        GeneralTree<Integer> n6 = new GeneralTree<>(6);

        n19.addChild(n17);
        n19.addChild(n6);

        GeneralTree<Integer> n23 = new GeneralTree<>(23);
        n17.addChild(n23);

        GeneralTree<Integer> n21 = new GeneralTree<>(21);
        n5.addChild(n21);

        GeneralTree<Integer> n18 = new GeneralTree<>(18);
        GeneralTree<Integer> n25 = new GeneralTree<>(25);

        n21.addChild(n18);
        n21.addChild(n25);

        // Instanciar RecorridoAG
        RecorridoAG recorrido = new RecorridoAG();

        int n = 6; // Número de referencia para las búsquedas (impares mayores a 6)

        // Ejecutar métodos y mostrar resultados
        System.out.println("=== PreOrden ===");
        List<Integer> preOrden = recorrido.numerosImparesMayoresQuePreOrden(root, n);
        System.out.println(preOrden);

        System.out.println("=== InOrden ===");
        List<Integer> inOrden = recorrido.numerosImparesMayoresqueInOrden(root, n);
        System.out.println(inOrden);

        System.out.println("=== PostOrden ===");
        List<Integer> postOrden = recorrido.numeroImparMayorQuePostOrden(root, n);
        System.out.println(postOrden);

        System.out.println("=== Por Niveles ===");
        List<Integer> niveles = recorrido.imparMayorQueNiveles(root, n);
        System.out.println(niveles);
    }
}
