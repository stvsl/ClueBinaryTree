package ClueBinaryTree;

public interface iClueBinaryTreeUnique <T>{
    
    /***
     * 先根序遍历
     */
    void preorder();

    /*** 
     * 中根序遍历
     */
    void inorder();

    /*** 
     * 后根序遍历
     */
    void postorder();

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
