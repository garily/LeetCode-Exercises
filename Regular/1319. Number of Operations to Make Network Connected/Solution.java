class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections == null || connections.length < n - 1) return -1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        int areaCount = 0;
        int[] extras = new int[1];
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] >= 0) continue;
            areaCount++;
            visited[i] = i;
            dfs(graph, visited, i, i, extras);
        }
        if (extras[0] > areaCount - 1) return areaCount - 1;
        else return -1;
    }
    
    private void dfs(List<List<Integer>> graph, int[] visited, int cur, int start, int[] extras) {
        List<Integer> adjList = graph.get(cur);
        for (int next : adjList) {
            if (visited[next] >= 0) {
                if (visited[next] == start) extras[0]++;
            }
            else {
                visited[next] = start;
                dfs(graph, visited, next, start, extras);
            }
        }
    }
}
