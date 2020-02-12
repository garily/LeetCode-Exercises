class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0 || k > matrix.length * matrix[0].length) return 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<int[]> edge = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        edge.add(new int[] { 0, 0 });
        int out = matrix[0][0];
        while (k > 0) {
            k--;
            int[] coord = edge.poll();
            int r = coord[0];
            int c = coord[1];
            visited[r][c] = true;
            out = matrix[r][c];
            if (r < matrix.length - 1 && !visited[r + 1][c]) {
                edge.add(new int[] { r + 1, c });
                visited[r + 1][c] = true;
            }
            if (c < matrix[0].length - 1 && !visited[r][c + 1]) {
                edge.add(new int[] { r, c + 1 });
                visited[r][c + 1] = true;
            }
        }
        return out;
    }
}
