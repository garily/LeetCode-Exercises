class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        for (int key : map.keySet()) {
            pq.offer(key);
        }
        int size = 0;
        int out = 0;
        while (arr.length - size > size) {
            // System.out.println(pq.peek());
            
            size += map.get(pq.poll());
            out++;
        }
        return out;
    }
}
