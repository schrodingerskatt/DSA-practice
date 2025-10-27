import java.util.*;
// Backtracking Solution

public class CherryPickUp{

    static int maxCherries = 0;

    public static void ToptoBottom(int[][] arr, int i, int j, int cherriesSofar){

        if(arr[i][j] == -1 || i >= arr.length || j >= arr[0].length || i < 0 || j < 0){
            return;
        }

        int cherry = arr[i][j];
        arr[i][j] = 0;
        ToptoBottom(arr, i+1, j, cherriesSofar+cherry);
        ToptoBottom(arr, i, j+1, cherriesSofar+cherry);
        arr[i][j] = cherry;

        if(i == arr.length-1 && j == arr.length-1){
            BottomtoTop(arr,n-1,n-1, cherriesSofar);
        }
    }

    public static void BottomtoTop(int[][] arr, int i, int j, int cherriesSofar){

        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == -1){
            return;
        }

        if(i == 0 && j == 0){
            maxCherries = Math.max(maxCherries, cherriesSofar);
            return;
        }

        int cherry = arr[i][j];
        arr[i][j] = 0;
        BottomtoTop(arr, i-1, j, cherriesSofar+cherry);
        BottomtoTop(arr, i, j-1, cherriesSofar+cherry);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        ToptoBottom(arr,0,0,0);
    }
}

// DP Solution

class Solution {

    public static int pathTracer(int r1, int c1, int r2, int[][] grid, int[][][] dp) {
        int c2 = r1 + c1 - r2;

        if (r1 >= grid.length || c1 >= grid[0].length || r2 >= grid.length || c2 >= grid[0].length ||
            r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0 ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != Integer.MIN_VALUE) {
            return dp[r1][c1][r2];
        }

        int cherries = (r1 == r2 && c1 == c2) ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];

        int hh = pathTracer(r1, c1 + 1, r2, grid, dp);
        int vv = pathTracer(r1 + 1, c1, r2 + 1, grid, dp);
        int hv = pathTracer(r1, c1 + 1, r2 + 1, grid, dp);
        int vh = pathTracer(r1 + 1, c1, r2, grid, dp);

        int bestNext = Math.max(Math.max(hh, vv), Math.max(hv, vh));
        if (bestNext == Integer.MIN_VALUE) {
            dp[r1][c1][r2] = Integer.MIN_VALUE;
            return dp[r1][c1][r2];
        }

        cherries += bestNext;
        dp[r1][c1][r2] = cherries;
        return cherries;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] arr2d : dp) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, pathTracer(0, 0, 0, grid, dp));
    }
}
