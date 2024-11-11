// TC => O(nlogn)

public class HeapSortFile {
    
    // it is for Ascending order sorting
    public static void heapify(int arr[], int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxidx = i;

        if(left < size && arr[left] > arr[maxidx]){
            maxidx = left;
        }
        if(right < size && arr[right] > arr[maxidx]){
            maxidx = right;
        }
        if(maxidx != i){
            //swap maxidx and i th elements
            int temp = arr[i];
            arr[i] = arr[maxidx];
            arr[maxidx] = temp;

            heapify(arr, maxidx, size);
        } 
    }

    public static void heapsort(int arr[]){
        // 1. Build max-heap
        int n = arr.length;
        // apply heapify on non-leaf nodes only
        for (int i = n/2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // 2. push largest to end
        for (int i = n-1; i >= 0; i--) {
            // swap largest=0 and end=i
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);   // from root node
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,5,2,4,1,6};

        heapsort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
