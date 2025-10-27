class Solution {

    public int dfs(int r1, int c1, int c2, int[][] grid, Integer[][][] dp){

        if(c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length){
            return Integer.MIN_VALUE;
        }

        if(r1 == grid.length-1){
            if(c1 == c2){
                return grid[r1][c1];
            }else{
                return grid[r1][c1]+grid[r1][c2];
            }
        }

        if(dp[r1][c1][c2]!= null){ return dp[r1][c1][c2]; }

        int cherries = (c1 == c2) ? grid[r1][c1] : grid[r1][c1] + grid[r1][c2];

        int maxNext = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                maxNext = Math.max(maxNext, dfs(r1 + 1, c1 + d1, c2 + d2, grid, dp));
            }
        }

        cherries += maxNext;
        dp[r1][c1][c2] = cherries;
        return cherries;

    }
    public int CherryPickUpII(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        Integer[][][] dp = new Integer[rows][cols][cols];
        return dfs(0, 0, cols-1, grid, dp);
        
    }
}