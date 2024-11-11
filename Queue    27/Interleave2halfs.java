/*
 * Interleave 2 halves of a queue (Even length)
 * TC => O(n)
 * SC => O(n)
 */

import java.util.LinkedList;
import java.util.Queue;

public class Interleave2halfs {
    
    public static void interleave(Queue<Integer> q){
        Queue<Integer> fq = new LinkedList<>();
        int size = q.size();

        for (int i = 0; i < size/2; i++) {
            fq.add(q.remove());
        }

        while(!fq.isEmpty()){
            q.add(fq.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleave(q);
        
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
