class Solution {
    public int minFlips(int a, int b, int c) {
        if ((a | b) == c) return 0;
        int out = 0;
        System.out.println(b);
        System.out.println("dfa");
        for (int i = 0; i < 32; i++) {
            int a0 = a & 1;
            int b0 = b & 1;
            int c0 = c & 1;
            a >>= 1;
            b >>= 1;
            c >>= 1;
            
            if ((a0 | b0) == c0) continue;
            if (c0 == 1) out += 1;
            else {
                if (a0 == 1) out += 1;
                if (b0 == 1) out += 1;
            }
        }
        return out;
    }
}
