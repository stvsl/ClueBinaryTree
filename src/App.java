import java.util.Scanner;

import BinaryTree.binaryTree;

public class App {
    // private static Scanner reader;

    public static void main(String[] args) throws Exception {
        // reader = new Scanner(System.in);
        System.out.println("请输入一棵树");
        // binaryTree<String> originaltree = new binaryTree<String>(reader.next().split(","));
        binaryTree<String> originaltree = new binaryTree<String>("A,B,#,#,C".split(","));
        originaltree.preorder();
        originaltree.inorder();
        originaltree.postorder();
    }
}
