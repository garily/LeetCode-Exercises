class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) numList.add(num);
        return kthSmallest(numList, nums.length - k);
    }
    
    private int kthSmallest(List<Integer> nums, int k) {
        int pivot = nums.get(0);
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int num : nums) {
            if (num == pivot) continue;
            if (num < pivot) smaller.add(num);
            else greater.add(num);
        }
        if (k < smaller.size()) return kthSmallest(smaller, k);
        if (k >= smaller.size() && k < nums.size() - greater.size()) return pivot;
        return kthSmallest(greater, k + greater.size() - nums.size());
    }
}
