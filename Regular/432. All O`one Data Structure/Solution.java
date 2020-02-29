class AllOne {
    class FreqNode {
        int val; // frequency
        FreqNode next;
        FreqNode prev;
        public FreqNode(int val) {
            this.val = val;
        }
    }
    // <int freq, FreqNode node>
    Map<Integer, FreqNode> freqs;
    // <String key, int freq>
    Map<String, Integer> keyFreq;
    // <int freq, <String keys>>
    Map<Integer, Set<String>> freqKeys;
    FreqNode head, tail;
    /** Initialize your data structure here. */
    public AllOne() {
        freqs = new HashMap();
        keyFreq = new HashMap();
        freqKeys = new HashMap();
        head = new FreqNode(0);
        tail = new FreqNode(0);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        FreqNode prevFreq = head;
        if (keyFreq.containsKey(key)) { // remove given key from its previous freq set
            prevFreq = freqs.get(keyFreq.get(key));
            freqKeys.get(prevFreq.val).remove(key);
        }
        Set<String> newFreqSet = freqKeys.getOrDefault(prevFreq.val + 1, new HashSet());
        newFreqSet.add(key);
        freqKeys.put(prevFreq.val + 1, newFreqSet);
        // maintain doubly-linked list of frequency
        if (freqKeys.get(prevFreq.val + 1).size() == 1) { // current key is the only element with its new frequency, add its corresponding FreqNode after prevFreq
            FreqNode newFreq = freqs.getOrDefault(prevFreq.val + 1, new FreqNode(prevFreq.val + 1));
            newFreq.next = prevFreq.next;
            prevFreq.next.prev = newFreq;
            prevFreq.next = newFreq;
            newFreq.prev = prevFreq;
            freqs.put(prevFreq.val + 1, newFreq); // in case it is a new frequency
        }
        if (prevFreq.val > 0 && freqKeys.get(prevFreq.val).size() == 0) { // no more elements with prevFreq, remove prevFreq from doubly-linked list
            prevFreq.prev.next = prevFreq.next;
            prevFreq.next.prev = prevFreq.prev;
            prevFreq.prev = null;
            prevFreq.next = null;
        }
        keyFreq.put(key, prevFreq.val + 1);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!keyFreq.containsKey(key)) return;
        FreqNode prevFreq = freqs.get(keyFreq.get(key));
        freqKeys.get(prevFreq.val).remove(key);
        if (prevFreq.val == 1) { // remove it
            keyFreq.remove(key);
        }
        else {
            keyFreq.put(key, prevFreq.val - 1);
            freqKeys.get(prevFreq.val - 1).add(key);
        }
        if (prevFreq.val - 1 > 0 && freqKeys.get(prevFreq.val - 1).size() == 1) {
            // current element is the only element with its new frequency, add the corresponding FreqNode to doubly-linked list before prevFreq
            FreqNode newFreq = freqs.get(prevFreq.val - 1);
            newFreq.next = prevFreq;
            newFreq.prev = prevFreq.prev;
            newFreq.prev.next = newFreq;
            prevFreq.prev = newFreq;
        }
        if (freqKeys.get(prevFreq.val).size() == 0) {
            // no more elements with prevFreq.val, remove the corresponding FreqNode from doubly-linked list
            prevFreq.prev.next = prevFreq.next;
            prevFreq.next.prev = prevFreq.prev;
            prevFreq.prev = null;
            prevFreq.next = null;
            
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.prev == head) return "";
        return freqKeys.get(tail.prev.val).iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) return "";
        return freqKeys.get(head.next.val).iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
