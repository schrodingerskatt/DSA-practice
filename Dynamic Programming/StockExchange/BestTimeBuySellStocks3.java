/*
Best time to buy and sell stocks with transaction fee and infinite transactions
*/

import java.util.*;

public class BestTimeBuySellStocks3{

public static void main(String[] args)throws Exception{

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
    }

    int fee = sc.nextInt();

    int old_bought_state_profit = -arr[0];
    int old_sell_state_profit = 0;

    for(int i = 1; i < arr.length; i++){

        int new_bought_state_profit = 0;
        int new_sell_state_profit = 0;

        if(old_sell_state_profit-arr[i] > old_bought_state_profit){
            new_bought_state_profit = old_sell_state_profit-arr[i];
        }else{
            new_bought_state_profit = old_bought_state_profit;
        }
        if(old_bought_state_profit+arr[i]-fee > old_sell_state_profit){
            new_sell_state_profit = old_bought_state_profit+arr[i]-fee;
        }else{
            new_sell_state_profit = old_sell_state_profit;
        }
        old_bought_state_profit = new_bought_state_profit;
        old_sell_state_profit = new_sell_state_profit;
    }
    System.out.println(old_sell_state_profit);
}

}