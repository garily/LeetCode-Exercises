class Solution {
    public int titleToNumber(String s) {
        int out = 0;
        for (int i = 0; i < s.length(); i++) out = 26 * out + (s.charAt(i) - 'A' + 1);
        return out;
    }
}
