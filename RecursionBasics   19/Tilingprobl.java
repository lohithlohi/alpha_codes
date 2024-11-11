public class Tilingprobl {

    public static int Tiling_prolem(int n) {    // for (2 x n) board/floor
        // base case
        if(n == 0 ||n == 1){   // (2x1) or (2x0) board
            return 1;    // only 1 way to place
        }

        // work
        // choiceing

        // vertical choice
        int Fnm1 = Tiling_prolem(n-1);

        // horizantal choice
        int Fnm2 = Tiling_prolem(n-2);

        int totalways = Fnm1 + Fnm2;
        return totalways;
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println("Ways: "+Tiling_prolem(n));
    }
}
