public class GridWays {

    public static int countways = 0;
    public static void findgridways1(int grid[][], int row, int col) {
        // base case
        if(row==grid.length-1 && col==grid[0].length-1){ //at target //row==n-1 && col==m-1
            countways++;
            return;
        }

        // recursion
        if(col < grid[0].length){
            findgridways1(grid, row, col+1);  // right move
        }
        if(row < grid.length){
            findgridways1(grid, row+1, col);  //down move
        }
    }

    public static int findgridways2(int i, int j, int n, int m) {
        // base case
        if(i==n-1 && j==m-1){  // at target
            return 1;
        }
        else if(i==n || j==m){  // Boundary cross
            return 0;
        }

        int w1 = findgridways2(i, j+1, n, m); // right move
        int w2 = findgridways2(i+1, j, n, m); // down move

        return w1+w2;
    }

    public static int findgridways3(int n, int m) {
        /*
         *              (n-1 + m-1)!
         * total ways = -------------
         *              (n-1)!(m-1)!
         */

        int numer = factorial(n-1 + m-1);
        int denom = factorial(n-1)*factorial(m-1);

        return numer/denom;
    }

    public static int factorial(int n) {
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        int n=3,m=3;
        int grid[][] = new int[n][m];

        findgridways1(grid, 0, 0);
        System.out.println("void Approach 1: (TC) => O(2^(n+m))\nTotal ways: "+countways);
        System.out.println();

        System.out.println("int Approach 2: (TC) => O(2^(n+m))\nTotal ways: "+findgridways2(0, 0, n, m));
        System.out.println();

        System.out.println("Math Approach 3: (TC) => O((n+m))\nTotal ways: "+findgridways3(n, m));
    }
}
