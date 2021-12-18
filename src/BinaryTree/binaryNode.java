package BinaryTree;

public class BinaryNode<T> {
    T data;
    BinaryNode<T> left;
    BinaryNode<T> right;

    protected BinaryNode(){
        this.data = null;
        this.left = null;
        this.right = null;
    }

    protected BinaryNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    protected BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }
}
