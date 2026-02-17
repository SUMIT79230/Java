// Improved responsiveness (UI freeze nahi hoga)
// This file tells us how to use multi-threading to perform tasks concurrently, which can improve the responsiveness of an application.
// In this example, we have a main thread that simulates a user interface (UI) and a separate thread that simulates downloading a file. 
// The main thread continues to execute and print messages to the console while the file is being downloaded in the background. This allows the UI to remain responsive and not freeze while waiting for the download to complete.

public class MultiThreading_4 {
    public static void main(String[] args) {
       
        // Thread is created for downloading a file
        Thread firstThread  = new Thread(()->{
            System.out.println("Downloading File started ... ");
            sleep(2000); // Simulate file download with sleep
            System.out.println("File Downloaded Successfully!");
        });

        firstThread.start();

       // Main thread free hai - UI responsive rahega
        for (int i = 0; i < 10; i++) {                     // Main thread kaam
            System.out.println("UI is responsive: " + i);  // Print kiya
            sleep(500);                                // Small delay
        }

    }
    static void sleep(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
