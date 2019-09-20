class FizzBuzz {
    private int n;
    private int i;

    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            if (i > n) return;
            if (i % 3 == 0 && i % 5 != 0) {
                i++;
                printFizz.run();
                notifyAll();
            }
            else wait();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            if (i > n) return;
            if (i % 5 == 0 && i % 3 != 0) {
                i++;
                printBuzz.run();
                notifyAll();
            }
            else wait();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            if (i > n) return;
            if (i % 5 == 0 && i % 3 == 0) {
                i++;
                printFizzBuzz.run();
                notifyAll();
            }
            else wait();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            if (i > n) return;
            if (i % 5 != 0 && i % 3 != 0) {
                printNumber.accept(i);
                i++;
                notifyAll();
            }
            else wait();
        }
    }
}
