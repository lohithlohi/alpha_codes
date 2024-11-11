// import java.util.*;

public class tt {

    public static boolean issorted(int arr[], int i){
        // base case
        if(i == arr.length-1){
            return true;
        }

        //work
        if(issorted(arr, i+1) && arr[i]<=arr[i+1]){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,4,5,6};
        if(issorted(arr,0)){
            System.out.println("sorted");
        }else{
            System.out.println("Not sorted");
        }
    }
}
