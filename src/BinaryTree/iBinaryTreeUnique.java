package BinaryTree;

/****************************************************************
 * 二叉树基本操作独有特性接口
 ****************************************************************/

 public interface iBinaryTreeUnique<T> {
         // 先根序遍历
         void preorder();
 
         // 中根序遍历
         void inorder();
     
         // 后根序遍历
         void postorder();
     
         //先根序遍历非递归
         void preorderTraverse();
     
         // 层次遍历
         void levelorder();
}
