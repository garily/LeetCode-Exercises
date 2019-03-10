/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = (p, q) => {
    let strP = "-" + dlr(p); // avoid falsey comparison
    let strQ = "-" + dlr(q); // avoid falsey comparison
    return strP == strQ;
};

/**
 * @param {TreeNode} node
 * @param {string} str
 * @return {undefined}
 */
var dlr = (node, obj) => {
    str = "";
    if (!node || node.val === null) return "d";
    else str += node.val;
    if (!!node.left) str += dlr(node.left);
    else str += "l";
    if (!!node.right) str += dlr(node.right);
    else str += "r";
    return str;
}
