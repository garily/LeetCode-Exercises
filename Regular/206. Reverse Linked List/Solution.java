/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode tail = head;
        ListNode next = tail.next;
        head.next = null;
        while (next != null) {
            ListNode mid = next;
            next = next.next;
            mid.next = tail;
            tail = mid;
        }
        return tail;
    }
}
