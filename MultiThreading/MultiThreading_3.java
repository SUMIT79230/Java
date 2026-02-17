// Better Resource Utilization (CPU cores ka use)

public class MultiThreading_3 {
    // Agar 8 CPU cores hain, to 8 threads efficiently kaam karenge
    public static void main(String[] args) {
        
        // Available processors check karo
        int cores = Runtime.getRuntime().availableProcessors();  // CPU cores
        System.out.println("Available CPU Cores: " + cores);
        // Output: Available CPU Cores: 8
        
        // Create threads = number of cores
        Thread[] threads = new Thread[cores];              // Threads array
        
        for (int i = 0; i < cores; i++) {                  // Har core ke liye
            final int taskId = i;                          // Task ID
            threads[i] = new Thread(() -> {                // Thread banaya
                System.out.println("Task " + taskId + " running on " +  Thread.currentThread().getName());
                heavyTask();                               // Heavy task
                System.out.println("Task " + taskId + " completed");
            });
            threads[i].start();                            // Start kiya
        }
    }
    
    static void heavyTask() {
        for (long i = 0; i < 1_000_000_000; i++) {        // Heavy computation
            Math.sqrt(i);
        }
    }

}
