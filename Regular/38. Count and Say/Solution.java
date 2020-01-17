class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder out = new StringBuilder();
        char ch = prev.charAt(0);
        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == ch) {
                count++;
            }
            else {
                out.append(count);
                out.append(ch);
                ch = prev.charAt(i);
                count = 1;
            }
        }
        out.append(count);
        out.append(ch);
        return out.toString();
    }
}
