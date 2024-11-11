public class spiralmat{
    public static void main(String[] args) {
        // int matrix[][] =   {{1, 2, 3, 4},
        //                     {5, 6, 7, 8},
        //                     {9, 10, 11, 12},
        //                     {13, 14, 15, 16}};

        // int matrix[][] = {{1,2,3,4,5},
        //                   {6,7,8,9,10}};

        // int matrix[][] = {{1,2,3,4,5,6}};

        int matrix[][] ={{1,2,3},
                         {4,5,6},
                         {7,8,9}};

        int strow = 0;
        int stcol = 0;
        int enrow = matrix.length-1;
        int encol = matrix[0].length-1; // n = matrix.length;

        while(strow <= enrow && stcol <= encol){

            // top
            for (int j = stcol; j <= encol; j++) {
                System.out.print(matrix[strow][j]+" ");
            }
            // strow++;

            // right
            for (int i=strow+1; i <= enrow; i++){
                System.out.print(matrix[i][encol]+" ");
            }
            // encol--;

            // bottom
            for (int j = encol-1; j >= stcol; j--) {
                if(strow == enrow){     // to tackle 1D row array and avoid repeated printing
                    break;
                }
                System.out.print(matrix[enrow][j]+" ");
            }
            // enrow--;

            // left
            for (int i=enrow-1; i >= strow+1; i--){
                if(stcol == encol){     // to tackle 1D column array and avoid repeated printing
                    break;
                }
                System.out.print(matrix[i][stcol]+" ");
            }

            // update (shrink matrix boundaries)
            strow++;
            enrow--;
            stcol++;
            encol--;
        }

        System.out.println();
    }
}