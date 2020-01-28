class Solution {
    public boolean isHappy(int n) {
        Set<Integer> history = new HashSet<>();
        history.add(n);
        while (true) {
            n = next(n);
            if (n == 1) return true;
            if (history.contains(n)) break;
            else history.add(n);
        }
        return false;
    }
    
    private int next(int n) {
        if (n == 0) return 0;
        int out = 0;
        while (n != 0) {
            out += (n % 10) * (n % 10);
            n /= 10;
        }
        return out;
    }
}
