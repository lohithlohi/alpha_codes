import java.util.Scanner;

public class selectionsort {

    // TC ==> O(n^2)
    public static void selection(int arr[]) {
        int n = arr.length;
        for(int i=0; i < n-1; i++){       // 0 to n-2 times
            int minpos = i;
            for(int j=i+1; j < n; j++){    // i+1 to n-1 times compare

                if(arr[j] < arr[minpos]){    // for desc ord arr[j] > arr[minpos]
                    minpos = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[minpos];
            arr[minpos]=temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {5, 3, 4, 2, 1};
        selection(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
