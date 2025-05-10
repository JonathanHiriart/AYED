package Parciales.Parcial7;

import TP3.EJ1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArbol7 {
    GeneralTree<Compuesto> arbol;

    public ParcialArbol7(GeneralTree<Compuesto> raiz) {
        this.arbol = raiz;
    }

    public List<Compuesto> estrategia(GeneralTree<Compuesto> raiz){
        List<Compuesto> caminoMasCorto=new ArrayList<>();
        double min=Double.MAX_VALUE;
        recorridoEstrategia(raiz,0,min,caminoMasCorto,new ArrayList<Compuesto>());
        return caminoMasCorto;
    }

    private double recorridoEstrategia(GeneralTree<Compuesto>nodo,double tiempoActual,double min,List<Compuesto> res,List<Compuesto> caminoActual){
        tiempoActual+= nodo.getData().getVueltas() * nodo.getData().getTipo() + 10; // calculo el tiempo actual vuelta * neumatico + 10
        caminoActual.add(nodo.getData()); // agrego el camino
        if(nodo.isLeaf()){
            if(tiempoActual < min){
                min=tiempoActual;
                res.clear();
                res.addAll(caminoActual);
            }
        }
        if(!nodo.isLeaf()){
            for(GeneralTree<Compuesto> hijo:nodo.getChildren()){
                min =recorridoEstrategia(hijo,tiempoActual,min,res,caminoActual);
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
        return min;
    }
}
