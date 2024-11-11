public class Friendpair {
    public static int pairing(int n) {
        if(n == 1 || n == 2 || n == 0){
            return n;
        }

        // choices
        
        // single
        int Fnm1 = pairing(n-1);

        // paired
        int Fnm2 = pairing((int)(n-2));   // ways after making 1st pair
        int pairways = (n-1) * Fnm2;   //No of ways to make 1st pair => (n-1)

        int totalways = Fnm1 + pairways;
        return totalways;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(pairing(n));
    }
}
