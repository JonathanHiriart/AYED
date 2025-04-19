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
        return toString("", SON_STATUS.NONE);
    }

    private enum SON_STATUS {
        NONE, UP, DOWN;
    }

    public String toString(String spacing, SON_STATUS sonstat) {
        if (this.isLeaf())
            return spacing + data;

        int dataLength = getData().toString().length();
        String dataLengthSpacing = " ".repeat(dataLength-1);

        String upperSpacing = spacing + (sonstat == SON_STATUS.DOWN ? "║   " : "    ") + dataLengthSpacing;
        String downSpacing = spacing + (sonstat == SON_STATUS.UP ? "║   " : "    ") + dataLengthSpacing;

        if (this.hasLeftChild() && this.hasRightChild())
            return this.getRightChild().toString(upperSpacing, SON_STATUS.UP) + "\n" +
                    spacing + data + " ══╣\n" +
                    this.getLeftChild().toString(downSpacing, SON_STATUS.DOWN);
        if (!this.hasLeftChild() && this.hasRightChild())
            return this.getRightChild().toString(upperSpacing, SON_STATUS.UP) + "\n" +
                    spacing + data + " ══╝";
        if (this.hasLeftChild() && !this.hasRightChild())
            return spacing + data + " ══╗\n" +
                    this.getLeftChild().toString(downSpacing, SON_STATUS.DOWN);

        return "" + data;
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
        }else if(m>=0){
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

