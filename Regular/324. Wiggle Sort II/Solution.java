class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        int median = kthSmallest(list, nums.length / 2);
        System.out.println(median);
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int num : nums) {
            if (num == median) continue;
            if (num > median) greater.add(num);
            else smaller.add(num);
        }
        int smallerSize, greaterSize;
        if (nums.length % 2 == 1) {
            smallerSize = nums.length / 2 + 1;
            greaterSize = nums.length / 2;
        }
        else {
            smallerSize = nums.length / 2;
            greaterSize = nums.length / 2;
        }
        while (smaller.size() < smallerSize) smaller.add(0, median);
        while (greater.size() < greaterSize) greater.add(median);
        int i = 0;
        for (; i < nums.length / 2; i++) {
            nums[2 * i] = smaller.get(i);
            nums[2 * i + 1] = greater.get(i);
        }
        if (nums.length % 2 == 1) nums[2 * i] = smaller.get(i);
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
