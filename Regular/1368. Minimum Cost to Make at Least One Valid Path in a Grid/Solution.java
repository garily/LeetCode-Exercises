class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<Integer> deque = new LinkedList();
        int[][] visited = new int[m][n];
        dfs(grid, visited, 0, 0, 1, deque);
        while (visited[grid.length - 1][grid[0].length - 1] == 0 && !deque.isEmpty()) {
            int cur = deque.poll();
            int i = cur / n;
            int j = cur % n;
            int prevDepth = visited[i][j];
            if (i > 0) dfs(grid, visited, i - 1, j, prevDepth + 1, deque);
            if (j > 0) dfs(grid, visited, i, j - 1, prevDepth + 1, deque);
            if (i < m - 1) dfs(grid, visited, i + 1, j, prevDepth + 1, deque);
            if (j < n - 1) dfs(grid, visited, i, j + 1, prevDepth + 1, deque);
        }
        return visited[grid.length - 1][grid[0].length - 1] - visited[0][0];
    }
    
    private void dfs(int[][] grid, int[][] visited, int i, int j, int k, Deque<Integer> deque) {
        if (visited[i][j] > 0) return;
        // r1, l2, d3, u4
        visited[i][j] = k;
        deque.offer(i * grid[0].length + j);
        if (i > 0 && grid[i][j] == 4) {
            dfs(grid, visited, i - 1, j, k, deque);
        }
        if (j > 0 && grid[i][j] == 2) {
            dfs(grid, visited, i, j - 1, k, deque);
        }
        if (i < grid.length - 1 && grid[i][j] == 3) {
            dfs(grid, visited, i + 1, j, k, deque);
        }
        if (j < grid[0].length - 1 && grid[i][j] == 1) {
            dfs(grid, visited, i, j + 1, k, deque);
        }
    }
}
