/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return isSubPath(head, root, true) || isSubPath(head, root, false);
    }
    
    private boolean isSubPath(ListNode head, TreeNode root, boolean canStart) {
        if (head == null) return true;
        if (root == null) return false;
        return (head.val == root.val && (isSubPath(head.next, root.left, false) || isSubPath(head.next, root.right, false))) || (canStart && (isSubPath(head, root.left, true) || isSubPath(head, root.right, true)));
    }
}
