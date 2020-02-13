class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap();
        for (int num : nums) freqs.put(num, freqs.getOrDefault(num, 0) + 1); // O(N)
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> freqs.get(b) - freqs.get(a));
        for (int freq : freqs.keySet()) pq.offer(freq); // O(M * log (M)) where M is the number of unique elements
        List<Integer> out = new LinkedList();
        while (k-- > 0) out.add(pq.poll());
        return out;
    }
}
