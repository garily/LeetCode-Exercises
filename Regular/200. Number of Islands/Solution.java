class Solution {
    // BFS solution
    public int numIslands(char[][] grid) {
        // edge cases
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        int islandCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<Integer> toVisit = new LinkedList<>();
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (visited[r][c] || grid[r][c] == '0') continue;
                // an unvisited new land ('1')
                islandCount++;
                toVisit.add(r * grid[0].length + c);
                while (!toVisit.isEmpty()) {
                    int coord = toVisit.remove();
                    int rr = coord / grid[0].length, cc = coord % grid[0].length;
                    visited[rr][cc] = true;
                    // up
                    if (rr > 0 && !visited[rr - 1][cc] && grid[rr - 1][cc] == '1' && !toVisit.contains(coord - grid[0].length)) toVisit.add(coord - grid[0].length);
                    // down
                    if (rr < grid.length - 1 && !visited[rr + 1][cc] && grid[rr + 1][cc] == '1' && !toVisit.contains(coord + grid[0].length)) toVisit.add(coord + grid[0].length);
                    // left
                    if (cc > 0 && !visited[rr][cc - 1] && grid[rr][cc - 1] == '1' && !toVisit.contains(coord - 1)) toVisit.add(coord - 1);
                    // down
                    if (cc < grid[0].length - 1 && !visited[rr][cc + 1] && grid[rr][cc + 1] == '1' && !toVisit.contains(coord + 1)) toVisit.add(coord + 1);
                }
            }
        }
        
        return islandCount;
    }
}
