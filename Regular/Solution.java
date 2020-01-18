class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return ;
        int fast = 1;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) fast++;
            else nums[++slow] = nums[fast++];
        }
        return slow + 1;
    }
}
