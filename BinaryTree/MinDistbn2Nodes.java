package BinaryTree;

public class MinDistbn2Nodes {

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

    public static Node findlca(Node root, int n1, int n2){
        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            return root;
        }

        // ask to find n1 or n2 in left (or) right
        Node left = findlca(root.left, n1, n2);
        Node right = findlca(root.right, n1, n2);
        
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        
        return root;  // both right && left == null
    }

    public static int giveDist(Node root, int n){

        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }
        int leftdist = giveDist(root.left, n);
        int rightdist = giveDist(root.right, n);
        
        if(leftdist == -1 && rightdist == -1){
            return -1;
        }
        int max =  Math.max(leftdist, rightdist);  // like combining two operations
        return max + 1;

        // if(leftdist != -1){
        //     return leftdist+1;
        // }
        // if(rightdist != -1){
        //     return rightdist+1;
        // }
        // return -1;  // both rightdist && leftdist == -1
    }

    public static int findMindist(Node root, int n1, int n2){
        // find LCA of n1 and n2
        Node lca = findlca(root, n1, n2);

        int distn1 = giveDist(lca, n1);
        int distn2 = giveDist(lca, n2);

        return distn1 + distn2;
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

        int n1=4, n2=3;
        int md = findMindist(root, n1, n2);
        System.out.println(md);
    }
}
