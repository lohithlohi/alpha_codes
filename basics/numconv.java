import java.util.Scanner;

public class numconv {

    public static void binTodeci(int binnum) {
        int pow = 0;
        int decinum = 0;

        while(binnum > 0){
            int lastdigit = binnum % 10;
            decinum = decinum + (lastdigit * (int)Math.pow(2,pow));
            pow++;
            binnum = binnum / 10;
        }

        System.out.println("Decimal num : "+decinum);
    }

    public static void deciTobin(int decinum) {
        int pow = 0;
        int binnum = 0;
        
        while(decinum > 0){
            int rem = decinum % 2;
            binnum = binnum + (rem * (int)Math.pow(10,pow));
            pow++;
            decinum = decinum / 2;
        }
        System.out.println("Binary num : "+binnum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1.binary to decimal\n2.decimal to binary\nEnter choice: ");
        int c = sc.nextInt();

        switch(c){
            case 1: System.out.print("Enter binary num: ");
                    int bin = sc.nextInt();
                    binTodeci(bin);
                    break;
            case 2: System.out.print("Enter decimal num: ");
                    int deci = sc.nextInt();
                    deciTobin(deci);
                    break;
            default: System.out.println("Invalid choice");
                     break;
        }
        sc.close();
    }
}
