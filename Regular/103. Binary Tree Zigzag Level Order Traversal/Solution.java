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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();
        if (root == null) return out;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> layer = new LinkedList<>();
        Deque<Integer> depths = new LinkedList<>();
        nodes.offerLast(root);
        depths.offerLast(0);
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.pollLast();
            int depth = depths.pollLast();
            if (cur != null) {
                if (depth % 2 == 0) { // left to right in current layer
                    layer.offerLast(cur.val);
                }
                else { // right to left in current layer
                    layer.offerFirst(cur.val);
                }
                nodes.offerFirst(cur.left);
                depths.offerFirst(depth + 1);
                nodes.offerFirst(cur.right);
                depths.offerFirst(depth + 1);
            }
            if (!depths.isEmpty() && depths.peekLast() != depth) {
                out.add(layer);
                layer = new LinkedList<Integer>();
            }
        }
        return out;        
    }
}
