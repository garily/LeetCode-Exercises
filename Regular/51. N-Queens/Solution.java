class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> out = new ArrayList<>();
        if (n == 0) out.add(Arrays.asList());
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(board[i], '.');
        }
        dfs(out, board, 0);
        return out;
    }
    
    private void dfs(List<List<String>> out, char[][] board, int row) {
        for (int r = row; r < board.length; r++) {
            boolean ifQueenPlaced = false;
            for (int c = 0; c < board.length; c++) {
                if (hasAttack(board, r, c)) {
                    continue;
                }
                else {
                    board[r][c] = 'Q';
                    ifQueenPlaced = true;
                    if (row == board.length - 1) {
                        List<String> list = new ArrayList<>();
                        for (int i = 0; i < board.length; i++) {
                            list.add(new String(board[i]));
                        }
                        out.add(list);
                        board[r][c] = '.';
                        return;
                    }
                    dfs(out, board, r + 1);
                    board[r][c] = '.';
                    ifQueenPlaced = false;
                }
            }
            if (!ifQueenPlaced) return;
        }
    }
    
    private boolean hasAttack(char[][] board, int newR, int newC) {
        for (int row = 0; row < newR; row++) {
            // same column
            if (board[row][newC] == 'Q') return true;
            // two diagons
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 'Q' && newR - row == newC - col) return true;
                if (board[row][col] == 'Q' && newR - row == col - newC) return true;
            }
        }
        return false;
    }
}
