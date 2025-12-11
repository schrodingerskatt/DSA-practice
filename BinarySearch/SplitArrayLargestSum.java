/* Problem Link : https://leetcode.com/problems/split-array-largest-sum/description/ */

class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0, high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }

        while(low < high){

            int mid = low + (high - low)/2;
            if(canSplit(nums, k, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
    return high;
    }

    public boolean canSplit(int[] nums, int k, int threshold){

        int currentSum = 0;
        int subarrays = 1;

        for(int num : nums){
            if(currentSum + num > threshold){
                subarrays++;
                currentSum = num;
                if(subarrays > k) return false;
            }else{
                currentSum+=num;
            }
        }
    return true;
    }
}