import java.util.PriorityQueue;

public class KNearestCars {
    
    public static class points implements Comparable<points> {
        int x, y, distsq, carno;

        public points(int x, int y, int distsq, int carno){
            this.x = x;
            this.y = y;
            this.carno = carno;
            this.distsq = distsq;
        }

        @Override
        public int compareTo(points p2) {       // this - o  => ascending  (vise-versa)
            return this.distsq - p2.distsq;
        }
    }

    public static void main(String[] args) {
        int cars[][] = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;
        PriorityQueue<points> pq = new PriorityQueue<>();

        for (int i = 0; i < cars.length; i++) {
            int distsq = cars[i][0]*cars[i][0] + cars[i][1]*cars[i][1];
            pq.add(new points(cars[i][0], cars[i][1], distsq, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C"+pq.remove().carno);
        }
    }
}
