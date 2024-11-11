public class powerof2 {

    // TC => O(logn)
    public static int pow_of_2eff(int x,int n) {
        //base case
        if(n==0){
            return 1;
        }

        int halfpow = pow_of_2eff(x, (int)n/2);
        int halfpowsqr = halfpow * halfpow;

        if(n%2 != 0){     // odd power case
            return x * halfpowsqr;
        }

        return halfpowsqr;
    }


    // TC => O(n)
    public static int pow_of_2(int x,int n) {
        // base case
        if(n==0){
            return 1;
        }
        return x * pow_of_2(x,n-1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(pow_of_2eff(2, n));
        System.out.println(pow_of_2(2,n));
    }
}
