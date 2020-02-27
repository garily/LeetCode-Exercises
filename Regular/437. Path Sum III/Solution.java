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
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, true);
    }
    
    private int pathSum(TreeNode root, int sum, boolean canStartNew) {
        if (root == null) return 0;
        int count = 0;
        if (sum == root.val) count++;
        if (canStartNew) {
            count += pathSum(root.left, sum, true);
            count += pathSum(root.right, sum, true);
        }
        count += pathSum(root.left, sum - root.val, false);
        count += pathSum(root.right, sum - root.val, false);
        return count;
    }
}
