import java.util.ArrayList;

public class IndianCoins {
    public static void main(String[] args) {
        int coins[] = {2000, 500, 100, 50, 20, 10, 5, 2, 1};  // descending sorted
        int amount = 1059;  // total amount
        int count = 0;
        ArrayList<Integer> change = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if(amount >= coins[i]){
                while(amount >= coins[i]){
                    change.add(coins[i]);   // valid change
                    count++;
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Min no. of coins: "+count);
        System.out.println("Change is: "+change);
    }
}