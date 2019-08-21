class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] cumS = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            cumS[i + 1] = cumS[i] + A[i];
        }
        
        int[] countArr = new int[cumS[A.length] + S + 1];
        int count = 0;
        for (int i = 0; i < cumS.length; i++) {
            count += countArr[cumS[i]];
            countArr[cumS[i] + S]++;
        }
        return count;
    }
}
