class Solution {
    private int[] original;
    private Integer[] rand;

    public Solution(int[] nums) {
        rand = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) rand[i] = nums[i];
        original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Arrays.sort(rand, (a, b) -> Math.random() >= 0.5 ? 1 : -1);
        int[] out = new int[rand.length];
        for (int i = 0; i < rand.length; i++) out[i] = rand[i];
        return out;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
