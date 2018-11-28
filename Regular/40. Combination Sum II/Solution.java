class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, new ArrayList<Integer>(), candidates, target, new boolean[candidates.length], -1);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> row, int[] candidates, int target, boolean[] visited, int prevIdx) {
        for (int i = prevIdx + 1; i < candidates.length; i++) {
            if (visited[i] || (i > 0 && !visited[i] && candidates[i - 1] == candidates[i] && !visited[i - 1])) continue;
            if (target > candidates[i]) {
                row.add(candidates[i]);
                visited[i] = true;
                dfs(list, row, candidates, target - candidates[i], visited, i);
                row.remove(row.size() - 1);
                visited[i] = false;
            }
            else if (target == candidates[i]) {
                row.add(candidates[i]);
                list.add(new ArrayList<Integer>(row));
                row.remove(row.size() - 1);
                return;
            }
        }
    }
}
