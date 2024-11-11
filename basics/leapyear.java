import java.util.*;

public class leapyear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter year");
        // int year = sc.nextInt();

        int count=0,nc=0;
        // for(int year=1000; year<=3000; year++){
        //     if(year%4 == 0){
        //         if(year%100 == 0 && year%400 == 0){
        //             System.out.println(year+" is leap year");count++;
        //         }
        //         else if(year%100 != 0){
        //             System.out.println(year+" is leap year");count++;
        //         }
        //         else{
        //             System.out.println("\t\t\t"+year+" is not leap year");nc++;
        //         }
        //     }
        //     else{
        //         System.out.println("\t\t\t"+year+" is not leap year");nc++;
        //     }
        // }

        for(int year=1000; year<=3000; year++){
            boolean x = year%4==0;
            boolean y = year%100==0;
            boolean z = year%400==0;
            if(x && y && z || x && !y){
                System.out.println(year+" is leap year");count++;
            }else{
                System.out.println("\t\t\t"+year+" is not leap year");nc++;
            }
        }
        
        System.out.println("leap = "+count);
        System.out.println("non leap = "+nc);
        
        sc.close();
    }
}
