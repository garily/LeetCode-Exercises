class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int sum = 0;
        for (int num : target) {
            sum += num;
            pq.offer(num);
        }
        while (pq.peek() > 1) {
            int cur = pq.poll();
            
            sum -= cur;
            if (sum > 1 && cur > sum) cur %= sum;
            else cur -= sum;
            sum += cur;
            if (cur < 1 || sum < 1) return false;
            pq.offer(cur);
        }
        return true;
    }
}
