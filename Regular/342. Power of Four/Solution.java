class Solution {
    public boolean isPowerOfFour(int num) {
        if (num < 0) return false;
        int digit = 1;
        while (digit > 0) {
            if (digit == num) return true;
            digit <<= 2;
        }
        return false;
    }
}
