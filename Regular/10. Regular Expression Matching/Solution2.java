class Solution {
    public boolean isMatch(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        return isMatch(arrS, arrP, 0, 0);
    }
    
    private boolean isMatch(char[] s, char[] p, int sIndex, int pIndex) {
        if (pIndex == p.length) return sIndex == s.length;
        boolean firstMatch = sIndex < s.length && p[pIndex] == s[sIndex] || p[pIndex] == '.';
        if (pIndex + 1 < p.length && p[pIndex + 1] == '*') {
            return (firstMatch && (sIndex < s.length) && isMatch(s, p, sIndex + 1, pIndex)) || isMatch(s, p, sIndex, pIndex + 2);
        }
        else {
            return firstMatch && isMatch(s, p, sIndex + 1, pIndex + 1);
        }
    }
}
