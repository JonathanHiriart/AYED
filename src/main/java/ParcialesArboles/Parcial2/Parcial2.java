package ParcialesArboles.Parcial2;

import TP2.EJ1.BinaryTree;

public class Parcial2 {
    BinaryTree<Integer> arbol;

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public Parcial2(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    public  boolean resolver(int k){
        if(arbol!=null && !(arbol.isEmpty())) return monodistante(arbol,0, k);
        return false;
    }
    private boolean monodistante(BinaryTree<Integer>a,int caminoactual,int k){
        caminoactual+=a.getData();
        if(a.isLeaf()){
            return caminoactual == k;
        }
        if(a.hasLeftChild()){
            if(!monodistante(a.getLeftChild(),caminoactual,k)){
                return false;
            }
        }
        if(a.hasRightChild()){
            if(!monodistante(a.getLeftChild(),caminoactual,k)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
            BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
            ab.addLeftChild(new BinaryTree<Integer>(3));
            ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(3));
            ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
            ab.addRightChild(new BinaryTree<Integer>(4));
            ab.getRightChild().addLeftChild(new BinaryTree<Integer>(1));
            ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
            ab.getRightChild().addRightChild(new BinaryTree<Integer>(2));

            Parcial2 a = new Parcial2(ab);
            System.out.println(a.resolver(7));

    }
}
