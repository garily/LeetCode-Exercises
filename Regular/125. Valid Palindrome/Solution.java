class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;
        char[] arr = s.toLowerCase().toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (i < j && !isAN(arr[i])) i++;
            while (i < j && !isAN(arr[j])) j--;
            if (i == j) break;
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    
    private boolean isAN(char c) { // isAlphanumeric
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
