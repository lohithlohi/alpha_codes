package BinaryTree;

public class HeightofTree {

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

    public static int findheight(Node root) {
        if(root == null){
            return 0;  // 0 => according to "node" depth , -1 => according to "edge" depth
        }
        int maxleft = findheight(root.left);
        int maxright = findheight(root.right);

        return Math.max(maxleft, maxright) + 1;
    }

    public static void main(String[] args) {
        
            //        1           => 1
            //       /  \
            //      2    3        => 2
            //     / \    \ 
            //    4   5    6      => 3
        
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.right = new Node(6);

        System.out.println(findheight(root));
    }
}
