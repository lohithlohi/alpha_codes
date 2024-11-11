package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LowstCmnAnstr {
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

    public static boolean findPath(Node root, int n, List<Integer> list){
        if(root == null){
            return false;
        }
        
        list.add(root.data);

        if(root.data == n){
            return true;
        }

        if (findPath(root.left, n, list) || findPath(root.right, n, list)) {
            return true;
        }
        // both left and right don't have 'n' node
        list.remove(list.size()-1);
        return false;
    }

    public static int findAnstr(Node root, int n1, int n2){
        ArrayList<Integer> pathn1 = new ArrayList<>();
        ArrayList<Integer> pathn2 = new ArrayList<>();
        boolean foundleft = findPath(root, n1, pathn1);   // find and buid path from root to n1
        boolean foundright = findPath(root, n2, pathn2);  // find and buid path from root to n2

        if ((foundright && foundleft) == false) {  // case not found
            return -1;
        }
        
        int i = 0;
        for (; i < pathn1.size() && i < pathn2.size(); i++) {
            if(pathn1.get(i) != pathn2.get(i)){
                break;
            }
        }
        return pathn1.get(i-1);
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
        
        return root;
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

        int n1=4, n2=5;
        int Anstr = findAnstr(root, n1, n2);  // TC => O(N), SC => O(N) <= (N+N) 2 list used
        System.out.println(Anstr);

        System.out.println(findlca(root, n1, n2).data);  // TC => O(N), SC => O(1)
    }
}
