class Solution {
    public int numSquares(int n) {
        if (n < 0) return 0;
        if (n < 4) return n;
        int[] minNum = new int[n + 1];
        minNum[0] = 0;
        minNum[1] = 1;
        minNum[2] = 2;
        minNum[3] = 3;
        for (int i = 4; i <= n; i++) {
            minNum[i] = Integer.MAX_VALUE;
            for (int j = (int) Math.sqrt(i / 3); j * j <= i; j++) {
                minNum[i] = Math.min(minNum[i], minNum[i - j * j] + 1);
            }
        }
        return minNum[n];
    }
}
