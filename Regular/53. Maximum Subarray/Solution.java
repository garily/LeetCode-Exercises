class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
            max = Math.max(max, dp[i + 1]);
        }
        return max;
    }
}
