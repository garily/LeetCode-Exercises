class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        TreeNode[] nodes = new TreeNode[n + 1];
        nodes[1] = new TreeNode(1);
        for (int i = 0; i < edges.length; i++) {
            if (nodes[edges[i][0]] == null) {
                nodes[edges[i][0]] = new TreeNode(edges[i][0]);
            }
            if (nodes[edges[i][1]] == null) {
                nodes[edges[i][1]] = new TreeNode(edges[i][1]);
            }
            TreeNode node1 = nodes[edges[i][0]];
            TreeNode node2 = nodes[edges[i][1]];
            node1.nexts.add(node2);
            node2.nexts.add(node1);
        }
        Stack<TreeNode> stack = new Stack<>();
        dfs(nodes[1], target, stack); // make single dir
        // System.out.println(stack.size());
        int pathLen = stack.size() - 1;
        if (pathLen > t) return 0;
        double prob = 1.0;
        while (stack.size() > 1) {
            // System.out.println(stack.peek().id);
            prob /= stack.pop().nexts.size();
        }
        if (!stack.peek().nexts.isEmpty() && pathLen < t) return 0;
        return prob;
    }
    
    private boolean dfs(TreeNode root, int target, Stack<TreeNode> path) {
        if (root == null) return false;
        boolean out = false;
        for (TreeNode next : root.nexts) {
            next.nexts.remove(root);
            if (dfs(next, target, path)) {
                path.push(root);
                out = true;
            }
        }
        if (root.id == target) {
            path.push(root);
            out = true;
        }
        return out;
    }
    
    private class TreeNode {
        int id;
        Set<TreeNode> nexts;
        public TreeNode(int id) {
            this.id = id;
            nexts = new HashSet<>();
        }
    }
}
