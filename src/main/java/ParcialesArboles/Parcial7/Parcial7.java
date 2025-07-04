package ParcialesArboles.Parcial7;

import TP1.EJ8.Queue;
import TP2.EJ1.BinaryTree;


public class Parcial7 {
    public BinaryTree<Integer> arbol;

    public Parcial7(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    public  BinaryTree<Integer> minEnNivelAB(int n){
        if(arbol!=null && (!arbol.isLeaf()) ){
            BinaryTree<Integer> resul = new BinaryTree<>();
            return  recorridomin(arbol,n,resul);
        }
        return null;
    }
    private BinaryTree<Integer> recorridomin(BinaryTree<Integer>a,int n, BinaryTree<Integer> resultado){
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(a);
        int nivelActual = 0;
        while (!cola.isEmpty()){
            int min = 99999;
            int cantNodoEnNivel = cola.size();
            for (int i=0; i<cantNodoEnNivel; i++){
                BinaryTree<Integer> actual= cola.dequeue();
                if(actual.isLeaf()){
                    if(actual.getData()<min){
                        min= actual.getData();
                        resultado=actual;
                    }
                }
                if(actual.hasLeftChild()){
                    cola.enqueue(actual.getLeftChild());
                }
                if(actual.hasRightChild()) {
                    cola.enqueue(actual.getRightChild());
                }
            }
            nivelActual++;
            if(nivelActual==(n+1)){
                System.out.println("El minimo nodo en el nivel " + n + " es: ");
                return resultado;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.addRightChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(9));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(4));
        Parcial7 a = new Parcial7(ab);
        System.out.println(ab);
//        System.out.println(a.minEnNivelAB(1).getData());
//        System.out.println(a.minEnNivelAB(2).getData());
        System.out.println(a.minEnNivelAB(3).getData());
        System.out.println("");
    }
}
