package TP3.EJ6;

import TP3.EJ1.GeneralTree;

import java.awt.*;
import java.util.List;

public class RedDeAguaPotable {
    public GeneralTree<Character> a;
    public double minimoCaudal(double caudal)
    {
        if (a ==null || a.isEmpty())return 0;
        return minimoCaudalRecorrido(caudal,a);
    }
    private double minimoCaudalRecorrido(double caudalActual,GeneralTree<Character> a){
        if(a.isLeaf())return caudalActual;
        List<GeneralTree<Character>> hijos = a.getChildren();
        int cantHijos= hijos.size();
        if(cantHijos== 0) return caudalActual;
        double caudalHijo= caudalActual/ cantHijos;
        double minimo =Double.MAX_VALUE;
        for(GeneralTree<Character> hijo:hijos){
            double minimoSubArbol = minimoCaudalRecorrido(caudalHijo,hijo);
            minimo = Math.min(minimo,minimoSubArbol); // comparo el resultado
        }
        return minimo;
    }
}
