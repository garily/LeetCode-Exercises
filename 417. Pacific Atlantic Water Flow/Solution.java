class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> out = new LinkedList<>();
        // edge cases
        if (matrix.length == 0 || matrix[0].length == 0) return out;
        
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (r == 0 || c == 0) pacific[r][c] = true;
                if (r == matrix.length - 1 || c == matrix[0].length - 1) atlantic[r][c] = true;
            }
        }
        
        Queue<Integer> toVisit = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        // from Pacific shore
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (r > 0 && c > 0) continue;
                toVisit.add(r * matrix[0].length + c);
                while (!toVisit.isEmpty()) {
                    int coord = toVisit.remove();
                    int rr = coord / matrix[0].length, cc = coord % matrix[0].length;
                    visited[rr][cc] = true;
                    pacific[rr][cc] = true;
                    // up
                    if (rr > 0 && matrix[rr - 1][cc] >= matrix[rr][cc] && !visited[rr - 1][cc] && !toVisit.contains(coord - matrix[0].length)) toVisit.add(coord - matrix[0].length);
                    // down
                    if (rr < matrix.length - 1 && matrix[rr + 1][cc] >= matrix[rr][cc] && !visited[rr + 1][cc] && !toVisit.contains(coord + matrix[0].length)) toVisit.add(coord + matrix[0].length);
                    // left
                    if (cc > 0 && matrix[rr][cc - 1] >= matrix[rr][cc] && !visited[rr][cc - 1] && !toVisit.contains(coord - 1)) toVisit.add(coord - 1);
                    // right
                    if (cc < matrix[0].length - 1 && matrix[rr][cc + 1] >= matrix[rr][cc] && !visited[rr][cc + 1] && !toVisit.contains(coord + 1)) toVisit.add(coord + 1);
                }
            }
        }
        
        toVisit = new LinkedList<>();
        visited = new boolean[matrix.length][matrix[0].length];
        
        // from Atlantic shore
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (r < matrix.length - 1 && c < matrix[0].length - 1) continue;
                toVisit.add(r * matrix[0].length + c);
                while (!toVisit.isEmpty()) {
                    int coord = toVisit.remove();
                    int rr = coord / matrix[0].length, cc = coord % matrix[0].length;
                    visited[rr][cc] = true;
                    atlantic[rr][cc] = true;
                    // up
                    if (rr > 0 && matrix[rr - 1][cc] >= matrix[rr][cc] && !visited[rr - 1][cc] && !toVisit.contains(coord - matrix[0].length)) toVisit.add(coord - matrix[0].length);
                    // down
                    if (rr < matrix.length - 1 && matrix[rr + 1][cc] >= matrix[rr][cc] && !visited[rr + 1][cc] && !toVisit.contains(coord + matrix[0].length)) toVisit.add(coord + matrix[0].length);
                    // left
                    if (cc > 0 && matrix[rr][cc - 1] >= matrix[rr][cc] && !visited[rr][cc - 1] && !toVisit.contains(coord - 1)) toVisit.add(coord - 1);
                    // right
                    if (cc < matrix[0].length - 1 && matrix[rr][cc + 1] >= matrix[rr][cc] && !visited[rr][cc + 1] && !toVisit.contains(coord + 1)) toVisit.add(coord + 1);
                }
            }
        }
        
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) out.add(new ArrayList<Integer>(Arrays.asList(r, c)));
            }
        }
        return out;
    }
}
