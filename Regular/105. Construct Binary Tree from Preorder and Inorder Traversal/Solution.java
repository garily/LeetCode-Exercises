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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) return null;
        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0);
        return root;
        
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd, int rootPreIdx) {
        if (inStart > inEnd || rootPreIdx >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[rootPreIdx]);
        int i = inStart;
        for (; i < inEnd; i++) {
            if (inorder[i] == preorder[rootPreIdx]) break;
        }
        root.left = buildTree(preorder, inorder, inStart, i - 1, rootPreIdx + 1);
        root.right = buildTree(preorder, inorder, i + 1, inEnd, rootPreIdx + i - inStart + 1);
        return root;
    }
}
