// Complexity O(N^3)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        int aitmp = nums[0] - 1;
        int ajtmp = nums[1] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == aitmp) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == ajtmp) continue;
                int k;
                for (k = j + 1; k < nums.length && nums[i] + nums[j] + nums[k] < 0; k++);
                if (k < nums.length && nums[i] + nums[j] + nums[k] == 0)
                    out.add(Arrays.asList(nums[i], nums[j], nums[k]));
                ajtmp = nums[j];
            }
            aitmp = nums[i];
        }
        return out;
    }
}
