package SymmetricTree;
import java.util.Stack;

// Iterative solution

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null) return root.right == null;
        if (root.right == null) return false;
        if (root.left.val != root.right.val) return false;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode nodeR = stack.pop();
            TreeNode nodeL = stack.pop();
            if (nodeL == null && nodeR == null) continue;
            if (nodeL == null || nodeR == null) return false;
            if (nodeL.val != nodeR.val) return false;

            stack.push(nodeL.left);
            stack.push(nodeR.right);
            stack.push(nodeL.right);
            stack.push(nodeR.left);
        }
        return stack.size() == 0;
    }
}
