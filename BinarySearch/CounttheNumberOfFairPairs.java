/* Problem Link : https://leetcode.com/problems/count-the-number-of-fair-pairs/ */


class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int left = lower_bound(nums, lower - nums[i], i + 1, n - 1);
            int right = upper_bound(nums, upper - nums[i], i + 1, n - 1);

            if(left <= right){
                count += (right - left + 1);
            }
        }
        return count;
    }

    public int lower_bound(int[] nums, int target, int low, int high){
        int ans = high + 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int upper_bound(int[] nums, int target, int low, int high){
        int ans = low - 1;  

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] <= target){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
