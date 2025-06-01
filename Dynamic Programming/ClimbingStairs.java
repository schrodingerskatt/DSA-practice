/*
Climbing Stairs

1. You are given a number 'n' representing the no. of staircases.
2. You are on 0th step and are required to climb the top.
3. In one move you are allowed to climb 1, 2 or 3 stairs.
4. Print no. of different paths via which you can climb to the top.
*/


import java.util.*;

public class ClimbingStairs{

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cp = countpaths(n);
        System.out.println(cp);
    }

    public static int countpaths(int n){

        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <=n; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    } 
}
