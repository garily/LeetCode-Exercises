/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {boolean}
 */
var hasPathSum = function(root, sum) {
    if (root != null) {
        let diff = sum - root.val;
        if (root.left == null && root.right == null) return !diff;
        return hasPathSum(root.left, diff) || hasPathSum(root.right, diff);
    }
    return false;
};
