import java.util.*;

public class Numtostr {

    static String name[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void num_to_string(int n, StringBuilder str) {
        // base case
        if(n <= 0){
            return;
        }

        //work
        int lastdigit = n % 10;
        num_to_string(n / 10, str);
        str.append(name[lastdigit]+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int n = sc.nextInt();
        StringBuilder str = new StringBuilder("");
        num_to_string(n,str);
        System.out.println(str);
        sc.close();
    }
}
