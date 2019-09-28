/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        //edge cases
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        ListNode head = null, tail = null, top = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (ListNode a, ListNode b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) queue.offer(lists[i]);
        }
        head = new ListNode(0);
        tail = head;
        while(queue.size() > 0) {
            top = queue.poll();
            tail.next = top;
            tail = tail.next;
            if (top.next != null) queue.offer(top.next);
        }
        return head.next;
    }
}
