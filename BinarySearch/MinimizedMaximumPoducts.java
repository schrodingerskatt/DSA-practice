/* Problem Link : https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/ */


class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = Integer.MAX_VALUE;
        for(int q : quantities) high = Math.max(q, high);
        while(low < high){

            int mid = low + (high - low)/2;
            if(isPossible(quantities, mid, n)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
    return high;
    }

    public boolean isPossible(int[] quantities, int limit, int n){

        int total = 0;
        for(int q : quantities){
            total += Math.ceil((double)q/limit);
            if(total > n) return false;
        }
    return true;
    }
}