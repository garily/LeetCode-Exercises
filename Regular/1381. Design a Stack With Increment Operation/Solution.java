class CustomStack {
    int maxSize;
    int size;
    int[] stack;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.stack = new int[maxSize];
    }
    
    public void push(int x) {
        if (size == maxSize) return;
        stack[size++] = x;
    }
    
    public int pop() {
        if (size == 0) return -1;
        return stack[--size];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < size && i < k; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
