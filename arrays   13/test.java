import java.util.*;

public class test {
    public static void main(String[] args) {
        // int arr[] = {1,-2,6,-1,3};
        // int arr[] = {2,4,6,8,10};
        int arr[] = {2,1,4,3};
        int srtarr[] = {2,1,4,3};
        Arrays.sort(srtarr);

        int newarr[] = new int[10];
        int prefixarr[] = new int[arr.length];
        newarr[0] = 0;
        prefixarr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            prefixarr[i] = prefixarr[i-1] + srtarr[i-1];
            newarr[i] = prefixarr[i];
        }
        // for (int i = 0; i < prefixarr.length; i++) {
        //     System.out.print(prefixarr[i]+" ");
        // }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(newarr[arr[i]]+" ");
        }
    }
}
