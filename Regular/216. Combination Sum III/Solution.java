class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<Integer>(), k, n, 0);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> row, int k, int target, int prev) {
        if (k == 0) return;
        for (int i = prev + 1; i < 10; i++) {
            if (target > i) {
                row.add(i);
                dfs(list, row, k - 1, target - i, i);
                row.remove(row.size() - 1);
            }
            if (i == target && k == 1) {
                row.add(i);
                list.add(new ArrayList<Integer>(row));
                row.remove(row.size() - 1);
                return;
            }
        }
    }
}
