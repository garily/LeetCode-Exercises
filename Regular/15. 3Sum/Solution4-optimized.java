// Complexity O(N^2)
// 2 pointers
// Solution 4 sped-up by accelerating
// self-reduction (decrementation) of k
// and self-incrase (incrementation) of j
// to skip duplicates
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        
        if (nums.length <= 2) return out;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int jkSum = 0 - nums[i];
            int k = nums.length - 1;
            for (int j = i + 1; j < k;) {
                if (nums[j] + nums[k] == jkSum) {
                    out.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (k-- > j && nums[k] == nums[k + 1]);
                    while (j++ < k && nums[j] == nums[j - 1]);
                }
                else if (nums[j] + nums[k] > jkSum)
                    while (k-- > j && nums[k] == nums[k + 1]);
                else while (j++ < k && nums[j] == nums[j - 1]);
            }
        }
        return out;
    }
}
