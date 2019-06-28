/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */
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
    public List<Integer> rightSideView(TreeNode root) {
        // <depth, node.val>
        Map<Integer, Integer> rightMostAtDepth = new HashMap<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> depths = new LinkedList<>();

        List<Integer> out = new LinkedList<>();

        nodes.add(root);
        depths.add(0);

        // bfs (queue-based)
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            int depth = depths.remove();

            if (node != null) {
                rightMostAtDepth.put(depth, node.val);
                nodes.add(node.left);
                depths.add(depth + 1);
                nodes.add(node.right);
                depths.add(depth + 1);
            }
        }

        for (int depth = 0; depth < rightMostAtDepth.size(); depth++) {
            out.add(rightMostAtDepth.get(depth));
        }

        return out;
    }
}


