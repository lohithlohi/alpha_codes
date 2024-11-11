package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        static int idx = -1;

        public Node BuildTree(int[] nodes) {
            idx+=1;
            if (nodes[idx] == -1) {
                return null;
            }

            // using preorder series
            Node newnode = new Node(nodes[idx]);
            newnode.left = BuildTree(nodes);
            newnode.right = BuildTree(nodes);

            return newnode;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelorder(Node root){
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while (!que.isEmpty()) {
            Node ptr = que.remove();
            if(ptr==null){
                System.out.println();
                if (que.isEmpty()) {
                    break;
                }
                que.add(null);
            }else{
                System.out.print(ptr.data+" ");
                if(ptr.left != null){
                    que.add(ptr.left);
                }
                if(ptr.right != null){
                    que.add(ptr.right);
                }
            }
        }
        
    }
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, - 1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(nodes);
        // System.out.println(root.data);

        // preorder(root);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // postorder(root);
        // System.out.println();

        levelorder(root);
    }
}
