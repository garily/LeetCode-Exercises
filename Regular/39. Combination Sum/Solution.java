class Solution {
    //dfs
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> row, int[] candidates, int target, int prevIdx) {
        for (int i = prevIdx; i < candidates.length; i++) {
            if (target > candidates[i]) {
                row.add(candidates[i]);
                dfs(list, row, candidates, target - candidates[i], i);
                row.remove(row.size() - 1);
            }
            else if (target == candidates[i]) {
                row.add(candidates[i]);
                list.add(new ArrayList<Integer>(row));
                row.remove(row.size() - 1);
                return;
            }
            else return;
        }
    }
}
