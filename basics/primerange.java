import java.util.Scanner;

public class primerange {

    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void prirange(int n){
        for (int i = 1; i <= n; i++) {
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prime range: ");
        int n = sc.nextInt();
        System.out.print("Prime no's = ");
        prirange(n);
        sc.close();
    }
}
