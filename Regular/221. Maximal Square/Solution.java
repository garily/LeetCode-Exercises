class Solution {
    public int maximalSquare(char[][] pool) {
        if (pool == null || pool.length == 0 || pool[0].length == 0) return 0;
        
        // dynamic programming: maxSide[i][j] denotes the side of the largest square to its upper-left side (including itself)
        // maxSide[i][j] will denote a square with side equals to min(maxSide[i - 1][j], maxSide[i][j -1] , maxSide[i - 1][j - 1]) + 1
        // i.e. pool[i][j] has to be '1'
        int[][] maxSide = new int[pool.length][pool[0].length];
        int maxSideOfAll = 0;
        int up, left, upLeft;
        
        for (int i = 0; i < maxSide.length; i++) {
            for (int j = 0; j < maxSide[0].length; j++) {
                if (pool[i][j] == '1') {
                    if (i == 0 || j == 0) maxSide[i][j] = 1;
                    else {
                        up = maxSide[i - 1][j];
                        left = maxSide[i][j - 1];
                        upLeft = maxSide[i - 1][j - 1];
                        maxSide[i][j] = 1 + Math.min(Math.min(up, left), upLeft);
                    }
                    if (maxSide[i][j] > maxSideOfAll) maxSideOfAll = maxSide[i][j];
                }
            }
        }
        return maxSideOfAll * maxSideOfAll;
    }
}
