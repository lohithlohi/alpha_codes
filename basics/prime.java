// package basics;

import java.util.*;

public class prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;
        // for (int i = 2; i <= n - 1; i++) {
        for (int i=2; i<=Math.sqrt(n); i++) {     //optimised
            if (n % i == 0) {
                flag = true;
                System.out.println(n + " is not a prime number");
                break;
            }
        }
        if(!flag){
            System.out.println(n+" is a prime number");
        }
        sc.close();
    }
}
