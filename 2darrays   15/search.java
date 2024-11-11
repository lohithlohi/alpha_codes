import java.util.Scanner;

public class search {
    
    public static void find(int matrix[][],int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == key){
                    System.out.println("Key found at: ("+i+","+j+")");
                    return;
                }
            }
        }
        System.out.println("Key not found");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];

        // int n = matrix.length;    // rows
        // int m = matrix[0].length; // columns
        
        System.out.println("Fill 3x3 matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Matrix entered:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.print("Enter key : ");
        int key = sc.nextInt();

        find(matrix,key);

        sc.close();
    }
}
