import java.util.Scanner;

public class righttri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // normal pattern
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){         // 1 to i
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n");

        // inverted pattern
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i+1; j++){     // 1 to n-i+1
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n");

        // number half-pyramid
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){         // 1 to i
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("\n");

        // character half-pyramid
        char ch = 'A';
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){         // 1 to i
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }

        sc.close();
    }
}