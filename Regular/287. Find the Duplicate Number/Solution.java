class Solution {
    public int findDuplicate(int[] nums) {
        int lowCt = 0;
        int mid = nums.length / 2;
        int high = nums.length - 1;
        int low = 1;
        while (low < high) {
            // System.out.println(mid);
            for (int num : nums) {
                if (num <= mid && num >= low) lowCt++;
            }
            // System.out.println("lowCt: " + lowCt);
            if (lowCt > mid - low + 1) { // dupliate exists in [low, mid)
                // System.out.println("lower");
                high = mid;
            }
            else {
                // System.out.println("higher");
                low = mid + 1;
            }
            lowCt = 0;
            mid = (low + high) / 2;
        }
        return mid;
    }
}
