class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        boolean firstRowZero = false, firstColZero = false;
        
        for (int i = 0; i < matrix.length && !firstColZero; i++) if (matrix[i][0] == 0) firstColZero = true;
        
        for (int j = 0; j < matrix[0].length && !firstRowZero; j++) if (matrix[0][j] == 0) firstRowZero = true;
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        
        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
