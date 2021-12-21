package ClueBinaryTree;

import BinaryTree.binaryNode;
import BinaryTree.binaryTree;

public class clueBinaryTree<T> extends binaryTree<T> implements iClueBinaryTreeUnique<T> {

    // 二叉树根结点
    clueBinaryNode<T> root = null;

    // 构造线索二叉树时以及后续线索遍历时记录其前一个结点
    clueBinaryNode<T> preNode = null;

    /***
     * 状态控制器
     * 状态:
     *  -1 未初始化
     * 0 仅初始化
     * 1 先序线索
     * 2 中序线索
     * 3 后序线索
     */
    private int status = -1;

    /**
     * 构造函数
     * 将根据一棵树进行线索化
     * 
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
    public void initialize(binaryTree<T> tree) {
        if (tree.root != null) {
            this.root = new clueBinaryNode<T>(tree.root);
            this.root.left = initialize(tree.root.left);
            this.root.right = initialize(tree.root.right);
        }
        this.status = 0;
    }

    /**
     * 线索二叉树初始化递归单元
     * 
     * @param p
     * @return
     */
    private clueBinaryNode<T> initialize(binaryNode<T> p) {
        clueBinaryNode<T> tmp = new clueBinaryNode<T>(p.data);
        if (p != null && p.left != null && p.data != null) {
            tmp.left = initialize(p.left);
        }
        if (p != null && p.right != null && p.data != null) {
            tmp.right = initialize(p.right);
        }
        return tmp;
    }

    @Override
    public void toClueBinaryTreePre() {
        this.toClueBinaryTreePre(this.root);
        //结束递归后,最后的结点的右指针变更为false,其表示它的后继为null
        preNode.isright = false;
        preNode = null;
        //对象状态是表示先序线索二叉树
        this.status = 1;
    }

    // 先序线索化递归执行单元
    private void toClueBinaryTreePre(clueBinaryNode<T> p) {
        if (p != null) {
            // 先序线索化时会因p的左右子树发生变化导致进入死循环,所以需要先保存p的左右孩子
            clueBinaryNode<T> tmpl = p.left;
            clueBinaryNode<T> tmpr = p.right;
            // 如果其左子树为null时指向其前驱
            if (p.left == null) {
                p.left = preNode;
                p.isleft = false;
            }
            // 前一个结点的右孩子如果为null则其现在可以更正为其后继结点
            // 此时,前一个结点的后继结点就是p
            if (preNode != null && preNode.right == null) {
                preNode.right = p;
                preNode.isright = false;
            }
            preNode = p;
            // 继续对原来p的左子树线索化
            this.toClueBinaryTreePre(tmpl);
            // 然后对原来p的右子树线索化
            this.toClueBinaryTreePre(tmpr);
        }
    }

    @Override
    public void toClueBinaryTreeIn() {
        this.toClueBinaryTreeIn(this.root);
        //结束递归后,最后的结点的右指针变更为false,其表示它的后继为null
        preNode.isright = false;
        preNode = null;
        this.status = 2;
    }

    // 中序线索化递归执行单元
    private void toClueBinaryTreeIn(clueBinaryNode<T> p) {
        if (p != null) {
            this.toClueBinaryTreeIn(p.left);
            if (p.left == null) {
                p.left = preNode;
                p.isleft = false;
            }
            if (preNode != null && preNode.right == null) {
                preNode.right = p;
                preNode.isright = false;
            }
            preNode = p;
            this.toClueBinaryTreeIn(p.right);
        }
    }

    @Override
    public void toClueBinaryTreePost() {
        this.toClueBinaryTreePost(this.root);
        preNode = null;
        this.status = 3;
    }

    private void toClueBinaryTreePost(clueBinaryNode<T> p) {
        if (p != null) {
            this.toClueBinaryTreePost(p.left);
            this.toClueBinaryTreePost(p.right);
            if (p.left == null) {
                p.left = preNode;
                p.isleft = false;
            }
            if (preNode != null && preNode.right == null) {
                preNode.right = p;
                preNode.isright = false;
            }
            preNode = p;
        }
    }

    /***
     * 非正常继承继承
     * 获取其双亲结点
     */
    public clueBinaryNode<T> getParent(clueBinaryNode<T> child) {
        // TODO Auto-generated method stub
        return null;
    }

    public clueBinaryNode<T> getChild(clueBinaryNode<T> parent, boolean isLChild) {
        if (isLChild) {
            return parent.isleft ? parent.left : null;
        } else {
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
        if(this.status != 1) {
            System.out.println("遍历错误,当前不是先序线索二叉树");
            //不返回调用跳出
            return;
        }
        clueBinaryNode<T> p = this.root;
        //循环遍历部分
        while(p != null) {
            //从根结点开始遍历,直到到达最左面第一个结点
            while(p.left != null && p.isleft) {
                System.out.print(p.data.toString() + "\t");
                p = p.left;
            }
            //设计缺陷弥补,结点data未访问
            System.out.print(p.data.toString() + "\t");
            //此时,如果右子树不是右孩子,则说明是其后继,直接前往
            if(!p.isright){
                p = p.right;
            }
            //
            while(p != null){
                if(p.isleft){
                    break;
                }
                System.out.print(p.data.toString() + "\t");
                p = p.right;
            }
        
        }
        System.out.println();
    }

    @Override
    public void inorder() {
        if(this.status != 2) {
            System.out.println("遍历错误,当前不是中序线索二叉树");
            //不返回调用跳出
            return;
        }
        clueBinaryNode<T> p  = this.root;
        //先找到最左面的第一个结点(中序遍历从此开始)
        while (p != null && p.isleft) {
            p = p.left;
        }
        //循环遍历部分
        while(p != null){
            //在左子树没有时,一直遍历读取右子树
            //由于当右孩子没有时右孩子指针指向下一个元素的位置,所以不必去寻找此位置,直接访问即可
            System.out.print(p.data.toString() + "\t");
            p = p.right;
            if(p != null && p.isright){
                //如果左子树存在左孩子则一直往左子树移动
                while (p != null && !p.isleft){
                    p = p.left;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void postorder() {
        if(this.status != 3) {
            System.out.println("遍历错误,当前不是后序线索二叉树");
            //不返回调用跳出
            return;
        }
        clueBinaryNode<T> p  = this.root;
        // while(p != null){
        //     //先找到最左面结点,其不能指向它的前驱,防止死循环
        //     while(p.left != preNode && p.isleft){
        //         p = p.left;
        //     }
        //     //访问后继结点
        //     while(p != null && p.isright){
        //         System.out.print(p.data.toString() + "\t");
        //         preNode = p;
        //         p = p.right;
        //     }
        //     //判断此时p是否指向根结点,如果指向说明遍历结束
        //     if(p == root){
        //         System.out.println(p.data.toString());
        //         break;
        //     }
        //     while(p != null && p.right == preNode){
        //         System.out.print(p.data.toString() + "\t");
        //         preNode = p;
        //         p = this.getParent(p);
        //     }
        //     if(p != null && p.isright){
        //         p = p.right;
        //     }
        // }
        while(p != null) {
            while(p != null && p.isright){
                System.out.print(p.data.toString() + "\t");
                p = p.right;
            }
            System.out.print(p.data.toString() + "\t");
            while(p.left!= null && !p.isleft){
                p = p.left;
                System.out.print(p.data.toString() + "\t");
            }
            p = p.left;
        }
        System.out.println();
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
