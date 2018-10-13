class Solution {
    public int reverse(int x) {
        long y = 0;
        
        for (; x != 0; x /= 10) {
            y = y * 10  + x % 10;
        }
        
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) return 0;
        return (int) y;
    }
}
