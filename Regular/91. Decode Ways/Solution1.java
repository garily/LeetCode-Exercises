// Recursion
class Solution {
    public int numDecodings(String s) {
        if (s.length() < 1) return 0;
        char[] arr = s.toCharArray();
        return numDecodings(arr, 0);// + numDecodings(arr, 1);
    }
    
    private int numDecodings(char[] arr, int idx) {
        if (idx > arr.length) return 0;
        if (idx == arr.length) return 1;
        if (arr[idx] == '0') return 0;
        if (idx == arr.length - 1) return 1;
        if (arr[idx] == '1') {
            if (arr[idx + 1] > '0') return numDecodings(arr, idx + 1) + numDecodings(arr, idx + 2);
            return numDecodings(arr, idx + 2);
        }
        if (arr[idx] == '2') {
            if (arr[idx + 1] > '0' && arr[idx + 1] < '7') return numDecodings(arr, idx + 1) + numDecodings(arr, idx + 2);
            if (arr[idx + 1] == '0') return numDecodings(arr, idx + 2);
        }
        return numDecodings(arr, idx + 1);
    }
}
