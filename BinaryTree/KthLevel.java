package BinaryTree;

public class KthLevel {
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

    public static void kthlvl(Node root, int k, int lvl){
        if(root == null){
            return;
        }

        if(lvl == k){
            System.out.print(root.data+" ");
            return;
        }

        kthlvl(root.left, k, lvl+1);
        kthlvl(root.right, k, lvl+1);
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

        int k = 3;
        kthlvl(root, k, 1);
    }
}
