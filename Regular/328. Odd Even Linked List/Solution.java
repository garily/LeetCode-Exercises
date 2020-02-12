/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode odd = head;
        ListNode even = second;
        while (odd.next != null && even.next != null) {
            if (odd.next == even) {
                odd.next = even.next;
                odd = odd.next;
            }
            else if (even.next == odd) {
                even.next = odd.next;
                even = even.next;
            }
        }
        if (odd.next == null && even.next != null) even.next = null;
        odd.next = second;
        return head;
    }
}
