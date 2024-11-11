import java.util.Scanner;

public class xy_split {
    public static void xy_split_ways(String str){

        int ways = 0;
        for (int i = 1; i < str.length(); i++) {
            String p1 = str.substring(0, i);
            String p2 = str.substring(i);

            // only focused on which cases will give negative o/p  <= {" LEARNING "}
            // p1 | p2
            // x  | y    => false
            // y  | x    => false
            // remaining all cases are true
            
            if(p1.contains("x") && !p1.contains("y") && !p2.contains("x") && p2.contains("y")
                || !p1.contains("x") && p1.contains("y") && p2.contains("x") && !p2.contains("y")){
                continue;
            }else{
                ways++;
            }
        }

        System.out.println(ways);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        String str = sc.next();

        xy_split_ways(str);


        sc.close();
    }
}
