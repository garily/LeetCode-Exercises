/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        List<Node> org = new ArrayList<>();
        while (cur != null) {
            org.add(cur);
            cur = cur.next;
        }
        Node[] nodes = new Node[org.size()];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(org.get(i).val);
        }
        for (int i = 0; i < nodes.length; i++) {
            if (i < nodes.length - 1) nodes[i].next = nodes[i + 1];
            int randomIndex = org.indexOf(org.get(i).random);
            if (randomIndex >= 0) nodes[i].random = nodes[randomIndex];
        }
        return nodes[0];
    }
             
}
