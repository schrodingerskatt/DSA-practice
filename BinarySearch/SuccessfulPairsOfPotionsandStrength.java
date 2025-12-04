/*  https://leetcode.com/problems/successful-pairs-of-spells-and-potions/    */


class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++){

            int spell = spells[i];
            int low = 0;
            int high = potions.length - 1;
            int idx = potions.length;
            while(low <= high){
                int mid = low + (high - low)/2;
                long strength = (long)spell*potions[mid];
                if(strength >= success){
                    high = mid - 1;
                    idx = mid;
                }else{
                    low = mid + 1;
                }
            }
        ans[i] = potions.length - idx;
        }
    return ans;
    }
}