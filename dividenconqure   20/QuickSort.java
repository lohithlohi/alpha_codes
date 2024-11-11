/*
 * Actually we are hardworking for sorting/alligning "once",
 * then  we divide array as left and right based on pivot 
 * to do same on L&R (recurcive).
 */

 public class QuickSort {

    public static void printarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void quicksort(int arr[], int si, int ei) {
        //base case
        if(si >= ei){
            return;
        }

        // select last element as pivot and get its right position/index in array
        int pivIdx = partition(arr,si,ei);

        // dividing as left and right and doing partition again and again
        quicksort(arr, si, pivIdx-1);
        quicksort(arr, pivIdx+1, ei);
    }

    //hardwork of sorting
    public static int partition(int arr[], int si, int ei) {
        //iterator i = si-1 creates space for elements less than pivot element
        int i = si-1; //initially -1
        int pivot = arr[ei]; // last element as pivot

        for (int j = si; j < ei; j++) {
            if(arr[j] <= pivot){
                i++;  //creating space
                
                //swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // moving pivot to right place
        i++;  //creating space for pivot
                
        //swap arr[i] and pivot/arr[ei]
        int temp = arr[i];
        arr[i] = pivot;
        arr[ei] = temp;

        return i;  // returning right pivot index in array
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5, -4};
        quicksort(arr, 0, arr.length-1);
        printarray(arr);
    }
}
