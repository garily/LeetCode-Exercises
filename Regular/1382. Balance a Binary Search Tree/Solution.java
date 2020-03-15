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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return buildTree(list, 0, list.size());
    }
    
    private TreeNode buildTree(List<Integer> list, int start, int end) {
        if (start >= end) return null;
        int mid = (start + end) / 2;
        TreeNode out = new TreeNode(list.get(mid));
        out.left = buildTree(list, start, mid);
        out.right = buildTree(list, mid + 1, end);
        return out;
    }
    
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
