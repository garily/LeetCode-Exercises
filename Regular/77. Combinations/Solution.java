class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (k == 0) {
            list.add(new ArrayList<Integer>());
            return list;
        }
        dfs(list, new ArrayList<Integer>(), n, k, 0);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> row, int n, int k, int previous) {
        if (row.size() == k) list.add(new ArrayList<Integer>(row));
        else {
            for (int i = previous + 1; i <= n; i++) {
                //if (row.contains(i)) continue;
                row.add(i);
                dfs(list, row, n, k, i);
                row.remove(row.size() - 1);
            }
        }
    }
}
