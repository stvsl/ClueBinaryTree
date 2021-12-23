// import java.util.Scanner;

import BinaryTree.binaryTree;
import ClueBinaryTree.clueBinaryTree;

public class App {
    // private static Scanner reader;

    public static void main(String[] args) throws Exception {
        // reader = new Scanner(System.in);
        System.out.println("请输入一棵树");
        // binaryTree<String> originaltree = new binaryTree<String>(reader.next().split(","));
        binaryTree<String> originaltree = new binaryTree<String>("3,#,2,1,#,#,d,6,7,4".split(","));
        originaltree.preorder();
        originaltree.inorder();
        originaltree.postorder();
        clueBinaryTree<String> clueTree = new clueBinaryTree<String>(originaltree);
        clueTree.toClueBinaryTreePost();
        clueTree.postorder();
        System.out.println(clueTree.size());
    }
}
