import java.util.Scanner;

public class binomialcoeff {

    public static int factorial(int n){
        int f=1;
        for(int i=1; i<=n; i++){
            f=f*i;
        }
        return f;
    }

    public static double bincof(int n,int r){
        int a = factorial(n);
        int b = factorial(r);
        int c = factorial(n-r);
        double ncr = a/(b*c);
        return ncr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter r: ");
        int r = sc.nextInt();
        System.out.println("Binary coefficient ncr = "+bincof(n,r));
        sc.close();
    }
}
