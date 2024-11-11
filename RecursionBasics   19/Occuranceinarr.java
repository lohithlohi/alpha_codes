// TC => O(n)
// SC => O(n)

public class Occuranceinarr {

    public static int First_occr(int arr[],int i,int key) {   // Top-Down approach
        // base case
        if(i==arr.length){
            return -1;
        }

        if(arr[i] == key){
            return i;
        }

        return First_occr(arr, i+1, key);
    }

    public static int Lastoccrr(int arr[],int i,int key) {   // Top-Down approach
        //base case
        if(i == -1){
            return -1;
        }

        if(arr[i] == key){
            return i;
        }

        return Last_occr(arr, i-1, key);
    }

    public static int Last_occr(int arr[],int i,int key) {  // Bottom-Up approach
        //base case
        if(i == arr.length){
            return -1;
        }

        int idx = Last_occr(arr, i+1, key);

        if(arr[i] == key && idx == -1){
            return i;
        }
        return idx;
    }

    public static void main(String[] args) {
        int arr[] = {8,3,5,6,9,5,10,2,5,3};
        System.out.println("First occurance: "+First_occr(arr,0,5));

        System.out.println("Last occurance: "+Lastoccrr(arr,arr.length-1,5));
        
        System.out.println("Last occurance: "+Last_occr(arr,0,5));
    }
}
