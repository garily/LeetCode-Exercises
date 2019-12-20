class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // sum[i][j] is meant for the max coins that can be collected after shooting all balloons from i to j (inclusive)
        int[][] sum = new int[nums.length][nums.length];
        for (int breadth = 0; breadth < nums.length; breadth++) {
            for (int start = 0; start < nums.length - breadth; start++) {
                int end = start + breadth;
                sum[start][end] = Integer.MIN_VALUE;
                int left = (start - 1 < 0 || start - 1 >= nums.length) ? 1 : nums[start - 1];
                int right = (end + 1 < 0 || end + 1 >= nums.length) ? 1 : nums[end + 1];
                if (start == end) {
                    sum[start][end] = Math.max(sum[start][end], left * nums[start] * right);
                }
                else {
                    sum[start][end] = Math.max(sum[start][end], sum[start][end - 1] + nums[end] * left * right);
                    sum[start][end] = Math.max(sum[start][end], sum[start + 1][end] + nums[start] * left * right);
                }
                for (int i = start + 1; i < end; i++) {
                    sum[start][end] = Math.max(sum[start][end], sum[start][i - 1] + nums[i] * left * right + sum[i + 1][end]);
                }
            }
        }
        return sum[0][nums.length - 1];
    }
}
