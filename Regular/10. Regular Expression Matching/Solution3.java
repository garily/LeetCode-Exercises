class Solution {
    public boolean isMatch(String s, String p) {
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        boolean[][] visited = new boolean[S.length + 1][P.length + 1];
        boolean[][] dp = new boolean[S.length + 1][P.length + 1];
        return isMatch(S, P, 0, 0, visited, dp);
    }
    
    private boolean isMatch(char[] s, char[] p, int sIndex, int pIndex, boolean[][] visited, boolean[][] dp) {
        if (sIndex > s.length || pIndex > p.length) return false;
        if (visited[sIndex][pIndex]) return dp[sIndex][pIndex];
        boolean result = false;
        if (pIndex == p.length) result = sIndex == s.length;
        else {
            boolean firstMatch = sIndex < s.length && p[pIndex] == s[sIndex] || p[pIndex] == '.';
            if (pIndex + 1 < p.length && p[pIndex + 1] == '*') {
                result = (isMatch(s, p, sIndex, pIndex + 2, visited, dp)) || firstMatch && sIndex < s.length && isMatch(s, p, sIndex + 1, pIndex, visited, dp); 
            }
            else { // pIndex + 1 == p.length
                result = firstMatch && isMatch(s, p, sIndex + 1, pIndex + 1, visited, dp);
            }
        }
        visited[sIndex][pIndex] = true;
        dp[sIndex][pIndex] = result;
        return result;
    }
}
