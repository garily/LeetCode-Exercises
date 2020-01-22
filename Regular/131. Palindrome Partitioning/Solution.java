class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> out = new ArrayList<>();
        if (s == null || s.length() == 0) return out;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int head = i;
            int tail = i;
            while (head >= 0 && tail < s.length() && s.charAt(head) == s.charAt(tail)) {
                isPalindrome[head][tail] = true;
                head--;
                tail++;
            }
            head = i;
            tail = i + 1;
            while (head >= 0 && tail < s.length() && s.charAt(head) == s.charAt(tail)) {
                isPalindrome[head][tail] = true;
                head--;
                tail++;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            partition(s, 0, i, new ArrayList<String>(), out, isPalindrome);
        }
        return out;
    }
    
    private void partition(String s, int start, int end, List<String> cur, List<List<String>> out, boolean[][] isPalindrome) {
        if (!isPalindrome[start][end - 1]) return;
        cur.add(s.substring(start, end));
        if (end == s.length()) out.add(new ArrayList<String>(cur));
        else {
            for (int i = end + 1; i <= s.length(); i++) partition(s, end, i, cur, out, isPalindrome);
        }
        cur.remove(cur.size() - 1);
    }
}
