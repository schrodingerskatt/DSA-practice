/*Problem Statement : https://leetcode.com/problems/number-of-islands/ */

class NumberOfIslands {

    public void DFS(int r, int c, char[][] grid){

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        DFS(r+1, c, grid);
        DFS(r-1, c, grid);
        DFS(r, c+1, grid);
        DFS(r, c-1, grid);
    }
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islands = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    DFS(i, j, grid);
                    islands++;
                }
            }
        }
    return islands;
    }
}