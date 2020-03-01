/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode p1 = l1, p2 = l2;
        Stack<ListNode> s1 = new Stack(), s2 = new Stack();
        while (p1 != null) {
            s1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2);
            p2 = p2.next;
        }
        boolean carry = false;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            p1 = s1.pop();
            p2 = s2.pop();
            int cur = p1.val + p2.val + (carry ? 1 : 0);
            carry = cur > 9;
            p1.val = cur % 10;
            p2.val = cur % 10;
        }
        if (s1.isEmpty() && s2.isEmpty()) {
            if (carry) {
                p1 = new ListNode(1);
                p1.next = l1;
                return p1;
            }
            else return l1;
        }
        else if (s1.isEmpty()) {
            while (carry && !s2.isEmpty()) {
                p2 = s2.pop();
                int cur = p2.val + 1;
                carry = cur > 9;
                p2.val = cur % 10;
            }
            if (carry) {
                p2 = new ListNode(1);
                p2.next = l2;
                return p2;
            }
            else return l2;
        }
        else { // s2.isEmpty()
            while (carry && !s1.isEmpty()) {
                p1 = s1.pop();
                int cur = p1.val + 1;
                carry = cur > 9;
                p1.val = cur % 10;
            }
            if (carry) {
                p1 = new ListNode(1);
                p1.next = l1;
                return p1;
            }
            else return l1;
        }
    }
}
