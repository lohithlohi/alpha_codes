public class exmparray {

    public static void printarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");        
        }
        System.out.println();
    }

    public static void changearray(int arr[], int i, int val) {
        // base case
        if(i == arr.length){
            printarray(arr);
            return;
        }
        //work/recursion
        arr[i] = val;
        changearray(arr, i+1, val+1);  // fux recurion step
        arr[i] = arr[i]-2;  //backtracking step
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        changearray(arr, 0, 1);
        printarray(arr);
    }
}
