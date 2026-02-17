// This file demonstrates various thread methods in Java, including getName(), setName(), setPriority(), getState(), isAlive(), and join().

//  Points to Notes :
// 1. getName() - Returns the name of the thread.
// 2. setName(String name) - Sets the name of the thread.
// 3. setPriority(int priority) - Sets the priority of the thread (1 to 10).
// 4. getState() - Returns the state of the thread (NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED).
// 5. isAlive() - Returns true if the thread is alive (running or ready to run), false otherwise.
// 6. join() - Waits for the thread to die (finish execution) before proceeding with the next line of code in the main thread.
// Thread.currentThread() - Returns a reference to the currently executing thread object (main thread in this case).
// Thread.activeCount() - Returns the number of active threads in the current thread's thread group (main thread only, t1 thread is dead after join).
// Thread.sleep(long millis) - Causes the currently executing thread to sleep (pause) for the specified number of milliseconds.
// Note: Thread methods can be called before or after starting the thread, but some methods (like getState() and isAlive()) will show different results based on the thread's lifecycle stage.

public class Thread_Method_9 {
    public static void main(String[] args){

        Thread t1 = new Thread(()->{
            System.out.println("Creating Thread"  +Thread.currentThread().getName()+ "by using Lambda.");
            // t1 Thread execution
            for(int i = 6;i<=10;i++){
                System.out.println(i);
            }
            try{
                Thread.sleep(2000); // pause current Thread for 2 sec
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        t1.start();
        t1.setName(" MyThread-1 "); // set name of thread after starting it
        t1.setPriority(Thread.MAX_PRIORITY); // set priority of thread after starting it

        Thread.State state = t1.getState(); // get current state of thread
        System.out.println("Current State of Thread : " + state);

        System.out.println("Is thread is running before Join Method : "+  t1.isAlive());

        try {
            t1.join();
            System.out.println("Is thread is running after Join Method : "+  t1.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Main Thread execution
        for(int i = 1;i<=5;i++){
            System.out.println(i);
        }

        Thread current = Thread.currentThread(); // Get current thread (main thread)
        System.out.println("Current Thread : " + current.getName());

        int count = Thread.activeCount(); // main thread only, t1 thread is dead after join
        System.out.println("Total number of Thread is : "+ count);
    }
}