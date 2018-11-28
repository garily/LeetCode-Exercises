class Solution {//dfs
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        return dfs(nums, target, map);
    }
    
    private int dfs(int[] nums, int target, Map<Integer, Integer> map) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target)) return map.get(target);
            if (target > nums[i]) {
                count = count + dfs(nums, target - nums[i], map);
            }
            else if (target == nums[i]) {
                count++;
                break;
            }
            else break;
        }
        map.put(target, count);
        return count;
    }
}
