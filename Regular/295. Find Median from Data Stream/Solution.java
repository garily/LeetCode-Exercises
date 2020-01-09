class MedianFinder {
    PriorityQueue<Integer> left, right;
    double median;

    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a); // biggest on top of heap
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.size() == right.size()) { // even size before add
            if (left.size() == 0) {
                left.offer(num);
                median = num;
            }
            else if (num <= right.peek()) { // smaller than the number just above median
                left.offer(num);
                median = left.peek();
            }
            else { // greater than the number just above median, i.e. the top of right
                left.offer(right.poll());
                right.offer(num);
                median = left.peek();
            }
        }
        else if (left.size() > right.size()) { // odd size before add, leftTop is the previous median
            if (num < left.peek()) { // only add to the left if smaller than the top of left to save unnecessary movement when num == leftTop
                right.offer(left.poll());
                left.offer(num);
                median = (left.peek() + right.peek()) / 2.0;
            }
            else { // num >= median (i.e., leftTop), add to right
                right.offer(num);
                median = (left.peek() + right.peek()) / 2.0;
            }
        }
        
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
