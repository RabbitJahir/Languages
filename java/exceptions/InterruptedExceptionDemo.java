// ─────────────────────────────────────────────
//  InterruptedException
//  Thrown when a thread is sleeping, waiting,
//  or blocked and another thread interrupts it
//  via thread.interrupt().
// ─────────────────────────────────────────────

public class InterruptedExceptionDemo {

    // ── Example 1: Basic sleep interruption ────────────────────────────
    static void basicSleepInterrupt() throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                System.out.println("[Worker] Starting long task (sleeping 5s)...");
                Thread.sleep(5000);  // sleeping for 5 seconds
                System.out.println("[Worker] Task complete!");
            } catch (InterruptedException e) {
                // Best practice: restore the interrupted flag
                Thread.currentThread().interrupt();
                System.out.println("[Worker] Interrupted! Stopping early.");
            }
        });

        worker.start();
        Thread.sleep(500);           // main waits briefly
        System.out.println("[Main] Interrupting the worker...");
        worker.interrupt();          // sends interrupt signal
        worker.join();               // wait for it to finish
    }

    // ── Example 2: Interrupting a loop that sleeps ─────────────────────
    static void loopWithSleep() throws InterruptedException {
        Thread counter = new Thread(() -> {
            int count = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("[Counter] Count: " + (++count));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    // Restore interrupt flag, then break gracefully
                    Thread.currentThread().interrupt();
                    System.out.println("[Counter] Interrupted at count " + count);
                    break;
                }
            }
            System.out.println("[Counter] Loop exited cleanly.");
        });

        counter.start();
        Thread.sleep(1200);        // let it run for ~1.2 seconds
        counter.interrupt();
        counter.join();
    }

    // ── Example 3: Object.wait() interruption ──────────────────────────
    static void waitInterrupt() throws InterruptedException {
        final Object lock = new Object();

        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("[Waiter] Waiting for notify...");
                    lock.wait();   // releases lock and waits
                    System.out.println("[Waiter] Notified!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("[Waiter] Interrupted while waiting.");
                }
            }
        });

        waiter.start();
        Thread.sleep(500);
        System.out.println("[Main] Interrupting the waiter...");
        waiter.interrupt();
        waiter.join();
    }

    // ── Bad practice: swallowing the exception ──────────────────────────
    static void badPractice() {
        Thread bad = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // ✗ BAD: silently swallowing — the interrupt flag is lost!
                // Other code can't detect the interrupt happened.
            }
        });
        bad.start();
        bad.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Example 1: Basic sleep interruption ===");
        basicSleepInterrupt();

        System.out.println("\n=== Example 2: Loop with sleep ===");
        loopWithSleep();

        System.out.println("\n=== Example 3: Object.wait() interruption ===");
        waitInterrupt();

        System.out.println("\n=== Summary: Best Practices ===");
        System.out.println("1. Always call Thread.currentThread().interrupt() in catch block");
        System.out.println("2. Check isInterrupted() in long-running loops");
        System.out.println("3. Never swallow InterruptedException silently");
        System.out.println("4. If you can't handle it, declare 'throws InterruptedException'");
    }
}
