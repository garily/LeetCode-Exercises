class Solution {
    public int romanToInt(String s) {
        int[] romans = new int[26];
        romans['I' - 'A'] = 1;
        romans['V' - 'A'] = 5;
        romans['X' - 'A'] = 10;
        romans['L' - 'A'] = 50;
        romans['C' - 'A'] = 100;
        romans['D' - 'A'] = 500;
        romans['M' - 'A'] = 1000;
        int out = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            boolean plus = true;
            if (i < arr.length - 1) {
                if (arr[i] == 'I' && (arr[i + 1] == 'V' || arr[i + 1] == 'X')) plus = false;
                else if (arr[i] == 'X' && (arr[i + 1] == 'L' || arr[i + 1] == 'C')) plus = false;
                else if (arr[i] == 'C' && (arr[i + 1] == 'D' || arr[i + 1] == 'M')) plus = false;
            }
            out += plus ? romans[arr[i] - 'A'] : -romans[arr[i] - 'A'];
        }
        return out;
    }
}
