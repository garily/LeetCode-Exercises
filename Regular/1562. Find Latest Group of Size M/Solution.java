class Solution {
    public int findLatestStep(int[] arr, int m) {
        int[] bin = new int[arr.length + 1];
        int out = -1;
        // [length, count]
        int[] map = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            int lenL = 0, lenR = 0, len = 1;
            bin[arr[i]] = arr[i];
            if (arr[i] - 1 > 0 && bin[arr[i] - 1] > 0) {
                lenL = arr[i] - bin[arr[i] - 1];
                bin[arr[i] - lenL] = arr[i];
                bin[arr[i]] = arr[i] - lenL;
                len += lenL;
            }
            if (arr[i] + 1 <= arr.length && bin[arr[i] + 1] > 0) {
                lenR = bin[arr[i] + 1] - arr[i];
                bin[arr[i] + lenR] = arr[i] - lenL;
                bin[arr[i] - lenL] = arr[i] + lenR;
                len += lenR;
            }
            map[len]++;
            map[lenL]--;
            map[lenR]--;
            if (map[m] > 0) out = i + 1;
        }
        return out;
    }
}
