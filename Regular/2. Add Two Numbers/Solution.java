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
        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Null input!");
        
        ListNode iL1 = l1;
        ListNode iL2 = l2;
        ListNode iLN = new ListNode(0);
        ListNode output = iLN;
        
        for (;iL1 != null || iL2 != null || iLN != null;) {
            if ((iL1 != null && (iL1.val > 9 || iL1.val < 0)) || iL2 != null && (iL2.val > 9 || iL2.val < 0))
                throw new IllegalArgumentException("Digit value not within 0~9!");
            
            
            int valL1 = 0;
            int valL2 = 0;
            
            if (iL1 != null) {
                valL1 = iL1.val;
                iL1 = iL1.next;
            }
            
            if (iL2 != null) {
                valL2 = iL2.val;
                iL2 = iL2.next;
            }
            
            int temp = valL1 + valL2 + iLN.val;
            
            if (temp < 10) {
                iLN.val = temp;
                if ( iL1 == null && iL2 == null)
                    break;
                else
                    iLN.next = new ListNode(0);
            }
            else {
                iLN.val = temp % 10;
                iLN.next = new ListNode(1);
            }
            iLN = iLN.next;
        }
        return output;
    }
        
}
