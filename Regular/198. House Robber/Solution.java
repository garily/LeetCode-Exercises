class Solution {
    public int rob(int[] nums) {
        // dp[i]: max profit if nums[i] is taken
        int nLen = nums.length;
        if (nLen == 0) return 0;
        if (nLen == 1) return nums[0];
        int[] dp = new int[nLen];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nLen; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nLen - 1];
    }
}
