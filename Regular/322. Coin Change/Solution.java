class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] possible = new int[amount + 1];
        Arrays.fill(possible, -1);
        possible[0] = 0;
        
        for (int i = 0; i < possible.length; i++) {
            for (int coin: coins) {
                if (possible[i] >= 0 && coin < possible.length - i) {
                    possible[i + coin] = possible[i + coin] >= 0 ? Math.min(possible[i + coin], possible[i] + 1) : possible[i] + 1;
                }
            }
        }
        return possible[amount];
    }
}
