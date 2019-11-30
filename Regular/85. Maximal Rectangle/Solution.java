class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0;
        int[][] dp1, dp2;
        dp1 = new int[matrix[0].length][matrix[0].length];
        // explain: dp1[endCol][startCol] represents the area of maxRect from endCol to startCol (both inclusive) on the row before the current one
        int metaMaxWidth = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp2 = new int[matrix[0].length][matrix[0].length];
            metaMaxWidth = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') metaMaxWidth++;
                else metaMaxWidth = 0;
                for (int w = 0; w < metaMaxWidth; w++) {
                    dp2[j][j - w] = w + 1 + dp1[j][j - w];
                    maxArea = Math.max(maxArea, dp2[j][j - w]);
                }
            }
            dp1 = dp2;
        }
        return maxArea;
    }
}
