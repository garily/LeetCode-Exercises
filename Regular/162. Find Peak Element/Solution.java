class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        if (nums[1] < nums[0]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low < high - 2) {
            if (nums[mid + 1] > nums[mid]) low = mid;
            else high = mid + 1;
            mid = (low + high) / 2;
        }
        return mid;
    }
}
