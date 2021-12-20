package ClueBinaryTree;

import BinaryTree.binaryNode;
import BinaryTree.binaryTree;

public class clueBinaryTree<T> extends binaryTree<T> implements iClueBinaryTreeUnique<T>{
    
    //二叉树根结点
    clueBinaryNode<T> root = null;

    //构造线索二叉树时记录其前一个结点
    clueBinaryNode<T> preNode = null;

    /**
     * 构造函数
     * 将根据一棵树进行线索化
     * @param tree
     */
    public clueBinaryTree(binaryTree<T> tree) {
        initialize(tree);
    }

    /***
     * 线索二叉树初始化 <br>
     * 通过后序对其进行初始化
     * 二次调用可以清空树的线索使其可以被重新线索化
     * 
     * @param tree 要线索化的树
     */
    public void initialize(binaryTree<T> tree){
        if(tree.root != null){
            this.root =new clueBinaryNode<T>(tree.root);
            this.root.left = initialize(tree.root.left);
            this.root.right = initialize(tree.root.right);
        }
        System.exit(0);
    }

    private clueBinaryNode<T> initialize(binaryNode<T> p) {
        clueBinaryNode<T> tmp = new clueBinaryNode<T>(p);
        if(p.left != null){
            tmp.left = initialize(p.left);
        }
        if(p.right != null){
            tmp.right = initialize(p.right);
        }
        return tmp;
    }

    @Override
    public void toClueBinaryTreePre() {
        this.toClueBinaryTreePre(this.root);
    }

    //先序递归线索化
    private void toClueBinaryTreePre(clueBinaryNode<T> p) {
        if(p != null){
            //如果其左子树为null时指向其前驱
            if(p.left == null){
                p.left = preNode;
                p.isleft = false;
            }
        }
    }

    @Override
    public void toClueBinaryTreeIn() {
    }

    @Override
    public void toClueBinaryTreePost() {
    }

    public binaryNode<T> getParent(clueBinaryNode<T> child) {
        
        return null;
    }

    public clueBinaryNode<T> getChild(clueBinaryNode<T> parent, boolean isLChild) {
        if(isLChild) {
            return parent.isleft ? parent.left : null;
        }else{
            return parent.isright ? parent.right : null;
        }
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
