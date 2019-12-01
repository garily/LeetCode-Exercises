class LRUCache {
    private class Node { // node for a doubly linked list
        public Node prev;
        public Node next;
        public Integer key;
        public Integer val;
        public Node(Node prev, Node next, Integer key, Integer val) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }
    
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(null, null, null, null);
        tail = new Node(head, null, null, null);
        head.next = tail;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        // System.out.println("get " + key + ", rightMost == null: " + (rightMost == null));
        Node temp = cache.get(key);
        if (temp == null) return -1;
        if (temp != tail.prev) {
            // move temp to the end of the doubly linked list
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.prev = tail.prev;
            tail.prev.next = temp;
            temp.next = tail;
            tail.prev = temp;
        }
        return temp.val;
    }
    
    public void put(int key, int value) {
        if (get(key) == -1) { // key does not exist
            Node temp;
            if (cache.size() == 0) {
                temp = new Node(head, tail, key, value);
                head.next = temp;
                tail.prev = temp;
            }
            else {
                temp = new Node(tail.prev, tail, key, value);
                tail.prev.next = temp;
                tail.prev = temp;
            }
            cache.put(key, temp);
            while (cache.size() > capacity) {
                cache.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
        }
        else {
            tail.prev.val = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
