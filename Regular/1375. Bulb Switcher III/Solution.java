class Solution {
    public int numTimesAllBlue(int[] light) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max heap
        for (int i = 0; i < light.length; i++) {
            pq.offer(light[i]);
            if (pq.peek() == i + 1) count++;
        }
        return count;
    }
}
