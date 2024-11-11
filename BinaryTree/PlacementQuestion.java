package BinaryTree;

public class PlacementQuestion {

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
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

// ------------------------------------------------------------------- //
    public static Node construct(Node root){
        // base case
        if(root.left == null && root.right == null){
            root.left = new Node(root.data);
            root.right = new Node(root.data);
            return root;
        }

        // work (traverse)
        if(root.left != null){
            root.left = construct(root.left);
        }
        if (root.right != null) {
            root.right = construct(root.right);
        }

        return root;
    }
// ------------------------------------------------------------------- //
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        Node trroot = construct(root);
        inorder(trroot);
    }
}
