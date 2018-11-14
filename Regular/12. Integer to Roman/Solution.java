class Solution {
    String[] roman0 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] roman1 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] roman2 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] roman3 = {"", "M", "MM", "MMM"};
    public String intToRoman(int num) {
        return roman3[num / 1000] + roman2[(num % 1000) / 100] + roman1[(num % 100) / 10] + roman0[num % 10];
    }
}
