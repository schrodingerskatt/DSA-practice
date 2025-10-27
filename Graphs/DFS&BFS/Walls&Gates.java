/* Problem Link : https://leetcode.com/problems/walls-and-gates/ */

class Pair{
    int r,c;
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        Queue<Pair>q = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    q.add(new Pair(i, j));
                }
            }
        }
    
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while(!q.isEmpty()){
        int n = q.size();
        for(int i = 0; i < n; i++){
            Pair p = q.remove();
            int row = p.r;
            int col = p.c;
            for(int[] dir:directions){
                int r = row+dir[0];
                int c = col+dir[1];
                if(r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c]!= 2147483647){
                    continue;
                }
                rooms[r][c] = rooms[row][col]+1;
                q.add(new Pair(r, c));
            }
        }
    }
    }
}