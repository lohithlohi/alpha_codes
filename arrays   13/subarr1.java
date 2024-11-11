import java.util.*;

public class subarr1 {
    public static void print_subarray(int arr[]) {
        int totsr = 0, maxsum = Integer.MIN_VALUE, minsum = Integer.MAX_VALUE;
        // time complexity ==> O(n^3)
        for(int i=0; i<arr.length; i++){        // starting point
            
            for(int j=i; j<arr.length; j++){    // ending point including first single element
                
                int sum=0;
                for(int k=i; k<=j; k++){        // print strat --> end
                    
                    System.out.print(arr[k]+" ");
                    sum += arr[k];
                }
                totsr++;
                System.out.print("  sum = "+sum+"\n");
                if(maxsum<sum) maxsum=sum;      //max subarray sum
                if(minsum>sum) minsum=sum;      //min subarray sum
            }
            System.out.println();
        }
        System.out.println("Total subarrays: "+totsr);   // n(n+1)/2
        System.out.println("Maxsum = "+maxsum);
        System.out.println("Minsum = "+minsum);
    }
    
    public static void max_subarr(int arr[]) {

        // prefix array
        int prefixarr[] = new int[arr.length];
        prefixarr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixarr[i] = prefixarr[i-1] + arr[i];
        }

        // time complexity ==> O(n^2)
        int max = Integer.MIN_VALUE, currsum = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                // formula for direct sub array sum ===> prefix[end]-prefix[start-1]
                currsum = start==0 ? prefixarr[end] : prefixarr[end]-prefixarr[start-1];
                max = Math.max(currsum,max);
            }
        }
        System.out.println("\nUsing prefix array\nMAXSUM of sub array sum is: "+max);
    }
    
    public static void kadane_maxsum(int arr[]) {
        int sum = 0, max = Integer.MIN_VALUE;
        // Time complexity is ==> O(n)
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum<0) sum = 0;
            max = Math.max(sum,max);
        }
        System.out.println("\nUsing Kadane's algorithm\nMAXSUM of sub array sum is: "+max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1,-2,6,-1,3};
        // int arr[] = {2,4,6,8,10};
        print_subarray(arr);
        max_subarr(arr);
        kadane_maxsum(arr);
        sc.close();
    }
}
