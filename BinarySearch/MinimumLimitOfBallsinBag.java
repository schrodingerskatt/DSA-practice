/* Problem Link : https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/ */

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {

        int low = 1;
        int high = 0;
        for(int n : nums) high = Math.max(n, high);

        while(low < high){

            int mid = low + (high - low)/2;
            if(minPenalty(nums, mid, maxOperations)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
    return high;
    }

    public boolean minPenalty(int[] nums, int threshold, int maxOps){

        int ops = 0;
        for(int n : nums){
           ops+= (n-1)/threshold;
           if(ops > maxOps) return false;
        }
        return true;
    }
}