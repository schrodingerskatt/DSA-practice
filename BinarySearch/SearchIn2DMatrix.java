/* Problem Link : https://leetcode.com/problems/search-a-2d-matrix/   */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length;
        int c = matrix[0].length;

        int start = 0;
        int end = r*c-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[mid/c][mid%c] == target) return true;
            else if(matrix[mid/c][mid%c] > target) end = mid - 1;
            else start = mid + 1;
        }
    return false;
    }
}