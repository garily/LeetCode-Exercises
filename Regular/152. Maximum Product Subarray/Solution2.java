class Solution2 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int current = 1;
        // forward
        for (int i = 0; i < nums.length; i++) {
            current *= nums[i];
            max = Math.max(current, max);
            if (current == 0) current = 1;
        }
        current = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            current *= nums[i];
            max = Math.max(current, max);
            if (current == 0) current = 1;
        }
        return max;
    }
}
