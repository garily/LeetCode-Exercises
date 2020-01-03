/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int n = 0;
        ListNode h1 = head;
        while (h1 != null) {
            n++;
            h1 = h1.next;
        }
        if (n == 1) return true;
        h1 = head;
        ListNode h2 = h1.next;
        ListNode tmp = null;
        h1.next = null;
        int i = 1;
        while (i < n / 2) {
            tmp = h1;
            h1 = h2;
            h2 = h2.next;
            h1.next = tmp;
            i++;
        }
        if (n % 2 == 1) h2 = h2.next;
        while (h1 != null && h2 != null) {
            if (h1.val == h2.val) {
                h1 = h1.next;
                h2 = h2.next;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
