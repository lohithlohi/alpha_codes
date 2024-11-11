public class diagonalsum {
    public static void main(String[] args) {
        int matrix[][] =   {{1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}};

        int sum = 0;
        
        // // TC ==> O(n^2)
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         // primary diagonal
        //         if(i==j){
        //             sum += matrix[i][j];
        //         }
        //         // secondary diagonal
        //         else if(i+j == matrix.length-1){   // i+j == n-1 and repeated middle celll addition is also resolved
        //             sum += matrix[i][j];
        //         }
        //     }
        // }
        // System.out.println("Sum : "+sum);


        //TC => O(n)
        for (int i = 0; i < matrix.length; i++) {
            
            // 1. primary diagonal
            sum += matrix[i][i];

            // 2. secondary diagonal
            if(i != matrix.length-1-i){       // to tackle repeated middle celll addition
                sum += matrix[i][matrix.length-1-i]; // if i+j = n-1 then j = n-1-i
            }
        }
        System.out.println("Sum : "+sum);
    }
}
