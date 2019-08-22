import java.util.concurrent.Semaphore;

class H2O {
    private final Semaphore hydrogenSem  = new Semaphore(2, true);
    private final Semaphore oxygenSem = new Semaphore(1, true);

    public H2O() {
        
    }
    
    private void checkMolecule() {
        if (hydrogenSem.availablePermits() == 0 && oxygenSem.availablePermits() == 0) {
            hydrogenSem.release(2);
            oxygenSem.release(1);
        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSem.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        checkMolecule();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSem.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        checkMolecule();
    }
}
