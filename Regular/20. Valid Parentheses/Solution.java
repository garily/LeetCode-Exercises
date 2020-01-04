class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false;
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                else {
                    switch(stack.pop()) {
                        case '(':
                            if (ch != ')') return false;
                            break;
                        case '{':
                            if (ch != '}') return false;
                            break;
                        case '[':
                            if (ch != ']') return false;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
