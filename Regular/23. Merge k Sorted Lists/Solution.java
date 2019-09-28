/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // edge cases
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        ListNode head = null, tail = null;
        int smallestIdx = getSmallestIndex(lists);
        while (smallestIdx != -1) {
            if (head == null) {
                head = lists[smallestIdx];
                tail = head;
            }
            else {
                tail.next = lists[smallestIdx];
                tail = tail.next;
            }
            lists[smallestIdx] = lists[smallestIdx].next;
            smallestIdx = getSmallestIndex(lists);
        }
        return head;
    }
    
    private int getSmallestIndex(ListNode[] lists) {
        int smallestIdx = -1, smallestVal = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (lists[i].val <= smallestVal) {
                smallestVal = lists[i].val;
                smallestIdx = i;
            }
        }
        return smallestIdx;
    }
}
