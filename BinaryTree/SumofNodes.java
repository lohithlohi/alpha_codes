package BinaryTree;

public class SumofNodes {
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

    public static int NodesSum(Node root) {
        if(root == null){
            return 0;
        }
        int leftSum = NodesSum(root.left);
        int rightSum = NodesSum(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {

            //        1
            //       /  \
            //      2    3
            //     / \    \ 
            //    4   5    6
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(NodesSum(root));
    }
}
