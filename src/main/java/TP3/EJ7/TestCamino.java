package TP3.EJ7;

import TP3.EJ1.GeneralTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCamino {
    public static void main(String[] args) {
        // Prueba 1: Árbol del ejemplo del enunciado
        GeneralTree<Integer> arbol = crearArbolEjemplo();
        Camino camino = new Camino();
        camino.arbol = arbol;

        List<Integer> resultado = camino.caminoAHojaMasLejana();
        List<Integer> esperado = Arrays.asList(12, 17, 6, 1);
        System.out.println("Prueba 1 - Árbol del enunciado");
        System.out.println("Resultado esperado: " + esperado);
        System.out.println("Resultado obtenido: " + resultado);
        if (resultado.equals(esperado)) {
            System.out.println("Prueba 1: ÉXITO");
        } else {
            System.out.println("Prueba 1: FALLO");
        }

        // Prueba 2: Árbol vacío
        camino.arbol = null;
        resultado = camino.caminoAHojaMasLejana();
        System.out.println("\nPrueba 2 - Árbol vacío");
        System.out.println("Resultado esperado: []");
        System.out.println("Resultado obtenido: " + resultado);
        if (resultado.isEmpty()) {
            System.out.println("Prueba 2: ÉXITO");
        } else {
            System.out.println("Prueba 2: FALLO");
        }

        // Prueba 3: Árbol con un solo nodo
        GeneralTree<Integer> arbolSimple = new GeneralTree<>(5);
        camino.arbol = arbolSimple;
        resultado = camino.caminoAHojaMasLejana();
        esperado = Arrays.asList(5);
        System.out.println("\nPrueba 3 - Árbol con un solo nodo (valor 5)");
        System.out.println("Resultado esperado: " + esperado);
        System.out.println("Resultado obtenido: " + resultado);
        if (resultado.equals(esperado)) {
            System.out.println("Prueba 3: ÉXITO");
        } else {
            System.out.println("Prueba 3: FALLO");
        }
    }

    private static GeneralTree<Integer> crearArbolEjemplo() {
        // Hojas del camino [12, 17, 6, 1]
        GeneralTree<Integer> hoja1 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(6, Arrays.asList(hoja1));
        GeneralTree<Integer> nodo8 = new GeneralTree<>(8); // Hoja adicional bajo 17
        GeneralTree<Integer> nodo17 = new GeneralTree<>(17, Arrays.asList(nodo6, nodo8));

        // Hojas del camino [12, 15, 14, 16] y [12, 15, 14, 7]
        GeneralTree<Integer> hoja16 = new GeneralTree<>(16);
        GeneralTree<Integer> hoja7 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo14 = new GeneralTree<>(14, Arrays.asList(hoja16, hoja7));
        GeneralTree<Integer> nodo15 = new GeneralTree<>(15, Arrays.asList(nodo14));

        // Raíz
        List<GeneralTree<Integer>> hijosRaiz = new ArrayList<>();
        hijosRaiz.add(nodo17); // Primer hijo para que [12, 17, 6, 1] sea el primero encontrado
        hijosRaiz.add(nodo15);
        GeneralTree<Integer> raiz = new GeneralTree<>(12, hijosRaiz);

        return raiz;
    }
}