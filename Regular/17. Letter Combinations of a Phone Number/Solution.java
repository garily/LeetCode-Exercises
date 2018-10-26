class Solution {
    final String[][] keyPad = {{"a", "b", "c"}, {"d", "e", "f"},
                               {"g", "h", "i"}, {"j", "k", "l"},
                               {"m", "n", "o"}, {"p", "q", "r", "s"},
                               {"t", "u", "v"}, {"w", "x", "y", "z"}};
    
    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();
        if (digits.length() == 0) return out;
        dfs(out, "", digits);
        return out;
    }
    
    private void dfs(List<String> strings, String combined, String remains) {
        if (remains.length() == 0) strings.add(combined);
        else {
            int keyPressed = remains.charAt(0) - '2';
            for (int i = 0; i < keyPad[keyPressed].length; i++) {
                dfs(strings, combined + keyPad[keyPressed][i], remains.substring(1, remains.length()));
            }
        }
    }
}
