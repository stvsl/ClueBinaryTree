package BinaryTree;

/****************************************************************
 * 二叉树主接口
 ****************************************************************/
public interface iBinaryTreeMuster<T> {
     // 查询父节点
     binaryNode<T> getParent(binaryNode<T> child);

     // 查询孩子结点
     binaryNode<T> getChild(binaryNode<T> parent, boolean isLChild);
 
     // 判空
     boolean isEmpty();
 
     // 清空树
     void clear();
 
     // 返回结点个数
     int size();
 
     // 返回二叉树高度
     int height();
 
     // 查找并返回首个与key元素相等的结点
     binaryNode<T> search(T key);
 
     // 返回查找并返回首个与key元素相等的结点的所在层次
     int level(T key);
 
     //统计叶子节点数
     int leaf();
}
