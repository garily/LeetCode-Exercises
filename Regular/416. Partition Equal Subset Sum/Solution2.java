class Solution2 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[1 + target];
        dp[target] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[j - nums[i]] = dp[j - nums[i]] || dp[j];
            }
        }
        return dp[0];
    }
}
