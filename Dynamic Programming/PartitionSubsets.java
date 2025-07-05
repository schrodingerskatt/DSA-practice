/*
Count the number of ways to partition a set of 'n' distinct elements into 'k' non-empty subsets
(order of subsets doesn't matter, but contents do).
Let's say we already know how to partition n-1 elements.

Now we're trying to add the nth element.

Two possibilities for the nth element :

Let's fix the set of n-1 elements and consider all valid partitions of it into 'k' ot 'k-1' subsets.
We now need to add element n.

Case 1: Add 'n' to an existing subset

* Suppose we already partitioned n-1 elements into k subsets.
* Now, we want to add nth element to one of these already existing subsets.
* For each such partitions, there are 'k' choices to insert the new element 'n' into one of the subsets.
So, this contributes to - k*S(n-1, k)

Case 2: Put 'n' in a new singleton subset

* Suppose we partitioned 'n-1' elements into 'k-1' subsets.
* Now, create a new subset just for the nth element.
* This increases the number of subsets from (k-1) to k
so, this contributes to S(n-1, k-1)

S(n,k) = k*S(n-1,k)+S(n-1,k-1)
*/

import java.util.*;

public class Main{

    public static void main(String[] args)throws Exception{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if(n == 0 || k == 0 || n < k){
            System.out.println(0);
            return;
        }
        long[][] dp = new long[k+1][n+1];
        for(int t = 1; t <=k; t++){
            for(int p = 1; p <=n; p++){
                if(p < t){
                    dp[t][p] = 0;
                }
                else if(p == t){
                    dp[t][p] = 1;
                }
                else{
                    dp[t][p] = t*dp[t][p-1]+dp[t-1][p-1];
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}