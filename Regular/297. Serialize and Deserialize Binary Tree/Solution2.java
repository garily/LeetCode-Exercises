/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder out = new StringBuilder();
        preTraverse(root, out);
        return out.toString();        
    }
    
    private void preTraverse(TreeNode root, StringBuilder out) {
        if (root == null) out.append("#,");
        else {
            out.append(root.val + ",");
            preTraverse(root.left, out);
            preTraverse(root.right, out);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("()")) return null;
        Queue<String> queue = new LinkedList<String>();
        Collections.addAll(queue, data.split(","));
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode cur = new TreeNode(Integer.valueOf(s));
        cur.left = buildTree(queue);
        cur.right = buildTree(queue);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
