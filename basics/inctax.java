import java.util.*;

public class inctax{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter inclome");
        int income = sc.nextInt();

        if(income < 500000){
            System.out.println("No TAX aka 0");
        }
        else if(income >= 500000 && income < 1000000){
            System.out.println("20% TAX aka "+income*0.2);
        }
        else{
            System.out.println("30% TAXaka "+income*0.3);
        }
        sc.close();
    }
}