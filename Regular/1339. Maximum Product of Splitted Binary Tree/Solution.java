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
    long max = 0;
    long sum = 0;
    public int maxProduct(TreeNode root) {
        sum = getSum(root);
        getMax(root);
        return (int) (max % 1000000007);
    }
    
    private long getSum(TreeNode node) {
        if (node == null) return 0;
        return (long) node.val + getSum(node.left) + getSum(node.right);
    }
    
    private long getMax(TreeNode node) {
        if (node == null) return 0;
        long left = getMax(node.left);
        long right = getMax(node.right);
        max = Math.max(max, left * (sum - left));
        max = Math.max(max, right * (sum - right));
        return left + right + (long) node.val;
    }
}
