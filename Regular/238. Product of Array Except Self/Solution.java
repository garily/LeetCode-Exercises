class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        if (out.length == 0) return out;
        dfs(out, nums, 0, 1);
        return out;
    }
    
    private int dfs(int[] out, int[] nums, int idx, int prev) {
        if (idx == out.length) return 1;
        int after = dfs(out, nums, idx + 1, prev * nums[idx]);
        out[idx] = prev * after;
        return nums[idx] * after;
    }
}
