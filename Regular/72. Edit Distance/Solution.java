class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int[][] minOps = new int[w1.length + 1][w2.length + 1];
        for (int i = 1; i <= w1.length; i++) minOps[i][0] = i;
        for (int j = 1; j <= w2.length; j++) minOps[0][j] = j;
        for (int i = 0; i < w1.length; i++) {
            for (int j = 0; j < w2.length; j++) {
                if (w1[i] == w2[j]) minOps[i + 1][j + 1] = minOps[i][j];
                else minOps[i + 1][j + 1] = 1 + min(minOps[i][j], minOps[i][j + 1], minOps[i + 1][j]);
            }
        }
        return minOps[w1.length][w2.length];
    }
    
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
