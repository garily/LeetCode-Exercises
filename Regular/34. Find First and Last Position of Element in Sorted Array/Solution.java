class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] out = new int[] { -1, -1 };
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return out;
        int leftIndex = binarySearch(nums, target, true);
        if (nums[leftIndex] != target) return out;
        out[0] = leftIndex;
        out[1] = binarySearch(nums, target, false) - 1;
        return out;
    }
    
    private int binarySearch(int[] nums, int target, boolean findLeft) {
        int high = nums.length;
        int low = 0;
        int mid = (high + low) / 2;
        while (low < high) {
            if (nums[mid] > target || (findLeft && nums[mid] == target)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }
}
