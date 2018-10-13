package SymmetricTree;
import java.util.Stack;

// Recursive solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null) return root.right == null;
        if (root.right == null) return false;
        if (root.left.val != root.right.val) return false;

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        leftInPush(leftStack, root.left);
        rightInPush(rightStack, root.right);

        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            if (leftStack.pop().val != rightStack.pop().val)
                return false;
        }
        return leftStack.isEmpty() && rightStack.isEmpty();
    }

    void rightInPush(Stack stack, TreeNode node) {
        if (stack == null) return;
        if (node != null) {
            rightInPush(stack, node.right);
            stack.push(node);
            rightInPush(stack, node.left);
        }
        else {
            //mark empty
            stack.push(new TreeNode(0));
        }
    }

    void leftInPush(Stack stack, TreeNode node) {
        if (stack == null) return;
        if (node != null) {
            leftInPush(stack, node.left);
            stack.push(node);
            leftInPush(stack, node.right);
        }
        else {
            //mark empty
            stack.push(new TreeNode(0));
        }
    }
}
