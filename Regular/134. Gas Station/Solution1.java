class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return 0;
        int[] gains = new int[gas.length]; // gains[i] refers to the gains after travelling from index i to i+1
        for (int i = 0; i < gas.length; i++) gains[i] = gas[i] - cost[i];
        for (int i = 0; i < gains.length; i++) {
            int balance = 0;
            for (int j = i; j < i + gains.length && balance >= 0; j++) {
                balance += gains[j % gains.length];
            }
            if (balance >= 0) return i;
        }
        // worst case O(n2)
        return -1;
    }
}
