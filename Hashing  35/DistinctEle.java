import java.util.HashSet;

public class DistinctEle {

    public static int finddDistinct(int arr[]){
        // TC => O(N)
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        //     if (hm.containsKey(arr[i])) {
        //         //continue
        //         hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        //     } else {
        //         hm.put(arr[i], 1);
        //     }
        // }
        // return hm.size();

        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            st.add(arr[i]);
        }
        return st.size();
    }

    public static void main(String[] args) {
        int arr[] = {4,3,2,5,6,7,3,4,2,1};

        System.out.println(finddDistinct(arr));
    }
}