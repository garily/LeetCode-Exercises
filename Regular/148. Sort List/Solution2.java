/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(slow);
        return mergeList(h1, h2);
    }
    
    private ListNode mergeList(ListNode h1, ListNode h2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                cur.next = h2;
                h2 = h2.next;
            }
            else {
                cur.next = h1;
                h1 = h1.next;
            }
            cur = cur.next;
        }
        if (h1 == null) cur.next = h2;
        if (h2 == null) cur.next = h1;
        return head.next;
    }
}
