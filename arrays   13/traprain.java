import java.util.*;

public class traprain {

    //Method 1
    public static int trap_rain(int arr[]) { // time complexity=> O(n)

        int trapped = 0, width = 1;

        /*
         * //left max boundry
         * int leftboundry[] = new int[arr.length];
         * for (int i = 0; i < arr.length; i++) {
         * int max = Integer.MIN_VALUE;
         * for (int j = 0; j <= i; j++) {
         * max = Math.max(arr[j],max);
         * }
         * leftboundry[i] = max;
         * }
         * 
         * //right max boundry
         * int rightboundry[] = new int[arr.length];
         * for (int i = 0; i < arr.length; i++) {
         * int max = Integer.MIN_VALUE;
         * for (int j = i; j < arr.length; j++) {
         * max = Math.max(arr[j],max);
         * }
         * rightboundry[i] = max;
         * }
         */




        // left max boundry
        int leftboundry[] = new int[arr.length];
        leftboundry[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftboundry[i] = Math.max(arr[i], leftboundry[i - 1]);
        }

        // right max boundry
        int rightboundry[] = new int[arr.length];
        rightboundry[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightboundry[i] = Math.max(arr[i], rightboundry[i + 1]);
        }

        // traped water calculation
        for (int i = 0; i < arr.length; i++) {
            int blocklev = arr[i];
            int waterlev = Math.min(leftboundry[i], rightboundry[i]);
            trapped += (waterlev - blocklev) * width;
        }
        return trapped;
    }

    //Method 2
    public static int trap(int[] height) {
        int n = height.length;
        int res = 0, l = 0, r = n - 1;
        int rMax = height[r], lMax = height[l];
        while (l < r) {
            if (lMax < rMax) {            //this itself tells current water level
                l++;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }
        return res;
    }

    public static int TraptheRain(int height[]) {
        int res=0;

        //step 1 set extremes as lmax and rmax
        int lmax=0, rmax=height.length-1;
        int i=1, j=height.length-2;
        while (i < j) {
            if(height[lmax] < height[rmax]){
                int currlevel = height[lmax];
                if(height[lmax] > height[i]){
                    res += currlevel-height[i];
                    i++;
                }else{
                    lmax=i;
                }   
            }else{
                int currlevel = height[rmax];
                if(height[rmax] > height[j]){
                    res += currlevel-height[j];
                    j--;
                }else{
                    rmax=j;
                }   
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height1[] = { 4, 2, 0, 6, 3, 2, 5 };
        int height2[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int height3[] = { 4, 2, 0, 3, 2, 5 };

        System.out.println("trapped water area = " + trap_rain(height1));
        System.out.println("trapped water area = " + trap_rain(height2));
        System.out.println("trapped water area = " + trap_rain(height3));

        sc.close();
    }
}
