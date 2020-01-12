class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] out = new int[] {1, n - 1};
        while (out[0] <= out[1] && (hasZero(out[0]) || hasZero(out[1]))) {
            out[0]++;
            out[1]--;
        }
        return out;
    }
    private boolean hasZero(int k) {
        return String.valueOf(k).indexOf('0') >= 0;
    }
}
