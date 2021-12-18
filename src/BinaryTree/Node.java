package BinaryTree;

/**
 * 结点类
 * @param data      数据域
 * @param left      左子树
 * @param right     右子树
 * @param isleft    是否是左孩子,默认为true
 * @param isright   是否是右孩子,默认为true
 *                                                  @author stvsl
 *                                                  @date 2021.12.18
 */
public class Node <T> {
    
    //数据存储
    T data;
    //左子树
    Node <T> left;
    //右子数
    Node <T> right;
    //左子树判定
    boolean isleft;
    //右子数判定
    boolean isright;

    Node(){
        this.data = null;
        left = null;
        right = null;
        isleft = true;
        isright = true;
    }
}
