class ProductOfNumbers {
    LinkedList<Integer> list;
    public ProductOfNumbers() {
        list = new LinkedList();
        list.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            list = new LinkedList();
            list.add(0);
        }
        else {
            Integer last = list.peekLast();
            if (last == 0) list.add(num);
            else list.add(last * num);
        }
        // System.out.println(list);
    }
    
    public int getProduct(int k) {
        if (k >= list.size()) return 0;
        int numerator = list.peekLast();
        int denominator = list.get(list.size() - k - 1);
        if (denominator == 0) return numerator;
        return numerator / denominator;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
