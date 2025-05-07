package Parciales.Parcial1;

import TP1.EJ8.Queue;
import TP3.EJ1.GeneralTree;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ParcialArboles {
    GeneralTree<Integer> a;

    public ParcialArboles(GeneralTree<Integer> root) {
        this.a= root;
    }

    public List<Integer> nivel(int num){
        List<Integer> l = new ArrayList<>();
        if(!a.isEmpty()&& a!= null){
            recorrido(a,l,num);
        }
        return l;
    }
    private void recorrido(GeneralTree<Integer> a, List<Integer> l, int num){
        GeneralTree<Integer> nodo;
        Queue<GeneralTree<Integer>> cola =new Queue<>();
        cola.enqueue(a);
        while (!cola.isEmpty()){
            int cantNodo=cola.size();
            int cantNodoQueCumplieron = 0;
            for (int i=0;i<cantNodo;i++){

                nodo=cola.dequeue();
                List<GeneralTree<Integer>> hijos= nodo.getChildren();

                if(hijos.size()>=num){ // si un nodo cumple que sus hijos es mayor a num
                    l.add(nodo.getData());
                    cantNodoQueCumplieron++;// se suma 1
                }
                for(GeneralTree<Integer> hijo:hijos){
                    cola.enqueue(hijo);
                }
            }
            //una vez terminado de recorrer los hijos
            if(cantNodoQueCumplieron==cantNodo){
                return;// si todos esos nodos cumplieron devuelvo
            }
            // sino limpio la lista
            l.clear();
        }
    }
}
