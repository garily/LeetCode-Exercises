class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        k %= nums.length;
        if (k < 1) return;
        int[] tmp = Arrays.copyOf(nums, nums.length);
        for (int i = k; i < k + nums.length; i++) {
            nums[i % nums.length] = tmp[i - k];
        }
    }
}
