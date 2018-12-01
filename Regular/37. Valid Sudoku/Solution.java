class Solution {
    public void solveSudoku(char[][] board) {
        boolean used[][][] = new boolean[3][9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                int pos = board[r][c] - '1';
                used[0][r][pos] = true;
                used[1][c][pos] = true;
                used[2][r / 3 * 3 + c / 3][pos] = true;
            }
        }
        dfs(board, used, 0);
    }
    
    private boolean dfs(char[][] board, boolean[][][] used, int index) {
        if (index > 80) return true;
        int r = index / 9;
        int c = index % 9;
        if (board[r][c] != '.') return dfs(board, used, index + 1);
        for (int k = 0; k < 9; k++) {
            int bloc = r / 3 * 3 + c / 3;
            if (used[0][r][k] || used[1][c][k] || used[2][bloc][k]) continue;
            char ch = (char)(k + '1');
            board[r][c] = ch;
            used[0][r][k] = true;
            used[1][c][k] = true;
            used[2][bloc][k] = true;
            if (dfs(board, used, index + 1)) return true;
            board[r][c] = '.';
            used[0][r][k] = false;
            used[1][c][k] = false;
            used[2][bloc][k] = false;
        }
        return false;
    }
}
