import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Threesumzero {
    
    public static List<List<Integer>> triplets(int arr[]){
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(arr[i]+arr[j]+arr[k] == 0){
                        List<Integer> trp = new ArrayList<Integer>();
                        trp.add(arr[i]);
                        trp.add(arr[j]);
                        trp.add(arr[k]);
                        Collections.sort(trp);
                        result.add(trp);
                    }
                }
            }
        }
        result = new ArrayList<List<Integer>> (new LinkedHashSet<List<Integer>>(result));
        return result;
    }
    
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        System.out.println("Triplets:\n"+triplets(arr));
    }
}
