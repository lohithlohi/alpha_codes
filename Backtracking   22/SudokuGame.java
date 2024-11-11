public class SudokuGame {

    public static void printsudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static Boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // full vertical check
        for (int i = 0; i < sudoku.length; i++) {
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        // full horizantal check
        for (int j = 0; j < sudoku.length; j++) {
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        // full sub-grid check
        int gsr = (row/3)*3;  // grid's starting row
        int gsc = (col/3)*3;  // grid's starting col
        // traversing whole grid
        for (int i = gsr; i < gsr+3; i++) {
            for (int j = gsc; j < gsc+3; j++) {
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static Boolean SudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if(row == 9){   // if(row==9 && col==0){}
            // printsudoku(sudoku);
            return true;   // solution exists
        }

        //recursion
        int Newrow = row, Newcol = col+1;
        if(Newcol == 9){
            Newrow = row+1;
            Newcol = 0;
        }

        if(sudoku[row][col] != 0){   // if cell is filed default , skip all for loops
            return SudokuSolver(sudoku, Newrow, Newcol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit; // place digit
                if(SudokuSolver(sudoku, Newrow, Newcol)){  //funx call
                    return true;   // stops backtracking after getting 1 solution
                }
                sudoku[row][col] = 0;  // Backtracking
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int sudoku[][] = {
            {0, 0, 0, 0, 0, 4, 7, 0, 0},
            {0, 0, 0, 5, 6, 0, 0, 0, 0},
            {2, 0, 9, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {0, 0, 0, 7, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 0, 0, 9, 4, 0},
            {0, 5, 0, 6, 8, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 3, 0, 0}
        };

        if(SudokuSolver(sudoku, 0, 0)){
            System.out.println("Solution Exists");
            printsudoku(sudoku);
        }
        else{
            System.out.println("Solution dosen't Exists");
        }
    }

}



/*
int sudoku[][] = {
            {0, 0, 0, 0, 0, 4, 7, 0, 0},
            {0, 0, 0, 5, 6, 0, 0, 0, 0},
            {2, 0, 9, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {0, 0, 0, 7, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 0, 0, 9, 4, 0},
            {0, 5, 0, 6, 8, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 3, 0, 0}
        };


int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

*/