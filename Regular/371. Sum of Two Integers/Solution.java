class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int fence = 1;
        int ai, bi;
        int out = 0;
        boolean carry = false;
        fence = 1;
        for (int i = 0; i < 32; i++) {
            ai = fence & a;
            bi = fence & b;
            if ((ai & bi) == fence) {
                if (carry) out |= fence;
                carry = true;
            }
            else if ((ai | bi) == fence) {
                if (!carry) {
                    out |= fence;
                } // otherwise carry is true, and this digit of out should be 0
            }
            else {
                if (carry) {
                    out |= fence;
                    carry = false;
                }
            }
            fence <<= 1;
        }
        return out;
    }
}
