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
    private Map<TreeNode, Integer>[] map = new HashMap[] {
        new HashMap(),
        new HashMap()
    };
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(root.val + rob(root, true), rob(root, false));
    }
    
    private int rob(TreeNode root, boolean parentRobbed) {
        if (root == null) return 0;
        if (!parentRobbed && map[0].containsKey(root)) return map[0].get(root);
        else if (parentRobbed && map[1].containsKey(root)) return map[1].get(root);
        int out = 0;
        if (parentRobbed) {
            out = rob(root.left, false) + rob(root.right, false);
            map[1].put(root, out);
        }
        else {
            out = rob(root.left) + rob(root.right);
            map[0].put(root, out);
        }
        return out;
    }
}
