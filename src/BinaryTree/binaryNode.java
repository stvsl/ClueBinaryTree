package BinaryTree;

/***
 * 标准二叉树结点类
 */
public class binaryNode<T> {
    public T data;
    public binaryNode<T> left;
    public binaryNode<T> right;

    protected binaryNode(){
        this.data = null;
        this.left = null;
        this.right = null;
    }

    protected binaryNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    protected binaryNode(T data, binaryNode<T> left, binaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }
}
