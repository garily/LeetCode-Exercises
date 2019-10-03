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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> out = new LinkedList<>();
        for (; ;) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.empty()) break;
            root = stack.pop();
            out.add(root.val);
            root = root.right;
        }
        return out;
    }
}
