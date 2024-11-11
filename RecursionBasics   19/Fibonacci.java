// TC => O(2^n)
// SC => O(n) max stack calls or height of tree


public class Fibonacci {
    public static int fib(int n) {
        //base case
        if(n==0 || n==1){
            return n;
        }
        int Fnm1 = fib(n-1);
        int Fnm2 = fib(n-2);
        int Fn = Fnm1 + Fnm2;
        return Fn;

        // return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        int n = 100;
        for (int i = 0; i <= n; i++) {
            System.out.print(fib(i)+" ");
        }
    }
}
