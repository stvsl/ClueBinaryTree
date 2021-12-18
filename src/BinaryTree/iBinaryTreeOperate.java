package BinaryTree;

/****************************************************************
 * 二叉树结构操作接口
 ****************************************************************/

public interface iBinaryTreeOperate<T> {
     // 插入
     void insert(T x);
 
     // 插入 x 作为 p 的左/右孩子结点并返回
     binaryNode<T> insert(binaryNode<T> p, boolean left, T x);
 
     // 删除p结点的左/右孩子
     void remove(binaryNode<T> p, boolean isleft);
 
     // 查找并删除首个以p为根结点的子树
     void remove(T key);

     // 清空树
     void clear();
}
