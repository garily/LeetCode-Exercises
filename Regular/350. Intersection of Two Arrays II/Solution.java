class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        int[] out = new int[list.size()];
        for (int i = 0; i < list.size(); i++) out[i] = list.get(i); 
        return out;        
    }
}
