// import java.util.*;

public class Factoriall {
    public static int fact(int n) {
        //base case
        if(n==1 || n==0){
            return 1;
        }

        int Fnm1 = fact(n-1);
        int Fn = n * Fnm1;
        return Fn; 

        // return n * fact(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }
}
