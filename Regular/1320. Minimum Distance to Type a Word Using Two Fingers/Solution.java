class Solution {
    public int minimumDistance(String wordStr) {
        if (wordStr == null || wordStr.length() <= 2) return 0;
        char[] word = wordStr.toCharArray();
        int[][] dp = new int[word.length + 1][word.length + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minDist(word, dp, 1, 0);
    }
    
    private int minDist(char[] word, int[][] dp, int left, int right) {
        // System.out.println(left + ", " + right);
        int prev = left > right ? left : right;
        if (prev == word.length) return 0;
        if (dp[left][right] > -1) return dp[left][right];
        dp[left][right] = Math.min(
            minDist(word, dp, prev + 1, right) + dist(word[prev], word[left - 1]),
            minDist(word, dp, left, prev + 1) + (right == 0 ? 0 : dist(word[prev], word[right - 1]))
        );
        return dp[left][right];
    }
    
    private int dist(char A, char B) {
        int a = A - 'A';
        int b = B - 'A';
        int ax = a / 6;
        int ay = a % 6;
        int bx = b / 6;
        int by = b % 6;
        return (ax > bx ? (ax - bx) : (bx - ax)) + (ay > by ? (ay - by) : (by - ay));
    }
}
