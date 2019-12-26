class Solution {
    public int findNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int out = 0;
        double log10 = Math.log(10);
        for (int i = 0; i < nums.length; i++) {
            if ((int) (Math.log(nums[i]) / log10) % 2 == 1) out++;
        }
        return out;
    }
}
