class Solution {
    public String longestPalindrome(String s) {
        // s is empty or single-character
        if (s.length() < 2) return s;
        int longestPalLen = 1;
        int startingIndex = 0;
        int j, tmp;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - longestPalLen / 2; i++) {
            // odd length
            for (j = 0; i - j >= 0 && i + j < arr.length && arr[i - j] == arr[i + j]; j++) {
                tmp = j * 2 + 1;
                if (longestPalLen < tmp) {
                    longestPalLen = tmp;
                    startingIndex = i - j;
                }
            }
            // even length
            for (j = 0; i - j >= 0 && i + j + 1 < arr.length && arr[i - j] == arr[i + j + 1]; j++) {
                tmp = j * 2 + 2;
                if (longestPalLen < tmp) {
                    longestPalLen = tmp;
                    startingIndex = i - j;
                }
            }
        }
        return s.substring(startingIndex, startingIndex + longestPalLen);
    }
}
