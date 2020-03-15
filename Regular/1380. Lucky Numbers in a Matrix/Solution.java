class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> out = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return out;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMin = new int[m];
        int[] colMax = new int[n];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) out.add(matrix[i][j]);
            }
        }
        return out;
    }
}
