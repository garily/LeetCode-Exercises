class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length || matrix.length == 1) return;
        int halfLen = (matrix.length + 1) / 2;
        int halfLen2 = matrix.length / 2;
        int len = matrix.length;
        for (int i = 0; i < halfLen; i++) {
            for (int j = 0; j < halfLen2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = tmp;
            }
        }
    }
}
