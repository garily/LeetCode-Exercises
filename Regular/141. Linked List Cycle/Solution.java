/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode end = new ListNode(0);
        ListNode prev = null, cur = head;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
            prev.next = end;
        }
        return cur == end;
    }
}
