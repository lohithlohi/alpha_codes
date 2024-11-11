public class insertionsort {

    public static void insertion(int arr[]) {

        for(int i=1; i < arr.length; i++){   //from arr[i(1)] to arr[n-1] is unsorted part
            int curr = arr[i];    // current element
            int prev = i-1;       // previous element
            while(prev>=0 && arr[prev] > curr){   // for desc ord arr[prev] < curr
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 5, 3};
        insertion(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
