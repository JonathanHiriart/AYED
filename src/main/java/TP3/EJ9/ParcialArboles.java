package TP3.EJ9;

import TP1.EJ8.Queue;
import TP3.EJ1.GeneralTree;

import java.util.List;

public class ParcialArboles {
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if (arbol!=null && !arbol.isEmpty()){
            return recorridoPost(arbol).esValido;
        }
        return false;
    }
    private static Resultado recorridoPost(GeneralTree<Integer> a){
        // Caso base: si es hoja, es válido y su menor valor es su propio dato
        if (a.isLeaf()){
            return new Resultado(true, a.getData());
        }
        int menorHijo=Integer.MAX_VALUE;
        // Recorro todos los hijos del nodo actual
        for(GeneralTree<Integer> hijo:a.getChildren()){
            // Llamo recursivamente para analizar cada subárbol (postorden)
            Resultado resHijo=recorridoPost(hijo);
            // Si alguno de los hijos no cumple, ya corto y retorno false
            if(!resHijo.esValido){
                return new Resultado(false ,0);
            }
            // Voy buscando el menor valor entre todos los hijos
            if(resHijo.valorMin < menorHijo){
                menorHijo=resHijo.valorMin;
            }
        }
        // Ahora que tengo el menor hijo, comparo si el nodo actual cumple:
        // su dato debe ser igual al menor valor encontrado entre sus hijos
        boolean cumple = a.getData() == menorHijo;
        // Retorno:
        // - Si cumple o no
        // - Y el menor valor entre el dato actual y el menor hijo (para seguir subiendo en la recursión)
        return new Resultado(cumple,Math.min(a.getData(),menorHijo));
    }
}
