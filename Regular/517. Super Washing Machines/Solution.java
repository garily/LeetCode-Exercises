class Solution {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) return -1;
        int sum = 0;
        for (int machine : machines) sum += machine;
        if (sum % machines.length != 0) return -1;
        int avg = sum / machines.length;
        machines[0] -= avg;
        int maxDiff = Math.abs(machines[0]);
        int maxRunningDiff = machines[0];
        for (int i = 1; i < machines.length; i++) {
            machines[i] -= avg;
            maxDiff = Math.max(maxDiff, machines[i]);
            machines[i] += machines[i - 1];
            maxRunningDiff = Math.max(maxRunningDiff, Math.abs(machines[i]));
        }
        return Math.max(maxDiff, maxRunningDiff);
    }
}
