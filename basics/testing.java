import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        while(n > 0){
            if((n & 1) == 0){
                n = n>>1;
            }
            else{
                count++;
                n = n>>1;
            }
        }
        System.out.println("set count: "+count);

        sc.close();
    }
}
