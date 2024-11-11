// package basics;

import java.util.Scanner;

public class maxof3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // if (a > b) {
        //     if (a > c) {
        //         System.out.println(a + " is greatest");
        //     } else {
        //         System.out.println(c + " is greatest");
        //     }
        // } else {
        //     if (b > c) {
        //         System.out.println(b + " is greatest");
        //     } else {
        //         System.out.println(c + " is greatest");
        //     }
        // }

        // if(a>=b && a>=c){
        //     System.out.println(a+" is greatest");
        // }
        // else if(b>=c){
        //     System.out.println(b+" is greatest");
        // }
        // else{
        //     System.out.println(c+" is greatest");
        // }

        //ternary operator
        //variable = condition? statement1(if true) : statement2(if false);
        int larger = ((larger = (a>b)?a:b)>c)?larger:c;
        System.out.println(larger+" is large");

        String type = ((larger%2)==0)?"even":"odd";
        System.out.println(larger+" is "+type);
        sc.close();
    }
}
