/*
 * Actually 1st we divide array completely (recurcive),
 * then we are hardworking for sorting/alligning.
 */

public class Mergesorting{

    public static void printarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void MergeSort(int arr[], int si, int ei) {
        //base case
        if(si >= ei){
            return;
        }

        //work
        int mid = si+(ei-si)/2;
        
        // dividing
        MergeSort(arr, si, mid);  //left part
        MergeSort(arr, mid+1, ei);  //right part
        
        //merging
        Merge(arr, si, mid, ei);
    }

    public static void Merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si;     // iterator for left part
        int j = mid+1;  // iterator for right part
        int k = 0;      // iterator for temp arr

        //filling temp array by comparing left and right part
        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        //if still left part remained
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        //if still right part remained
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        //copy temp to original array
        for (k=0, i=si ; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};

        MergeSort(arr, 0, arr.length-1);
        printarray(arr);
    }
}