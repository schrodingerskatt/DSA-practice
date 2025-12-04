/* Problem Link : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/  */

class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }

        while(low < high){

            int mid = low + (high - low)/2;
            int total = 0;
            int dayCount = 1;
            for(int w : weights){
                if(total+w > mid){
                    dayCount++;
                    total = 0;
                }
                total+=w;
            }
            if(dayCount > days) low = mid + 1;
            else {
                high = mid;
            }
        }
    return low;
    }
}