/*
Best time to buy and sell stocks with cool down - Infinite Transaction
*/

import java.util.*;
public class BestTimeBuySellStocks4{

    public static void main(String[] args)throws Exception{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int obsp = -arr[0];
        int ossp = 0;
        int ocsp = 0;

        for(int i = 1; i < arr.length; i++){
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;

            if(ocsp-arr[i] > obsp){
                nbsp = ocsp-arr[i];
            }else{
                nbsp = obsp;
            }
            if()
        }

    }


}
