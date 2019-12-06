class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int sLen = s.length();
        boolean[] dp = new boolean[sLen + 1];
        dp[0] = true;
        for (int startIdx = 0; startIdx < sLen; startIdx++) {
            if (!dp[startIdx]) continue;
            for (String word : dict) {
                if (s.startsWith(word, startIdx)) {
                    dp[startIdx + word.length()] = true;
                }
            }
        }
        return dp[sLen];
    }
}
