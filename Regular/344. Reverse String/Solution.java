class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int halfLen = (len + 1) / 2;
        for (int i = 0; i < halfLen; i++) {
            char ch = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = ch;
        }
    }
}
