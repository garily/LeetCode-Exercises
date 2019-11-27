class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int[] products = Arrays.copyOf(nums, nums.length);
        for (int num: nums) if (max < num) max = num;
        for (int len = 2; len <= nums.length; len++) {
            for (int i = 0; i + len - 1 < nums.length; i++) {
                products[i] *= nums[i + len - 1];
                // System.out.println(products[i]);
                if (max < products[i]) max = products[i];
            }
        }
        return max;
    }
}
