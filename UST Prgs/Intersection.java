import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection {
    public static List<Integer> intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
          map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
          if (map.containsKey(num) && map.get(num) > 0) {
            result.add(num);
            // Decrement count after adding to result
            map.put(num, map.get(num) - 1); 
          }
        }
        
        return result;
      }
    
      public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        List<Integer> intersection = intersect(nums1, nums2);
        
        System.out.println("Intersection:");
        for (int num : intersection) {
          System.out.print(num + " ");
        }
        System.out.println();
      }
}
