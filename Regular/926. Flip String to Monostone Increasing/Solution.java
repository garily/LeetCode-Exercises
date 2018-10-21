class Solution {
    public int minFlipsMonoIncr(String S) {
        int zeroCount = S.replace("1", "").length();
        int oneCount = S.length() - zeroCount;
        int min = zeroCount > oneCount ? oneCount : zeroCount;
        int left1 = 0, right0 = zeroCount;
        int leftDownRightUp = zeroCount;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') right0 --;
            else left1 ++;
            leftDownRightUp = left1 + right0;
            min = Math.min(leftDownRightUp, min);
        }
        return min;
    }
}
