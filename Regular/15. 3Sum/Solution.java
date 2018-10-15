// Complexity O(N^2*logN)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        
        if (nums.length <= 2) return out;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int jkSum = 0 - nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                //smallest second item plus the one follows it greater than jkSum
                if (nums[j] + nums[j + 1] > jkSum) break;
                if (j > i + 1 && nums[j] == nums[j - 1] || nums[j] + nums[nums.length - 1] < jkSum) continue;
                //search for (jkSum - nums[j]) in nums[j + 1, nums.length - 1]
                int k1 = j + 1, k2 = nums.length - 1;
                while (k1 < k2) {
                    if (nums[(k1 + k2) / 2] + nums[j] > jkSum) k2 = (k1 + k2) / 2;
                    else k1 = (k1 + k2) / 2 + 1;
                }
                if (nums[k1] + nums[j] == jkSum) out.add(Arrays.asList(nums[i], nums[j], nums[k1]));
                else if (nums[k1 - 1] + nums[j] == jkSum) out.add(Arrays.asList(nums[i], nums[j], nums[k1 - 1]));
            }
        }
        return out;
    }
}
