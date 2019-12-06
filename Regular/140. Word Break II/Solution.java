class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> out = new ArrayList<>();
        if (s.length() == 0 || wordDict.size() == 0) return out;
        int sLen = s.length();
        boolean dp[][] = new boolean[sLen + 1][sLen + 1];
        dp[0][0] = true;
        for (int startIdx = 0; startIdx < sLen; startIdx++) {
            if (!dp[startIdx][startIdx]) continue;
            for (int endIdx = startIdx + 1; endIdx <= sLen; endIdx++) {
                for (String word : wordDict) {
                    if (s.startsWith(word, startIdx)) {
                        int wordLen = word.length();
                        dp[startIdx][startIdx + wordLen] = true;
                        dp[startIdx + wordLen][startIdx + wordLen] = true;
                    }
                }
            }
        }
        // dfs
        dfs(s, out, dp, "", sLen);
        return out;
    }
    
    void dfs(String s, List<String> out, boolean[][] dp, String tmp, int endIdx) {
        if (endIdx == 0) out.add(tmp.trim());
        for (int i = endIdx - 1; i >= 0; i--) {
            if (!dp[i][endIdx]) continue;
            dfs(s, out, dp, s.substring(i, endIdx) + " " + tmp, i);
        }
    }
}
