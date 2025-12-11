/* Problem Link : https://leetcode.com/problems/find-k-th-smallest-pair-distance/ */

class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int low = 0, high = nums[nums.length-1] - nums[0];

        while(low < high){

            int mid = low + (high - low)/2;
            if(CountPairs(nums, mid) >= k){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
    return high;    
    }

    public int CountPairs(int[] nums, int dist){

        int count = 0;
        int i = 0;

        for(int j = 0; j < nums.length; j++){
            while(nums[j] - nums[i] > dist){
                i++;
            }
            count+= j-i;
        }
    return count;
    }
}