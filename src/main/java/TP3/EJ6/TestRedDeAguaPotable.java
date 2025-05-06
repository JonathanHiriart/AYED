package TP3.EJ6;

import TP3.EJ1.GeneralTree;
import java.util.ArrayList;
import java.util.List;

public class TestRedDeAguaPotable {
    public static void main(String[] args) {
        // Prueba 1: Árbol con caudal mínimo 25.0
        GeneralTree<Character> arbol = crearArbol();
        RedDeAguaPotable red = new RedDeAguaPotable();
        red.a = arbol;

        double resultado = red.minimoCaudal(1000.0);
        System.out.println("Prueba 1 - Caudal inicial: 1000.0");
        System.out.println("Resultado esperado: 25.0");
        System.out.println("Resultado obtenido: " + resultado);
        if (Math.abs(resultado - 25.0) < 0.0001) {
            System.out.println("Prueba 1: ÉXITO");
        } else {
            System.out.println("Prueba 1: FALLO");
        }

        // Prueba 2: Árbol vacío
        red.a = null;
        resultado = red.minimoCaudal(1000.0);
        System.out.println("\nPrueba 2 - Árbol vacío");
        System.out.println("Resultado esperado: 0.0");
        System.out.println("Resultado obtenido: " + resultado);
        if (resultado == 0.0) {
            System.out.println("Prueba 2: ÉXITO");
        } else {
            System.out.println("Prueba 2: FALLO");
        }
    }

    private static GeneralTree<Character> crearArbol() {
        // Crear hojas del nivel más bajo (caudal 25.0)
        GeneralTree<Character> hoja1_1_1 = new GeneralTree<>('C');
        GeneralTree<Character> hoja1_1_2 = new GeneralTree<>('C');

        // Crear nieto 1.1 con 2 hijos (caudal 50.0)
        List<GeneralTree<Character>> hijosNieto1_1 = new ArrayList<>();
        hijosNieto1_1.add(hoja1_1_1);
        hijosNieto1_1.add(hoja1_1_2);
        GeneralTree<Character> nieto1_1 = new GeneralTree<>('N', hijosNieto1_1);

        // Crear otros nietos (hojas con caudal 50.0)
        GeneralTree<Character> nieto1_2 = new GeneralTree<>('C');
        GeneralTree<Character> nieto1_3 = new GeneralTree<>('C');
        GeneralTree<Character> nieto1_4 = new GeneralTree<>('C');
        GeneralTree<Character> nieto1_5 = new GeneralTree<>('C');

        // Crear hijo 1 con 5 hijos (caudal 250.0)
        List<GeneralTree<Character>> hijosHijo1 = new ArrayList<>();
        hijosHijo1.add(nieto1_1);
        hijosHijo1.add(nieto1_2);
        hijosHijo1.add(nieto1_3);
        hijosHijo1.add(nieto1_4);
        hijosHijo1.add(nieto1_5);
        GeneralTree<Character> hijo1 = new GeneralTree<>('N', hijosHijo1);

        // Crear otros hijos (hojas con caudal 250.0)
        GeneralTree<Character> hijo2 = new GeneralTree<>('C');
        GeneralTree<Character> hijo3 = new GeneralTree<>('C');
        GeneralTree<Character> hijo4 = new GeneralTree<>('C');

        // Crear raíz con 4 hijos (caudal 1000.0)
        List<GeneralTree<Character>> hijosRaiz = new ArrayList<>();
        hijosRaiz.add(hijo1);
        hijosRaiz.add(hijo2);
        hijosRaiz.add(hijo3);
        hijosRaiz.add(hijo4);
        GeneralTree<Character> raiz = new GeneralTree<>('R', hijosRaiz);

        return raiz;
    }
}