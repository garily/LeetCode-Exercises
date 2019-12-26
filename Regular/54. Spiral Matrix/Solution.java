class Solution {
    private final int[][] direction= new int[][] {
        { 0, 1 }, // right
        { 1, 0 }, // down
        { 0, -1 }, // left
        { -1, 0 } // up
    };
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return out;
        int dir = 0, i = 0, j = 0;
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];
        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && !visited[i][j]) {
            out.add(matrix[i][j]);
            visited[i][j] = true;
            int nexti = i + direction[dir][0];
            int nextj = j + direction[dir][1];
            if (nexti >= 0 && nexti < matrix.length && nextj >= 0 && nextj < matrix[0].length) {
                if (visited[nexti][nextj]) {
                    dir = (dir + 1) % 4;
                    i = i + direction[dir][0];
                    j = j + direction[dir][1];
                }
                else {
                    i = nexti;
                    j = nextj;
                }
            }
            else {
                dir = (dir + 1) % 4;
                i = i + direction[dir][0];
                j = j + direction[dir][1];
            }
        }
        return out;        
    }
}
