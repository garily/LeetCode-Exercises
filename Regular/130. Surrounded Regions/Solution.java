class Solution {
    public void solve(char[][] board) {
        // edge case
        if (board.length == 0 || board[0].length == 0) return;
        
        Queue<Integer> toVisit = new LinkedList<>();
        // boolean[][] marked = new boolean[board.length][board[0].length];
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (r > 0 && r < board.length - 1 && c > 0 && c < board[0].length - 1) continue;
                if (board[r][c] == 'X') continue;
                if (board[r][c] == 'O') {
                    toVisit.add(r * board[0].length + c);
                    while (!toVisit.isEmpty()) {
                        int coord = toVisit.remove();
                        int rr = coord / board[0].length, cc = coord % board[0].length;
                        // System.out.println("r: " + r + ", c: " + c + ", rr: " + rr + ", cc: " + cc);
                        board[rr][cc] = 'Y';
                        // up
                        if (rr > 0 && board[rr - 1][cc] == 'O' && !toVisit.contains(coord - board[0].length)) toVisit.add(coord - board[0].length);
                        // down
                        if (rr < board.length - 1 && board[rr + 1][cc] == 'O' && !toVisit.contains(coord + board[0].length)) toVisit.add(coord + board[0].length);
                        // left
                        if (cc > 0 && board[rr][cc - 1] == 'O' && !toVisit.contains(coord - 1)) toVisit.add(coord - 1);
                        // right
                        if (cc < board[0].length - 1 && board[rr][cc + 1] == 'O' && !toVisit.contains(coord + 1)) toVisit.add(coord + 1);
                    }
                }
            }
        }
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'Y') board[r][c] = 'O';
            }
        }
    }
}
