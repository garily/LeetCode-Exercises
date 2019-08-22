class FooBar {
    private int n;
    private boolean shouldPrintFoo;

    public FooBar(int n) {
        this.n = n;
        shouldPrintFoo = true;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n;) {
            if (shouldPrintFoo) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                i++;
                shouldPrintFoo = false;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n;) {
            if (!shouldPrintFoo) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                i++;
                shouldPrintFoo = true;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }
}
