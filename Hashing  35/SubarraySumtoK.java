import java.util.HashMap;

public class SubarraySumtoK {
    
    public static int SubartoK(int arr[], int k){
        HashMap<Integer, Integer> hm = new HashMap<>();   // (sum, count)
        hm.put(0, 1); // default (if whole array's sum == k => valid situation)
        int sum = 0;
        int count = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum-k)) {
                count += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3}; int k = 3;
        // int arr[] = {10, 2, -2, -20, 10}; int k = -10;
        // int arr[] = {15, -2, 2, -8, 1, 7, 10}; int k = 0;
        // int arr[] = {1, 2, 3}; int k = 3;
        System.out.println(SubartoK(arr, k));
    }
}
