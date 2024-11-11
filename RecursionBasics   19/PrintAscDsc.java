// import java.util.*;

public class PrintAscDsc {

    public static void printDsec(int n) {
        //base case
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        printDsec(n-1);
    }

    public static void printAsec(int n) {
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        printAsec(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        int n = 10;
        printDsec(n);
        System.out.println();
        printAsec(n);
    }
}