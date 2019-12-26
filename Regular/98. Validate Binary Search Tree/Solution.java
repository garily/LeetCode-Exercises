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
    // recursion
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return root.val < max && root.val > min;
        if (root.left == null && root.right != null) return root.val < root.right.val && isValidBST(root.right, root.val, max);
        if (root.right == null && root.left != null) return root.left.val < root.val && isValidBST(root.left, min, root.val);
        // root.left != null && root.right != null
        return root.left.val < root.val && root.val < root.right.val && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
