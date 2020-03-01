class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(i);
        }
        int[] out = new int[nums.length];
        int count = 0;
        int prevIdx = -1;
        while (!pq.isEmpty()) {
            int idx = pq.poll();
            if (prevIdx == -1) out[idx] = 0;
            else if (nums[prevIdx] == nums[idx]) out[idx] = out[prevIdx];
            else out[idx] = count;
            prevIdx = idx;
            count++;
        }
        return out;
    }
}
