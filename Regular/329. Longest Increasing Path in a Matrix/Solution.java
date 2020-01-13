class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int out = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int[] row : visited) Arrays.fill(row, -1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                out = Math.max(out, dfs(matrix, visited, i, j, Integer.MIN_VALUE));
        }
        return out;
    }
    
    private int dfs(int[][] matrix, int[][] visited, int r, int c, int prevVal) {
        if (r >= matrix.length || r < 0 || c >= matrix[0].length || c < 0) return 0;
        if (matrix[r][c] <= prevVal) return 0;
        if (visited[r][c] >= 0) {
            return visited[r][c];
        }
        int up = dfs(matrix, visited, r - 1, c, matrix[r][c]);
        int down = dfs(matrix, visited, r + 1, c, matrix[r][c]);
        int left = dfs(matrix, visited, r, c - 1, matrix[r][c]);
        int right = dfs(matrix, visited, r, c + 1, matrix[r][c]);
        visited[r][c] = 1 + max(up, down, left, right);
        return visited[r][c];
    }
    
    private int max(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
