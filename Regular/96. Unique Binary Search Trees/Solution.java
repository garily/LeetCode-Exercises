class Solution {
    public int numTrees(int n) {
        if (n < 2) return 1;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int mid = i / 2;
            for (int j = 1; j <= mid; j++) {
                dp[i] += 2 * dp[j - 1] * dp[i - j];
            }
            if (i % 2 == 1) dp[i] += dp[mid] * dp[mid];
        }
        return dp[n];
    }
}
