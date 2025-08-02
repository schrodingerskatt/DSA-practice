import java.util.*;

public class UnboundedKnapsack{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];
        for(int i = 0; i < n; i++){
            vals[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            wts[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int bagc = 0; bagc <= target; bagc++){
            for(int i = 0; i < n; i++){
                int max = 0;
                if(wts[i] <= bagc){
                    int rbagc = bagc-wts[i];
                    int rbagv = dp[rbagc];
                    int tbagv = rbagv+vals[i];

                    if(tbagv > max){
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }

    System.out.println(dp[target]);
    }
}