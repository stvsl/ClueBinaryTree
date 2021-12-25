package BinaryTree;

/****************************************************************
 * 二叉树结构操作接口
 * @author stvsl
 * @date 2021.12.25
 ****************************************************************/

public interface iBinaryTreeOperate<T> {
     /***
      * 插入
      */
     void insert(T x);

     /***
      * 插入 x 作为 p 的左/右孩子结点并返回
      * 
      * @param p    插入成为p结点的孩子
      * @param left 是否作为作为左孩子
      * @param x    待插入的元素
      */
     binaryNode<T> insert(binaryNode<T> p, boolean left, T x);

     /***
      * 删除p结点的左/右孩子
      * 
      * @param isleft 是否为其左孩子
      *               是 true
      *               否 false
      */
     void remove(binaryNode<T> p, boolean isleft);

     /***
      * 查找并删除首个以p为根结点的子树
      */
     void remove(T key);

     /***
      * 清空树
      */
     void clear();
}
