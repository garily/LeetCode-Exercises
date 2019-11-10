class Solution {
    public boolean isMatch(String s, String p) {
        char[] sa = s.toCharArray(), pa = p.toCharArray();
        boolean[][] dp = new boolean[sa.length + 1][pa.length + 1];
        dp[0][0] = true;
        for (int pi = 0; pi < pa.length; pi++) {
            if (pa[pi] == '*') dp[0][pi + 1] = true;
            else break;
        }
        for (int si = 0; si < sa.length; si++) {
            for (int pi = 0; pi < pa.length; pi++) {
                if (pa[pi] == '?' || pa[pi] == sa[si]) dp[si + 1][pi + 1] = dp[si][pi];
                else if (pa[pi] == '*') dp[si + 1][pi + 1] = dp[si][pi + 1] || dp[si + 1][pi];
            }
        }
        return dp[sa.length][pa.length];
    }
}
