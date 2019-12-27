class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int result = 0;
        // if pivot is 0
        if (nums[0] < nums[nums.length - 1]) {
            result = Arrays.binarySearch(nums, target);
            if (result < 0) result = -1;
            return result;
        }
        // binary search to find pivot
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low < high - 1) {
            if (nums[mid] < nums[high]) {
                high = mid;
                mid = (low + high) / 2;
            }
            else if (nums[mid] > nums[low]) {
                low = mid;
                mid = (low + high) / 2;
            }
        }
        if (target < nums[0]) result = Arrays.binarySearch(nums, high, nums.length, target);
        else result = Arrays.binarySearch(nums, 0, high, target);
        if (result < 0) result = -1;
        return result;
    }
}
