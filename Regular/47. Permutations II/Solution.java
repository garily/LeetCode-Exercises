class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            list.add(new ArrayList<Integer>());
            return list;
        }
        Arrays.sort(nums);
        dfs(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> row, int[] nums, boolean[] numUsed) {
        if (row.size() == nums.length) {
            list.add(new ArrayList<Integer>(row));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (numUsed[i] || (i > 0 && !numUsed[i - 1] && nums[i] == nums[i - 1])) continue;
                row.add(nums[i]);
                numUsed[i] = true;
                dfs(list, row, nums, numUsed);
                numUsed[i] = false;
                row.remove(row.size() - 1);
            }
        }
    }
}
