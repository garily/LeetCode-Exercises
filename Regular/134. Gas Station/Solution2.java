class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return 0;
        int cum = 0;
        int cur = 0;
        int start = -1;
        for (int i = 0; i < gas.length; i++) {
            cum += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i;
                cur = 0;
            }
        }
        if (cum < 0) return -1;
        return start + 1;
    }
}
