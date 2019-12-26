class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int maxReach = 0;
        int i = 0;
        while (i < nums.length && i <= maxReach) {
            if (maxReach < i + nums[i]) maxReach = i + nums[i];
            i++;
        }
        return maxReach >= nums.length - 1;
    }
}
