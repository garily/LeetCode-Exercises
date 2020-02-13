class Solution {
    public void moveZeroes(int[] nums) {
        int head = 0; // beginning index for all zeros (inclusive)
        int tail = 0;
        while (head < nums.length && tail < nums.length) {
            if (nums[head] != 0) head++;
            else {
                tail = head + 1;
                while (tail < nums.length && nums[tail] == 0) tail++;
                while (tail < nums.length && nums[head] == 0 && nums[tail] != 0) {
                    nums[head] = nums[tail];
                    nums[tail] = 0;
                    head++;
                    tail++;
                }
            }
        }
    }
}
