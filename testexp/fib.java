import java.util.Scanner;

public class fib{

    public static int fun(int n){
        if(n == 0 || n==1){
            return n;
        }
        int num = fun(n-1) + fun(n-2);
        return num;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // System.out.println(fun(n));

        for(int i=0; i<n; i++){
            // System.out.print(fun(i)+" ");
            System.out.print(fibonacci(i)+" ");   // DP efficient
        }

        sc.close();
    }
}