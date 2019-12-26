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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int lm = root.val + dfs(root.left);
        int rm = root.val + dfs(root.right);
        int lmr = lm + rm - root.val;
        int maxSingleChild = Math.max(lm, Math.max(rm, root.val));
        max = Math.max(max, lmr);
        max = Math.max(max, maxSingleChild);
        return maxSingleChild;
    }
}
