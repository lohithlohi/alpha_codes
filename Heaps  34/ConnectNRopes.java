import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int ropes[] = {2, 3, 3, 4, 6};
        // int ropes[] = {4, 3, 2, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int r1 = pq.remove();
            int r2 = pq.remove();
            cost += r1+r2;
            pq.add(r1+r2);
        }

        System.out.println("Total cost: "+cost);
    }
}
