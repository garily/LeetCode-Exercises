class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = searchSortedList(nums[i], sorted);
            if (index < sorted.size()) {
                sorted.set(index, Math.min(sorted.get(index), nums[i]));
            }
            else {
                sorted.add(index, nums[i]);
            }
            
        }
        return sorted.size();
    }
    
    private int searchSortedList(int e, List<Integer> sorted) {
        int low = 0, high = sorted.size();
        int mid = (low + high) / 2;
        while (low < high) {
            if (e > sorted.get(mid)) {
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
