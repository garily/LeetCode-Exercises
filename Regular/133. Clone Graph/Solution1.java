/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Node clone = new Node(node.val, new ArrayList<Node>());
        Deque<Node> orgQue = new LinkedList();
        Deque<Node> copyQue = new LinkedList();
        Map<Integer, Node> visited = new HashMap();
        orgQue.offer(node);
        copyQue.offer(clone);
        visited.put(clone.val, clone);
        // bfs
        while (!orgQue.isEmpty()) {
            Node org = orgQue.poll();
            Node copy = copyQue.poll();
            for (Node neighbor : org.neighbors) {
                if (visited.containsKey(neighbor.val)) {
                    Node neighborCopy = visited.get(neighbor.val);
                    copy.neighbors.add(neighborCopy);
                }
                else {
                    Node neighborCopy = new Node(neighbor.val, new ArrayList<Node>());
                    copy.neighbors.add(neighborCopy);
                    orgQue.offer(neighbor);
                    copyQue.offer(neighborCopy);
                    visited.put(neighbor.val, neighborCopy);
                }
            }
        }
        return clone;
    }
}
