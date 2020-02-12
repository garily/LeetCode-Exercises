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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();
        if (root == null) return out;
        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<Integer> depths = new LinkedList<>();
        List<Integer> row = new LinkedList<>();
        nodes.offerLast(root);
        depths.offerLast(0);
        while (!nodes.isEmpty()) {
            TreeNode curNode = nodes.pollFirst();
            int depth = depths.pollFirst();
            if (curNode == null) continue;
            if (out.size() != depth) {
                out.add(row);
                row = new LinkedList<Integer>();
            }
            row.add(curNode.val);
            nodes.offerLast(curNode.left);
            depths.offerLast(depth + 1);
            nodes.offerLast(curNode.right);
            depths.offerLast(depth + 1);
        }
        if (row.size() > 0) out.add(row);
        return out;
    }
}
