public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int out = 0;
        for (int i = 0; i < 31; i++) {
            out |= n & 0x1;
            n >>= 1;
            out <<= 1;
        }
        out |= n & 0x1;
        return out;
    }
}
