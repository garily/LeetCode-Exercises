class LFUCache {
    private final int CAP;
    // <key, val>
    private Map<Integer, Integer> keyVal;
    // <key, freq>
    private Map<Integer, Integer> keyFreq;
    // <freq, <key>>
    private Map<Integer, Set<Integer>> freqKeys;
    
    private int leastFreq = 0;

    public LFUCache(int capacity) {
        CAP = capacity;
        keyVal = new HashMap();
        keyFreq = new HashMap();
        freqKeys = new HashMap();
    }
    
    public int get(int key) {
        if (keyVal.containsKey(key)) { 
            int freq = keyFreq.get(key);
            keyFreq.put(key, keyFreq.get(key) + 1);
            Set<Integer> prevFreqKeys = freqKeys.get(freq);
            prevFreqKeys.remove(key);
            Set<Integer> curFreqKeys = freqKeys.getOrDefault(freq + 1, new LinkedHashSet<Integer>());
            curFreqKeys.add(key);
            freqKeys.put(freq + 1, curFreqKeys);
            if (freq == leastFreq && prevFreqKeys.size() == 0) leastFreq++;
            return keyVal.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int val) {
        if (CAP == 0) return;
        if (keyVal.containsKey(key)) {
            // no need to worry about eviction
            get(key);
            keyVal.put(key, val);
        }
        else {
            // adds key to freq map
            if (keyVal.size() == CAP) {
                Set<Integer> leastFreqKeys = freqKeys.get(leastFreq);
                Iterator<Integer> it = leastFreqKeys.iterator();
                int leastFreqKey = it.next();
                keyVal.remove(leastFreqKey);
                keyFreq.remove(leastFreqKey);
                it.remove();
            }
            leastFreq = 1;
            Set<Integer> leastFreqKeys = freqKeys.getOrDefault(1, new LinkedHashSet<Integer>());
            leastFreqKeys.add(key);
            freqKeys.put(1, leastFreqKeys);
            keyVal.put(key, val);
            keyFreq.put(key, 1);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
