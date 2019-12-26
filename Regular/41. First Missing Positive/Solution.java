class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        boolean[] slot = new boolean[nums.length + 1];
        for (int num : nums) if (num < slot.length && num > 0) slot[num] = true;
        for (int i = 1; i < slot.length; i++) if (!slot[i]) return i;
        return slot.length;
    }
}
