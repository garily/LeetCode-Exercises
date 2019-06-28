class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> out = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0) return out;
        boolean[][] ifFilled = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < words.length; i++) {
            boolean ifFound = false;
            for (int row = 0; row < board.length && !ifFound; row++) {
                for (int col = 0; col < board[0].length && !ifFound; col++) {
                    if (words[i].charAt(0) == board[row][col]) {
                        ifFilled[row][col] = true;
                        ifFound = lookup(board, ifFilled, words[i], 1, row, col);
                        ifFilled[row][col] = false;
                    }
                }
            }
            if (ifFound) out.add(words[i]);
        }
        return out;
    }
    
    private boolean lookup(char[][] board, boolean[][] ifFilled, String word, int curIdx, int row, int col) {
        if (word.length() == curIdx) return true;
        char firstChar = word.charAt(curIdx);
        boolean ifFound = false;
        // cell above: [row - 1][col]
        if (row - 1 >= 0 && !ifFilled[row - 1][col] && firstChar == board[row - 1][col]) {
            ifFilled[row - 1][col] = true;
            ifFound = lookup(board, ifFilled, word, curIdx + 1, row - 1, col);
            ifFilled[row - 1][col] = false;
        }
        // cell below: [row + 1][col]
        if (!ifFound && row + 1 < board.length && !ifFilled[row + 1][col] && firstChar == board[row + 1][col]) {
            ifFilled[row + 1][col] = true;
            ifFound = lookup(board, ifFilled, word, curIdx + 1, row + 1, col);
            ifFilled[row + 1][col] = false;
        }
        // cell to the left: [row][col - 1]
        if (!ifFound && col - 1 >= 0 && !ifFilled[row][col - 1] && firstChar == board[row][col - 1]) {
            ifFilled[row][col - 1] = true;
            ifFound = lookup(board, ifFilled, word, curIdx + 1, row, col - 1);
            ifFilled[row][col - 1] = false;
        }
        // cell to the right: [row][col + 1]
        if (!ifFound && col + 1 < board[0].length && !ifFilled[row][col + 1] && firstChar == board[row][col + 1]) {
            ifFilled[row][col + 1] = true;
            ifFound = lookup(board, ifFilled, word, curIdx + 1, row, col + 1);
            ifFilled[row][col + 1] = false;
        }
        return ifFound;
    }
}
