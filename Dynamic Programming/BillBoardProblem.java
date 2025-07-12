/*
You are given:

* A highway of length n miles.

* Possible billboard locations billboard[] (sorted array of integers).

* Profit revenue[i] associated with placing a billboard at billboard[i].

* A constraint: no two billboards can be placed within t miles of each other.

Your task: Place billboards to maximize total revenue while satisfying the distance constraint.

*/

import java.util.*;

public class BillBoardProblem{

    static void main(String[] args)throws Exception{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] billboards = new int[n];
        int m = sc.nextInt();
        int[] revenue = new int[m];

        for(int i = 0; i < n; i++){
            billboards[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++){
            revenue[i] = sc.nextInt();
        }

        int t = sc.nextInt();
        int[] dp = new int[m];
        dp[0] = revenue[0];
        for(int i = 1; i < n; i++){

            int incl = revenue[i];
            int j = i-1;

            while(j >=0 && billboards[i]-billboards[j] <=t){
                j--;
            }
            if(j >=0){
                incl+=dp[j];
            }
            dp[i] = Math.max(dp[i-1], incl);
        }
        System.out.println(dp[n-1]);


    }
}