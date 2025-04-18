package TP2.EJ1;

public class BinaryTree <T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;


    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;

    }

    public T getData() {
        return data;

    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        if (this.leftChild == null) {
            return null;
        }
        return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
        if (this.rightChild == null) {
            return null;
        }
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        if (this.hasLeftChild()) {
            throw new IllegalArgumentException("Ya existe un hijo izquierdo");
        }
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        if (this.hasRightChild()) {
            throw new IllegalArgumentException("Ya existe un hijo derecho");
        }
        this.rightChild = child;
    }

    public void removeLeftChild() {
        if (!this.hasLeftChild()) {
            throw new IllegalArgumentException("No existe un hijo izquierdo");
        }
        this.leftChild = null;
    }

    public void removeRightChild() {
        if (!this.hasRightChild()) {
            throw new IllegalArgumentException("No existe un hijo derecho");
        }
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() {
        return this.rightChild!=null;
    }
    @Override
    public String toString() {
        return this.getData().toString();
    }

    public  int contarHojas() {
        int hojas = 0;
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        if (this.hasLeftChild()) {
            hojas += this.getLeftChild().contarHojas();
        }
        if (this.hasRightChild()) {
            hojas += this.getRightChild().contarHojas();
        }
        return hojas;
    }



    public BinaryTree<T> espejo(){
        if (this.isLeaf()){
            return this;
        }
        BinaryTree<T> temporal = this.getLeftChild();

        if (this.hasLeftChild()){
            this.getLeftChild().espejo();
        }
        if (this.hasRightChild()){
            this.getRightChild().espejo();
        }
        return this;
    }

    // 0<=n<=m
    public void entreNiveles(int n, int m){
        if (n<m){
            return;
        }
        if (n>0 ){
            if (this.hasLeftChild()){
                this.leftChild.entreNiveles(n-1,m -1);
            }
            if (this.hasRightChild()){
                this.rightChild.entreNiveles(n-1,m-1);
            }
        }else if(m>0){
            System.out.println(this);
            if (this.hasLeftChild()){
                this.leftChild.entreNiveles(0,m-1);
            }
            if (this.hasRightChild()){
                this.rightChild.entreNiveles(0,m-1);
            }
        }
    }

}

