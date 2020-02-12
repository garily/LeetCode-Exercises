class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        Queue<Integer> nodes = new LinkedList<>();
        Queue<Integer> depths = new LinkedList<>();
        int rowSize = grid[0].length;
        int maxDepth = 0;
        int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    int coord = i * rowSize + j;
                    nodes.offer(coord);
                    depths.offer(0);
                }
            }
        }
        
        while (!nodes.isEmpty()) {
            int coord = nodes.poll();
            int depth = depths.poll();
            maxDepth = Math.max(depth, maxDepth);
            int row = coord / rowSize;
            int col = coord % rowSize;
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    int newCoord = newRow * rowSize + newCol;
                    nodes.offer(newCoord);
                    depths.offer(depth + 1);
                    grid[newRow][newCol] = 2;
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return maxDepth;
    }
}
