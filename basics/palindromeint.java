import java.util.Scanner;

public class palindromeint {

    public static int reverse(int n) {
        int rev = 0;
        while(n > 0){
            int lastdigit = n % 10;
            rev = (rev*10) + lastdigit;
            n = n / 10;
        }
        return rev;
    }

    public static boolean isPlaindrome(int n) {
        int rev = reverse(n);
        if(n == rev){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        if(isPlaindrome(n)){
            System.out.println(n+" is a palindrome number");
        }else{
            System.out.println(n+" is not a palindrome number");
        }
        sc.close();
    }
}
