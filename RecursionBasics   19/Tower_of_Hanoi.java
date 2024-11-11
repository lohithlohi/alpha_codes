import java.util.*;

public class Tower_of_Hanoi {

    public static void Tw_Of_Ha(int n, String src, String helper, String dest) {
        // base case
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        Tw_Of_Ha(n - 1, src, dest, helper);

        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);

        Tw_Of_Ha(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        Tw_Of_Ha(n, "A", "B", "C");

        sc.close();
    }
}
