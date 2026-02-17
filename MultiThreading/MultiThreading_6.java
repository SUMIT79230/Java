// This file tells us about context switching in multi-threading.
// Context switching is the process of saving the state of a currently running thread and loading the state of another thread to allow it to run on the CPU. 
// This is necessary in a multi-threaded environment where multiple threads are competing for CPU time.

public class MultiThreading_6 {
    public static void main(String[] args) {
        
        // Assume: Single CPU core
        // 2 threads banao
        
        Thread t1 = new Thread(() -> {                 // Thread 1
            for (int i = 1; i <= 1000; i++) {          // Heavy loop
                // CPU pe execute ho raha
                Math.sqrt(i);                          // Calculation
            }
            System.out.println("T1 done");
        });
        
        Thread t2 = new Thread(() -> {                 // Thread 2
            for (int i = 1; i <= 1000; i++) {          // Heavy loop
                // CPU pe execute ho raha
                Math.sqrt(i);                          // Calculation
            }
            System.out.println("T2 done");
        });
        
        t1.start();                                    // T1 start
        t2.start();                                    // T2 start
        
        /* Context Switching
         * 
         * Time 0-10ms:   CPU runs T1 → T1 state save
         * Time 10-20ms:  CPU runs T2 → T2 state save
         * Time 20-30ms:  CPU runs T1 → T1 state restore
         * ... repeat ...
         * 
         * Har switch pe:
         * 1. Current thread ka state save (registers, program counter)
         * 2. Next thread ka state load
         * 3. Next thread execute
         */
    }
}
