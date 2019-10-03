/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> stack;
    private Set<TreeNode> iterated = new HashSet<>();
    private TreeNode curRoot;

    public BSTIterator(TreeNode root) {
        curRoot = root;
        stack = new Stack<>();
    }
    
    /** @return the next smallest number */
    public int next() {
        while (curRoot != null && !iterated.contains(curRoot)) {
            stack.push(curRoot);
            curRoot = curRoot.left;
        }
        curRoot = stack.pop();
        iterated.add(curRoot);
        int out = curRoot.val;
        // System.out.println("out: " + out);
        curRoot = curRoot.right;
        return out;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curRoot != null || !stack.empty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
