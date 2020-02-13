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
    public TreeNode sortedArrayToBST(int[] nums) {
        return subTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode subTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = subTree(nums, start, mid - 1);
        node.right = subTree(nums, mid + 1, end);
        return node;
    }
}
