/*
 * Stock Span Problem
 * Span => Max No of consecutive days for which price <= currentprice
 * TC=> O(n)
 * 
 */
import java.util.*;

public class StockSpan {

    public static void stokspn(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();   // for only index not price values

        // for first day or index-0
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {   //traverse for all days

            // untill we meet prevHigh from current price
            while (!s.isEmpty() && stocks[s.peek()] <= stocks[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;    // this stocks[i] is biggest till 'i'   {ex: last 100 => 7}
            } else {
                span[i] = i - s.peek(); // s.peek() is prevhigh
            }

            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];

        stokspn(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.err.print(span[i] + " ");
        }
    }
}
