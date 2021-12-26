package ClueBinaryTree;

/****************************************************************
 * 线索二叉树独有操作接口
 ****************************************************************/
public interface iClueBinaryTreeUnique <T>{
    
    /***
     * 先根序遍历
     */
    String preorder();

    /*** 
     * 中根序遍历
     */
    String inorder();

    /*** 
     * 后根序遍历
     */
    String postorder();

    /***
     * 先序线索化
     */
    void toClueBinaryTreePre();

    /***
     * 中序线索化
     */
    void toClueBinaryTreeIn();

    /***
     * 后序线索化
     */
    void toClueBinaryTreePost();
}
