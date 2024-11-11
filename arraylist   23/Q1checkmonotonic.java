/*
 * Monotonic ArrayList(EASY)
 * An Arraylist is monotonic if it is either monotone increasing or monotone decreasing.
 * An Arraylistnumsismonotoneincreasingifforalli<=j,nums.get(i)<=nums.get(j).
 * AnA rraylist nums is monotone decreasing if for all i <= j, nums.get(i) >= nums.get(j).
 * Given an integer Arraylist nums, return true if the given list is monotonic, or false otherwise
 */

import java.util.ArrayList;

public class Q1checkmonotonic {

    public static boolean chkm_onotonic(ArrayList<Integer> nums) {
        int i = 0;
        boolean flagi = true;
        for (i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                flagi = false;
                break;
            }
        }

        int j = 0;
        boolean flagj = true;
        for (j = 0; j < nums.size() - 1; j++) {
            if (nums.get(j) < nums.get(j + 1)) {
                flagj = false;
                break;
            }
        }

        // just printing
        if (flagi) {
            System.out.println("it is Monotonic Increasing");
        }
        if (flagj) {
            System.out.println("it is Monotonic Decreasing");
        }

        // Check monotonic
        if (flagi || flagj) {
            return true;
        } else {
            return false;
        }
    }

    // in solutions
    public static boolean isMonotonic(ArrayList<Integer> A) {
        boolean inc=true;
        boolean dec=true;
        for(int i=0; i<A.size()-1; i++) {
            if(A.get(i) > A.get(i+1))
                inc=false;
            if(A.get(i) < A.get(i+1))
                dec=false;
        }
        return inc || dec;  // both should be different to get "true"
    }

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();
        // nums = [1,2,2,3]
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);

        System.out.println(chkm_onotonic(nums));
        System.out.println(isMonotonic(nums));
    }
}
