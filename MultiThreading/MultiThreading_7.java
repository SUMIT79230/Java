public class MultiThreading_7 {
    public static void main(String[] args) throws InterruptedException {
        
        Runtime runtime = Runtime.getRuntime();
        // Check available CPU cores
        int cores = runtime.availableProcessors();
        System.out.println("Available CPU Cores: " + cores);
        // Output: Available CPU Cores: 8 
        
        System.out.println("\n Sequential Execution");
        long start1 = System.currentTimeMillis();      // Start time
        
        // Sequential - ek ke baad ek
        heavyTask("Task 1");                           // Task 1 complete
        heavyTask("Task 2");                           // Task 2 complete
        heavyTask("Task 3");                           // Task 3 complete
        heavyTask("Task 4");                           // Task 4 complete
        heavyTask("Task 5");                           // Task 5 complete
        heavyTask("Task 6");                           // Task 6 complete
        heavyTask("Task 7");                           // Task 7 complete
        heavyTask("Task 8");                           // Task 8 complete
        heavyTask("Task 9");                           // Task 9 complete
        heavyTask("Task 10");                          // Task 10 complete
        heavyTask("Task 11");                          // Task 11 complete
        heavyTask("Task 12");                          // Task 12 complete
        
        long end1 = System.currentTimeMillis();        // End time
        System.out.println("Sequential Time: " + (end1 - start1) + " ms");
        // Output: Sequential Time: ~4000 ms
        
        
        System.out.println("\n=== Parallel Execution ===");
        long start2 = System.currentTimeMillis();      // Start time
        
        // Parallel - saath mein (har core pe ek thread)
        Thread t1 = new Thread(() -> heavyTask("Task 1"));  // Core 1
        Thread t2 = new Thread(() -> heavyTask("Task 2"));  // Core 2
        Thread t3 = new Thread(() -> heavyTask("Task 3"));  // Core 3
        Thread t4 = new Thread(() -> heavyTask("Task 4"));  // Core 4
        Thread t5 = new Thread(() -> heavyTask("Task 5"));  // Core 5
        Thread t6 = new Thread(() -> heavyTask("Task 6"));  // Core 6
        Thread t7 = new Thread(() -> heavyTask("Task 7"));  // Core 7
        Thread t8 = new Thread(() -> heavyTask("Task 8"));  // Core 8
        Thread t9 = new Thread(() -> heavyTask("Task 9"));  // Core
        Thread t10 = new Thread(() -> heavyTask("Task 10")); // Core
        Thread t11 = new Thread(() -> heavyTask("Task 11")); // Core
        Thread t12 = new Thread(() -> heavyTask("Task 12")); // Core
        
        t1.start(); t2.start(); t3.start(); t4.start(); t5.start(); t6.start(); t7.start(); t8.start(); t9.start(); t10.start(); t11.start(); t12.start();     // All start
        t1.join(); t2.join(); t3.join(); t4.join(); t5.join(); t6.join(); t7.join(); t8.join(); t9.join(); t10.join(); t11.join(); t12.join();         // All wait
        
        long end2 = System.currentTimeMillis();        // End time
        System.out.println("Parallel Time: " + (end2 - start2) + " ms");
        // Output: Parallel Time: ~1000 ms (4x faster!)
        
        
        /*
         * Single Core:
         * Core 1: Task1 → Task2 → Task3 → Task4  (4 sec)
         * 
         * Multi Core (4 cores):
         * Core 1: Task1  ┐
         * Core 2: Task2  ├── All parallel (1 sec)
         * Core 3: Task3  │
         * Core 4: Task4  ┘
         */
    }
    
    static void heavyTask(String name) {
        System.out.println(name + " started on " + Thread.currentThread().getName());
        long sum = 0;
        for (long i = 0; i < 1_000_000_000; i++) {    // Billion iterations
            sum += i;                                  // Add
        }
        
        System.out.println(name + " completed. Sum: " + sum);
    }

}
