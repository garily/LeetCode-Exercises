class Solution {
    public String fractionToDecimal(int _numerator, int _denominator) {
        long numerator = _numerator, denominator = _denominator;
        if (denominator == 0) throw new ArithmeticException("denominator == 0");
        
        String symbol = (((float) numerator) / ((float) denominator)) >= 0 ? "" : "-";
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        
        String integral = symbol + String.valueOf((long) (numerator / denominator));
        long remain = numerator % denominator;
        if (remain == 0) return integral;
        String fractional = ".";
        int powerOf10 = 0;
        // <remains, powerOf10 for that remain>
        Map remains = new HashMap<Long, Integer>();
        do {
            numerator = remain;
            remains.put(remain, powerOf10++);
            numerator *= 10;
            remain = numerator % denominator;
            fractional += String.valueOf((int) (numerator / denominator));
            if (remain == 0) return integral + fractional;
        }
        while (!remains.containsKey(remain));
        int prevPowerOf10 = (int) remains.get(remain);
        fractional = fractional.substring(0, prevPowerOf10 + 1) + "(" + fractional.substring(prevPowerOf10 + 1) + ")";
        return integral + fractional;
    }
}
