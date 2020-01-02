/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int aLen = 0, bLen = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            aLen++;
            curA = curA.next;
        }
        while (curB != null) {
            bLen++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (aLen > bLen) {
            while (aLen > bLen) {
                curA = curA.next;
                aLen--;
            }
        }
        else if (bLen > aLen) {
            while (bLen > aLen) {
                curB = curB.next;
                bLen--;
            }
        }
        while (curA != curB && curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
