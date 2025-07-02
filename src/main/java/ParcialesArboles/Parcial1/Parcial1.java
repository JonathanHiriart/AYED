package ParcialesArboles.Parcial1;

import TP2.EJ1.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Parcial1 {
    public static BinaryTree<List<Integer>> sumAndDif(BinaryTree<Integer> arbol){
        BinaryTree<List<Integer>> resultado = new BinaryTree<List<Integer>>();
        if(arbol!=null && !(arbol.isEmpty())) return nuevoArbol(arbol,0,0);
        return resultado;
    }

    private static BinaryTree<List<Integer>> nuevoArbol(BinaryTree<Integer> a,Integer datPadre, Integer total){
        total+= a.getData();
        List<Integer> datNodo = new ArrayList<>();
        datNodo.add(total);
        datNodo.add(a.getData()-datPadre);
        BinaryTree<List<Integer>> nuevoNodo = new BinaryTree<List<Integer>>(datNodo);
        if(a.hasLeftChild()){
            nuevoNodo.addLeftChild(nuevoArbol(a.getLeftChild(),a.getData(),total));
        }
        if(a.hasRightChild()){
            nuevoNodo.addRightChild(nuevoArbol(a.getRightChild(),a.getData(),total));
        }
        return nuevoNodo;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(20);

        BinaryTree<Integer> treeL = new BinaryTree<>(5);
        BinaryTree<Integer> treeR = new BinaryTree<>(30);

        BinaryTree<Integer> treeLL = new BinaryTree<>(-5);
        BinaryTree<Integer> treeLR = new BinaryTree<>(10);

        BinaryTree<Integer> treeRL = new BinaryTree<>(50);
        BinaryTree<Integer> treeRR = new BinaryTree<>(-5);

        BinaryTree<Integer> treeLRL = new BinaryTree<>(1);

        BinaryTree<Integer> treeRLR = new BinaryTree<>(4);

        BinaryTree<Integer> treeRLRR = new BinaryTree<>(6);

        tree.addLeftChild(treeL);
        tree.addRightChild(treeR);

        treeL.addLeftChild(treeLL);
        treeL.addRightChild(treeLR);

        treeR.addLeftChild(treeRL);
        treeR.addRightChild(treeRR);

        treeLR.addLeftChild(treeLRL);

        treeRL.addRightChild(treeRLR);

        treeRLR.addRightChild(treeRLRR);

        System.out.println(tree);
        System.out.println();
        System.out.println(sumAndDif(tree));
    }
}
