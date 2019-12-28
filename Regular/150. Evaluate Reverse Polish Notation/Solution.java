class Solution {
    public int evalRPN(String[] tokens) {
        Integer number = null;
        if (tokens == null) return 0;
        if (tokens.length == 1) {
            number = getNumber(tokens[0]);
            return number == null ? 0 : number.intValue();
        }
        if (tokens.length < 3) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.valueOf(tokens[0]));
        stack.push(Integer.valueOf(tokens[1]));
        int i = 2;
        while (i < tokens.length) {
            number = getNumber(tokens[i]);
            if (number != null) {
                stack.push(number.intValue());
            }
            else {
                stack.push(eval(stack.pop(), stack.pop(), tokens[i]));
            }
            i++;
        }
        return stack.pop();
    }
    
    private Integer getNumber(String string) {
        Integer out = null;
        try {
            out = Integer.valueOf(string);
            return out;
        }
        catch (Exception e) {
            return out;
        }
    }
    
    private int eval(int a, int b, String op) {
        int result = 0;
        switch (op) {
            case "+":
                result = b + a;
                break;
            case "-":
                result = b - a;
                break;
            case "*":
                result = b * a;
                break;
            case "/":
                result = b / a;
                break;
            default:
                break;
        }
        return result;
    }
}
