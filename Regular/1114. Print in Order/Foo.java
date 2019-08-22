class Foo {
    private int lastPrinted;

    public Foo() {
        
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (true) {
            if (lastPrinted <= 0) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                lastPrinted++;
                notifyAll();
                return;
            }
            else wait();
        }
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (lastPrinted == 1) {
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                lastPrinted++;
                notifyAll();
                return;
            }
            else wait();
        }
        
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (lastPrinted == 2) {
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                lastPrinted++;
                notifyAll();
                return;
            }
            else wait();
        }
    }
}
