import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class KmostFreq {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
          map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
          pq.offer(num);
          if (pq.size() > k) {
            pq.poll();
          }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
          result.add(pq.poll());
        }
        
        return result;
      }
    
      public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> frequent = topKFrequent(nums, k);
        
        System.out.println("Top " + k + " Frequent Elements:");
        for (int num : frequent) {
          System.out.print(num + " ");
        }
        System.out.println();
      }
}
