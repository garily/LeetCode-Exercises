class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        char[] first = strs[0].toCharArray();
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < first.length && first[j] >= 'a' && j < strs[i].length();) {
                if (strs[i].charAt(j) == first[j]) j++;
                else {
                    first[j] = 'a' - 1;
                }
            }
            if (j < first.length) first[j] = 'a' - 1;
        }
        String out = "";
        for (int i = 0; i < first.length && first[i] >= 'a'; i++) out += first[i];
        return out;
    }
}
