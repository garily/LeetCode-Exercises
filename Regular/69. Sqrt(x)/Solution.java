class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = 46341;
        int mid = (low + high) / 2;
        while (low < high - 1) {
            int tmp = mid * mid;
            if (tmp > x) {
                high = mid;
                mid = (low + high) / 2;
            }
            else if (tmp == x) {
                return mid;
            }
            else {
                low = mid;
                mid = (low + high) / 2;
            }
        }
        return mid;
    }
}
