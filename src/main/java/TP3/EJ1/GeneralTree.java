package TP3.EJ1;

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


    public int nivel(T dato){
        return 0;
    }

    public int ancho(){

        return 0;
    }
}