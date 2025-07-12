/* Best time to buy and sell stocks - Infinite transactions allowed */

import java.util.*;

public class BestTimeBuySellStocks2{

public static void main(String[] agrs)throws Exception{

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
    }

    int buy_day = 0;
    int sell_day = 0;
    int profit = 0;
    for(int i = 0; i < n; i++){
        if(arr[i] >= arr[i-1]){
            sell_day++;
        }
        else{
            profit+=arr[sell_day]-arr[buy_day];
            buy_day = sell_day = i;
        }
    }
    System.out.println(profit);
}
}