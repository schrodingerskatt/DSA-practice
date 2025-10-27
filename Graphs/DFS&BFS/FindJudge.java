class Solution {
    public int FindJudge(int n, int[][] trust) {

        if(n == 1) return 1;
        int[] judge = new int[n+1];

        for(int[] t:trust){
            judge[t[0]]--;
            judge[t[1]]++;
        }
        for(int i = 1; i <=n; i++){
            if(judge[i] == n-1) return i;
        }
        return -1;
        
    }
}