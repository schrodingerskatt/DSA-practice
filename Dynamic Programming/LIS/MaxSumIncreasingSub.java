import java.util.*;

public class MaxSumIncreasingSub{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int omax = Integer.MIN_VALUE;
        int[] dp = new int[n];

        for(int i = 0; i < dp.length; i++){
            Integer max = null;

            for(int j = 0; j < i; j++){
                if(arr[j] <= arr[i]){
                    if(max == null){
                        max = dp[i];
                    }else if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }

            if(max == null){
                dp[i] = arr[i];
            }else{
                dp[i] = max+arr[i];
            }
            if(dp[i] > omax){
                omax = dp[i];
            }
        }
        System.out.println(omax);
    }
}