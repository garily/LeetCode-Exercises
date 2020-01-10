/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) return root;
        Deque<Node> nodes = new LinkedList<Node>();
        Deque<Integer> depths = new LinkedList<Integer>();
        nodes.offer(root);
        depths.offer(0);
        Node prev = root;
        int prevDepth = -1;
        while (!nodes.isEmpty()) {
            Node cur = nodes.poll();
            int depth = depths.poll();
            if (depth == prevDepth) prev.next = cur;
            prev = cur;
            prevDepth = depth;
            if (cur.left != null) {
                nodes.offer(cur.left);
                depths.offer(depth + 1);
                nodes.offer(cur.right);
                depths.offer(depth + 1);
            }
        }
        return root;
        
    }
}
