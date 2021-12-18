package ClueBinaryTree;
import BinaryTree.binaryNode;

/***
 * 结点类
 * @param data      数据域
 * @param left      左子树
 * @param right     右子树
 * @param isleft    是否是左孩子,默认为true
 * @param isright   是否是右孩子,默认为true
 *                                                  @author stvsl
 *                                                  @date 2021.12.18
 */

public class clueBinaryNode <T> extends binaryNode<T> {
    
    //数据存储
    T data;
    //左子树
    clueBinaryNode <T> left;
    //右子数
    clueBinaryNode <T> right;
    //左子树判定
    boolean isleft;
    //右子数判定
    boolean isright;

    clueBinaryNode(){
        super();
        isleft = true;
        isright = true;
    }
    /**
     * 有参构造,单参数,其他草书默认为null与true
     * @param data
     */
    clueBinaryNode(T data){
        super(data);
        this.isleft = true;
        this.isright = true;
    }

    /**
     * 有参构造,构造无需指定isleft与isright,默认为true
     * @param data
     * @param left
     * @param right
     */
    clueBinaryNode(T data,clueBinaryNode<T> left,clueBinaryNode<T> right) {
        super(data,left,right);
        this.isleft = true;
        this.isright = true;
    }
}
