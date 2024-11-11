package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumTree {

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

    public static int makeSumTree(Node root) {
        if(root == null){
            return 0;
        }

        int leftsum = makeSumTree(root.left);
        int rightsum = makeSumTree(root.right);

        int rtdta = root.data;
        root.data = leftsum + rightsum;
        return root.data + rtdta;
    }
    public static void main(String[] args) {

        //        1
        //       /  \
        //      2    3
        //     / \  / \ 
        //    4  5 7   6
    
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);

        int md = makeSumTree(root);
        System.out.println(md);

        levelorder(root);
    }
}
