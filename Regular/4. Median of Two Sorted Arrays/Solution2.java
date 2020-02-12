class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0.0;
        boolean odd = (nums1.length + nums2.length) % 2 == 1;
        int[] half = new int[(nums1.length + nums2.length + 2) / 2];
        int i = 0, j = 0;
        for (int k = 0; k < half.length; k++) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) half[k] = nums1[i++];
                else half[k] = nums2[j++];
            }
            else if (i < nums1.length) {
                half[k] = nums1[i++];
            }
            else { // i == num1.length && j < nums2.length
                half[k] = nums2[j++];
            }
        }
        return odd ? half[half.length - 1] : ((half[half.length - 2] + half[half.length - 1]) / 2.0);
    }
}
