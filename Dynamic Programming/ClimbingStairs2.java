/*

Climbing Stairs with variable jumps

1. You are given a number 'n', representing the number of stairs in a staircase.
2. You are in the 0th step and are required to climb to the top.
3. You are given 'n' numbers. where ith element's value represents - till how far from the step you could
   jump in a single move. you can of course use fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.
*/

import java.util.*;

public class ClimbingStairs2{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i = n-1; i >= 0; i--){
            for(int j = 1; j <= arr[i] && i+j < dp.length; j++){
                  dp[i]+=dp[i+j];
            }
        }
        System.out.println(dp[0]);
    }
}