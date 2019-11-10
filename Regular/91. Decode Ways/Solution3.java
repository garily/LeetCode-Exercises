// Dynamic programming: dp array size is 3 (fixed)
class Solution {
    public int numDecodings(String s) {
        int sLen = s.length();
        if (sLen < 1) return 0;
        char[] arr = s.toCharArray();
        int[] dp = new int[3];
        int tmp;
        if (arr[0] < '1') return 0; // arr[0] == '0'
        if (sLen < 2) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < sLen + 1; i++) {
            dp[2] = 0;
            if (arr[i - 1] > '0') dp[2] = dp[1];
            // System.out.println(dp[2]);
            tmp = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
            if (tmp < 27 && tmp > 9) dp[2] += dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
