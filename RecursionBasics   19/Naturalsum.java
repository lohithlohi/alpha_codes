public class Naturalsum {

    public static int printnatsum(int n) {
        //base case
        if(n==1 || n==0){
            return n;
        }

        int Snm1 = printnatsum(n-1);
        int Sn = n + Snm1;
        return Sn;

        // return n + printnatsum(n-1);
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(printnatsum(n));
    }
}
