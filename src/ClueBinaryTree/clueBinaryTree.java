package ClueBinaryTree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import BinaryTree.binaryNode;
import BinaryTree.binaryTree;

public class clueBinaryTree<T> extends binaryTree<T> implements iClueBinaryTreeUnique<T> {

    // 二叉树根结点
    clueBinaryNode<T> root = null;

    // 构造线索二叉树时记录其前一个结点
    clueBinaryNode<T> preNode = null;

    // 线索二叉树长度
    // 进行线索二叉树后序遍历时临时栈长度
    int length = 0;

    /***
     * 状态控制器
     * 状态:
     * -1 未初始化
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
     * 通过先序对其进行初始化
     * 二次调用可以清空树的线索使其可以被重新线索化
     * 
     * @param tree 要线索化的树
     */
    public void initialize(binaryTree<T> tree) {
        this.length = 0;
        if (tree.root != null) {
            this.length++;
            this.root = new clueBinaryNode<T>(tree.root);
            if (tree.root.left != null) {
                this.root.left = initialize(tree.root.left);
            }
            if (tree.root.right != null) {
                this.root.right = initialize(tree.root.right);
            }
        }
        this.status = 0;
    }

    /**
     * 线索二叉树初始化递归单元
     * 
     * @param p
     */
    private clueBinaryNode<T> initialize(binaryNode<T> p) {
        this.length++;
        clueBinaryNode<T> tmp = new clueBinaryNode<T>(p.data);
        if (p.left != null) {
            tmp.left = initialize(p.left);
        }
        if (p.right != null) {
            tmp.right = initialize(p.right);
        }
        return tmp;
    }

    @Override
    public void toClueBinaryTreePre() {
        this.toClueBinaryTreePre(this.root);
        // 结束递归后,最后的结点的右指针变更为false,其表示它的后继为null
        preNode.isright = false;
        preNode = null;
        // 对象状态是表示先序线索二叉树
        this.status = 1;
    }

    // 先序线索化递归执行单元
    private void toClueBinaryTreePre(clueBinaryNode<T> p) {
        if(status != 0) {
            return;
        }
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
        if(status != 0) {
            return;
        }
        this.toClueBinaryTreeIn(this.root);
        // 结束递归后,最后的结点的右指针变更为false,其表示它的后继为null
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
        if(status != 0) {
            return;
        }
        this.toClueBinaryTreePost(this.root);
        preNode = null;
        this.status = 3;
    }

