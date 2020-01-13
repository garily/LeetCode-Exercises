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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack, qStack;
        pStack = new Stack<TreeNode>();
        qStack = new Stack<TreeNode>();
        hasNode(root, p, pStack);
        hasNode(root, q, qStack);
        TreeNode out = null;
        while (pStack.size() > 0 && qStack.size() > 0 && pStack.peek() == qStack.peek()) {
            out = pStack.pop();
            qStack.pop();
        }
        return out;
    }
    
    private boolean hasNode(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null || node == null) return false;
        if (root == node) {
            stack.push(root);
            return true;
        }
        if (hasNode(root.left, node, stack) || hasNode(root.right, node, stack)) {
            stack.push(root);
            return true;
        }
        return false;
    }
}
