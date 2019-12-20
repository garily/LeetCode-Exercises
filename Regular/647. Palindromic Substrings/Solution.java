class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 2) return s.length();
        int out = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            out++;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                out++;
            }
        }
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i + len) && dp[i + 1][i + len - 1]) {
                    dp[i][i + len] = true;
                    out++;
                }
            }
        }
        return out;
    }
}
