import java.util.ArrayList;
import java.util.List;

public class Findmissing {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        
        // Mark visited elements using the array itself
        for (int num : nums) {
          int index = Math.abs(num) - 1; // Adjust index for 0-based array
          if (nums[index] > 0) {
            nums[index] *= -1; // Mark as visited by negating the value
          }
        }
        
        // Find missing numbers (elements with positive values)
        for (int i = 0; i < n; i++) {
          if (nums[i] > 0) {
            result.add(i + 1); // Adjust for 1-based numbering
          }
        }
        
        return result;
      }
    
      public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> missing = findDisappearedNumbers(nums);
        
        System.out.println("Missing Numbers:");
        for (int num : missing) {
          System.out.print(num + " ");
        }
        System.out.println();
    }
}