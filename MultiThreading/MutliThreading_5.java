public class MutliThreading_5 {
    public static void main(String[] args) {
        
        System.out.println("Main thread: " + Thread.currentThread().getName());
        // Output: Main thread: main
        
        
        // 3 threads banate hain
        Thread t1 = new Thread(() -> {                 // Thread 1 banaya
            for (int i = 1; i <= 5; i++) {             // Loop 1 to 5
                System.out.println("T1: " + i + " [CPU: " + 
                    Thread.currentThread().getName() + "]");  // Print
                sleep(100);                            // Sleep
            }
        }, "Worker-1");
        
        Thread t2 = new Thread(() -> {                 // Thread 2 banaya
            for (int i = 1; i <= 5; i++) {             // Loop 1 to 5
                System.out.println("T2: " + i + " [CPU: " + 
                    Thread.currentThread().getName() + "]");  // Print
                sleep(100);                            // Sleep
            }
        }, "Worker-2");
        
        Thread t3 = new Thread(() -> {                 // Thread 3 banaya
            for (int i = 1; i <= 5; i++) {             // Loop 1 to 5
                System.out.println("T3: " + i + " [CPU: " + 
                    Thread.currentThread().getName() + "]");  // Print
                sleep(100);                            // Sleep
            }
        }, "Worker-3");
        
        
        // Set different priorities
        t1.setPriority(Thread.MIN_PRIORITY);           // Priority 1 (lowest)
        t2.setPriority(Thread.NORM_PRIORITY);          // Priority 5 (normal)
        t3.setPriority(Thread.MAX_PRIORITY);           // Priority 10 (highest)
        
        
        // Start all threads
        t1.start();                                    // Start T1
        t2.start();                                    // Start T2
        t3.start();                                    // Start T3
        
        // Higher priority thread ko zyada CPU time milega (not guaranteed)
        // OS Thread Scheduler decide karega kon thread CPU pe chalega
    }
    
    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }

}
