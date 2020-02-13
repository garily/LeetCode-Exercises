class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList();
        dfs(n, n, out, "");
        return out;
    }
    
    private void dfs(int open, int close, List<String> out, String cur) {
        if (open > close || open < 0 || close < 0) return;
        if (close == 0 && cur.length() > 0) {
            out.add(cur);
            return;
        }
        // open <= close && close > 0
        dfs(open - 1, close, out, cur + '(');
        dfs(open, close - 1, out, cur + ')');
    }
}
