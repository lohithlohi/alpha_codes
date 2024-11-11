import java.util.HashSet;

public class Q1 {

    public static boolean rep(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeated(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                return true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // int arr1[] = {1,2,3,4,5,6};
        int arr2[] = {1,2,3,1,4,2};

        System.out.println("repeated: "+repeated(arr2));
    }
}
