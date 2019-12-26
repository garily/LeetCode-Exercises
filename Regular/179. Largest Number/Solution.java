class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        // pseudo bubble sort
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int bubble = nums[j];
                String a = Integer.toString(bubble);
                int k = j - 1;
                while (k >= 0) {
                    String b = Integer.toString(nums[k]);
                    if ((a + b).compareTo(b + a) > 0) {
                        nums[k + 1] = nums[k];
                        nums[k] = bubble;
                        k--;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        if (nums[0] == 0) return "0";
        String out = "";
        for (int num : nums) out += num;
        return out;
    }
}
