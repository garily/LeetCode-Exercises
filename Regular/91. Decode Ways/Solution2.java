// Dynamic Programming: dp array size == sLen + 1
class Solution {
    public int numDecodings(String s) {
        int sLen = s.length();
        if (sLen < 1) return 0;
        char[] arr = s.toCharArray();
        int[] dp = new int[sLen + 1];
        int tmp;
        if (arr[0] < '1') return 0; // arr[0] == '0'
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < sLen + 1; i++) {
            if (arr[i - 1] > '0') dp[i] = dp[i - 1];
            tmp = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
            if (tmp < 27 && tmp > 9) dp[i] += dp[i - 2];
        }
        return dp[sLen];
    }
}
