/*Either single or pair with someone
A-B-C
A-BC
B-AC
C-AB
We have to tell the count in which this can be done. order doesn't matters. here n = 3
so, f(n) = 4

Case 1: nth person is single, remaining people = f(n-1)
Case 2: nth person pairs with any of the (n-1) remaining peoples, now remaining will be f(n-2)
f(n) = f(n-1)+(n-1)*f(n-2)
f(0) = 1
f(1) = 1
f(2) = 2
*/ 

import java.util.*;
class FriendsPairing{

    public static void main(String[] args)throws Exception{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1]+(i-1)*dp[i-2];
        }
        System.out.println(dp[n]);
    }
}