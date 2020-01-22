class Solution {
    public void sortColors(int[] nums) {
        int twoStart = nums.length;
        int zeroEnd = -1;
        for (int i = 0; i < twoStart;) {
            if (nums[i] == 0) {
                zeroEnd++;
                if (zeroEnd < i) {
                    nums[i] = nums[zeroEnd];
                    nums[zeroEnd] = 0;
                }
                else {
                    i++;
                }
            }
            else if (nums[i] == 1) i++;
            else if (nums[i] == 2) {
                twoStart--;
                nums[i] = nums[twoStart];
                nums[twoStart] = 2;
            }
        }
    }
}
