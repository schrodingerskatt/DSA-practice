/* Problem Link : https://leetcode.com/problems/minimum-time-to-repair-cars/ */


class Solution {
    public long repairCars(int[] ranks, int cars) {

        long low = 0;
        long high = 1;

        for(int r : ranks){
            high = Math.max(high, (long)r*cars*cars);
        }

        while(low < high){

            long mid = low + (high - low)/2;
            if(canFix(ranks, mid, cars)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
    return high;
    }

    public boolean canFix(int[] ranks, long time, int cars){

        long carsFixed = 0;

        for(int r : ranks){

            long n = (long) Math.sqrt((double) time / r);
            carsFixed += n;
            if(carsFixed >= cars) return true;
        }
    return false;
    }
}