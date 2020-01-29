class Solution {
    public int missingNumber(int[] nums) {
        long sum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) sum -= num;
        return (int) sum;
    }
}
