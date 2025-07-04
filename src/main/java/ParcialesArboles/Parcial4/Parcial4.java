package ParcialesArboles.Parcial4;

import TP2.EJ1.BinaryTree;
import java.util.ArrayList;
import java.util.List;

public class Parcial4 {
    BinaryTree<Integer> arbol;

    public Parcial4(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public static List<List<Integer>> procesar(BinaryTree<Integer> arbol){
        if(arbol!=null && !arbol.isEmpty()){
            List<Integer> unicoHijoImpar = new ArrayList<Integer>();
            List<Integer> cantImpar = new ArrayList<Integer>();
            proces(arbol,unicoHijoImpar,cantImpar);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(unicoHijoImpar);
            result.add(cantImpar);
            return result;
        }
        return null;
    }
    private static void proces(BinaryTree<Integer>actual,List<Integer> unicoHijoImpar,List<Integer> cantImpar){
        int hijos = 0;
        if(actual.isLeaf()){
            if(actual.getData()%2!=0){
                cantImpar.add(actual.getData());
                return;
            }
        }
        if(actual.hasLeftChild()){
            hijos++;
            proces(actual.getLeftChild(),unicoHijoImpar,cantImpar);
        }
        if(actual.hasRightChild()){
            hijos++;
            proces(actual.getRightChild(),unicoHijoImpar,cantImpar);
        }
        if(actual.getData()%2!=0){
            cantImpar.add(actual.getData());
        }
        if(hijos == 1){
            if(actual.getData()%2!=0) unicoHijoImpar.add(actual.getData());
        }
    }
    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(10);

        ab.addLeftChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(20));
        ab.getLeftChild().addRightChild(new BinaryTree<>(9));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(11));

        ab.addRightChild(new BinaryTree<Integer>(2));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<>(4));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));

        System.out.println(ab);
        List<List<Integer>> resultado = procesar(ab);
        System.out.println(resultado);
    }
}
