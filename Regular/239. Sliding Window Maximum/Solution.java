class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] out = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) pq.offer(nums[i]);
        for (int i = k - 1; i < nums.length; i++) {
            pq.offer(nums[i]);
            out[i - k + 1] = pq.peek();
            pq.remove(nums[i - k + 1]);
        }
        return out;
    }
}
