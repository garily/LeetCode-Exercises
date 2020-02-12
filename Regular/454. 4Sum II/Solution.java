class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null || A.length != B.length || B.length != C.length || C.length != D.length || A.length == 0) return 0;
        int out = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int a : A) {
            for (int b : B) map.put(a + b, map.getOrDefault(a + b, 0) + 1);
        }
        for (int c : C) {
            for (int d : D) out += map.getOrDefault(-(c + d), 0);
        }
        return out;
    }
}
