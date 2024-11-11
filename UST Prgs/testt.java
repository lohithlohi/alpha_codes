public class testt{
    public static void main(String[] args) {
        // System.out.println(999999991 + 9);

        // StringBuilder str = new StringBuilder("LOHITH");

        // String mail = "teste.mail+david@lee.tcode.com";
        String mail = "test.e.mail+bob.cathy@leetcode.com";
        String local = mail.substring(0, mail.indexOf('@'));
            local = local.replace(".", "");
            mail = local + mail.substring(mail.indexOf('@'));
            
            // remove content between '+' and '@'
            if(mail.contains("+")){
                mail = mail.substring(0, mail.indexOf('+')) + mail.substring(mail.indexOf('@'));
            }

            System.out.println(mail);

            // code for sum of array
            int[] arr = {1,2,3,4,5};
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            System.out.println("Sum of array : " + sum);
            // code for checking if the given string is a palindrome
            String str = "madam";
            boolean isPalindrome = true;
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i)!= str.charAt(str.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            System.out.println("Is palindrome? : " + isPalindrome);

            // javascript code for factorial sum of a given number of digits
            // var digits = 5;
            // var factorialSum = 0;
            // for(var i = 1; i <= digits; i++){
            //     factorialSum += factorial(i);
            // }
            // function factorial(n){
            //     if(n == 1) return 1;
            //     return n * factorial(n-1);
            // }
            // console.log("Factorial sum of "+digits+" digits is : "+factorialSum);
    }
}