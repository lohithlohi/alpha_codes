public class NQueens {

    public static int wayscount = 0;
    
    public static void printboard(char board[][]) {
        System.out.println("------CHESS BOARD:"+wayscount+"------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Boolean isSafe(char board[][], int row, int col) {
        // vertical up check
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // left diagonal up check
        for (int i=row-1, j=col-1 ; i>=0 && j>=0 ; i--, j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // right diagonal up check
        for (int i=row-1, j=col+1 ; i>=0 && j<board.length ; i--, j++) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
    
    // // for all ways of solutions
    // public static void nqueens(char board[][], int row) { // recursion is on row(level) basis
    //     // base case
    //     if(row == board.length){
    //         wayscount++;
    //         printboard(board);
    //         return;
    //     }

    //     // work/recursion
    //     // column loop (j)
    //     for (int j = 0; j < board.length; j++) {
    //         // check if Queen can be placed in row and j'th col
    //         if(isSafe(board, row, j)){
    //             board[row][j] = 'Q';   // place Queen on board[row][j]
    //             nqueens(board, row+1);  // function call to place Q in next row until BC hit
    //             board[row][j] = 'x';  // Backtracking, remove Queen from same place
    //         }
    //     }
    // }

    public static void main(String[] args) {
        int n = 5;  // rows x columns nxn
        char board[][] = new char[n][n];
        
        //initialization
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }

        // nqueens(board,0);
        // System.out.println("Total possible ways: "+wayscount);

        
        if(nqueens(board, 0)){
            System.out.println("Solution Exists");
            printboard(board);
        }
        else{
            System.out.println("Solution dosen't Exists");
        }
        
    }

    
    // for only 1 Solution and to tell if solution exists or not
    public static Boolean nqueens(char board[][], int row) {
        // base case
        if(row == board.length){
            // printboard(board);
            wayscount++;
            return true;
        }

        // work/recursion
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nqueens(board, row+1)){  
                    return true; // stops backtracking after getting 1 solution 
                }
                board[row][j] = 'x';
            }
        }

        return false;
    }
    
}
