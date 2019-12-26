class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i; j * i < n; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
        int out = 0;
        for (int i = 2; i < n; i++) if (isPrime[i]) out++;
        return out;
    }
}
