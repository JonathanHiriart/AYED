package TP3.EJ4;

import TP1.EJ8.Queue;
import TP3.EJ1.GeneralTree;

import java.awt.*;
import java.util.List;

public class AnalizadorArbol {
    public GeneralTree<AreaEmpresa> arbol;
    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> a){
        int promedioMax=0;
        int promedioActual=0;
        int suma=0;
        if (! (a==null)){
            GeneralTree<AreaEmpresa> nodo;
            Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
            queue.enqueue(a);
            while (!queue.isEmpty()){
                int cantNodosEnNivel = queue.size();
                suma=0;
                for(int i =0;i<cantNodosEnNivel;i++)
                {
                    nodo = queue.dequeue();
                    suma+=nodo.getData().getTardanza();
                    List<GeneralTree<AreaEmpresa>> hijos = nodo.getChildren();
                    for(GeneralTree<AreaEmpresa> child:hijos){
                            queue.enqueue(child);
                    }
                }
                promedioActual= suma / cantNodosEnNivel;
                if(promedioActual>promedioMax){
                    promedioMax=promedioActual;
                }
            }
        }
        return promedioMax;
    }
}
