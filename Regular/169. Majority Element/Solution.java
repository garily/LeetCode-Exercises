class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap();
        int out = 0;
        int maxFreq = 0;
        for (int num : nums) {
            int tmpFreq = freq.getOrDefault(num, 0);
            tmpFreq++;
            if (tmpFreq > maxFreq) {
                maxFreq = tmpFreq;
                out = num;
            }
            freq.put(num, tmpFreq);
        }
        return out;
    }
}
