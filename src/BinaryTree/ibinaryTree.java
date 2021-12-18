package BinaryTree;

public interface ibinaryTree<T> {
     // 查询父节点
     BinaryNode<T> getParent(BinaryNode<T> child);

     // 查询孩子结点
     BinaryNode<T> getChild(BinaryNode<T> parent, boolean isLChild);
 
     // 判空
     boolean isEmpty();
 
     // 插入
     void insert(T x);
 
     // 插入 x 作为 p 的左/右孩子结点并返回
     BinaryNode<T> insert(BinaryNode<T> p, boolean left, T x);
 
     // 删除p结点的左/右孩子
     void remove(BinaryNode<T> p, boolean isleft);
 
     // 查找并删除首个以p为根结点的子树
     void remove(T key);
 
     // 清空树
     void clear();
 
     // 先根序遍历
     void preorder();
 
     // 中根序遍历
     void inorder();
 
     // 后根序遍历
     void postorder();
 
     // 先根序遍历重载
     void preorder(BinaryNode<T> p);
 
     // 中根序遍历重载
     void inorder(BinaryNode<T> p);
 
     // 后根序遍历重载
     void postorder(BinaryNode<T> p);
 
     //先根序遍历非递归
     void preorderTraverse();
 
     // 层次遍历
     void levelorder();
 
     // 返回结点个数
     int size();
 
     // 返回二叉树高度
     int height();
 
     // 查找并返回首个与key元素相等的结点
     BinaryNode<T> search(T key);
 
     // 返回查找并返回首个与key元素相等的结点的所在层次
     int level(T key);
 
     //统计叶子节点数
     int leaf();
}
