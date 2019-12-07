class Solution2 {
    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n < 4) return n;
        if (n % 8 == 7) return 4;
        int upperBound = (int) Math.sqrt(n);
        if (upperBound * upperBound == n) return 1;
        int lowerBound = (int) Math.sqrt(n / 3);
        for (int i = lowerBound; i <= upperBound; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) return 2;
        }
        return 3;
    }
}
