class RecentCounter {
    static List<Integer> recentPings;
    public RecentCounter() {
        recentPings = new ArrayList<>();
    }
    
    public int ping(int t) {
        while (!recentPings.isEmpty() && recentPings.get(0) < t - 3000) recentPings.remove(0);
        recentPings.add(t);
        return recentPings.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
