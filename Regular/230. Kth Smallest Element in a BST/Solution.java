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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int out = root.val;
        for (int order = 0; order < k;) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.empty()) break;
            root = stack.pop();
            out = root.val;
            root = root.right;
            order++;
        }
        return out;
    }
}
