class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < n; i++) {
            if (i % 2 == 0) continue;
            int root = (int) Math.sqrt(i);
            boolean isPrime = true;
            for (int j = 1; j < primes.size() && primes.get(j) <= root && isPrime; j++) {
                if (i % primes.get(j) == 0) isPrime = false;
            }
            if (isPrime) primes.add(i);
        }
        return primes.size();
    }
}
