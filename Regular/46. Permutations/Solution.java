class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<Integer>(), nums);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> row, int[] nums) {
        if (row.size() == nums.length) list.add(row);
        else {
            for (int i = 0; i < nums.length; i++) {
                if (row.contains(nums[i])) continue;
                List<Integer> row_ = new ArrayList<>(row);
                row_.add(nums[i]);
                dfs(list, row_, nums);
            }
        }
    }
}
