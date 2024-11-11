import java.util.HashMap;

public class LarSubarrSumZ {
    
    // TC => O(N)
    public static int LarSubSumZero(int arr[]){
        /*
         * find sum like prefixsum array
         * compare between two index for sum zero
         * find the max lenght j-i
         * 
         * sum(i+1 to j) = sum(j) - sum(i) 
         *  0 = sum(j) - sum(i)
         * sum(i) = sum(j)
         */

        HashMap<Integer, Integer> hm = new HashMap<>();   // (sum, idx)
        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum)) {       // sum previously present in map{} / prefixsum[]
                len = Math.max(len, j - hm.get(sum));  // j-i
            }else{                           // New sum appearing
                hm.put(sum, j);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10};

        System.out.println("Largest SubArray with sum = "+LarSubSumZero(arr));
    }
}
