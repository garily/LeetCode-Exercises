class Solution {
    public int superEggDrop(int K, int N) {
        int[][] maxFloor = new int[K + 1][N + 1];
        int trials = 0;
        while (maxFloor[K][trials] < N) {
            trials++;
            for (int i = 1; i <= K; i++) maxFloor[i][trials] = maxFloor[i - 1][trials - 1] + maxFloor[i][trials - 1] + 1;
        }
        return trials;
    }
}