    private void toClueBinaryTreePost(clueBinaryNode<T> p) {
        if (p != null) {
            this.toClueBinaryTreePost(p.left);
            this.toClueBinaryTreePost(p.right);
            if(p.left != null) {
                p.left.parent = p;
            }
            if(p.right != null) {
                p.right.parent = p;
            }
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
    public T getParent(T data) {
        Stack<clueBinaryNode<T>> stack = new Stack<clueBinaryNode<T>>();
        clueBinaryNode<T> p = this.root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                if (p.left.data.equals(data)) {
                    preNode = p;
                    break;
                } else {
                    stack.push(p);
                    p = p.left;
                }
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        T elereturn = preNode.data;
        preNode = null;
        return elereturn;
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
        return this.length;
    }

    @Override
    public int height() {
        return this.height(this.root);
    }

    // 计算二叉树高度递归调用单元
    private int height(clueBinaryNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            int l = 0, r = 0;
            if (p.isleft) {
                l = this.height(p.left);
            }
            if (p.isright) {
                r = this.height(p.right);
            }
            return l > r ? l + 1 : r + 1;
        }
    }

    @Override
    public T search(T key) {
        Stack<clueBinaryNode<T>> stack = new Stack<clueBinaryNode<T>>();
        clueBinaryNode<T> p = this.root;
        while (p != null || !stack.isEmpty()) {
            if (p != null && p.isleft && p.isright) {
                if (p.left.data.equals(key)) {
                    preNode = p;
                    break;
                } else {
                    stack.push(p);
                    p = p.left;
                }
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        T result = null;
        if (preNode.left.data.equals(key)) {
            result = preNode.left.data;
        } else {
            result = preNode.right.data;
        }
        return result;
    }

    @Override
    public String preorder() {
        if (this.status != 1) {
            System.out.println("遍历错误,当前不是先序线索二叉树");
            // 不返回调用跳出
        }
        String result = "";
        clueBinaryNode<T> p = this.root;
        // 循环遍历部分
        while (p != null) {
            // 从根结点开始遍历,直到到达最左面第一个结点
            while (p.left != null && p.isleft) {
                System.out.print(p.data.toString() + "\t");
                result += p.data.toString() + "\t";
                p = p.left;
            }
            // 设计缺陷弥补,结点data未访问
            System.out.print(p.data.toString() + "\t");
            result += p.data.toString() + "\t";
            // 此时,如果右子树不是右孩子,则说明是其后继,直接前往
            if (!p.isright) {
                p = p.right;
            }
            while (p != null) {
                if (p.isleft) {
                    break;
                }
                System.out.print(p.data.toString() + "\t");
                result += p.data.toString() + "\t";
                p = p.right;
            }
        }
        System.out.println();
        return result;
    }

    @Override
    public String inorder() {
        if (this.status != 2) {
            System.out.println("遍历错误,当前不是中序线索二叉树");
            // 不返回调用跳出
            return "ERROR";
        }
        String result = "";
        clueBinaryNode<T> p = this.root;
        while (p != null && p.isleft) {
            p = p.left;
        }
        while (p != null) {
            // 先找到最左面的第一个结点(中序遍历从此开始)    
            System.out.print(p.data.toString() + "\t");
            result += p.data.toString() + "\t";
            // 循环遍历部分
            // 在左子树没有时,一直遍历读取右子树
            // 由于当右孩子没有时右孩子指针指向下一个元素的位置,所以不必去寻找此位置,直接访问即可
            p = p.right;
            while (p != null && p.isright) {
                System.out.print(p.data.toString() + "\t");
                result += p.data.toString() + "\t";
                p = p.right;
                while (p != null && p.isleft) {
                    p = p.left;
                }
            }
        }
        System.out.println();
        return result;
    }

    @Override
    public String postorder() {
        if (this.status != 3) {
            System.out.println("遍历错误,当前不是后序线索二叉树");
            // 不返回调用跳出
            return "ERROR";
        }
        // 临时存储栈(临时存放倒序结果)
        Object[] result = new Object[this.length];
        int status = 0;
        // 逆向遍历操作,由于后续遍历相当于对每个结点进行左右自身的遍历,则其逆向就是自身右左遍历
        // 根据其分析可以发现对于此步骤自身与右可以合并同时处理,对所有结点进行相同处理即可
        // 将遍历结果存储到简易栈内等待循环结束后输出即可
        clueBinaryNode<T> p = this.root;
        while (p != null) {
            // 遍历自身与右子树
            while (p != null && p.isright && p.right != null) {
                result[status++] = p.data;
                p = p.right;
            }
            // 设计缺陷弥补
            result[status++] = p.data;
            // 对其遍历左子树
            while (p.left != null && !p.isleft) {
                p = p.left;
                result[status++] = p.data;
            }
            p = p.left;           

        }
        String tmp = "";
        // 直接从后向前输出,随后交给jvm一并进行垃圾回收
        for (int i = status - 1; i >= 0; i--) {
            System.out.print(result[i].toString() + "\t");
            tmp += result[i].toString() + "\t";
        }
        System.out.println();
        return tmp;
    }

    public String postorder2(){
        String result = "";
        clueBinaryNode<T> p = this.root;
        //寻找开始结点
        while(p!= null && p.isleft){
            p = p.left;
        }
        preNode = null;
        while(p != null){
            //如果右边是线索
            if(!p.isright){
                result += p.data.toString() + "\t";
                System.out.print(p.data.toString() + "\t");
                preNode = p;
                p = p.right;
            }else{
                //如果上个处理的结点是当前结点的右结点
                if(p.right == preNode){
                    System.out.print(p.data.toString() + "\t");
                    result += p.data.toString() + "\t";
                    if(p == root){
                        break;
                    }
                    preNode = p;
                    p = p.parent;
                }else{
                    p = p.right;
                    while (p != null && p.isleft){
                        p = p.left;
                    }
                }   
            }
        }
        System.out.println();
        return result;
    }

    @Override
    public int leaf() {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<clueBinaryNode<T>> que = new LinkedBlockingQueue<clueBinaryNode<T>>();
        que.add(root);
        clueBinaryNode<T> p;
        while (!que.isEmpty()) {
            p = que.poll();
            if (p.isLeaf()) {
                sum = sum + 1;
            } else {
                if (p.isleft && p.left != null) {
                    que.add(p.left);
                }
                if (p.isright && p.right != null) {
                    que.add(p.right);
                }
            }
        }
        return sum;
    }

    @Override
    public int level(T key) {
        if (key == null) {
            return -1;
        } else {
            return this.level(root, key);
        }
    }

    // 查找指定元素所在层次递归执行单元
    private int level(clueBinaryNode<T> p, T key) {
        if (p == null) {
            return 0;
        } else if (key.equals(p.data)) {
            return 1;
        } else {
            int l = 0;
            int r = 0;
            if (p.isleft) {
                l = this.level(p.left, key);
            }
            if (p.isright) {
                r = this.level(p.right, key);
            }
            return l > r ? l + 1 : r + 1;
        }
    }
}
