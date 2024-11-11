public class arrpairs {

    public static void pairs(int arr[]) {
        int tp=0;                          //total pairs = n(n-1)/2
        for(int i=0; i<arr.length; i++){
            int curr = arr[i];
            for(int j=i+1; j<arr.length; j++){
                System.out.print("("+curr+","+arr[j]+") ");
                tp++;  //total pairs
            }
            System.out.println();
        }
        System.out.println("Total pairs: "+tp);
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        pairs(arr);
    }
}

// time complexity in O(n^2)
// n x w ~~ n^2
// w = n+(n-1)+(n-2)+(n-3)+....+1