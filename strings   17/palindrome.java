

public class palindrome {

    public static void pali(String str) {
        int first=0,last=str.length()-1;
        while(first <= last){
            if(str.charAt(first) != str.charAt(last)){
                System.out.println("Not palindrome");
                return;
            }
            first++;
            last--;
        }
        System.out.println("Palindrome");
    }
    public static void main(String[] args) {
        String str = "racetcar";
        pali(str);
    }
}
