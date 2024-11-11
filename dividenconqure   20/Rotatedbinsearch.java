public class Rotatedbinsearch {

    //Modefied Binary Search
    public static int ModBinSrch(int arr[], int key, int si, int ei) {
        // base case
        if(si > ei){
            return -1;
        }

        int mid = si + (ei-si)/2; //(si+ei)/2

        // FOUND case
        if(arr[mid] == key){
            return mid;
        }

        // mid on Line 1
        if(arr[si] <= arr[mid]){
            // left part of mid on line 1
            if(arr[si] <= key && key <= arr[mid]){
                return ModBinSrch(arr, key, si, mid-1);
            }
            else{
                return ModBinSrch(arr, key, mid+1, ei);
            }
        }
        // mid on Line 2
        else{
            // right part of mid on line 2
            if(arr[mid] <= key && key <= arr[ei]){
                return ModBinSrch(arr, key, mid+1, ei);
            }
            else{
                return ModBinSrch(arr, key, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int key = 0;
        int tarIdx = ModBinSrch(arr,key,0,arr.length-1);
        System.out.println("Key "+key+" found at index: "+tarIdx);
    }
}
