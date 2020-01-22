class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        int head = 0;
        int tail = 0;
        boolean newChunk = true;
        for (int num : nums) set.add(num);
        for (int num : nums) {
            if (!set.remove(num)) continue; // used
            head = num;
            tail = num;
            newChunk = false;
            while (!newChunk) {
                if (set.remove(head - 1)) {
                    head--;
                }
                else if (set.remove(tail + 1)) {
                    tail++;
                }
                else {
                    maxLen = Math.max(maxLen, tail - head + 1);
                    newChunk = true;
                }
            }
        }
        return maxLen;
    }
}
