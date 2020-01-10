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
        connectLR(root.left, root.right);
        return root;
        
    }
    
    private void connectLR(Node left, Node right) {
        if (left == null || right == null) return;
        left.next = right;
        connectLR(left.left, left.right);
        connectLR(left.right, right.left);
        connectLR(right.left, right.right);
    }
}
