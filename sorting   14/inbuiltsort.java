import java.util.Arrays;
// import java.util.Collections;

public class inbuiltsort {

    public static void printarr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer arr[] = {5, 2, 3, 4, 1};
        
        Arrays.sort(arr);
        printarr(arr);

        // Arrays.sort(arr,0,3);
        // printarr(arr);
        
        // Arrays.sort(arr,Collections.reverseOrder());
        // printarr(arr);
        
        // Arrays.sort(arr,1,3,Collections.reverseOrder());
        // printarr(arr);
    }
}
