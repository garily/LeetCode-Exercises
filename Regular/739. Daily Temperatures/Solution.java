class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] out = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int prev = stack.pop();
                out[prev] = i - prev;
            }
            stack.push(i);
        }
        return out;
    }
}
