class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList();
        dfs(nums, 0, new ArrayList<Integer>(), out);
        return out;
    }
    
    private void dfs(int[] nums, int idx, List<Integer> cur, List<List<Integer>> out) {
        if (idx >= nums.length) {
            out.add(new ArrayList<Integer>(cur));
            return;
        }
        dfs(nums, idx + 1, cur, out);
        cur.add(nums[idx]);
        dfs(nums, idx + 1, cur, out);
        cur.remove(cur.size() - 1);
    }
}
