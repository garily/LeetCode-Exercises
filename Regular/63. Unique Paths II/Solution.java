class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) return 0;
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        dp[1][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 1 && j == 1) continue;
                if (grid[i - 1][j - 1] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
