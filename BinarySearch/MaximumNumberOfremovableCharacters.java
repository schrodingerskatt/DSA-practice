/*Problem Link : https://leetcode.com/problems/maximum-number-of-removable-characters/description/ */


class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 0, high = removable.length, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isSubsequenceAfterRemoval(s, p, removable, mid)) {
                ans = mid;        // possible answer
                low = mid + 1;    // try removing more
            } else {
                high = mid - 1;   // remove fewer
            }
        }

        return ans;
    }

    private boolean isSubsequenceAfterRemoval(String s, String p, int[] removable, int k) {
        int n = s.length();
        boolean[] removed = new boolean[n];

        // Mark first k removable positions
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }

        int j = 0; // index in p

        // Try to match p inside s (skipping removed chars)
        for (int i = 0; i < n && j < p.length(); i++) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }

        return j == p.length(); // matched entire p
    }
}
