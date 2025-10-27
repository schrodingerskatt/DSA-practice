/* Problem Link : https://leetcode.com/problems/rotting-oranges/description/ */


class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        
        int fresh = 0;
        Queue<Pair>q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int timer = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty() && fresh > 0){
            int n = q.size();
            for(int i = 0; i < n; i++){
                Pair p = q.remove();
                int nr = p.r;
                int nc = p.c;
                for(int[] dir:directions){
                    int row = nr+dir[0];
                    int col = nc+dir[1];
                if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1){
                    continue;
                }
                grid[row][col] = 2;
                q.add(new Pair(row, col));
                fresh--;
                }
            }
            timer++;
        }
        if(fresh > 0) return -1;
        return timer;
    }
}