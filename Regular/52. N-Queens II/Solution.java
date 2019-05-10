class Solution {
    public int totalNQueens(int n) {
        int[] out = new int[1];
        if (n == 0) return 1;
        int[] board = new int[n];
        Arrays.fill(board, -1);
        dfs(out, board, 0);
        return out[0];
    }
    
    private void dfs(int[] out, int[] board, int row) {
        for (int r = row; r < board.length; r++) {
            boolean ifQueenPlaced = false;
            for (int c = 0; c < board.length; c++) {
                if (hasAttack(board, r, c)) {
                    continue;
                }
                else {
                    board[r] = c;
                    ifQueenPlaced = true;
                    if (row == board.length - 1) {
                        out[0]++;
                        board[r] = -1;
                        return;
                    }
                    dfs(out, board, r + 1);
                    board[r] = -1;
                    ifQueenPlaced = false;
                }
            }
            if (!ifQueenPlaced) return;
        }
    }
    
    private boolean hasAttack(int[] board, int newR, int newC) {
        for (int row = 0; row < newR; row++) {
            // same column
            if (board[row] == newC) return true;
            // two diagons
            if (board[row] >= 0 && newR - row == newC - board[row]) return true;
            if (board[row] >= 0 && newR - row == board[row] - newC) return true;
        }
        return false;
    }
}
