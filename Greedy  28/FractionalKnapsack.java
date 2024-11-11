import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        
        int value[] = {60, 100, 120};     // maxval => 220
        int weight[] = {10, 20, 30};
        int W = 50;  // Knapsack Capacity

        /* I need max value with less weight => ratio(value/weight) 
         * so sort in descending order of ratio
        */

        double ratio[][] = new double[value.length][2];
        // coll0 => idx, coll1 => ratio

        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        // Sorting 2D array according to coll1 (ratio values)
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        ArrayList<Integer> items = new ArrayList<>();
        int maxval = 0;

        for (int i = 0; i < ratio.length; i++) {
            int idx = (int)ratio[i][0];
            if(weight[idx] <= W){
                items.add(idx);
                maxval += value[idx];
                W -= weight[idx];
            }
            else{
                maxval += ratio[i][1] * W;    // fractional value
                items.add(idx);
                W=0;   // Capacity = 0
                break;
            }
        }

        System.out.println("Max value: "+maxval);
        // System.out.println("items added: "+items);
    }
}
