// Stair_case search techinque
// prerequisite = sorted 2d matrix
public class staircasesrc {

    /*
     * Time complexity depends on length of n or m
     * if n >>>>> m  TC = O(n)
     * if m >>>>> n  TC = O(m)
     * 
     * so for better worst case ===> TC = O(n+m)
     */
    
    public static void stair_case_src(int matrix[][], int key){
        // // start from top right corner (0,n-1)
        // int i = 0, j = matrix[0].length-1;

        // // i & j should be in matrix
        // while(i <= matrix.length-1 && j >= 0){   // b/c only down and left case
        //     if(key == matrix[i][j]){
        //         System.out.println("Key found at : ("+i+","+j+")");
        //         return;
        //     }
        //     else if(key > matrix[i][j]){
        //         // move DOWN
        //         i++;
        //     }
        //     else if(key < matrix[i][j]){
        //         // move LEFT
        //         j--;
        //     }
        // }

        // start from bottom left corner
        int row = matrix.length-1, col = 0;

        while(row >= 0 && col <= matrix.length-1){
            if(key == matrix[row][col]){
                System.out.println("Key found at : ("+row+","+col+")");
                return;
            }
            else if(key < matrix[row][col]){
                // move UP
                row--;
            }
            else if(key > matrix[row][col]){
                //move RIGHT
                col++;
            }
        }

        System.out.println("Key not found");
    }

    public static void main(String[] args) {
        int matrix[][] = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};
        
        int key = 33;

        stair_case_src(matrix,key);
        
    }
}
