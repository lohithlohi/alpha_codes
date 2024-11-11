            // TC => O(n)
            // SC => O(n)

public class checksort {

    // public static boolean chk_sort(int arr[],int len) {
    //     // checking in Descending order

    //     //base case
    //     if(len == 0){
    //         return  true;
    //     }
        
    //     if(arr[len] >= arr[len-1]){
    //         return chk_sort(arr,len-1);
    //     }else{
    //         return false;
    //     }
    // }

    public static boolean chk_sort(int arr[],int len) {
        // checking in Ascending order

        //base case
        if(len == arr.length-1){
            return true;
        }
        
        if(arr[len] > arr[len+1]){
            return false;
        }

        return chk_sort(arr,len+1);
    }

    public static void main(String[] args) {
        
        int arr[] = {2,2,4,5,10,7,8,9};

        // to check in Descending order
        // if(chk_sort(arr,arr.length-1)){
        //     System.out.println("SORTED");
        // }else{
        //     System.out.println("NOT SORTED");
        // }

        // to check in Ascending order
        if(chk_sort(arr,0)){
            System.out.println("SORTED");
        }else{
            System.out.println("NOT SORTED");
        }
    }
}
