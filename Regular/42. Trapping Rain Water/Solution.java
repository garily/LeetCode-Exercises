class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i = 0;
        int out = 0;
        int cur = 0;
        int bottomIdx = 0;
        while (i < height.length) {
            if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
                i++;
                continue;
            }
            else if (height[i] < height[stack.peek()]) {
                stack.push(i);
            }
            while (height[i] > height[stack.peek()]) {
                bottomIdx = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int minHeight = Math.min(height[i], height[stack.peek()]) - height[bottomIdx];
                out += minHeight * (i - stack.peek() - 1);
            }
            stack.push(i);
            i++;
        }
        return out;
        
    }
}
