class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long speedSum = 0;
        long mod = 1000000007;
        long maxPerf = 0;
        PriorityQueue<Integer> fastests = new PriorityQueue<Integer>((a, b) -> speed[a] - speed[b]);
        PriorityQueue<Integer> mostEffs = new PriorityQueue<Integer>((a, b) -> efficiency[b] - efficiency[a]);
        
        for (int i = 0; i < n; i++) {
            mostEffs.offer(i);
        }
        
        while (!mostEffs.isEmpty()) {
            int cur = mostEffs.poll();
            speedSum += speed[cur];
            fastests.offer(cur);
            while (fastests.size() > k) {
                speedSum -= speed[fastests.poll()];
            }
            maxPerf = Math.max(maxPerf, (long) efficiency[cur] * speedSum);
        }
        return (int) (maxPerf % mod);
    }
}
