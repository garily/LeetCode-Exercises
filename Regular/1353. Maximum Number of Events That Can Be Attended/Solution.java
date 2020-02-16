class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue();
        int eventIdx = 0;
        int out = 0;
        for (int day = 1; day <= 100000; day++) {
            while (eventIdx < events.length && events[eventIdx][0] == day) {
                pq.offer(events[eventIdx][1]);
                eventIdx++;
            }
            while (!pq.isEmpty()) {
                int end = pq.poll();
                if (end < day) continue;
                out++;
                break;
            }
        }
        return out;
    }
}
