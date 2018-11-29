class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] visited = new boolean[9][9];
        boolean[][][] unique = new boolean[3][9][9]; // unique[row/column/block][index][number]
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] - '.' == 0) continue;
                int num = board[r][c] - '1';
                if (unique[0][r][num]) return false;
                else unique[0][r][num] = true;
                if (unique[1][c][num]) return false;
                else unique[1][c][num] = true;
                int block = r / 3 * 3 + c / 3;
                if (unique[2][block][num]) return false;
                else unique[2][block][num] = true;
            }
        }
        return true;
    }
}
