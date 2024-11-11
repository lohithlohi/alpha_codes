import java.util.*;

public class maxmin{
    
    public static void mxmn(int matrix[][]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(matrix[i][j] , max);  // maximum
                min = Math.min(matrix[i][j] , min);  // minimum
            }
        }
        System.out.println("Max : "+max);
        System.out.println("Min : "+min);
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
        mxmn(matrix);
        
        sc.close();
    }
}