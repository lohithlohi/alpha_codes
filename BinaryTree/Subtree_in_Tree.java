package BinaryTree;

public class Subtree_in_Tree {
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

    public static boolean isIdentical(Node node, Node subroot){
        if(node == null && subroot == null){  //(0,0)  like base case
            return true;
        }else if(node == null || subroot == null || node.data != subroot.data){  // (0,1) || (1,0) || (1!=1)
            return false;
        }

        // now checking both trees's subbranches (recurcively)
        if(!(isIdentical(node.left, subroot.left))){
            return false;
        }
        if(!(isIdentical(node.right, subroot.right))){
            return false;
        }
        return true;
    }

    public static boolean isSubTree(Node root, Node subroot){
        // base case
        if(root == null){
            return false;
        }

        // 1st checking for root and subroot node data
        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }

        // apply same above operation on left and right subtree of tree (recusion)
        // checking identicals in left or right subtrees
        boolean leftAns = isSubTree(root.left, subroot);
        boolean righttAns = isSubTree(root.right, subroot);
        return leftAns || righttAns;

        // return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }

    public static void main(String[] args) {
        //        1          => 1
        //       / \
        //      2   3        => 2
        //     / \   \ 
        //    4   5   6      => 3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);


        //        2           => 1
        //       / \
        //      4   5        => 2
        Node subroot = new Node(2);
        // subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println(isSubTree(root, subroot));
    }
}
