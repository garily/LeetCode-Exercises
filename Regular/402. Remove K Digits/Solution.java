class Solution {
    public String removeKdigits(String num, int k) {
        int i = 0;
        boolean decrease = false;
        while (true) {
            if (num.length() <= k) return "0";
            if (k <= 0) return num;

            // num.length() > k > 0 => num > 1
            i = 0;
            decrease = false;
            while (i < num.length() - 1 && !decrease) {
                if (num.charAt(i) <= num.charAt(i + 1)) i++;
                else {
                    decrease = true;
                }
            }

            if (decrease) { // i <= num.length() - 2
                if (i == 0) num = num.substring(1);
                else num = num.substring(0, i) + num.substring(i + 1);
            }
            else { // no decrease
                num = num.substring(0, num.length() - 1);
            }

            i = 0;
            while (i < num.length()) {
                if (num.charAt(i) == '0') i++;
                else break;
            }
            num = num.substring(i);
            k--;
        }
    }
}
