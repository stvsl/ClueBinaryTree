package BinaryTree;

/****************************************************************
 * 二叉树基本操作独有特性接口
 ****************************************************************/

public interface iBinaryTreeUnique<T> {

        /***
         * 查询child的父节点
         */
        binaryNode<T> getParent(binaryNode<T> child);

        /***
         * 查询孩子结点
         * 
         * @param parent   父亲
         * @param isLChild 查询目标是否是它的左孩子
         *                 true 是
         *                 false 不是
         */
        binaryNode<T> getChild(binaryNode<T> parent, boolean isLChild);

        // 先根序遍历
        String preorder();

        // 中根序遍历
        String inorder();

        // 后根序遍历
        String postorder();

        // 先根序遍历非递归
        void preorderTraverse();

        // 层次遍历
        void levelorder();
}
