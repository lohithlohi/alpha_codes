package BinaryTree;

public class DiamofTree {
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

    public static int findmaxheight(Node root) {
        if(root == null){
            return 0;  // 0 => according to "node" depth , -1 => according to "edge" depth
        }
        int maxleft = findmaxheight(root.left);
        int maxright = findmaxheight(root.right);

        return Math.max(maxleft, maxright) + 1;
    }

// -------------------------------------------------------------------------------------------//
    
    // Approach - 1  TC => O(N^2)
    // finding Max(Selfdiam, leftmaxdiam, rightmaxdiam)
    public static int Find_Diam_A1(Node root){
        if(root == null){
            return 0;
        }

        // find left and right branch's max Diaameters
        int leftmaxDiam = Find_Diam_A1(root.left);
        int rightmaxdiam = Find_Diam_A1(root.right);
        
        // find Self Diameter
        int lht = findmaxheight(root.left);
        int rht = findmaxheight(root.right);
        int selfdiam = lht + rht + 1;
        
        return Math.max(selfdiam, Math.max(leftmaxDiam, rightmaxdiam));
    }

// -------------------------------------------------------------------------------------------//

    // Approach - 2  TC => O(N)
    // finding Dim = Max(Selfdiam, leftmaxdiam, rightmaxdiam) and height = Max(lh,rh)+1
    // using class
    static class info {
        int dia, ht;
        info(int dia, int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }
    public static info Find_Diam_A2(Node root){
        // base case
        if(root == null){
            return new info(0, 0);
        }

        // work
        // get left and right info of(d,h)
        info leftinfo = Find_Diam_A2(root.left);
        info rightinfo = Find_Diam_A2(root.right);

        // find Diameter and height of self/current node
        int Dim = Math.max(Math.max(leftinfo.dia, rightinfo.dia), leftinfo.ht + rightinfo.ht + 1);
        int higt = Math.max(leftinfo.ht, rightinfo.ht) + 1;

        return new info(Dim, higt);
    }

// -------------------------------------------------------------------------------------------//
    
    // MY code TC=> ??
    public static void FindDim(Node root, int dim){
        // base case
        if(root == null){    // max height branch is fully traversed
            System.out.println(dim);
            return;
        }

        // work
        int lmxht = findmaxheight(root.left);
        int rmxht = findmaxheight(root.right);

        dim = Math.max(dim ,lmxht + rmxht + 1);   // finding max diameter

        // move towards max height branch
        if(lmxht > rmxht){
            FindDim(root.left, dim);
        }else{
            FindDim(root.right, dim);
        }

        // System.out.println("HEllo");
    }

// -------------------------------------------------------------------------------------------//

    public static void main(String[] args) {
        
            //        1           => 1
            //       /  \
            //      2    3        => 2
            //     / \    \ 
            //    4   5    6      => 3
            // Node root = new Node(1);
            // root.left = new Node(2);
            // root.right = new Node(3);
            // root.left.left = new Node(4);
            // root.left.right = new Node(5);
            // root.right.right = new Node(6);


                               // height
            //        1           => 1
            //       /  \
            //      2    3        => 2
            //     / \     
            //    4   5           => 3
            //   /     \
            //  9       6         => 4
            //           \
            //            7       => 5
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.left.left.left = new Node(9);
            root.left.left.left.left = new Node(10);
            root.left.right.right = new Node(6);
            root.left.right.right.right = new Node(7); 

        // System.out.println(findmaxheight(root));
        // FindDim(root, 0);
        System.out.println(Find_Diam_A1(root));

        // info output = Find_Diam_A2(root);
        // System.out.println("MAX_DIA: "+output.dia+"\nMAX_HIGT: "+output.ht);
    }
}
