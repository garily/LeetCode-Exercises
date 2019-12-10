class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        Map<Integer, Set<Integer>> targets = new HashMap<>();
        targets.put(0, new HashSet<Integer>());
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                int diff = i - nums[j];
                if (diff >= 0 && targets.containsKey(diff)) {
                    Set<Integer> prev = targets.get(diff);
                    if (!prev.contains(j)) {
                        Set<Integer> tmp = new HashSet<Integer>(prev);
                        tmp.add(j);
                        targets.put(i, tmp);
                        break;
                    }
                }
            }
        }
        return targets.containsKey(target);
    }
}
