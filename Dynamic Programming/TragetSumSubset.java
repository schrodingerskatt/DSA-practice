import java.util.*;

public class TargetSumSubset{

    public static void main(String[] args)throws Exception{

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i =0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    int target = sc.nextInt();

    int[][] dp = new int[n+1][target+1];
    for(int i = 0; i < dp.length; i++){
        for(int j = 0; j < dp[0].length; j++){
            if(i == 0 && j == 0){
                dp[i][j]=0;
            }
            else if(i == 0){
                dp[i][j] = 0;
            }
            else if(j == 0){
                dp[i][j] = 1;
            }
            else{
                if(dp[i-1][j] == 1){
                    dp[i][j] = 1;
                }
                else{
                    int val = arr[i-1];
                    if(val <= j){
                        if(dp[i-1][j-val] == 1){
                            dp[i][j] = 1;
                        }
                    }
                }
            }
        }
    }
    if(dp[dp.length-1][dp[0].length-1] == 1){
        System.out.println("Target sum subset exists");
    }
    else{
        System.out.println("Target sum subset doesn't exists");
    }

    }
}