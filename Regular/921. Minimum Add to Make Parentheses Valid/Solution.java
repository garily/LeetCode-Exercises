class Solution {
    public int minAddToMakeValid(String S) {
        if (S.equals("")) return 0;
        int open = 0;
        int close = 0;
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') open++;
            else {
                if (open > 0) open --;
                else close ++;
            }
        }
        return open + close;
    }
}
