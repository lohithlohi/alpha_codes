import java.util.Stack;

public class Nextgraterele {

    /*
    public static int findx(int arr[], int x){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
    public static int nextgtrel(int arr[], int x){
        int i = findx(arr, x);
        if(i == -1) {
            return -1;
        }

        int nge = 999;
        i++;
        while(i < arr.length){
            if(arr[i] > x && arr[i] < nge){
                nge = arr[i];
            }
            i++;
        }
        return nge;
    }
     */

     public static void nextgtrel(int arr[], int nxgarr[]){
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length-1; i >= 0; i--) {   // for next greater in RIGHT side
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {   // step 1   for large/greater
                s.pop();
            }

            if(s.isEmpty()){       // step 2
                nxgarr[i] = -1;
            }
            else{
                nxgarr[i] = arr[s.peek()];
            }

            s.push(i);            // step 3
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nxgarr[] = new int[arr.length];

        nextgtrel(arr, nxgarr);
        
        for (int i = 0; i < nxgarr.length; i++) {
            System.out.print(nxgarr[i]+" ");
        }
    }


    /*
     *  change for-loop and <= sign in program for these variations
     * 
     *  -- next greater in RIGHT
     *  -- next greater in LEFT
     *  -- next smaller in RIGHT
     *  -- next smaller in LEFT
     * 
     */
}
