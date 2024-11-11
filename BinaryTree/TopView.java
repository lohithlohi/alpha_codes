package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {

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

    static class info{
        Node node;
        int hd;

        info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void toopViewofBt(Node root){
        Queue<info> que = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int max=0, min=0;

        que.add(new info(root, 0));
        que.add(null);

        while (!que.isEmpty()) {
            info ptr = que.remove();
            if(ptr==null){
                if (que.isEmpty()) {
                    break;
                }
                que.add(null);
            }else{
                if(!map.containsKey(ptr.hd)){
                    map.put(ptr.hd, ptr.node);
                }
                if(ptr.node.left != null){
                    que.add(new info(ptr.node.left, ptr.hd-1));
                    min = Math.min(min, ptr.hd-1);
                }
                if(ptr.node.right != null){
                    que.add(new info(ptr.node.right, ptr.hd+1));
                    max = Math.max(max, ptr.hd+1);
                }
            }
        }

        System.out.print("TopView: ");
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data+" ");
        }
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
        toopViewofBt(root);
    }
}
