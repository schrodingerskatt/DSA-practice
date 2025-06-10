import java.util.*;

public class ClimbStairsMinMoves{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Integer[] dp = new Integer[n+1];
        dp[n] = 0;

        for(int i = n-1; i >=0; i--){
            if(arr[i] > 0){
                int minval = Integer.MAX_VALUE;
                for(int j = 1 ; j <=arr[i];j++){
                    if(dp[i+j]!=null && i+j <= n){
                        minval = Math.min(minval, dp[i+j]);
                    }
                }
            if(minval != Integer.MAX_VALUE){
                dp[i] = minval+1;
            }
            }
        }
        System.out.println(dp[0]);
    }
}