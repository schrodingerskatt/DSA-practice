/* Problem Link : https://leetcode.com/problems/leaf-similar-trees/description/ */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer>leaves1 = new ArrayList<>();
        List<Integer>leaves2 = new ArrayList<>();

        CollectLeaves(root1, leaves1);
        CollectLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
        
    }

    public void CollectLeaves(TreeNode root, List<Integer>list){

        if(root == null) return;

        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        CollectLeaves(root.left, list);
        CollectLeaves(root.right, list);
    }
}