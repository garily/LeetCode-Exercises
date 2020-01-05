class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || k > s.length()) return 0;
        if (k <= 1) return s.length();
        return longestSubstring(s, k, 0, s.length());        
    }
    
    private int longestSubstring(String s, int k, int start, int end) {
        if (start >= end) return 0;
        int alphaCount[] = new int[26];
        boolean valid = true;
        int out = 0;
        int prevStart = start;
        for (int i = start; i < end; i++) {
            alphaCount[s.charAt(i) - 'a']++;
        }
        for (int i = start; i < end; i++) {
            if (alphaCount[s.charAt(i) - 'a'] > 0 && alphaCount[s.charAt(i) - 'a'] < k) {
                valid = false;
                out = Math.max(out, longestSubstring(s, k, prevStart, i));
                prevStart = i + 1;
            }
        }
        if (!valid) return Math.max(out, longestSubstring(s, k, prevStart, end));
        return end - start;
    }
}
