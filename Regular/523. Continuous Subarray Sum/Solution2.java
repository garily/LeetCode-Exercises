class Solution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // edge case
        if (nums.length < 2) return false;
        if (k == 1 || k == -1) return true;
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i < nums.length - 1 && nums[i] == 0 && nums[i + 1] == 0) return true;
            }
            return false;
        }
        else {
            int[] sums = Arrays.copyOf(nums, nums.length);
            for (int len = 2; len <= nums.length; len++) {
                for (int i = 0; i + len - 1 < sums.length; i++) {
                    sums[i] = sums[i] + nums[i + len - 1];
                    if (sums[i] % k == 0) return true;
                }
            }
            return false;
        }
    }
}
