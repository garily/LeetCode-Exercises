class Solution {
    public boolean canFinish(int numCourses, int[][] prereqs) {
        if (numCourses <= 1 || prereqs.length == 0) return true;
        List<List<Integer>> graph = toGraph(numCourses, prereqs);
        List<Integer> noPrereqs = graph.remove(0);
        boolean visited[] = new boolean[numCourses];
        boolean curStack[] = new boolean[numCourses];
        int total = 0;
        for (int i : noPrereqs) {
            if (isCyclic(graph, i, visited, curStack)) return false;
        }
        for (int i = 0; i < numCourses; i++) if (!visited[i]) return false;
        return true;
    }
    
    private List<List<Integer>> toGraph(int numCourses, int[][] prereqs) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean hasPrereq[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<Integer>());
        for (int[] prereq : prereqs) {
            graph.get(prereq[1]).add(prereq[0]);
            hasPrereq[prereq[0]] = true;
        }
        List<Integer> noPrereqs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!hasPrereq[i]) noPrereqs.add(i);
        }
        graph.add(0, noPrereqs);
        return graph;
    }
    
    private boolean isCyclic(List<List<Integer>> graph, int idx, boolean[] visited, boolean[] curStack) {
        if (curStack[idx]) return true;
        if (visited[idx]) return false;
        visited[idx] = true;
        curStack[idx] = true;
        for (int i : graph.get(idx)) {
            if (isCyclic(graph, i, visited, curStack)) return true;
        }
        curStack[idx] = false;
        return false;
    }
}
