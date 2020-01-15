class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0 || digits[0] == 0) return new int[] {1};
        boolean extra = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (extra) {
                digits[i]++;
                extra = false;
            }
            if (digits[i] >= 10) {
                digits[i] %= 10;
                extra = true;
            }
        }
        if (!extra) return digits;
        else {
            int[] out = new int[digits.length + 1];
            out[0] = 1;
            for (int i = 0; i < digits.length; i++) out[i + 1] = digits[i];
            return out;
        }
    }
}
