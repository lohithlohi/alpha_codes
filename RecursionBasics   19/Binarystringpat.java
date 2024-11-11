public class Binarystringpat {
    
    public static void binstr(int n, int lastplace, String str) {
        // base case
        if(n==0){
            System.out.println(str);
            return;
        }

        // work
        if(lastplace == 1){
            binstr(n-1, 0, str+'0');
        }else{
            binstr(n-1, 0, str+'0');
            binstr(n-1, 1, str+'1');
        }

        // binstr(n-1, lastplace, str+'0');
        // binstr(n-1, lastplace, str+'1');
        
    }
    public static void main(String[] args) {
        int n = 3;
        binstr(n, 0, "");
    }
}
