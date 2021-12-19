package ClueBinaryTree;
import BinaryTree.binaryNode;
import BinaryTree.binaryTree;

public class clueBinaryTree<T> extends binaryTree<T> implements iClueBinaryTreeUnique<T>{
    
    clueBinaryNode<T> root = null;

    clueBinaryTree(binaryTree<T> tree) {
        initialize(tree);
    }

    /***
     * 线索二叉树初始化 <br>
     * 通过先序对其进行初始化
     * 
     * @param tree 要线索化的树
     */
    public void initialize(binaryTree<T> tree){
        
        
    }

    @Override
    public void toClueBinaryTreePre() {
        
    }

    @Override
    public void toClueBinaryTreeIn() {
    }

    @Override
    public void toClueBinaryTreePost() {
    }

    @Override
    public binaryNode<T> getParent(binaryNode<T> child) {
        
        return null;
    }

    @Override
    public binaryNode<T> getChild(binaryNode<T> parent, boolean isLChild) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public binaryNode<T> search(T key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void preorder() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void inorder() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void postorder() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int leaf() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int level(T key) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
