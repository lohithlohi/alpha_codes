import java.util.*;
import java.util.LinkedList;

public class QueinJCF {
    public static void main(String[] args) {
        // Queue q = new Queue();

        Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();   // can also use

        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        q.remove();
        q.add(5);
        

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}

