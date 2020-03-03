class Solution {
    public int minScoreTriangulation(int[] A) {
        return dfs(A, 0, A.length - 1, new int[A.length][A.length]);
    }
    
    private int dfs(int[] A, int from, int to, int[][] mem) {
        if (from >= to - 1) return 0;
        if (mem[from][to] > 0) return mem[from][to];
        int min = Integer.MAX_VALUE;
        for (int i = from + 1; i < to; i++) {
            min = Math.min(min, A[from] * A[to] * A[i] + dfs(A, from, i, mem) + dfs(A, i, to, mem));
        }
        mem[from][to] = min;
        return min;
    }
}
