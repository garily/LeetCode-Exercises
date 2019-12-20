class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int biggestPowerOf2 = 1;
        for (int i = 1; i <= num; i++) {
            if (i >= biggestPowerOf2 * 2) biggestPowerOf2 *= 2;
            dp[i] = 1 + dp[i - biggestPowerOf2];
        }
        return dp;
    }
}
