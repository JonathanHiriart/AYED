package Parciales.Parcial4;

import TP3.EJ1.GeneralTree;
import java.util.ArrayList;
import java.util.List;

public class TestParcialArbol4 {
    public static void main(String[] args) {
        // Crear el árbol de la imagen
        GeneralTree<Integer> arbol = new GeneralTree<>(1); // G=1
        GeneralTree<Integer> nodoE = new GeneralTree<>(3); // E=3
        GeneralTree<Integer> nodoF = new GeneralTree<>(2); // F=2
        GeneralTree<Integer> nodoJ = new GeneralTree<>(5); // J=5
        GeneralTree<Integer> nodoA = new GeneralTree<>(7); // A=7
        GeneralTree<Integer> nodoB = new GeneralTree<>(9); // B=9
        GeneralTree<Integer> nodoC = new GeneralTree<>(5); // C=5
        GeneralTree<Integer> nodoD = new GeneralTree<>(10); // D=10
        GeneralTree<Integer> nodoH = new GeneralTree<>(5); // H=5
        GeneralTree<Integer> nodoI = new GeneralTree<>(10); // I=10

        // Construir el árbol
        List<GeneralTree<Integer>> hijosG = new ArrayList<>();
        hijosG.add(nodoE);
        hijosG.add(nodoF);
        hijosG.add(nodoJ);
        arbol.setChildren(hijosG);

        List<GeneralTree<Integer>> hijosE = new ArrayList<>();
        hijosE.add(nodoA);
        hijosE.add(nodoB);
        hijosE.add(nodoC);
        nodoE.setChildren(hijosE);

        List<GeneralTree<Integer>> hijosF = new ArrayList<>();
        hijosF.add(nodoD);
        nodoF.setChildren(hijosF);

        List<GeneralTree<Integer>> hijosJ = new ArrayList<>();
        hijosJ.add(nodoH);
        hijosJ.add(nodoI);
        nodoJ.setChildren(hijosJ);

        // Probar el método caminoEleccion
        ParcialArboles4 parcial = new ParcialArboles4();
        List<Integer> resultado = parcial.caminoEleccion(arbol);

        // Imprimir resultado
        System.out.println("Camino esperado: [1, 3, 5]");
        System.out.println("Camino obtenido: " + resultado);
    }
}