// import java.util.Scanner;

import BinaryTree.binaryTree;
import ClueBinaryTree.clueBinaryTree;

public class App {
    // private static Scanner reader;

    public static void main(String[] args) throws Exception {
        // reader = new Scanner(System.in);
        System.out.println("请输入一棵树");
        // binaryTree<String> originaltree = new binaryTree<String>(reader.next().split(","));
        binaryTree<String> originaltree = new binaryTree<String>("3,2,#,#,1".split(","));
        originaltree.preorder();
        originaltree.inorder();
        originaltree.postorder();
        clueBinaryTree<String> clueTree = new clueBinaryTree<String>(originaltree);
        clueTree.toClueBinaryTreePost();
        clueTree.postorder();
        System.out.println(clueTree.level("2"));
        System.out.println(clueTree.size());
        System.out.println(clueTree.leaf());
        System.out.println(clueTree.height());
        System.out.println(clueTree.getParent("2"));
    }
}
