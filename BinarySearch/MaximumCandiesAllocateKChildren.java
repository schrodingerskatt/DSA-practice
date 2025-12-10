/* Problem Link : https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/ */


class Solution {
    public int maximumCandies(int[] candies, long k) {

        int low = 1;
        int high = 0;
        for(int candy : candies) high = Math.max(high, candy);
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(candiesPossible(candies, mid, k)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
    return ans;
    }

    public boolean candiesPossible(int[] candies, int limit, long childrens){

        long total = 0;
        for(int c : candies){
            total+=(c/limit);
        }
        if(total >= childrens) return true;
        return false;
    }
}