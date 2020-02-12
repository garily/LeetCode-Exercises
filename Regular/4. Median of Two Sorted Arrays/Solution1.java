public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arrShort, arrLong;

        if (nums1.length > nums2.length) {
            arrShort = nums2;
            arrLong = nums1;
        }
        else {
            arrShort = nums1;
            arrLong = nums2;
        }
        int m = arrShort.length;
        int n = arrLong.length;

        boolean ifOdd = (m + n) % 2 == 1;
        int halfSize = (m + n + 1) / 2;

        for (int iMin = 0, iMax = m, i = 0, j = 0; ; ) {
            i = (iMin + iMax) / 2;
            j = halfSize - i;
            if (i < iMax && arrShort[i] < arrLong[j - 1]) {
                iMin = i + 1;
            }
            else if (i > iMin && arrShort[i - 1] > arrLong[j]){
                iMax = i - 1;
            }
            else {
                int maxLeft = 0, minRight = 0;
                if (i == 0) {
                    maxLeft = arrLong[j - 1];
                }
                else if (j == 0) {
                    maxLeft = arrShort[i - 1];
                }
                else {
                    maxLeft = Math.max(arrShort[i - 1], arrLong[j - 1]);
                }
                if (ifOdd) return maxLeft;

                if (i == m) {
                    minRight = arrLong[j];
                }
                else if (j == n) {
                    minRight = arrShort[i];
                }
                else {
                    minRight = Math.min(arrShort[i], arrLong[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
    }
}

