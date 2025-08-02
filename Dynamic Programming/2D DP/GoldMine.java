/*
GoldMine

1. You are given a number n, representing number of rows
2. You are given a number m, representing number of columns
3. You are given n*m nubers, representing elements of 2D array which represents a goldmine
4. You are standing in front of a left wall and are supposed to dig to the right wall.
   you can start from any row in the left wall.
5. You are allowed to move one cell right-up, one cell right, one cell right down.
*/

public class GoldMine{

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        /* we will go column-wise */
        for(int j = arr[0].length-1; j >=0; j--){
            for(int i = arr[0].length-1; i >=0; i--){
                if(j == arr[0].length-1){
                    dp[i][j] = arr[i][j];
                } else if(i == 0){
                    dp[i][j] = arr[i][j]+Math.max(dp[i][j+1], dp[i+1][j+1]);
                } else if(i == arr.length-1){
                    dp[i][j] = arr[i][j]+Math.max(dp[i][j+1], dp[i-1][j+1]);
                }else{
                    dp[i][j] = arr[i][j]+Math.max(dp[i][j+1], Math.max(dp[i-1][j+1],dp[i+1][j+1]));
                }
            }
        }
        int maxima = dp[0][0];
        for(int i = 0; i < n; i++){
            maxima = Math.max(maxima, dp[i][0]);
        }
        System.out.println("Maximum gold collected is " + maxima);
    }
}