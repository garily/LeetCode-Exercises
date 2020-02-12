class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) pq.offer(num);
        int out = 0;
        while (k > 0) {
            out = pq.poll();
            k--;
        }
        return out;
    }
}
