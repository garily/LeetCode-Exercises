class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] helper = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int num : mat[i]) count += num;
            helper[i][0] = i;
            helper[i][1] = count;
            // System.out.println(Arrays.toString(mat[i]));
            // System.out.println(Arrays.toString(helper[i]));
        }
        Arrays.sort(helper, (a, b) -> (a[1] - b[1]));
        int[] out = new int[k];
        for (int i = 0; i < k; i++) out[i] = helper[i][0];
        return out;
    }
}
