/* Problem Link : https://leetcode.com/problems/find-in-mountain-array/ */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findPeak(mountainArr);

        int left = binarySearch(mountainArr, 0, peak, target, true);
        if(left != -1) return left;

        return binarySearch(mountainArr, peak+1, mountainArr.length() - 1, target, false);
        
    }

    public int findPeak(MountainArray arr){

        int low = 0, high = arr.length() - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr.get(mid) < arr.get(mid+1)){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
    return high;
    }

    public int binarySearch(MountainArray arr, int low, int high, int target, boolean flag){

        while(low <= high){

            int mid = low + (high - low)/2;
            if(arr.get(mid) == target) return mid;

            if(flag){ // ascending

            if(arr.get(mid) < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }

            }else{ // descending

            if(arr.get(mid) < target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
    }
    return -1;
    }
}