import java.util.PriorityQueue;

public class WeakestSoldier {
    public static class Row implements Comparable<Row> {
        int sol, rno;

        public Row(int sol, int rno){
            this.sol = sol;
            this.rno = rno;
        }
        
        public int compareTo(Row r2){
            // high priority => less sol && less rno
            if(this.sol == r2.sol){
                return this.rno - r2.rno;
            }else{
                return this.sol - r2.sol;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };
        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int solcount = 0;
            for (int j = 0; j < army[0].length; j++) {
                solcount += (army[i][j] == 1)? 1 : 0;
            }
            pq.add(new Row(solcount, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("R"+pq.remove().rno);
        }
    }
}
