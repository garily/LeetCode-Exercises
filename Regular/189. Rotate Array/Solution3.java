class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        k %= nums.length;
        if (k < 1) return;
        if (k > 0) {
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 1; i--) nums[i] = nums[i - 1];
            nums[0] = tmp;
        }
        rotate(nums, --k);
    }
}
