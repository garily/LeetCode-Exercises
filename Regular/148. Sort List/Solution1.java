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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode cur = head;
        while (cur != null) {
            pq.offer(cur);
            cur = cur.next;
        }
        ListNode sortedHead = pq.poll();
        cur = sortedHead;
        while (cur != null) {
            ListNode tmp = pq.poll();
            cur.next = tmp;
            cur = tmp;
        }
        return sortedHead;
    }
}
