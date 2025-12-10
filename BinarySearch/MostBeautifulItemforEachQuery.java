/* Problem Link : https://leetcode.com/problems/most-beautiful-item-for-each-query/ */


class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int n = items.length;

        int[] prefix = new int[n];
        prefix[0] = items[0][1];

        for(int i = 1; i < n; i++){
            prefix[i] = Math.max(prefix[i-1], items[i][1]);
        }
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){

            int q = queries[i];
            int low = 0, high = n - 1, pos = -1;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(items[mid][0] <= q){
                    pos = mid;
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        ans[i] = (pos == -1 ? 0 : prefix[pos]);
        }
    return ans;
    }
}