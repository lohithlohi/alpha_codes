// get max of all subarrays of size 'k'

// import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindow {

    public static class Num implements Comparable<Num>{
        int val,idx;

        public Num(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Num n2) {
            return n2.val - this.val;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        // int arr[] = {1,2,3,4,5,6,7,8,9};
        int k = 3;  //window size
        int n = arr.length;
        int res[] = new int[n-k+1];
        
        PriorityQueue<Num> pq = new PriorityQueue<>();
        
        // TC => O(n)
        // 1st window
        for (int i = 0; i < k; i++) {
            pq.add(new Num(arr[i], i));
        }
        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            // check if peek is not in SW => remove
            while(pq.peek().idx > 0 && pq.peek().idx <= i-k){
                pq.remove();
            }
            // add next num
            pq.add(new Num(arr[i], i));
            // select max
            res[i-k+1] = pq.peek().val;
        }


        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // TC => O(N^2)
        // int r = 0;
        // for (int i = 0,j = k-1; j < arr.length; i++,j++) {
        //     for (int j2 = i; j2 <= j; j2++) {
        //         pq.add(arr[j2]);
        //     }
        //     res[r++] = pq.remove();
        //     for(int u=0; u < k-1; u++){
        //         pq.remove();
        //     }
        // }


        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
