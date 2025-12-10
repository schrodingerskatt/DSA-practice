/* Problem Link : https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/ */


class Solution {
    public int minimizeMax(int[] nums, int p) {

        if(p == 0) return 0;

        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1] - nums[0];
        while(low < high){

            int mid = low + (high - low)/2;
            if(isValid(nums, mid, p)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
    return high;
    }

    public boolean isValid(int[] nums, int limit, int p){

        int i = 0;
        int count = 0;
        while(i < nums.length-1){
            if(Math.abs(nums[i]-nums[i+1]) <= limit){
                count++;
                i+=2;
                if(count == p) return true;
            }else{
                i+=1;
            }  
        }
    return false;
    }
}