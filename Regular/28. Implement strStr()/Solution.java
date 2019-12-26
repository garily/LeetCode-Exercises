class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) throw new NullPointerException();
        if (needle.length() == 0) return 0;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int index = -1;
        for (int i = 0; i + n.length <= h.length && index < 0; i++) {
            int j = 0;
            while (j < n.length) {
                if (h[i + j] == n[j]) j++;
                else break;
            }
            if (j == n.length) index = i;
        }
        return index;
    }
}
