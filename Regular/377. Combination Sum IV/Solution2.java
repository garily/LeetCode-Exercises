class Solution2 {//dp
    public int combinationSum4(int[] nums, int target) {
        int count = 0;
        int dp[] = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j < target + 1 && j < (i + 1 < nums.length ? nums[i + 1] : Integer.MAX_VALUE); j++) {
                for (int k = 0; k <= i; k++)
                    dp[j] += dp[j - nums[k]];
            }
        }
        return dp[target];
    }
}
