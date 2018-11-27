class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<Integer>(), nums);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> row, int[] nums) {
        if (row.size() == nums.length) list.add(new ArrayList<Integer>(row));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (row.contains(nums[i])) continue;
                row.add(nums[i]);
                dfs(list, row, nums);
                // remove last element after this recursion instead of creating a copy of row
                row.remove(row.size() -1);
            }
        }
    }
}
