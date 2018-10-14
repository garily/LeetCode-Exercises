class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int size = A.length;
        int[] out = new int[size];
        for (int i = 0, j = 1; i < size + 1; i += 2) {
            if (i < size && A[i] % 2 == 0) out[i] = A[i];
            else {
                while(j < size && A[j] % 2 == 1) {
                    out[j] = A[j];
                    j += 2;
                }
                if (j < size) {
                    out[i] = A[j];
                    out[j] = A[i];
                    j += 2;
                }
            }
        }
        return out;
    }
}
