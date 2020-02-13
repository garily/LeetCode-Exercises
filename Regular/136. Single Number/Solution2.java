class Solution {
    public int singleNumber(int[] nums) {
        int out = 0;
        for (int num : nums) out ^= num;
        return out;
    }
}
