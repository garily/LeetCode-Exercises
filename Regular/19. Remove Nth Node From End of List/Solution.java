/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode begin = new ListNode(0);
        begin.next = head;
        Deque<ListNode> queue = new LinkedList<>();
        queue.offer(begin);
        while (head != null) {
            queue.offer(head);
            if (queue.size() > n + 1) queue.poll();
            head = head.next;
        }
        head = queue.poll();
        if (head.next != null) head.next = head.next.next;
        return begin.next;
    }
}
