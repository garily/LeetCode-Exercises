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
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenLast(root);
    }
    
    private TreeNode flattenLast(TreeNode root) {
        if (root == null) return null;
        TreeNode leftLast = flattenLast(root.left);
        TreeNode rightLast = flattenLast(root.right);
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
            if (rightLast == null) rightLast = leftLast;
        }
        return rightLast == null ? root : rightLast;
    }
}
