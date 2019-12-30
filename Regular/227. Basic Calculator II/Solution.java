class Solution {
    public int calculate(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        boolean wait = false; // boolean for if we need to wait for subsequent result
        boolean add = true; // if the waitNum is followed by a plus sign, otherwise false (minus sign)
        int waitNum = 0;
        int num1 = 0;
        int num2 = 0;
        int i = 0;
        // get first number
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                num1 = num1 * 10 + (ch - '0');
                i++;
            }
            else break;
        }
        // if the expression has not ended
        while (i < s.length()) {
            num2 = 0;
            // get the first symbol
            char op = s.charAt(i++);
            // get the firt number after the symbol
            while (i < s.length()) {
                char ch = s.charAt(i);
                if (ch == ' ') {
                    i++;
                    continue;
                }
                if (ch >= '0' && ch <= '9') {
                    num2 = num2 * 10 + (ch - '0');
                    i++;
                }
                else break;
            }
            switch (op) {
                // if plus or minus, update waitNum, and set wait to true, adjust add if necessary, use num2 as the new num1 for the next round of iteration
                case '+':
                    waitNum = waitNum + (add ? num1 : -num1);
                    wait = true;
                    add = true;
                    num1 = num2;
                    break;
                case '-':
                    waitNum = waitNum + (add ? num1 : -num1);
                    wait = true;
                    add = false;
                    num1 = num2;
                    break;
                // if product or division, use the calculated value as num1 for the next round of iteration
                case '*':
                    num1 = num1 * num2;
                    break;
                case '/':
                    num1 = num1 / num2;
                    break;
                default:
                    break;
            }
        }
        // if we have waited during calculation, i.e. we have encountered '+' or '-' at least once during calculation, we need to take waitNum into account when returning the final result
        if (wait) return waitNum + (add ? num1 : -num1);
        else return num1;
    }
}
