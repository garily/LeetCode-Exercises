class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        k %= nums.length;
        if (k < 1) return;
        int[] tmp = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) tmp[(i + k) % nums.length] = nums[i];
        for (int i = nums.length - 1; i >= k; i--) nums[i] = nums[i - k];
        for (int i = 0; i < k; i++) nums[i] = tmp[i];
    }
}
