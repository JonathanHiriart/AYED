package TP3.EJ7;

import TP3.EJ1.GeneralTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Camino {
    public GeneralTree<Integer> arbol;

    public List<Integer> caminoAHojaMasLejana()
    {
        List<Integer> maxCamino =new ArrayList<>(); // si esta vacia retorno vacia
        if(arbol !=null && !arbol.isEmpty()){
            buscarMaxCamino(arbol,maxCamino,new LinkedList<Integer>());
        }
        return maxCamino;
    }
    private void buscarMaxCamino(GeneralTree<Integer> a, List<Integer> maxCamino,LinkedList<Integer> caminoActual )
    {
        caminoActual.add(a.getData());// agrego el camino actual
        if (a.isLeaf()){ // si es una hoja
            if (maxCamino.size()<caminoActual.size()){ // actualizo el maximo
                maxCamino.clear();
                maxCamino.addAll(caminoActual); // agrego todo del camino actual
            }
        }
        else {// si no es una hoja sigo el camino
            List<GeneralTree<Integer>> hijos = a.getChildren();
            if (!hijos.isEmpty()) {
                for (GeneralTree<Integer> hijo : hijos) {
                    buscarMaxCamino(hijo, maxCamino, caminoActual);
                }
            }
        }
        caminoActual.remove(caminoActual.size()-1); caminoActual.remove(caminoActual.size() - 1); // Elimina el nodo actual de caminoActual (backtracking)
        // para restaurar el camino al estado del nodo padre antes de explorar otros nodos o regresar en la recursión.
//         12
//        /  \
//       17  15
//       /
//       6
//       |
//       1
//        Para el camino [12, 17, 6, 1]:
//        En el nodo 12: caminoActual = [12].
//        En el nodo 17: caminoActual = [12, 17].
//        En el nodo 6: caminoActual = [12, 17, 6].
//        En el nodo 1 (hoja): caminoActual = [12, 17, 6, 1], copias a maxCamino si es más largo.
//        Backtracking en el nodo 1: eliminas 1, caminoActual = [12, 17, 6].
//        Backtracking en el nodo 6: eliminas 6, caminoActual = [12, 17].
//        Backtracking en el nodo 17: eliminas 17, caminoActual = [12].
//        Ahora puedes explorar el nodo 15 con caminoActual = [12, 15].
//        Sin la línea de backtracking, caminoActual acumularía nodos como [12, 17, 6, 1, 15], lo que sería incorrecto.
    }
}
