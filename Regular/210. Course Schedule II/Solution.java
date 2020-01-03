class Solution {
    // bfs on a potentially disconnected graph
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];
        boolean[] taken = new boolean[numCourses + 1];
        boolean[] recursionStack = new boolean[numCourses + 1];
        List<List<Integer>> graph = toGraph(numCourses, prerequisites);
        Stack<Integer> order = new Stack<>();
        List<Integer> noPrereqs = graph.remove(0);
        if (noPrereqs.size() == 0) return new int[0];
        for (int i : noPrereqs) {
            if (isCyclic(graph, taken, recursionStack, order, i)) return new int[0];
        }
        if (order.size() < numCourses) return new int[0];
        int[] orderArr = new int[numCourses];
        System.out.println(order);
        for (int i = 0; i < numCourses; i++) {
            orderArr[i] = order.pop();
        }
        return orderArr;
    }
    
    private List<List<Integer>> toGraph(int numCourses, int[][] prereqs) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] hasPrereq = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<Integer>());
        for (int[] prereq : prereqs) {
            graph.get(prereq[1]).add(prereq[0]);
            hasPrereq[prereq[0]] = true;
        }
        List<Integer> noPrereq = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++) if (!hasPrereq[i]) noPrereq.add(i);
        graph.add(0, noPrereq);
        return graph;
    }
    
    private boolean isCyclic(List<List<Integer>> graph, boolean[] taken, boolean[] recursionStack, Stack<Integer> order, int cur) {
        if (recursionStack[cur]) return true;
        if (taken[cur]) return false;
        recursionStack[cur] = true;
        taken[cur] = true;
        for (int next : graph.get(cur)) {
            if (isCyclic(graph, taken, recursionStack, order, next)) return true;
        }
        recursionStack[cur] = false;
        order.push(cur);
        return false;
    }
}
