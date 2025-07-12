/* Best time to buy and sell stocks - One Transaction Allowed */

import java.util.*;

public class BestTimeBuySellStocks{

    public static void main(String[] args)throws Exception{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }

        int least_so_far = Integer.MAX_VALUE;
        int max_profit = 0;
        int profit_so_far = 0;

        for(int i = 0; i < n; i++){

            if(prices[i] < least_so_far){
                least_so_far = prices[i];
            }
            profit_so_far = prices[i]-least_so_far;
            if(profit_so_far > max_profit){
                max_profit = profit_so_far;
            }
        }
        System.out.println(max_profit);
    }

}