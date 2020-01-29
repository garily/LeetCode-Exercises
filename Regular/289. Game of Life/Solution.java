class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] |= (nextState(board, i, j) << 1);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int nextState(int[][] board, int i, int j) {
        int[] neighbors = new int[8]; // u, d, l, r ul, ur, dl, dr;
        neighbors[0] = (i == 0) ? 0 : board[i - 1][j];
        neighbors[1] = (i == board.length - 1) ? 0 : board[i + 1][j];
        neighbors[2] = (j == 0) ? 0 : board[i][j - 1];
        neighbors[3] = (j == board[i].length - 1) ? 0 : board[i][j + 1];
        neighbors[4] = (i == 0) ? 0 : ((j == 0) ? 0 : board[i - 1][j - 1]);
        neighbors[5] = (i == 0) ? 0 : ((j == board[i].length - 1) ? 0 : board[i - 1][j + 1]);
        neighbors[6] = (i == board.length - 1) ? 0 : ((j == 0) ? 0 : board[i + 1][j - 1]);
        neighbors[7] = (i == board.length - 1) ? 0 : ((j == board[i].length - 1) ? 0 : board[i + 1][j + 1]);
        
        int liveCt = 0;
        int out = 0;
        for (int k = 0; k < 8; k++) {
            neighbors[k] &= 0x1;
            if (neighbors[k] > 0) liveCt++;
        }
        
        if ((board[i][j] & 0x1) > 0) {
            if (liveCt < 2) return 0;
            if (liveCt < 4) return 1;
            return 0;
        }
        // dead
        if (liveCt == 3) return 1;
        return 0;
    }
}
