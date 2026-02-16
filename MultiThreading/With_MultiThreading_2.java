public class With_MultiThreading_2 {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();  // Correct type

        Thread t1 = new Thread(() -> {
            System.out.println("=== Task 1 Started ===");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 1: " + i);
                sleep(500);
            }
            System.out.println("=== Task 1 Completed ===\n");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("=== Task 2 Started ===");
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Task 2: " + c);
                sleep(500);
            }
            System.out.println("=== Task 2 Completed ===");
        });

        t1.start();
        t2.start();

        t1.join();   // Wait for Task 1
        t2.join();   // Wait for Task 2

        long endTime = System.currentTimeMillis();  // AFTER completion
        System.out.println("\nTime taken for both Tasks: " + (endTime - startTime) + " ms");
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// === Task 1 Started ===
// === Task 2 Started ===
// Task 2: A
// Task 1: 1
// Task 2: B
// Task 1: 2
// Task 2: C
// Task 1: 3
// Task 2: D
// Task 1: 4
// Task 2: E
// Task 1: 5
// === Task 1 Completed ===

// === Task 2 Completed ===

// Time taken for both Tasks: 2554 ms