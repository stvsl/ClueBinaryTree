package BinaryTree;

/****************************************************************
 * 二叉树主接口
 * 包含对二叉树的公有基本操作
 *                            @author   stvsl
 *                            @date     2001.12.19
 ****************************************************************/

public interface iBinaryTreeMuster<T> {
     /***
      * 查询child的父节点
      */
     binaryNode<T> getParent(binaryNode<T> child);

     /***
      * 查询孩子结点
      * @param parent    父亲
      * @param isLChild  查询目标是否是它的左孩子 
      *                       true 是
      *                       false 不是
      */
     binaryNode<T> getChild(binaryNode<T> parent, boolean isLChild);
 
     /***
      * 判空
      */
     boolean isEmpty();
 
     /***
      * 返回结点个数
      */ 
     int size();
 
     /*** 
      * 返回二叉树高度
      */ 
     int height();
 
     /*** 
      * 查找并返回首个与key元素相等的结点
      */ 
     binaryNode<T> search(T key);
 
     /***
      * 返回查找并返回首个与key元素相等的结点的所在层次
      * @param key  查找的元素
      */
     int level(T key);
 
     /***
      * 统计叶子节点数
      */
      int leaf();
}
