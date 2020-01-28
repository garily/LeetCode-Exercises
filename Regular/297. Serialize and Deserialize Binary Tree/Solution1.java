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
        String[] out = new String[] {""};
        preTraverse(root, out);
        return out[0];        
    }
    
    private void preTraverse(TreeNode root, String[] out) {
        out[0] += "(";
        if (root != null) {
            out[0] += root.val;
            preTraverse(root.left, out);
            preTraverse(root.right, out);
        }
        out[0] += ")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("()")) return null;
        return buildTree(data, 0, data.length());
    }
    
    private TreeNode buildTree(String string, int start, int end) {
        if (start == string.length() || start >= end - 2) return null;
        int i = start + 1;
        while (i < string.length() && string.charAt(i) != ')' && string.charAt(i) != '(') i++;
        TreeNode root = new TreeNode(Integer.valueOf(string.substring(start + 1, i)));
        int j = i + 1;
        int open = 1;
        while (j < string.length()) {
            if (string.charAt(j) == '(') open++;
            else if (string.charAt(j) == ')') open--;
            if (open == 0) break;
            j++;
        }
        root.left = buildTree(string, i, j);
        root.right = buildTree(string, j + 1, end - 1);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
