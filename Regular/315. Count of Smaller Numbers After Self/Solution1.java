class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // binary sort starting from the end
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = binarySearch(nums, nums[i], i + 1, nums.length);
            list.add(0, nums.length - j);
            int cur = nums[i];
            for (int k = i; k < j - 1; k++) {
                nums[k] = nums[k + 1];
            }
            nums[j - 1] = cur;
        }
        return list;
    }
    
    private int binarySearch(int[] nums, int target, int start, int end) {
        int low = start;
        int high = end;
        int mid = (low + high) / 2;
        while (low < high) {
            if (nums[mid] >= target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }
}
