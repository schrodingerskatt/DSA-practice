class Solution {
    public int IslandPerimeter(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, visited, i, j);
                }
            }
        }
    return 0;
    }

    public int dfs(int[][] grid, boolean[][] visited, int r, int c){

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 1;
        }

        if(visited[r][c]) return 0;
        visited[r][c] = true;
        return dfs(grid, visited, r+1, c)+dfs(grid, visited, r-1, c)+dfs(grid, visited, r, c+1)+dfs(grid, visited, r, c-1);
    }
}