package BinaryTree;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class binaryTree <T> implements iBinaryTreeMuster<T>, iBinaryTreeOperate<T> ,iBinaryTreeUnique<T>{
    /* 此树为二叉链表实现 */
       public binaryNode<T> root = null;

       public String result = "";

       // 无参构造
       public binaryTree() {
   
       }
   
       // 序列构造
       public binaryTree(T[] source) {
           this.root = prebuild(source);
       }
   
       private int i = 0;
   
       // 先根序指定构造递归单元
       private binaryNode<T> prebuild(T[] source) {
           binaryNode<T> p = null;
           if (i < source.length) {
               T element = source[i++];
               if (!element.equals("#")) {
                   p = new binaryNode<T>(element);
                   p.left = prebuild(source);
                   p.right = prebuild(source);
               }
           }
           return p;
       }
   
       @Override
       public binaryNode<T> getParent(binaryNode<T> child) {
           binaryNode<T> par = null;
           Stack<binaryNode<T>> stack = new Stack<binaryNode<T>>();
           binaryNode<T> p = this.root;
           while (p != null || !stack.isEmpty()) {
               if (p != null) {
                   if (p.left == child) {
                       par = p;
                       break;
                   } else {
                       stack.push(p);
                       p = p.left;
                   }
               } else {
                   p = stack.pop();
                   p = p.right;
               }
           }
           return par;
       }
   
       @Override
       public binaryNode<T> getChild(binaryNode<T> parent, boolean isLChild) {
           return isLChild ? parent.left : parent.right;
       }
   
       @Override
       public boolean isEmpty() {
           return root == null;
       }
   
       @Override
       public void insert(T x) {
           if (x != null) {
               this.root = new binaryNode<T>(x, this.root, null);
           }
       }
   
       @Override
       public binaryNode<T> insert(binaryNode<T> p, boolean left, T x) {
           if (p == null || x == null) {
               return null;
           } else {
               if (left) {
                   p.left = new binaryNode<T>(x, p.left, null);
                   return p.left;
               } else {
                   p.right = new binaryNode<T>(x, null, p.right);
                   return p.right;
               }
           }
       }
   
       @Override
       public void remove(binaryNode<T> p, boolean isleft) {
           if (p.data != null) {
               if (isleft) {
                   p.left = null;
               } else {
                   p.right = null;
               }
           }
       }
   
       @Override
       public void remove(T key) {
           Stack<binaryNode<T>> stack = new Stack<binaryNode<T>>();
           binaryNode<T> p = this.root;
           while (p != null || !stack.isEmpty()) {
               if (p != null) {
                   if (p.data.equals(key)) {
                       p.left = null;
                       p.right = null;
                       break;
                   } else {
                       stack.push(p);
                       p = p.left;
                   }
               } else {
                   p = stack.pop();
                   p = p.right;
               }
           }
       }
   
       @Override
       public void clear() {
           this.root = null;
       }
   
       @Override
       public String preorder() {
            result = "";
            preorder(this.root);
            System.out.println();
            return result;
       }
   
       @Override
       public String inorder() {
           result = "";
           inorder(this.root);
           System.out.println();
           return result;
       }
   
       @Override
       public String postorder() {
           result = "";
           postorder(this.root);
           System.out.println();
           return result;
       }
   
       private void preorder(binaryNode<T> p) {
           if (p != null) {
               System.out.print(p.data.toString() + "\t");
               result += p.data.toString() + "\t";
               preorder(p.left);
               preorder(p.right);
           }
       }
   
       private String inorder(binaryNode<T> p) {
           if (p != null) {
               inorder(p.left);
               System.out.print(p.data.toString() + "\t");
               result += p.data.toString() + "\t";
               inorder(p.right);
           }
           return result;
       }
   
       private void postorder(binaryNode<T> p) {
           if (p != null) {
                postorder(p.left);
                postorder(p.right);
                System.out.print(p.data.toString() + "\t");
                result += p.data.toString() + "\t";
            }
       }
   
       @Override
       public void preorderTraverse() {
           Stack<binaryNode<T>> stack = new Stack<binaryNode<T>>();
           binaryNode<T> p = this.root;
           while (p != null || !stack.isEmpty()) {
               if (p != null) {
                   System.out.print(p.data.toString() + "\t");
                   stack.push(p);
                   p = p.left;
               } else {
                   System.out.println("^ ");
                   p = stack.pop();
                   p = p.right;
               }
               System.out.println("^ ");
           }
       }
   
       @Override
       public void levelorder() {
           Queue<binaryNode<T>> que = new LinkedBlockingQueue<binaryNode<T>>();
           que.add(this.root);
           while (!que.isEmpty()) {
               binaryNode<T> p = que.poll();
               System.out.print(p.data.toString() + "\t");
               if (p.left != null) {
                   que.add(p.left);
               }
               if (p.right != null) {
                   que.add(p.right);
               }
           }
           System.out.println();
       }
   
       @Override
       public int size() {
           Stack<binaryNode<T>> stack = new Stack<binaryNode<T>>();
           binaryNode<T> p = this.root;
           int num = 0;
           while (p != null || !stack.isEmpty()) {
               if (p != null) {
                   num++;
                   stack.push(p);
                   p = p.left;
               } else {
                   p = stack.pop();
                   p = p.right;
               }
           }
           return num;
       }
   
       @Override
       public int height() {
            return this.height(this.root);
       }
       
       private int height(binaryNode<T> root) {
           if (root == null) {
               return 0;
           } else {
               int l = this.height(root.left);
               int r = this.height(root.right);
               return l > r ? l + 1 : r + 1;
           }
       }
   
       @Override
       public T search(T key) {
           Stack<binaryNode<T>> stack = new Stack<binaryNode<T>>();
           binaryNode<T> p = this.root;
           binaryNode<T> target = null;
           while (p != null || !stack.isEmpty()) {
               if (p != null) {
                   if (p.data.equals(key)) {
                       target = p;
                       break;
                   }
                   stack.push(p);
                   p = p.left;
               } else {
                   p = stack.pop();
                   p = p.right;
               }
           }
           return target.data;
       }
   
       @Override
       public int level(T key) {
           if (key == null) {
               return -1;
           } else if (root == null) {
               return 0;
           } else if (key.equals(root.data)) {
               return 1;
           } else {
               int l = this.level(root.left, key);
               int r = this.level(root.right, key);
               return l > r ? l + 1 : r + 1;
           }
       }
   
       public int level(binaryNode<T> root, T key) {
           if (key == null) {
               return -1;
           } else if (root == null) {
               return 0;
           } else if (key.equals(root.data)) {
               return 1;
           } else {
               int l = this.level(root.left, key);
               int r = this.level(root.right, key);
               return l > r ? l + 1 : r + 1;
           }
       }
   
       @Override
       public int leaf() {
           if (root == null) {
               return 0;
           }
           Queue<binaryNode<T>> que = new LinkedBlockingQueue<binaryNode<T>>();
           que.add(root);
           int sum = 0;
           binaryNode<T> p = null;
           while (!que.isEmpty()) {
               p = que.poll();
               if (p.isLeaf()) {
                   sum++;
               } else {
                   if (p.left != null) {
                       que.add(p.left);
                   }
                   if (p.right != null) {
                       que.add(p.right);
                   }
               }
           }
           return sum;
       }
}
