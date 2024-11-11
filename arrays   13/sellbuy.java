import java.util.Scanner;


public class sellbuy {

    //Method 1
    // time complexity: O(n)
    public static void stock_profit(int arr[]) {
        
        //tracked for minimum buy prices w.r.t each day(index)
        int buyarr[] = new int[arr.length];
        buyarr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            buyarr[i] = Math.min(arr[i],buyarr[i-1]);
        }

        int maxprofit = Integer.MIN_VALUE, currprofit = 0;
        for (int i = 0; i < arr.length; i++) {
            currprofit = arr[i] - buyarr[i];
            if(currprofit < 0) currprofit=0;
            maxprofit = Math.max(currprofit,maxprofit);
        }

        System.out.println("Max profit can be earned is: "+maxprofit);
    }

    //Method 2
    // time complexity: O(n)
    public static void stk_profit(int prices[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(buyprice < prices[i]){   // today can make profit
                int profit = prices[i] - buyprice;
                maxprofit = Math.max(profit,maxprofit);
            }
            else{  // today loss day , buy at lower price today
                buyprice = prices[i];
            }
        }
        System.out.println("Max profit can be earned is: "+maxprofit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int prices1[] = {7, 1, 5, 3, 6, 4};
        int prices2[] = {7, 6, 4, 3, 1};
        // stock_profit(arr);
        stk_profit(prices1);
        stk_profit(prices2);
        sc.close();  
    }
}
