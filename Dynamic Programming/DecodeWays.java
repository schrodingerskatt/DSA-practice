/*
1. You are given a string of digits
2. You are required to encode that str as per following rules
   1 -> a
   2 -> b
   3 -> c
   .....
   25 -> y
   26 -> z
3. You are required to calculate and print the count of encodings for the string str
    123 -> [abc, aw, lc]
    013 -> Invalid
    103 -> jc
*/

import java.util.*;

public class DecodeWays{

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] dp = new int[str.length()];
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++){
            if(str.charAt(i-1) == '0' && str.charAt(i) == '0'){
                dp[i] = 0;
            }
            else if(str.charAt(i-1) == '0' && str.charAt(i)!='0'){
                dp[i] = dp[i-1];
            }
            else if(str.charAt(i-1)!='0' && str.charAt(i) == '0'){
                if(str.charAt(i-1) == '1'|| str.charAt(i-1) == '2'){
                    dp[i] = (i>=2 ? dp[i-2]:1);
                }
                else{
                    dp[i] = 0
                }
            }
            else{
                if(Integer.parseInt(str.substring(i-1,i+1)) <= 26){
                    dp[i] = dp[i-1]+(i >=2 ? dp[i-2]:1);
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
        }
        System.out.println(dp[str.length()-1]);
    }
}