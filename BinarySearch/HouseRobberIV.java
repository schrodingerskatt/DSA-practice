/* Problem Link : https://leetcode.com/problems/house-robber-iv/description/ */

class Solution {
    public int minCapability(int[] nums, int k) {

        int low = 1;
        int high = 0;
        for(int n : nums) high = Math.max(n, high);

        while(low < high){

            int mid = low + (high - low)/2;
            if(CanRob(nums, mid, k)) high = mid;
            else{
                low = mid + 1;
            }
        }
    return low;
    }

    public boolean CanRob(int[] nums, int mid, int k){

        int i = 0;
        int count = 0;
        while(i < nums.length){
            if(nums[i] <= mid){
                count++;
                i+=2;
                if(count >= k) return true;
            }else{
                i++;
            }
        }
    return false;
    }
}