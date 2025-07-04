package TP3.EJ1;
import TP1.EJ8.Queue;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree() {

    }
    public GeneralTree(T data) {
        this.data = data;
        this.children= new ArrayList<>();
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }

    public int altura(GeneralTree<Integer> a) {
        // Caso base: si el árbol es null o no tiene hijos, su altura es 0
        if (a == null || a.getChildren().isEmpty()) {
            return 0;
        }

        int alturaMax = 0;
        List<GeneralTree<Integer>> hijos = a.getChildren();

        // Recorremos todos los hijos para calcular la altura de cada subárbol
        for (GeneralTree<Integer> child : hijos) {
            int alturaHijo = altura(child); // cálculo recursivo de la altura del hijo
            if (alturaHijo > alturaMax) {
                alturaMax = alturaHijo; // actualizo si encuentro una altura mayor
            }
        }

        // Retornamos la altura máxima encontrada entre los hijos más 1 (nivel actual)
        return alturaMax + 1;
    }


    public int nivel(T dato,GeneralTree<Integer> a){
        if (a==null )return -1; // caso base arbol vacio
        GeneralTree<Integer> nodo;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(a);
        int nivelActual=0;
        while(!cola.isEmpty())
        {
            int cantNodoEnNivel= cola.size();
            for(int i=0;i<cantNodoEnNivel;i++)
            {
                nodo= cola.dequeue();
                if (nodo.getData().equals(dato)){
                    return nivelActual;
                }
                List<GeneralTree<Integer>> hijos = nodo.getChildren();
                for(GeneralTree<Integer> child:hijos)
                {
                    cola.enqueue(child);
                }
            }
            nivelActual++;// siguiente nivel
        }
        return -1;// sino se encuentra devuelvo numero negativo
    }

    public int ancho(GeneralTree<Integer> a) {
        if (a == null) return -1;
        GeneralTree<Integer> nodo;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(a);
        int anchoMax = 0;
        while (!cola.isEmpty()){
            int anchoActual= cola.size();
            for(int i=0;i<anchoActual;i++){
                nodo = cola.dequeue();
                List<GeneralTree<Integer>> hijos= nodo.getChildren();
                for(GeneralTree<Integer> child: hijos)
                {
                    cola.enqueue(child);
                }
            }
            if(anchoActual>anchoMax) anchoMax=anchoActual;
        }
        return anchoMax;
    }
    public boolean buscarDesendiente(T b){
        if (this.data==null){
            return false;
        }
        if (this.data.equals(b)){
            return true;
        }
        for(GeneralTree<T> child:children){
            if (child.buscarDesendiente(b)){
                System.out.println("se encontro");
                return true;
            }
        }
        return false;

    }
    public boolean esAncestro(T a, T b){
        if (this.data == null){
            return false;
        }
        if (this.data.equals(a)){
            System.out.println("Se encontro el nodo a buscando desendencia ..");
            return buscarDesendiente(b);
        }
        for (GeneralTree<T> child:children){
            if(esAncestro(a,b)){
                return true;
            }
        }
        return false;
    }
}
