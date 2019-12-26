class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == word.charAt(idx) && !visited[i][j]) {
            visited[i][j] = true;
            if (dfs(board, visited, word, i - 1, j, idx + 1)) return true;
            if (dfs(board, visited, word, i + 1, j, idx + 1)) return true;
            if (dfs(board, visited, word, i, j - 1, idx + 1)) return true;
            if (dfs(board, visited, word, i, j + 1, idx + 1)) return true;
            visited[i][j] = false;
        }
        return false;
    }
}
