package TP3.EJ2;

import TP1.EJ8.Queue;
import TP3.EJ1.GeneralTree;

import javax.swing.*;
import java.security.CodeSigner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecorridoAG {
    public void recorridoPreOrden(ArrayList<Integer> resultado,GeneralTree<Integer>a ,Integer n){
        if (a.getData()%2 ==1 && a.getData()>n){
            resultado.add(a.getData());
        }
        List<GeneralTree<Integer>> hijo = a.getChildren();
        for (GeneralTree<Integer> child: hijo){
            recorridoPreOrden(resultado,child,n);
        }
    }
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n){
        ArrayList<Integer> resultado= new ArrayList<>();
        if (!a.isEmpty()){
            this.recorridoPreOrden(resultado,a,n);
        }
        return resultado;
    }
    public  List<Integer> numerosImparesMayoresqueInOrden(GeneralTree<Integer> a, Integer num)
    {
        List<Integer> resultado=new LinkedList<>();
        if(!a.isEmpty()) this.recorridoInOrden(a,resultado,num);
        return resultado;
    }
    public void recorridoInOrden(GeneralTree<Integer> a, List<Integer> l, Integer n)
    {
        // caso base nodo nulo
        if (a == null || a.getData() == null) return;
        // recorrer hasta el primer hijo
        List<GeneralTree<Integer>> hijos= a.getChildren();
        if (a.hasChildren()){
            recorridoInOrden(hijos.get(0),l,n);
        }
        // estoy en el primer hijo hoja
        int dato= a.getData();
        if(dato%2 == 1 && dato>n) {
            l.add(dato);
        }
        //recorrer los demas
        for(int i = 1; i < hijos.size(); i++)
        {
            recorridoInOrden(hijos.get(i),l,n);
        }
    }
    public List<Integer> numeroImparMayorQuePostOrden(GeneralTree<Integer> a, Integer num)
    {
        List<Integer> resultado = new ArrayList<>();
        if (!a.isEmpty()){
            recorridoPostOrden(a,resultado,num);
        }
        return resultado;
    }
    public void recorridoPostOrden(GeneralTree<Integer> a , List<Integer> l,Integer n){
        List<GeneralTree<Integer>> hijos= a.getChildren();
        for(GeneralTree<Integer> child: hijos){
            recorridoPostOrden(child,l,n);
        }
        int dato=a.getData();
        if(dato%2==1 && dato>n){
            l.add(dato);
        }
    }
    public List<Integer> imparMayorQueNiveles(GeneralTree<Integer> a, Integer num)
    {
        List<Integer> resultado = new ArrayList<>();
        if(!a.isEmpty())this.recorridoPorNiveles(a,resultado,num);
        return resultado;
    }
    public void recorridoPorNiveles(GeneralTree<Integer> a, List<Integer> l,Integer num)
    {
        GeneralTree<Integer> nodo;
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();// crear cola
        cola.enqueue(a);// enconlar el arbol
        while (!cola.isEmpty())// mientras la cola no este vacia
        {
            nodo=cola.dequeue();// desencolo y manipulo el dato
            int dato=nodo.getData();
            if (dato%2==1 && dato>num){
                l.add(dato);
            }
            List<GeneralTree<Integer>> hijos = nodo.getChildren();// almaceno los hijos
            for(GeneralTree<Integer> child: hijos)// por cada hijo lo encolo
            {
                cola.enqueue(child);
            }
        }
    }
}
