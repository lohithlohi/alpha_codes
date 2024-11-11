public class RatinMaze {

    public static void printmaze(int maze[][]){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int row, int col) {
        if (maze[row][col] == 1 && row < maze.length && col < maze[0].length) {
            return true;
        }
        return false;
    }

    public static boolean ratmaze(int maze[][], int row, int col,int sol[][]) {
        // base case
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            sol[row][col] = 1;
            printmaze(sol);
            return true;
        }

        // recursion
        if (isSafe(maze, row, col)) {
            sol[row][col] = 1;

            if (col + 1 < maze[0].length && ratmaze(maze, row, col + 1, sol)) { // right move
                return true;
            }
            if (row + 1 < maze.length && ratmaze(maze, row + 1, col, sol)) { // down move
                return true;
            }

            sol[row][col] = 0; // backtrack
            return false;
        }
        return false; // walls or barriers
    }

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 0 },
                { 1, 0, 0, 1, 1 },
                { 1, 1, 1, 0, 1 }
        };

        // System.out.println(maze.length+","+maze[0].length);

        System.out.println(ratmaze(maze, 0, 0, new int[maze.length][maze[0].length]));
    }
}
