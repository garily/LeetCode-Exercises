class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int max = 0;
        Map<Integer, Integer> visited = new HashMap();
        Map<Integer, Integer> toVisit = new HashMap();
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for (int[] time : times) {
            Map<Integer, Integer> cur = graph.getOrDefault(time[0], new HashMap());
            cur.put(time[1], Math.min(time[2], cur.getOrDefault(time[1], Integer.MAX_VALUE)));
            graph.put(time[0], cur);
        }
        visited.put(K, 0);
        if (!graph.containsKey(K)) return -1;
        for (Map.Entry<Integer, Integer> fromK : graph.get(K).entrySet()) toVisit.put(fromK.getKey(), fromK.getValue());
        int n = N;
        while (--n > 0 && !toVisit.isEmpty()) { // add one node from `toVisit` to `visited` per loop
            int min = Integer.MAX_VALUE;
            int minEnd = 0;
            for (int end : toVisit.keySet()) {
                if (toVisit.get(end) < min) {
                    min = toVisit.get(end);
                    minEnd = end;
                }
            }
            visited.put(minEnd, min);
            toVisit.remove(minEnd);
            if (graph.containsKey(minEnd)) for (Map.Entry<Integer, Integer> fromMinEnd : graph.get(minEnd).entrySet()) {
                if (!visited.containsKey(fromMinEnd.getKey())) toVisit.put(fromMinEnd.getKey(), Math.min(fromMinEnd.getValue() + min, toVisit.getOrDefault(fromMinEnd.getKey(), Integer.MAX_VALUE)));
            }
        }
        if (visited.size() < N) return -1;
        for (int value : visited.values()) max = Math.max(value, max);
        return max;
    }
}
