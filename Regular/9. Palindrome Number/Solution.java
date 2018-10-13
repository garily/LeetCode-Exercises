class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
        int digits = (int) Math.log10(x);
        int end = 1;
        while (digits >= end) {
            int l = (x / pow10(digits)) % 10;
            int r = x % pow10(end) / pow10(end - 1);
            if (l == r) {
                digits --;
                end++;
            }
            else return false;
        }
        return true;
    }
    
    int pow10(int a) {
        return (int) Math.pow(10, a);
    }
}
