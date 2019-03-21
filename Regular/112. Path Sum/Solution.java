/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            int diff = sum - root.val;
            if (root.left == null && root.right == null) return diff == 0;
            return hasPathSum(root.left, diff) || hasPathSum(root.right, diff);
        }
        return false;
    }
}
