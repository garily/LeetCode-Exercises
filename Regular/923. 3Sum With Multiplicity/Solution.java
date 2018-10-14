//Credit & thanks to @lee215 https://leetcode.com/problems/3sum-with-multiplicity/discuss/181131/C%2B%2BJavaPython-O(1012)

class Solution {
    public int threeSumMulti(int[] A, int target) {
        long sum = 0;
        long count[] = new long[101];
        for (int e : A) count[e]++;
        int i, j, k;
        for (i = 0; i < 101; i++) {
            for (j = i; j < 101; j++) {
                k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    sum += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                else if (i == j && j != k)
                    sum += count[k] * count[i] * (count[i] - 1) / 2;
                else if (j < k)
                    sum += count[i] * count[j] * count[k];
            }
        }
        return (int) (sum % (1e9 + 7));
    }
}
