/*
 *  Question 3 : Given an array of integers. Find the Inversion Count in the array. (HARD)
    Inversion Count: For an array, inversion count indicates how far (or close) the array is from
    being sorted. If the array is already sorted then the inversion count is 0. If an array is
    sorted in the reverse order then the inversion count is the maximum.
    Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
    Sample Input 1 : N = 5, arr[ ] = {2, 4, 1, 3, 5}
    Sample Output 1 : 3, because it has 3 inversions - (2, 1), (4, 1), (4, 3).
 */

public class InversionCount {

    // TC => O(n^2) in brute force
    public static int invcnt(int arr[]) {
        int count = 0;
        // like selection sort
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j] && i < j){   // in absence of (i < j) also works  
                    System.out.print("("+arr[i]+","+arr[j]+") ");
                    count++;
                }
            }
        }
        System.out.println();
        return count;
    }

    // Divide and conquer
    public static int invercnts(int arr[], int si, int ei) {
        // base case
        if(si >= ei){
            return 0;
        }

        //work
        int mid = si+(ei-si)/2;
        int leftcnt = invercnts(arr, si, mid);
        int rightcnt = invercnts(arr, mid+1, ei);

        return leftcnt + rightcnt + compcount(arr, si, mid, ei);
    }

    public static int compcount(int arr[], int si, int mid, int ei) {
        int count = 0;
        for (int i = si; i <= mid; i++) {
            for (int j = mid+1; j <= ei; j++) {
                if(arr[i] > arr[j]){
                    System.out.print("("+arr[i]+","+arr[j]+") ");
                    count++;
                }
            }
        }
        System.out.println();
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        // int  arr[] = {2, 3, 4, 5, 6};
        // int arr[] = {5, 5, 5};

        // Brute Force Method
        System.out.println("Inversion counts: "+invcnt(arr));
        
        System.out.println("\n");
        
        // Divide and conquer Method
        System.out.println("Inversion counts: "+invercnts(arr, 0, arr.length-1));
    }
}
