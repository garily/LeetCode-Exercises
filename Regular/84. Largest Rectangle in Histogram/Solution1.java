// Complexity O(n2)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 1 && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1)); // range: (stack.peek, i), exclusive on both ends
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
