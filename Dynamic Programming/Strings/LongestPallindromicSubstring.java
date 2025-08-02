import java.util.*;

public class LongestPallindromicSubstring{

    public static void main(String[] args)throws Exception{

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int g = 0; g < s.length; g++){
            for(int i = 0, j = g; j < s.length(); i++, j++){

                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        String ans = "";
        int longest = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(dp[i][j]){
                    if(j-i+1 > longest){
                        longest = j-i+1;
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}