class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        boolean ifPositive = true;
        
        String strCut = cutChar(str, ' ');
        if (strCut.length() == 0) return 0;
        
        if (strCut.charAt(0) == '+') strCut = strCut.substring(1);
        else if (strCut.charAt(0) == '-') {
            ifPositive = false;
            strCut = strCut.substring(1);
        }
        else if (Character.isDigit(strCut.charAt(0)));
        else return 0;
        
        strCut = cutChar(strCut, '0');
        if (strCut.length() == 0) return 0;
        
        long number = 0;
        int strLen = strCut.length();
        for (int i = 0; i < 11 && i < strLen; i++) {
            int digit = charToInt(strCut.charAt(i));
            if (digit == -1) break;
            number = number * 10 + digit;
        }
        
        number = ifPositive ? number : (-1) * number;
        return minMax(number);
    }
    
    int charToInt(char a) {
        int num = (int) a - (int) '0';
        if (num > 9 || num < 0) num = -1;
        return num;
    }
    
    String cutChar(String str, char c) {
        if (str.length() == 0 || str.charAt(0) != c) {
            return str;
        }
        else return cutChar(str.substring(1), c);
    }
    
    int minMax(long a) {
        if (a > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        else if (a < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        else return (int) a;
    }
}
