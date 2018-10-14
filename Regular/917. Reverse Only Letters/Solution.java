class Solution {
    public String reverseOnlyLetters(String S) {
        if (S.length() <= 1) return S;
        int length = S.length();
        char[] out = new char[length];
        for (int i = 0, j = length - 1; i < length; i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)) && j > -1) {
                    j--;
                }
                out[i] = S.charAt(j);
                j--;
            }
            else out[i] = S.charAt(i);
        }
        return new String(out);
    }
}
