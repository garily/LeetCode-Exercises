class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int out = 0;
        int turns = piles.length / 3;
        for (int i = 0; i < turns; i++) {
            out += piles[piles.length - i * 2 - 2];
        }
        return out;
    }
}
