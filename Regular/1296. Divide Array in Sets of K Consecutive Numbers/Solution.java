class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums == null || nums.length % k != 0) return false;
        if (k == 1) return true;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        int count = 0;
        for (int i = 0; i < nums.length / k; i++) {
            int prevNum = list.get(0);
            list.remove(0);
            count++;
            for (int j = 0; j < list.size() && count < k;) {
                // System.out.println(Arrays.toString(list.toArray()));
                if (list.get(j) == prevNum + 1) {
                // System.out.println(list.get(j));
                    prevNum++;
                    list.remove(j);
                    count++;
                }
                else {
                    j++;
                }
            }
            // System.out.println(count);
            if (count < k) return false;
            count = 0;
        }
        return list.size() == 0;
    }
}
