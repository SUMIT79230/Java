
// === WITHOUT MULTITHREADING ===
// Sequential execution - ek ke baad ek

public class Without_MultiThreading_1 {
    public static void main(String[] args) {
        
        // Task 1: 1 se 5 tak print karo
        int startTime = (int) System.currentTimeMillis(); // Start time for Task 1

        System.out.println("=== Task 1 Started ===");
        for (int i = 1; i <= 5; i++) {                    // Loop 1 to 5
            System.out.println("Task 1: " + i);           // Print kiya
            sleep(500);                               // 500ms wait kiya
        }
        System.out.println("=== Task 1 Completed ===\n");
        
        // Task 2: A se E tak print karo
        System.out.println("=== Task 2 Started ===");
        for (char c = 'A'; c <= 'E'; c++) {               // Loop A to E
            System.out.println("Task 2: " + c);           // Print kiya
            sleep(500);                               // 500ms wait kiya
        }
        int EndTime = (int) System.currentTimeMillis();
        System.out.println("=== Task 2 Completed ===");
        
        System.out.println("Time taken for both Task : " + (EndTime - startTime) + " ms\n");
    }
    
    static void sleep(int ms) {
        try {
            Thread.sleep(ms);                              // Sleep method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Output:
// === Task 1 Started ===
// Task 1: 1
// Task 1: 2
// Task 1: 3
// Task 1: 4
// Task 1: 5
// === Task 1 Completed ===
//
// === Task 2 Started ===
// Task 2: A
// Task 2: B
// Task 2: C
// Task 2: D
// Task 2: E
// === Task 2 Completed ===

// Total Time: ~5 seconds (Task 1) + ~2.5 seconds (Task 2) = ~7.5 seconds
