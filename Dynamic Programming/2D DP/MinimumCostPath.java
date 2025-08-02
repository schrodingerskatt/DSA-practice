/*
Minimum Cost Path

1. You are given a number 'n' representing the number of rows.
2. You are given a number 'm' representing the number of columns.
3. You are given a 'n*m' maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move one cell right or one cell down.
6. Each cell has a value that will have to be paid to enter that cell.
7. You are required to traverse through the matrix and print the least costly path.
*/

public class MinimumCostPath{

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

        for(int i = dp.length-1; i >=0; i--){
            for(int j = dp[0].length-1; j >=0; j--){
                if(i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }

                else if(i == dp.length-1){
                    dp[i][j] = dp[i][j+1]+arr[i][j];
                }
                else if(j == dp[0].length-1){
                    dp[i][j] = dp[i+1][j]+arr[i][j];
                }

                else{
                    dp[i][j] = arr[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        System.out.println("Minimum cost path is " + dp[0][0]);
    }
}