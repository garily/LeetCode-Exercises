class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        S = Math.abs(S); // symmetry
        int sum = 0;
        for (int num : nums) sum += num;
        if (S > sum) return 0;
        // S <= sum
        int[] sums = new int[sum + 1];
        sums[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                int someSum = j + 2 * nums[i];
                if (someSum <= sum) {
                    sums[j] += sums[someSum];
                }
            }
        }
        return sums[S];
    }
}
