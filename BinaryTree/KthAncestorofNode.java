package BinaryTree;

public class KthAncestorofNode {
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

    public static int findKthAns(Node root, int n, int k){
        
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftdist = findKthAns(root.left, n, k);
        int rightdist = findKthAns(root.right, n, k);

        if(leftdist == -1 && rightdist == -1){
            return -1;
        }

        int max= Math.max(leftdist, rightdist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;


        // USELESS THOUGHTHS or THINKING LOGIC :(

        //  | | | | | | |
        //  V V V V V V V 

        // if(leftdist == -1 && rightdist == -1){
        //     return -1;
        // }else if(leftdist + 1 == k){
        //     return root.data;
        // }else if(rightdist + 1 == k){
        //     return root.data;
        // }else if(leftdist != -1){
        //     return leftdist + 1;
        // }else{
        //     return rightdist + 1;
        // }
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

        int n = 5;
        int k = 1;
        findKthAns(root, n, k);
    }
}
