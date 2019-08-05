class ZeroEvenOdd {
    private int n;
    private int printCount = 0;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }


    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (printCount < 2 * n) {
            if (printCount % 2 == 1) wait();
            else {
                printNumber.accept(0);
                printCount++;
                notifyAll();
            }
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (printCount < 2 * n) {
            if (printCount % 4 != 3) wait();
            else {
                printNumber.accept((printCount++ + 1) / 2);
                notifyAll();
            }
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (printCount < 2 * n) {
            if (printCount % 4 != 1) wait();
            else {
                printNumber.accept(printCount++ / 2 + 1);
                notifyAll();
            }
        }
    }
}
