class Solution {
    public int shortestBridge(int[][] A) {
        int width = A[0].length;
        int height = A.length;
        int[][] visited = new int[width][height];
        int i = 0, j = 0, startX, startY;
        for (i = 0; i < height; i++) {
            for (j = 0; j < width && A[i][j] == 0; j++);
            if (j < width) break;
        }
        startX = i;
        startY = j;
        visited[i][j] = 1;
        //dfs for finding the first island, color it to 0
        dfsIsland(A, visited, startX, startY);
        
        //add color layers to the island already found
        int layers = 2;
        for (; layers < width + 1 || layers < height + 1; layers++) {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    if (visited[i][j] != layers - 1) continue;
                    int[] neighbors = getNeighbors(A, i, j);
                    for (int k = 0; k < 8; k += 2) {
                        int r = neighbors[k], c = neighbors[k + 1];
                        if (r >= 0) {
                            if (visited[r][c] == 0) {
                                visited[r][c] = layers;
                                if (A[r][c] == 1) return layers - 2;
                            }
                        }
                    }
                }
            }
        }
        return layers - 2;
    }
    
    public void dfsIsland(int[][] A, int[][] visited, int x, int y) {
        int[] neighbors = getNeighbors(A, x, y);
        for (int i = 0; i < 8; i += 2) {
            int r = neighbors[i], c = neighbors[i + 1];
            if (r >= 0
                && A[r][c] == 1
                && visited[r][c] == 0) {
                visited[r][c] = 1;
                dfsIsland(A, visited, r, c);
            }
        }
    }
    
    public int[] getNeighbors(int[][] A, int x, int y) {//x: row, y: column
        int[] result = new int[8];
        Arrays.fill(result, -1);
        if (x < 0 || y < 0 || x >= A.length || y >= A[0].length) return result;
        if (x + 1 < A.length) {
            result[0] = x + 1;
            result[1] = y;
        }
        if (y + 1 < A[0].length) {
            result[2] = x;
            result[3] = y + 1;
            
        }
        if (x - 1 >= 0) {
            result[4] = x - 1;
            result[5] = y;
        }
        if (y - 1 >= 0) {
            result[6] = x;
            result[7] = y - 1;
        }
        return result;
    }
}
