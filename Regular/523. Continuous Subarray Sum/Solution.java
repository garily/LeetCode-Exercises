class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> accuModIndex = new HashMap<Integer, Integer>() {{ put(0, -1); }};
        int accuSum = 0;
        for (int i = 0; i < nums.length; i++) {
            accuSum += nums[i];
            if (k != 0) accuSum %= k;
            Integer prev = accuModIndex.get(accuSum);
            if (prev == null) accuModIndex.put(accuSum, i);
            else if (i - prev > 1) return true;
        }
        return false;
    }
}
